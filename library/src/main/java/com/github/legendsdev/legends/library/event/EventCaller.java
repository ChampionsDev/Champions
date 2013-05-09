package com.github.legendsdev.legends.library.event;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author YoshiGenius
 */
public class EventCaller {
    private ArrayList<EventListener> watchers;
    private HashMap<EventWatcher, EventPriority> events = new HashMap<>();
    private HashMap<EventWatcher, Method> methods = new HashMap<>();
    
    public EventCaller() {
        watchers = new ArrayList<>();
    }

    public void callEvent(LegendsEvent event) {
        for (EventListener el : watchers) {
            for (Method method : el.getClass().getMethods()) {
                for (Annotation anno : method.getAnnotations()) {
                    if (anno.getClass() == EventWatcher.class) {
                        EventWatcher ew = (EventWatcher) anno;
                        if (method.getParameterTypes().length == 0 || ) {
                            
                        }
                        events.put(ew, ew.priority());
                        methods.put(ew, method);
                    }
                }
            }
        }
        ArrayList<EventWatcher> lowest = new ArrayList<>();
        ArrayList<EventWatcher> low = new ArrayList<>();
        ArrayList<EventWatcher> normal = new ArrayList<>();
        ArrayList<EventWatcher> high = new ArrayList<>();
        ArrayList<EventWatcher> highest = new ArrayList<>();
        for (EventWatcher ew : events.keySet()) {
            if (ew.priority() == EventPriority.LOWEST) {
                lowest.add(ew);
            } else if (ew.priority() == EventPriority.LOW) {
                low.add(ew);
            } else if (ew.priority() == EventPriority.NORMAL) {
                normal.add(ew);
            } else if (ew.priority() == EventPriority.HIGH) {
                high.add(ew);
            } else if (ew.priority() == EventPriority.HIGHEST) {
                highest.add(ew);
            }
        }
    }

}
