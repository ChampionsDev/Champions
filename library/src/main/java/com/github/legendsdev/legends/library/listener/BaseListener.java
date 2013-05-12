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
package com.github.legendsdev.legends.library.listener;

import com.github.legendsdev.legends.library.event.EventListener;
import com.github.legendsdev.legends.library.event.EventPriority;
import com.github.legendsdev.legends.library.event.LEventHandler;
import com.github.legendsdev.legends.library.event.weapon.WeaponClickEvent;
import com.github.legendsdev.legends.library.event.weapon.WeaponHitEvent;

/**
 * This listener fires all callback methods
 * @author B2OJustin
 */
public class BaseListener implements EventListener {

    @LEventHandler(priority = EventPriority.LOWEST)
    public void onWeaponClick(WeaponClickEvent event) {
        event.getWeapon().onClick(event);
    }

    @LEventHandler(priority = EventPriority.LOWEST)
    public void onWeaponHit(WeaponHitEvent event) {
        event.getWeapon().onHit(event);
    }
}
