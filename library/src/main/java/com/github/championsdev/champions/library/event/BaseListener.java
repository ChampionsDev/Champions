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

import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.cplayer.CPlayerHandler;
import com.github.championsdev.champions.library.database.DataManager;
import com.github.championsdev.champions.library.event.cplayer.*;
import com.github.championsdev.champions.library.event.skill.SkillUseEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponHitEvent;
import com.github.championsdev.champions.library.level.exp.sources.MobKillExpSource;
import com.github.championsdev.champions.library.level.exp.sources.PlayerKillExpSource;

/**
 * @author B2OJustin
 */
public class BaseListener implements EventListener {

    @CEventHandler
    public void onSkillUseEvent(SkillUseEvent event) {
        event.getSkill().getBehavior().onUse(event);
    }

    @CEventHandler
    public void onWeaponHitEvent(WeaponHitEvent event) {
        event.getWeapon().getBehavior().onHit(event);
    }

    @CEventHandler
    public void onWeaponClickEvent(WeaponClickEvent event) {
        event.getWeapon().getBehavior().onClick(event);
    }

    @CEventHandler
    public void onCPlayerQuit(CPlayerQuitEvent event) {
        DataManager.getDataSource().saveLPlayer(event.getCPlayer());
        CPlayerHandler.getInstance().remove(event.getCPlayer(), true);
        event.getCPlayer().getBehavior().onQuit(event);
    }

    @CEventHandler
    public void onCPlayerJoin(CPlayerJoinEvent event) {
        event.getCPlayer().getBehavior().onJoin(event);
    }

    @CEventHandler
    public void onCPlayerDeath(CPlayerDeathEvent event) {
        event.getCPlayer().getBehavior().onDeath(event);
    }

    @CEventHandler
    public void onCPlayerKill(CPlayerKillEvent event) {
        event.getKiller().addExp(new PlayerKillExpSource(event.getKilled().getName()));
        event.getKiller().getBehavior().onPlayerKill(event);
        event.getKilled().getBehavior().onPlayerKill(event);
    }

    @CEventHandler
    public void onCPlayerMobKill(CPlayerMobKillEvent event) {
        event.getCPlayer().addExp(new MobKillExpSource(event.getMobId()));
        event.getCPlayer().getBehavior().onMobKill(event);
    }
}
