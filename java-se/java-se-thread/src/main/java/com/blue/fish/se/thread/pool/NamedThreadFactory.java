package com.blue.fish.se.thread.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bluefish 2020-03-02
 * @version 1.0.0
 */
public class NamedThreadFactory implements ThreadFactory {


    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    private final Thread.UncaughtExceptionHandler exceptionHandler;

    public NamedThreadFactory(Thread.UncaughtExceptionHandler exceptionHandler) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        namePrefix = "pool-" +
                poolNumber.getAndIncrement() +
                "-thread-";
        this.exceptionHandler = exceptionHandler;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);

        t.setUncaughtExceptionHandler(exceptionHandler);

        return t;
    }

}
