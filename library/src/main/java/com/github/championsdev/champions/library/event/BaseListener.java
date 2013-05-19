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
package com.github.championsdev.champions.library.event;

import com.github.championsdev.champions.library.cplayer.CPlayerHandler;
import com.github.championsdev.champions.library.database.DataManager;
import com.github.championsdev.champions.library.event.cplayer.CPlayerQuitEvent;
import com.github.championsdev.champions.library.event.skill.SkillUseEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponHitEvent;

/**
 * @author B2OJustin
 */
public class BaseListener implements EventListener {

    @CEventHandler
    public void onSkillUseEvent(SkillUseEvent event) {
        event.getSkill().onUse(event);
    }

    @CEventHandler
    public void onWeaponHitEvent(WeaponHitEvent event) {
        event.getWeapon().onHit(event);
    }

    @CEventHandler
    public void onWeaponClickEvent(WeaponClickEvent event) {
        event.getWeapon().onClick(event);
    }

    @CEventHandler
    public void onCPlayerQuit(CPlayerQuitEvent event) {
        DataManager.getDataSource().saveLPlayer(event.getCPlayer());
        CPlayerHandler.getInstance().remove(event.getCPlayer(), true);
        event.getCPlayer().onQuit(event);
    }
}
