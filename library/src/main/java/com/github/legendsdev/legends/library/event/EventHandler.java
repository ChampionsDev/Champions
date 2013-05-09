package com.github.legendsdev.legends.library.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YoshiGenius
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface EventHandler {
    
    public EventPriority priority() default EventPriority.NORMAL;
    
    public boolean ignoreCancelled() default false;

}
