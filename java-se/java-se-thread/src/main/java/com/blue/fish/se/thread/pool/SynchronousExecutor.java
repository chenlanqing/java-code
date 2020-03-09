package com.blue.fish.se.thread.pool;

import java.util.concurrent.Executor;

/**
 * 线程池同步执行每一个任务：直接实现executor接口，实现execute方法，调用Runnable的 command方法
 *
 * @author bluefish 2020-03-02
 * @version 1.0.0
 */
public class SynchronousExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        if (command != null) {
            command.run();
        }
    }
}
