/*******************************************************************************
 * This file is part of Champions.
 *
 *     Champions is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Champions is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Champions.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.github.championsdev.champions.library.event;

import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cclass.CClassType;
import com.github.championsdev.champions.library.cplayer.CPlayerHandler;
import com.github.championsdev.champions.library.database.DataManager;
import com.github.championsdev.champions.library.event.cplayer.*;
import com.github.championsdev.champions.library.event.skill.SkillUseEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponHitEvent;
import com.github.championsdev.champions.library.restriction.BasicRestrictions;
import com.github.championsdev.champions.library.restriction.RestrictionHandler;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.util.LevelUtil;
import com.github.championsdev.champions.library.level.exp.Exp;
import com.github.championsdev.champions.library.level.exp.sources.ExpSource;
import com.github.championsdev.champions.library.level.exp.sources.MobKillExpSource;
import com.github.championsdev.champions.library.level.exp.sources.PlayerKillExpSource;

/**
 * @author B2OJustin
 */
public class BaseListener implements EventListener {

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onSkillUseEvent(SkillUseEvent event) {
        event.getSkill().getBehavior().onSkillUse(event);
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onWeaponHitEvent(WeaponHitEvent event) {
        event.getWeapon().getBehavior().onHit(event);
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onWeaponClickEvent(WeaponClickEvent event) {
        event.getWeapon().getBehavior().onClick(event);
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCPlayerQuit(CPlayerQuitEvent event) {
        DataManager.getDataSource().saveLPlayer(event.getCPlayer());
        CPlayerHandler.getInstance().remove(event.getCPlayer(), true);
        event.getCPlayer().getBehavior().onQuit(event);
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCPlayerJoin(CPlayerJoinEvent event) {
        event.getCPlayer().getBehavior().onJoin(event);
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCPlayerWeaponChange(CPlayerWeaponChangeEvent event) {
        event.getCPlayer().getBehavior().onWeaponChange(event);
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCPlayerDeath(CPlayerDeathEvent event) {
        event.getCPlayer().getBehavior().onDeath(event);
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCPlayerKill(CPlayerKillEvent event) {
        ExpSource source = new PlayerKillExpSource(event.getKilled().getName());
        Exp expGain = event.getKiller().addExp(new PlayerKillExpSource(event.getKilled().getName()));
        event.getKiller().getBehavior().onPlayerKill(event);
        event.getKilled().getBehavior().onPlayerKill(event);
        if(expGain.getExp() != 0) {
            EventManager.callEvent(new CPlayerExpGainEvent(event.getKiller(), source, expGain));
        }
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCPlayerMobKill(CPlayerMobKillEvent event) {
        ExpSource expSource = new MobKillExpSource(event.getMobId());
        Exp expGain = event.getCPlayer().addExp(expSource);
        event.getCPlayer().getBehavior().onMobKill(event);
        if(expGain.getExp() != 0) {
            EventManager.callEvent(new CPlayerExpGainEvent(event.getCPlayer(), expSource, expGain));
        }
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCPlayerExpGain(CPlayerExpGainEvent event) {
        if(LevelUtil.shouldLevelUp(event.getCPlayer().getPrimaryClassAttributes().getLevel())) {
            event.getCPlayer().getPrimaryClassAttributes().getLevel().levelUp();
            LevelUtil.levelUp(event.getCPlayer(), CClassType.PRIMARY);
        }
        if(LevelUtil.shouldLevelUp(event.getCPlayer().getSecondaryClassAttributes().getLevel())) {
            event.getCPlayer().getSecondaryClassAttributes().getLevel().levelUp();
            LevelUtil.levelUp(event.getCPlayer(), CClassType.SECONDARY);
        }
        event.getCPlayer().getBehavior().onExpGain(event);
    }

    @CEventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCPlayerLevelUp(CPlayerLevelUpEvent event) {
        event.getCPlayer().getBehavior().onLevelUp(event);
    }
}
