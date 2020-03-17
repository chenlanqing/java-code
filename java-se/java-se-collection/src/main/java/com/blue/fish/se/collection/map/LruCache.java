package com.blue.fish.se.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现 LruCache
 *
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 6441144548995179780L;

    public LruCache(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public LruCache(int initialCapacity) {
        super(initialCapacity);
    }

    public LruCache() {
    }

    public LruCache(Map<? extends K, ? extends V> m) {
        super(m);
    }

    public LruCache(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > 3;
    }
}
