package com.blue.fish.se.thread.lock.distribute.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;
import java.util.UUID;

/**
 * Redis分布式锁-实现1
 */
public class RedisDistributeLock {

    private final JedisPool jedisPool;

    public RedisDistributeLock(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 加锁
     *
     * @param lockName       锁的key
     * @param acquireTimeout 获取锁的超时时间
     * @param timeout        锁的超时时间
     * @return
     */
    public String lockWithTimeout(String lockName, long acquireTimeout, long timeout) {
        Jedis jedis = null;
        String retIdentifier = null;
        try {
            jedis = jedisPool.getResource();
            String identifier = UUID.randomUUID().toString();
            String lockKey = "lock：" + lockName;
            // 超时时间，上锁后超过此时间则自动释放锁
            int lockExpire = (int) (timeout / 1000);
            // 获取锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + acquireTimeout;
            while (System.currentTimeMillis() < end) {
                if (jedis.setnx(lockKey, identifier) == 1) {
                    jedis.expire(lockKey, lockExpire);
                    // 返回value值，用于释放锁时间确认
                    retIdentifier = identifier;
                    return retIdentifier;
                }
                // 返回-1代表key没有设置超时时间，为key设置一个超时时间
                if (jedis.ttl(lockKey) == -1) {
                    jedis.expire(lockKey, lockExpire);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return retIdentifier;
    }

    /**
     * 释放锁
     *
     * @param lockName   锁的key
     * @param identifier 释放锁标识
     * @return
     */
    public boolean releaseLock(String lockName, String identifier) {
        Jedis jedis = null;
        String lockKey = "lock：" + lockName;
        boolean retFlag = false;

        try {
            jedis = jedisPool.getResource();
            while (true) {
                jedis.watch(lockKey);
                // 通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
                if (identifier.equals(jedis.get(lockKey))) {
                    Transaction transaction = jedis.multi();
                    transaction.del(lockKey);
                    List<Object> results = transaction.exec();
                    if (results == null) {
                        continue;
                    }
                    retFlag = true;
                }
                jedis.unwatch();
                break;
            }
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return retFlag;
    }
}