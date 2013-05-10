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
package com.github.legendsdev.legends.library;


import com.github.legendsdev.legends.library.armor.*;
import com.github.legendsdev.legends.library.lclass.*;
import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.level.LevelRestrictions;
import com.github.legendsdev.legends.library.race.*;
import com.github.legendsdev.legends.library.skill.*;
import com.github.legendsdev.legends.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class LPlayer implements LEntity,
        WeaponUser<LPlayer>, ArmorUser<LPlayer>, SkillUser<LPlayer>, LClassUser<LPlayer>, RaceUser<LPlayer>,
        WeaponRestricted, ArmorRestricted, SkillRestricted, LevelRestricted, LClassRestricted, RaceRestricted {

    private Race race = new Race();

    private LClass primaryClass = new LClass();
    private LClass secondaryClass = new LClass();
    private LClassInfo primaryClassInfo = new LClassInfo();
    private LClassInfo secondaryClassInfo = new LClassInfo();

    private LevelRestrictions levelRestrictions = new LevelRestrictions();
    private WeaponRestrictions weaponRestrictions = new WeaponRestrictions();
    private ArmorRestrictions armorRestrictions = new ArmorRestrictions();
    private LClassRestrictions lClassRestrictions = new LClassRestrictions();
    private RaceRestrictions raceRestrictions = new RaceRestrictions();
    private SkillRestrictions skillRestrictions = new SkillRestrictions();

    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private HashMap<Weapon, WeaponInfo> weaponInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorInfo> armorInfoMap = new HashMap<>();
    private HashMap<Race, RaceInfo> raceInfoMap = new HashMap<>();

    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private Weapon currentWeapon = new Weapon();

    public LPlayer() {
    }

    public Race getRace() {
        return this.race;
    }

    @Override
    public LClass getPrimaryClass() {
        return this.primaryClass;
    }

    @Override
    public LClassInfo getPrimaryClassInfo() {
        return primaryClassInfo;
    }

    @Override
    public LClassInfo getSecondaryClassInfo() {
        return secondaryClassInfo;
    }

    @Override
    public LClass getSecondaryClass() {
        return secondaryClass;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    @Override
    public ArrayList<Skill> getSkills() {
        return currentSkills;
    }

    @Override
    public LPlayer addSkill(Skill skill) {
        if(skill != null) {
            currentSkills.add(skill);
        }
        return this;
    }

    @Override
    public LPlayer removeSkill(Skill skill) {
        currentSkills.remove(skill);
        return this;
    }

    @Override
    public HashMap<Skill, SkillInfo> getSkillInfoMap() {
        return skillInfoMap;
    }

    @Override
    public LPlayer setSkillInfo(Skill skill, SkillInfo info) {
        if(skill != null) {
            skillInfoMap.put(skill, info);
        }
        return this;
    }

    @Override
    public SkillInfo getSkillInfo(Skill skill) {
        if (!skillInfoMap.containsKey(skill)) {
            skillInfoMap.put(skill, new SkillInfo());
        }
        return skillInfoMap.get(skill);
    }

    @Override
    public SkillRestrictions getSkillRestrictions() {
        return skillRestrictions;
    }

    @Override
    public ArmorRestrictions getArmorRestrictions() {
        return armorRestrictions;
    }

    @Override
    public WeaponRestrictions getWeaponRestrictions() {
        return weaponRestrictions;
    }

    @Override
    public LevelRestrictions getLevelRestrictions() {
        return levelRestrictions;
    }

    @Override
    public LClassRestrictions getLClassRestrictions() {
        return lClassRestrictions;
    }

    @Override
    public HashMap<Weapon, WeaponInfo> getWeaponInfoMap() {
        return weaponInfoMap;
    }

    @Override
    public WeaponInfo getWeaponInfo(Weapon weapon) {
        return weaponInfoMap.get(weapon);
    }

    @Override
    public LPlayer setWeaponInfo(Weapon weapon, WeaponInfo info) {
        if(weapon != null) {
            weaponInfoMap.put(weapon, info);
        }
        return this;
    }

    @Override
    public HashMap<Armor, ArmorInfo> getArmorInfoMap() {
        return armorInfoMap;
    }

    @Override
    public ArmorInfo getArmorInfo(Armor armor) {
        return armorInfoMap.get(armor);
    }

    @Override
    public LPlayer setArmorInfo(Armor armor, ArmorInfo info) {
        if(armor != null) {
            armorInfoMap.put(armor, info);
        }
        return this;
    }

    @Override
    public RaceRestrictions getRaceRestrictions() {
        return raceRestrictions;
    }

    @Override
    public HashMap<Race, RaceInfo> getRaceInfoMap() {
        return raceInfoMap;
    }

    @Override
    public RaceInfo getRaceInfo(Race race) {
        return raceInfoMap.get(race);
    }

    @Override
    public LPlayer setRaceInfo(Race race, RaceInfo info) {
        if(race != null) {
            raceInfoMap.put(race, info);
        }
        return this;
    }
}
