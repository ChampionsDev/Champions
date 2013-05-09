package com.github.legendsdev.legends.library.event;
/**
 * @author YoshiGenius
 */
public @interface EventWatcher {
    
    public EventPriority priority() default EventPriority.NORMAL;
    
    public boolean ignoreCancelled() default false;

}
