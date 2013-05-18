/*
This file is part of Legends

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.championsdev.champions.library.race;


import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorInfo;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorUser;
import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cclass.CClassInfo;
import com.github.championsdev.champions.library.cclass.CClassRestricted;
import com.github.championsdev.champions.library.cclass.CClassUser;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.skill.SkillInfo;
import com.github.championsdev.champions.library.skill.SkillRestricted;
import com.github.championsdev.champions.library.skill.SkillUser;
import com.github.championsdev.champions.library.weapon.Weapon;
import com.github.championsdev.champions.library.weapon.WeaponInfo;
import com.github.championsdev.champions.library.weapon.WeaponRestricted;
import com.github.championsdev.champions.library.weapon.WeaponUser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class Race implements Informative<Race, RaceInfo>, ArmorUser<Race>, SkillUser<Race>, WeaponUser<Race>, CClassUser<Race>,
        SkillRestricted, WeaponRestricted, ArmorRestricted, CClassRestricted {
    private String name = "";
    private ArrayList<String> description = new ArrayList<>();
    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private HashMap<Weapon, WeaponInfo> weaponInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorInfo> armorInfoMap = new HashMap<>();
    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private HashMap<CClass, CClassInfo> lClassInfoMap = new HashMap<>();

    private RaceInfo raceInfo = new RaceInfo();

    public Race() {
    }

    public Race setName(String name) {
        this.name = name;
        return this;
    }

    public Race setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public RaceInfo getDefaultInfo() {
        return raceInfo;
    }

    @Override
    public Race setDefaultInfo(RaceInfo info) {
        this.raceInfo = info;
        return this;
    }

    public String getName() {
        return name;
    }
    
    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public ArrayList<Skill> getSkills() {
        return currentSkills;
    }

    @Override
    public Race addSkill(Skill skill) {
        currentSkills.add(skill);
        return this;
    }

    @Override
    public Race removeSkill(Skill skill) {
        currentSkills.remove(skill);
        return this;
    }

    @Override
    public HashMap<Skill, SkillInfo> getSkillInfoMap() {
        return skillInfoMap;
    }

    @Override
    public SkillInfo getSkillInfo(Skill skill) {
        return skillInfoMap.get(skill);
    }

    @Override
    public Race setSkillInfo(Skill skill, SkillInfo info) {
        if(skill != null) {
            skillInfoMap.put(skill, info);
        }
        return this;
    }

    @Override
    public HashMap<Armor, ArmorInfo> getArmorInfoMap() {
        return armorInfoMap;
    }

    @Override
    public ArmorInfo getArmorInfo(Armor armor) {
        if(armor != null) {
            ArmorInfo armorInfo = armorInfoMap.get(armor);
            if(armorInfo == null) {
                armorInfo = new ArmorInfo();
                armorInfoMap.put(armor, armorInfo);
            }
            return armorInfo;
        }
        return null;
    }

    @Override
    public Race setArmorInfo(Armor armor, ArmorInfo info) {
        if(armor != null) {
            armorInfoMap.put(armor, info);
        }
        return this;
    }

    @Override
    public HashMap<Weapon, WeaponInfo> getWeaponInfoMap() {
        return weaponInfoMap;
    }

    @Override
    public WeaponInfo getWeaponInfo(Weapon weapon) {
        if(weapon != null) {
            WeaponInfo weaponInfo = weaponInfoMap.get(weapon);
            if(weaponInfo == null) {
                weaponInfo = new WeaponInfo();
                weaponInfoMap.put(weapon, weaponInfo);
            }
            return weaponInfo;
        }
        return null;
    }

    @Override
    public Race setWeaponInfo(Weapon weapon, WeaponInfo info) {
        if(weapon != null) {
            weaponInfoMap.put(weapon, info);
        }
        return this;
    }

    @Override
    public HashMap<CClass, CClassInfo> getLClassInfoMap() {
        return lClassInfoMap;
    }

    @Override
    public CClassInfo getLClassInfo(CClass cClass) {
        if(cClass != null) {
            CClassInfo cClassInfo = lClassInfoMap.get(cClass);
            if(cClassInfo == null) {
                cClassInfo = new CClassInfo();
                lClassInfoMap.put(cClass, cClassInfo);
            }
            return cClassInfo;
        }
        return null;
    }

    @Override
    public Race setLClassInfo(CClass cClass, CClassInfo info) {
        if(cClass != null) {
            lClassInfoMap.put(cClass, info);
        }
        return this;
    }
}
