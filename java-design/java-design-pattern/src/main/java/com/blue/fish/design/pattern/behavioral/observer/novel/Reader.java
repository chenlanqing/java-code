package com.blue.fish.design.pattern.behavioral.observer.novel;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * 读者类
 */
@Slf4j
public class Reader implements Observer {

    private String name;

    public Reader(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 订阅作者
     *
     * @param writerName
     */
    public void subscribe(String writerName) {
        WriterManager.getInstance().getWriter(writerName).addObserver(this);
    }

    /**
     * 取消订阅
     * @param writerName
     */
    public void unSubscribe(String writerName) {
        WriterManager.getInstance().getWriter(writerName).deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Writer){
            Writer w = (Writer) o;
            log.info("{} 知道 {} 发布了新书《{}》 非要去看!", name, w.getName(), w.getLastNovel());
        }
    }
}
