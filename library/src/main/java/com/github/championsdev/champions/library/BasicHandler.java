package com.github.championsdev.champions.library;

import java.util.HashMap;

/**
 * @author YoshiGenius
 */
public class BasicHandler<T> {
    private HashMap<String, T> objectMap = new HashMap<>();

    public void register(String id, T object) {
        objectMap.put(id, object);
    }
    
    public T get(String id) {
        return objectMap.get(id);
    }

    public void remove(String id) {
        objectMap.remove(id);
    }

    public boolean isRegistered(String id) {
        return objectMap.containsKey(id);
    }

}