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

package com.github.championsdev.champions.library.server;

import com.github.championsdev.champions.library.CWorld;
import com.github.championsdev.champions.library.Configuration;
import com.github.championsdev.champions.library.armor.ArmorCategoryHandler;
import com.github.championsdev.champions.library.armor.ArmorHandler;
import com.github.championsdev.champions.library.cclass.CClassHandler;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.cplayer.CPlayerHandler;
import com.github.championsdev.champions.library.database.DataManager;
import com.github.championsdev.champions.library.event.EventManager;
import com.github.championsdev.champions.library.messaging.MessageHandler;
import com.github.championsdev.champions.library.race.RaceHandler;
import com.github.championsdev.champions.library.restriction.RestrictionHandler;
import com.github.championsdev.champions.library.skill.SkillCategoryHandler;
import com.github.championsdev.champions.library.skill.SkillHandler;
import com.github.championsdev.champions.library.util.PlatformUtil;
import com.github.championsdev.champions.library.weapon.WeaponCategoryHandler;
import com.github.championsdev.champions.library.weapon.WeaponHandler;

import java.util.Collection;
import java.util.List;

/**
 * @author YoshiGenius
 */
public abstract class ServerBridge {

    public abstract String getServerVersion();

    public abstract String getCoreVersion();

    public abstract String getLibVersion();

    public abstract PlatformUtil.PlatformType getServerPlatform();

    public abstract String getIp();

    public abstract int getPort();

    public abstract void loadConfiguration();

    public abstract void registerMessengers();

    public abstract void registerEvents();

    public abstract void registerPermissions();

    protected void init() {
        initDataManagement();
        loadConfiguration();
        registerEvents();
        registerMessengers();
        registerPermissions();
    }

    protected void initDataManagement() {
        DataManager.init(Configuration.getInstance());
    }

    public EventManager getEventManager() {
        return EventManager.getInstance();
    }

    public CPlayerHandler getPlayerHandler() {
        return CPlayerHandler.getInstance();
    }

    public SkillHandler getSkillHandler() {
        return SkillHandler.getInstance();
    }

    public SkillCategoryHandler getSkillCategoryHandler() {
        return SkillCategoryHandler.getInstance();
    }

    public WeaponHandler getWeaponHandler() {
        return WeaponHandler.getInstance();
    }

    public WeaponCategoryHandler getWeaponCategoryHandler() {
        return WeaponCategoryHandler.getInstance();
    }

    public ArmorHandler getArmorHandler() {
        return ArmorHandler.getInstance();
    }

    public ArmorCategoryHandler ArmorCategoryHandler() {
        return ArmorCategoryHandler.getInstance();
    }

    public CClassHandler getClassHandler() {
        return CClassHandler.getInstance();
    }

    public RaceHandler getRaceHandler() {
        return RaceHandler.getInstance();
    }

    public RestrictionHandler getRestrictionHandler() {
        return RestrictionHandler.getInstance();
    }

}
