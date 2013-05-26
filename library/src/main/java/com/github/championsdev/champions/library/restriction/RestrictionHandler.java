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
package com.github.championsdev.champions.library.restriction;

import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cclass.CClassRestricted;
import com.github.championsdev.champions.library.level.LevelRestricted;
import com.github.championsdev.champions.library.level.LevelRestrictions;
import com.github.championsdev.champions.library.race.Race;
import com.github.championsdev.champions.library.race.RaceRestricted;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.skill.SkillRestricted;
import com.github.championsdev.champions.library.weapon.Weapon;
import com.github.championsdev.champions.library.weapon.WeaponCategory;
import com.github.championsdev.champions.library.weapon.WeaponCategoryRestricted;
import com.github.championsdev.champions.library.weapon.WeaponRestricted;

import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class RestrictionHandler {
    private static RestrictionHandler instance = new RestrictionHandler();

    private HashMap<SkillRestricted, BasicRestrictions<Skill>> skillMap = new HashMap<>();
    private HashMap<LevelRestricted, LevelRestrictions> levelMap = new HashMap<>();
    private HashMap<RaceRestricted, BasicRestrictions<Race>> raceMap = new HashMap<>();
    private HashMap<CClassRestricted, BasicRestrictions<CClass>> classMap = new HashMap<>();
    private HashMap<WeaponRestricted, BasicRestrictions<Weapon>> weaponMap = new HashMap<>();
    private HashMap<WeaponCategoryRestricted, BasicRestrictions<WeaponCategory>> weaponTypeMap = new HashMap<>();
    private HashMap<ArmorRestricted, BasicRestrictions<Armor>> armorMap = new HashMap<>();

    public static RestrictionHandler getInstance() {
        return instance;
    }

    private RestrictionHandler(){}

    public BasicRestrictions<Skill> getSkillRestrictions(SkillRestricted restricted) {
        BasicRestrictions<Skill> restrictions = skillMap.get(restricted);
        if(restrictions == null) {
            restrictions = new BasicRestrictions<>();
            skillMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setSkillRestrictions(SkillRestricted restricted, BasicRestrictions<Skill> restrictions) {
        skillMap.put(restricted, restrictions);
        return this;
    }

    public LevelRestrictions getLevelRestrictions(LevelRestricted restricted) {
        LevelRestrictions restrictions = levelMap.get(restricted);
        if(restrictions == null) {
            restrictions = new LevelRestrictions();
            levelMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setLevelRestrictions(LevelRestricted restricted, LevelRestrictions restrictions) {
        levelMap.put(restricted, restrictions);
        return this;
    }

    public BasicRestrictions<Race> getRaceRestrictions(RaceRestricted restricted) {
        BasicRestrictions<Race> restrictions = raceMap.get(restricted);
        if(restrictions == null) {
            restrictions = new BasicRestrictions<>();
            raceMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setRaceRestrictions(RaceRestricted restricted, BasicRestrictions<Race> restrictions) {
        raceMap.put(restricted, restrictions);
        return this;
    }

    public BasicRestrictions<CClass> getClassRestrictions(CClassRestricted restricted) {
        BasicRestrictions<CClass> restrictions = classMap.get(restricted);
        if(restrictions == null) {
            restrictions = new BasicRestrictions<>();
            classMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setClassRestrictions(CClassRestricted restricted, BasicRestrictions<CClass> restrictions) {
        classMap.put(restricted, restrictions);
        return this;
    }

    public BasicRestrictions<Weapon> getWeaponRestrictions(WeaponRestricted restricted) {
        BasicRestrictions<Weapon> restrictions = weaponMap.get(restricted);
        if(restrictions == null) {
            restrictions = new BasicRestrictions<>();
            weaponMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setWeaponRestrictions(WeaponRestricted restricted, BasicRestrictions<Weapon> restrictions) {
        weaponMap.put(restricted, restrictions);
        return this;
    }

    public BasicRestrictions<WeaponCategory> getWeaponTypeRestrictions(WeaponCategoryRestricted restricted) {
        BasicRestrictions<WeaponCategory> restrictions = weaponTypeMap.get(restricted);
        if(restrictions == null) {
            restrictions = new BasicRestrictions<>();
            weaponTypeMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setWeaponTypeRestrictions(WeaponCategoryRestricted restricted, BasicRestrictions<WeaponCategory> restrictions) {
        weaponTypeMap.put(restricted, restrictions);
        return this;
    }

    public BasicRestrictions<Armor> getArmorRestrictions(ArmorRestricted restricted) {
        BasicRestrictions<Armor> restrictions = armorMap.get(restricted);
        if(restrictions == null) {
            restrictions = new BasicRestrictions<>();
            armorMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setArmorRestrictions(ArmorRestricted restricted, BasicRestrictions<Armor> restrictions) {
        armorMap.put(restricted, restrictions);
        return this;
    }
}
