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

package net.dawnfirerealms.legends.library.race;


import net.dawnfirerealms.legends.library.armor.*;
import net.dawnfirerealms.legends.library.skill.*;
import net.dawnfirerealms.legends.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class Race implements ArmorUser<Race>, SkillUser<Race>, WeaponUser<Race>, SkillRestricted, WeaponRestricted, ArmorRestricted {
    private String name = "";
    private ArrayList<String> description = new ArrayList<>();
    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private HashMap<Weapon, WeaponInfo> weaponInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorInfo> armorInfoMap = new HashMap<>();

    private WeaponRestrictions weaponRestrictions = new WeaponRestrictions();
    private ArmorRestrictions armorRestrictions = new ArmorRestrictions();
    private SkillRestrictions skillRestrictions = new SkillRestrictions();

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
    public WeaponRestrictions getWeaponRestrictions() {
        return weaponRestrictions;
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
        skillInfoMap.put(skill, info);
        return this;
    }

    @Override
    public HashMap<Armor, ArmorInfo> getArmorInfoMap() {
        return armorInfoMap;
    }

    @Override
    public ArmorInfo getArmorInfo(Armor armor) {
        ArmorInfo armorInfo = armorInfoMap.get(armor);
        if(armorInfo == null) {
            armorInfo = new ArmorInfo();
            armorInfoMap.put(armor, armorInfo);
        }
        return armorInfo;
    }

    @Override
    public Race setArmorInfo(Armor armor, ArmorInfo info) {
        armorInfoMap.put(armor, info);
        return this;
    }

    @Override
    public HashMap<Weapon, WeaponInfo> getWeaponInfoMap() {
        return weaponInfoMap;
    }

    @Override
    public WeaponInfo getWeaponInfo(Weapon weapon) {
        WeaponInfo weaponInfo = weaponInfoMap.get(weapon);
        if(weaponInfo == null) {
            weaponInfo = new WeaponInfo();
            weaponInfoMap.put(weapon, weaponInfo);
        }
        return weaponInfo;
    }

    @Override
    public Race setWeaponInfo(Weapon weapon, WeaponInfo info) {
        weaponInfoMap.put(weapon, info);
        return this;
    }

    @Override
    public ArmorRestrictions getArmorRestrictions() {
        return armorRestrictions;
    }

    @Override
    public SkillRestrictions getSkillRestrictions() {
        return skillRestrictions;
    }
}
