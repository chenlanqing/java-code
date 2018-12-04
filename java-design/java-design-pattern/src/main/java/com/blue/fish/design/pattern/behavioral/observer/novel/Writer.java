package com.blue.fish.design.pattern.behavioral.observer.novel;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;

/**
 * 作者类
 */
@Slf4j
public class Writer extends Observable {

    private String name;
    /**
     * 最新的小说
     */
    private String lastNovel;

    public String getName() {
        return name;
    }

    public String getLastNovel() {
        return lastNovel;
    }

    public Writer(String name) {
        super();
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    /**
     * 作者发布小说
     *
     * @param novel
     */
    public void addNovel(String novel) {
        log.info("{} 发布了新书 《{}》！", name, novel);
        lastNovel = novel;
        setChanged();
        notifyObservers();
    }


}
