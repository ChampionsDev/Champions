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
import com.github.legendsdev.legends.library.level.Level;
import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.level.LevelRestrictions;
import com.github.legendsdev.legends.library.level.LevelUser;
import com.github.legendsdev.legends.library.race.Race;
import com.github.legendsdev.legends.library.race.RaceRestricted;
import com.github.legendsdev.legends.library.race.RaceUser;
import com.github.legendsdev.legends.library.skill.*;
import com.github.legendsdev.legends.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class LPlayer implements LEntity,
        WeaponUser, ArmorUser<LPlayer>, SkillUser<LPlayer>, LClassUser, RaceUser,
        WeaponRestricted, ArmorRestricted, SkillRestricted, LevelRestricted, LClassRestricted, RaceRestricted {
    private Race race = new Race();
    private LClass primaryClass = new LClass();
    private LClass secondaryClass = new LClass();
    private LevelRestrictions levelRestrictions = new LevelRestrictions();
    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private LClassInfo primaryClassInfo = new LClassInfo();
    private LClassInfo secondaryClassInfo = new LClassInfo();

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
        return null;
    }

    @Override
    public ArrayList<Skill> getSkills() {
        return null;
    }

    @Override
    public LPlayer addSkill(Skill skill) {
        return this; //TODO addSkill method stub
    }

    @Override
    public LPlayer removeSkill(Skill skill) {
        return this; //TODO removeSkill method stub
    }

    @Override
    public HashMap<Skill, SkillInfo> getSkillInfoMap() {
        return null; //TODO getSkillInfoMap method stub
    }

    @Override
    public LPlayer setSkillInfo(Skill skill, SkillInfo info) {
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
        return null;
    }

    @Override
    public ArmorRestrictions getArmorRestrictions() {
        return null;
    }

    @Override
    public WeaponRestrictions getWeaponRestrictions() {
        return null;
    }

    @Override
    public LevelRestrictions getLevelRestrictions() {
        return levelRestrictions;
    }

    @Override
    public LClassRestrictions getLClassRestrictions() {
        return null; //TODO getLClassRestrictions method stub
    }

    @Override
    public HashMap<String, WeaponInfo> getWeaponInfoMap() {
        return null; //TODO getWeaponInfoMap method stub
    }

    @Override
    public WeaponInfo getWeaponInfo(Weapon weapon) {
        return null; //TODO getWeaponInfo method stub
    }

    @Override
    public WeaponUser setWeaponInfo(Weapon weapon, WeaponInfo info) {
        return null; //TODO setWeaponInfo method stub
    }

    @Override
    public HashMap<Armor, ArmorInfo> getArmorInfoMap() {
        return null; //TODO getArmorInfoMap method stub
    }

    @Override
    public ArmorInfo getArmorInfo(Armor armor) {
        return null; //TODO getArmorInfo method stub
    }

    @Override
    public LPlayer setArmorInfo(Armor armor, ArmorInfo info) {
        return this; //TODO setArmorInfo method stub
    }
}
