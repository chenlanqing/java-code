package com.blue.fish.se.thread.lock.distribute.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author bluefish 2019-03-16
 * @version 1.0.0
 */
public class RedissonLockDemo {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient redisson = Redisson.create(config);

        RLock anylock = redisson.getLock("anylock");

        anylock.lock();


        anylock.unlock();
    }
}
