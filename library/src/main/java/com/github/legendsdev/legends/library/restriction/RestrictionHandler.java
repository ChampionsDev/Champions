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
package com.github.legendsdev.legends.library.restriction;

import com.github.legendsdev.legends.library.armor.ArmorRestricted;
import com.github.legendsdev.legends.library.armor.ArmorRestrictions;
import com.github.legendsdev.legends.library.lclass.LClassRestricted;
import com.github.legendsdev.legends.library.lclass.LClassRestrictions;
import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.level.LevelRestrictions;
import com.github.legendsdev.legends.library.race.RaceRestricted;
import com.github.legendsdev.legends.library.race.RaceRestrictions;
import com.github.legendsdev.legends.library.skill.SkillRestricted;
import com.github.legendsdev.legends.library.skill.SkillRestrictions;
import com.github.legendsdev.legends.library.weapon.WeaponRestricted;
import com.github.legendsdev.legends.library.weapon.WeaponRestrictions;

import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class RestrictionHandler {
    private static RestrictionHandler instance = new RestrictionHandler();

    private HashMap<SkillRestricted, SkillRestrictions> skillMap = new HashMap<>();
    private HashMap<LevelRestricted, LevelRestrictions> levelMap = new HashMap<>();
    private HashMap<RaceRestricted, RaceRestrictions> raceMap = new HashMap<>();
    private HashMap<LClassRestricted, LClassRestrictions> classMap = new HashMap<>();
    private HashMap<WeaponRestricted, WeaponRestrictions> weaponMap = new HashMap<>();
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

    public LClassRestrictions getClassRestrictions(LClassRestricted restricted) {
        LClassRestrictions restrictions = classMap.get(restricted);
        if(restrictions == null) {
            restrictions = new LClassRestrictions();
            classMap.put(restricted, restrictions);
        }
        return restrictions;
    }

    public RestrictionHandler setClassRestrictions(LClassRestricted restricted, LClassRestrictions restrictions) {
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
