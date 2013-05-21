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

import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorRestrictions;
import com.github.championsdev.champions.library.cclass.CClassRestricted;
import com.github.championsdev.champions.library.cclass.CClassRestrictions;
import com.github.championsdev.champions.library.level.LevelRestricted;
import com.github.championsdev.champions.library.level.LevelRestrictions;
import com.github.championsdev.champions.library.race.RaceRestricted;
import com.github.championsdev.champions.library.race.RaceRestrictions;
import com.github.championsdev.champions.library.skill.SkillRestricted;
import com.github.championsdev.champions.library.skill.SkillRestrictions;
import com.github.championsdev.champions.library.weapon.WeaponRestricted;
import com.github.championsdev.champions.library.weapon.WeaponRestrictions;
import com.github.championsdev.champions.library.weapon.WeaponTypeRestricted;
import com.github.championsdev.champions.library.weapon.WeaponTypeRestrictions;

import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class RestrictionHandler {
    private static RestrictionHandler instance = new RestrictionHandler();

    private HashMap<SkillRestricted, SkillRestrictions> skillMap = new HashMap<>();
    private HashMap<LevelRestricted, LevelRestrictions> levelMap = new HashMap<>();
    private HashMap<RaceRestricted, RaceRestrictions> raceMap = new HashMap<>();
    private HashMap<CClassRestricted, CClassRestrictions> classMap = new HashMap<>();
    private HashMap<WeaponRestricted, WeaponRestrictions> weaponMap = new HashMap<>();
    private HashMap<WeaponTypeRestricted, WeaponTypeRestrictions> weaponTypeMap = new HashMap<>();
    private HashMap<ArmorRestricted, ArmorRestrictions> armorMap = new HashMap<>();

    public static RestrictionHandler getInstance() {
        return instance;
    }

    private RestrictionHandler(){}

    public SkillRestrictions getSkillRestrictions(SkillRestricted restricted) {
        SkillRestrictions restrictions = skillMap.get(restricted);
        if(restrictions == null) {
            restrictions = new SkillRestrictions();
            skillMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setSkillRestrictions(SkillRestricted restricted, SkillRestrictions restrictions) {
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

    public RaceRestrictions getRaceRestrictions(RaceRestricted restricted) {
        RaceRestrictions restrictions = raceMap.get(restricted);
        if(restrictions == null) {
            restrictions = new RaceRestrictions();
            raceMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setRaceRestrictions(RaceRestricted restricted, RaceRestrictions restrictions) {
        raceMap.put(restricted, restrictions);
        return this;
    }

    public CClassRestrictions getClassRestrictions(CClassRestricted restricted) {
        CClassRestrictions restrictions = classMap.get(restricted);
        if(restrictions == null) {
            restrictions = new CClassRestrictions();
            classMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setClassRestrictions(CClassRestricted restricted, CClassRestrictions restrictions) {
        classMap.put(restricted, restrictions);
        return this;
    }

    public WeaponRestrictions getWeaponRestrictions(WeaponRestricted restricted) {
        WeaponRestrictions restrictions = weaponMap.get(restricted);
        if(restrictions == null) {
            restrictions = new WeaponRestrictions();
            weaponMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setWeaponRestrictions(WeaponRestricted restricted, WeaponRestrictions restrictions) {
        weaponMap.put(restricted, restrictions);
        return this;
    }

    public WeaponTypeRestrictions getWeaponTypeRestrictions(WeaponTypeRestricted restricted) {
        WeaponTypeRestrictions restrictions = weaponTypeMap.get(restricted);
        if(restrictions == null) {
            restrictions = new WeaponTypeRestrictions();
            weaponTypeMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setWeaponTypeRestrictions(WeaponTypeRestricted restricted, WeaponTypeRestrictions restrictions) {
        weaponTypeMap.put(restricted, restrictions);
        return this;
    }

    public ArmorRestrictions getArmorRestrictions(ArmorRestricted restricted) {
        ArmorRestrictions restrictions = armorMap.get(restricted);
        if(restrictions == null) {
            restrictions = new ArmorRestrictions();
            armorMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setArmorRestrictions(ArmorRestricted restricted, ArmorRestrictions restrictions) {
        armorMap.put(restricted, restrictions);
        return this;
    }
}
