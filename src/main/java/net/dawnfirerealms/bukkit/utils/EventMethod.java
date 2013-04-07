package net.dawnfirerealms.bukkit.utils;

import java.lang.reflect.Method;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;

public class EventMethod {
	private Class<? extends Event> eventClass;
	private EventPriority priority;
	private boolean ignoreCancelled;
	private Method method;
	
	public EventMethod(Class<? extends Event> eventClass,
			EventPriority priority, boolean ignoreCancelled, Method method) {
		this.eventClass = eventClass;
		this.priority = priority;
		this.ignoreCancelled = ignoreCancelled;
		this.method = method;
	}

	public Class<? extends Event> getEventClass() {
		return eventClass;
	}

	public EventPriority getPriority() {
		return priority;
	}

	public boolean isIgnoreCancelled() {
		return ignoreCancelled;
	}
	
	public Method getMethod() {
		return method;
	}
}
