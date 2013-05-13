package com.github.legendsdev.legends.library.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method to be registered with the EventManager
 *
 * @author YoshiGenius
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LEventHandler {
    
    public EventPriority priority() default EventPriority.NORMAL;
    
    public boolean ignoreCancelled() default false;

}
