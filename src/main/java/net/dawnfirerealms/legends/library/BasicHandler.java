package net.dawnfirerealms.legends.library;

import java.util.HashMap;

/**
 * @author YoshiGenius
 */
public class BasicHandler<T> {
    private HashMap<String, T> objectMap = new HashMap<>();

    public void registerObject(String id, T object) {
        objectMap.put(id, object);
    }
    
    public T getObject(String id) {
        return objectMap.get(id);
    }

}