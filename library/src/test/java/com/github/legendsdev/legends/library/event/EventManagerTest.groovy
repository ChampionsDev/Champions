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
package com.github.legendsdev.legends.library.event

import com.github.legendsdev.legends.library.event.weapon.WeaponClickEvent
import com.github.legendsdev.legends.library.weapon.Weapon

/**
 * @author B2OJustin
 */
class EventManagerTest extends GroovyTestCase implements EventListener {
    boolean eventFired = false;

    void setUp() {
        EventManager.registerEvents(this);
    }

    void testCallEvent() {
        EventManager.callEvent(new WeaponClickEvent(new Weapon(), WeaponClickEvent.ClickType.LEFT_CLICK))
        assertTrue(eventFired);
    }

    @LEventHandler
    public void eventHandler(WeaponClickEvent event) {
        eventFired = true;
    }
}
