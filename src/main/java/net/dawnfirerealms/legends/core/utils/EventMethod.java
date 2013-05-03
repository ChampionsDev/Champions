/*
This file is part of Legends.

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends.  If not, see <http://www.gnu.org/licenses/>.
*/

package net.dawnfirerealms.legends.core.utils;

import java.lang.reflect.Method;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;

/**
 * @author Ranzdo
 */
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
