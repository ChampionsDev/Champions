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
package net.dawnfirerealms.legends.library.race

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.dawnfirerealms.legends.core.utils.EventMethod;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerEvent;



public enum RaceType {
    HUMAN_NORTHERNERS("Human", ChatColor.GRAY, Human.class),
    ELVES("Elves", ChatColor.DARK_PURPLE, Elve.class),
    ORC("Orc", ChatColor.RED, Orc.class);

    private Class<? extends Race> clazz;
    private Map<Class<? extends Event>, List<EventMethod>> eventMethods = new LinkedHashMap<Class<? extends Event>, List<EventMethod>>();
    private String userFriendlyName;
    private ChatColor color;

    @SuppressWarnings("unchecked")
    private RaceType(String userFriendlyName, ChatColor color, Class<? extends Race> clazz) {
        this.clazz = clazz;
        this.userFriendlyName = userFriendlyName;
        this.color = color;
        for(Class<?> nclass = clazz; nclass != null; nclass = nclass.getSuperclass()) {
            for(Method method : clazz.getMethods()) {
                EventHandler handler = method.getAnnotation(EventHandler.class);
                if(handler == null)
                    continue;
                Class<?>[] para = method.getParameterTypes();
                if(para.length != 1 || !(PlayerEvent.class.isAssignableFrom(para[0]) || EntityEvent.class.isAssignableFrom(para[0])))
                    throw new RuntimeException("The class "+clazz.getName()+" have a method with a eventhandler that does not have an EntityEvent or PlayerEvent parameter.");

                Class<? extends Event> event = (Class<? extends Event>) para[0];

                List<EventMethod> methods = eventMethods.get(event);

                if(methods == null) {
                    methods = new ArrayList<EventMethod>();
                    eventMethods.put(event, methods);
                }

                methods.add(new EventMethod(event, handler.priority(), handler.ignoreCancelled(), method));
            }
        }
    }

    public Map<Class<? extends Event>, List<EventMethod>> getEventMethods() {
        return eventMethods;
    }

    public String getName() {
        return userFriendlyName;
    }

    public String getColorizedName() {
        return color+userFriendlyName+ChatColor.RESET;
    }

    public Class<? extends Race> getRaceClass() {
        return clazz;
    }

    public Race newInstance(Player player)  {
        Race instance = null;
        try {
            instance = clazz.newInstance();
        } catch (Exception e) {
            //This should not happen as longs as there is empty constructor in the races
            e.printStackTrace();
        }
        instance.player = player;
        instance.type = this;
        instance.init();
        return instance;
    }
}
