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
import com.github.legendsdev.legends.library.event.weapon.WeaponEvent
import com.github.legendsdev.legends.library.lclass.LClass
import com.github.legendsdev.legends.library.lplayer.LPlayer
import com.github.legendsdev.legends.library.race.Race
import com.github.legendsdev.legends.library.weapon.Weapon

/**
 * @author B2OJustin
 */
class EventManagerTest extends GroovyTestCase implements EventListener {
    boolean upstreamEventFired = false;
    boolean downstreamEventFired = false;
    LPlayer lPlayer;

    void setUp() {
        EventManager.registerEvents(this);
        lPlayer = new LPlayer(new Race(), new LClass(), new LClass());
    }

    void testCallUpstreamEvent() {
        EventManager.callEvent(new WeaponClickEvent(new Weapon(), lPlayer, WeaponClickEvent.ClickType.LEFT_CLICK));
        assertTrue("Upstream events not called", upstreamEventFired);
        assertTrue(downstreamEventFired);
    }

    void testCallDownstreamEvent() {
        EventManager.callEvent(new WeaponEvent(new Weapon(), lPlayer));
        assertFalse("Downstream event called inappropriately", downstreamEventFired);
        assertTrue(upstreamEventFired);
    }

    @LEventHandler
    public void upstreamHandler(WeaponEvent event) {
        upstreamEventFired = true;
    }

    @LEventHandler
    public void downstreamHandler(WeaponClickEvent weaponClickEvent) {
        downstreamEventFired = true;
    }
}
