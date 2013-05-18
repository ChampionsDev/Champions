/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library.event

import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent
import com.github.championsdev.champions.library.event.weapon.WeaponEvent
import com.github.championsdev.champions.library.cclass.CClass
import com.github.championsdev.champions.library.cplayer.CPlayer
import com.github.championsdev.champions.library.race.Race
import com.github.championsdev.champions.library.weapon.Weapon

/**
 * @author B2OJustin
 */
class EventManagerTest extends GroovyTestCase implements EventListener {
    boolean upstreamEventFired = false;
    boolean downstreamEventFired = false;
    CPlayer lPlayer;

    void setUp() {
        EventManager.registerEvents(this);
        lPlayer = new CPlayer(new Race(), new CClass(), new CClass());
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

    @CEventHandler
    public void upstreamHandler(WeaponEvent event) {
        upstreamEventFired = true;
    }

    @CEventHandler
    public void downstreamHandler(WeaponClickEvent weaponClickEvent) {
        downstreamEventFired = true;
    }
}
