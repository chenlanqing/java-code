package com.qing.fan.common.utils;

import java.io.*;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月03日 16:45
 */
public class CloneUtils {

    /**
     * 深拷贝一个对象
     *
     * @param obj 需要拷贝的对象
     * @param <T> 需要拷贝的对象必须实现Serializable接口，代表其可序列化
     * @return
     */
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            // 写⼊入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();
            // 分配内存，写⼊入原始对象，⽣生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios); //返回⽣生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            // ignore
        }
        return cloneObj;
    }
}
