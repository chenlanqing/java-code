package com.blue.fish.design.pattern.observer.novel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作者管理类
 */
public class WriterManager {

    private Map<String, Writer> writerMap = new ConcurrentHashMap<>();

    /**
     * 添加作者
     * @param writer
     */
    public void add(Writer writer){
        writerMap.put(writer.getName(), writer);
    }

    public Writer getWriter(String name){
        return writerMap.get(name);
    }

    private WriterManager(){}

    public static WriterManager getInstance(){
        return WriterManagerHolder.INSTANCE;
    }

    private static class WriterManagerHolder {
        private static final WriterManager INSTANCE = new WriterManager();
    }
}
