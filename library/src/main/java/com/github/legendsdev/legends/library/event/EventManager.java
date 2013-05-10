package com.github.legendsdev.legends.library.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author YoshiGenius
 */
//TODO Finish making this thread safe
public class EventManager {
    private static HashMap<Method, LEventHandler> handlers = new HashMap<>();
    private static HashMap<Class<? extends LegendsEvent>, ArrayList<Method>> methods = new HashMap<>();
    private static HashMap<Method, EventListener> listeners = new HashMap<>();

    private static EventManager instance = new EventManager();

    public static EventManager getInstance() {
        return instance;
    }

    private EventManager() {
    }

    public static synchronized void registerEvents(EventListener listener) {
        for(Method method : listener.getClass().getMethods()) {
            if(method.isAnnotationPresent(LEventHandler.class)) {
                Class[] paramType = method.getParameterTypes();
                if(paramType.length == 1 &&
                        LegendsEvent.class.isAssignableFrom(paramType[0])) {
                    handlers.put(method, method.getAnnotation(LEventHandler.class));

                    ArrayList<Method> methodList = methods.get(paramType[0]);
                    if(methodList == null) methodList = new ArrayList<>();
                    methodList.add(method);
                    methods.put(paramType[0], methodList);

                    listeners.put(method, listener);
                }
            }
        }
    }

    // TODO this can be optimized by mapping the priorities before the event needs to be called.
    public static synchronized void callEvent(LegendsEvent event) {
        try {
            if(methods.containsKey(event.getClass())) {
                ArrayList<Method> lowestPriority = new ArrayList<>();
                ArrayList<Method> lowPriority = new ArrayList<>();
                ArrayList<Method> normalPriority = new ArrayList<>();
                ArrayList<Method> highPriority = new ArrayList<>();
                ArrayList<Method> highestPriority = new ArrayList<>();

                for(Method method : methods.get(event.getClass())) {
                    LEventHandler handler = handlers.get(method);
                    switch(handler.priority()) {
                        case LOWEST:
                            lowestPriority.add(method);
                        break;
                        case LOW:
                            lowPriority.add(method);
                        break;
                        case NORMAL:
                            normalPriority.add(method);
                        break;
                        case HIGH:
                            highPriority.add(method);
                        break;
                        case HIGHEST:
                            highestPriority.add(method);
                        break;
                    }
                }

                for(Method method : lowestPriority) method.invoke(listeners.get(method), event);
                for(Method method : lowPriority) method.invoke(listeners.get(method), event);
                for(Method method : normalPriority) method.invoke(listeners.get(method), event);
                for(Method method : highPriority) method.invoke(listeners.get(method), event);
                for(Method method : highestPriority) method.invoke(listeners.get(method), event);
            }
        } catch (IllegalAccessException | InvocationTargetException ignored){
        }
    }

}
