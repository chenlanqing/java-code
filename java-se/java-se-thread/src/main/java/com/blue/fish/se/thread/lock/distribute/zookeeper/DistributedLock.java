package com.blue.fish.se.thread.lock.distribute.zookeeper;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁接口
 *
 * @author BlueFish
 */
public interface DistributedLock {

    /**
     * 获取锁，如果没有得到锁就等待
     *
     * @throws Exception
     */
    void acquire() throws Exception;

    /**
     * 获取锁，直到超时
     *
     * @param time 超时时间
     * @param unit 参数单位
     * @return 是否获取到锁
     * @throws Exception 异常信息
     */
    boolean acquire(long time, TimeUnit unit) throws Exception;

    /**
     * 释放锁
     *
     * @throws Exception
     */
    void release() throws Exception;
}
