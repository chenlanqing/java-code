package com.blue.fish.design.pattern.structural.proxy.db;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class DataSourceContextHolder {

    private static ThreadLocal<String> context = new ThreadLocal<>();

    public static void setDBType(String dbName) {
        context.set(dbName);
    }

    public static String getDBType() {
        return context.get();
    }

    public static void remove(){
        context.remove();
    }
}
