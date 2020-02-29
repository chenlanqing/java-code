package com.blue.fish.se.basis.exception;

/**
 * 在什么情况下finally的代码不会执行：在try代码块中调用了 System.exit(0) 表示退出JVM，那么finally代码块不会执行；
 *
 * @author bluefish 2020-02-28
 * @version 1.0.0
 */
public class FinallyNotExecute {

    public static void main(String[] args) {
        try {
            System.out.println("执行 try 代码块");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("执行 catch 代码块");
        } finally {
            System.out.println("执行 finally 代码块");
        }
    }
}
