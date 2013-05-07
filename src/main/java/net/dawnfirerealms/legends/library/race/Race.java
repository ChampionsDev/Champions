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
import net.dawnfirerealms.legends.library.restriction.IDRestrictable;
import net.dawnfirerealms.legends.library.skill.*;
import net.dawnfirerealms.legends.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class Race implements ArmorUser<Race>, SkillUser<Race>, WeaponUser<Race>, SkillRestricted, WeaponRestricted, ArmorRestricted, IDRestrictable {
    private String name = "";
    private ArrayList<String> description = new ArrayList<>();
    private HashMap<String, SkillInfo> skillInfo = new HashMap<>();
    private WeaponRestrictions weaponRestrictions = new WeaponRestrictions();

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
        return null; //TODO getSkills method stub
    }

    @Override
    public Race addSkill(Skill skill) {
        return this; //TODO addSkill method stub
    }

    @Override
    public Race removeSkill(Skill skill) {
        return this; //TODO removeSkill method stub
    }

    @Override
    public WeaponRestrictions getWeaponRestrictions() {
        return weaponRestrictions;
    }

    @Override
    public String getId() {
        return name;
    }

    @Override
    public HashMap<String, SkillInfo> getSkillInfoMap() {
        return skillInfo;
    }

    @Override
    public SkillInfo getSkillInfo(Skill skill) {
        return skillInfo.get(skill);
    }

    @Override
    public Race setSkillInfo(Skill skill, SkillInfo info) {
        return this; //TODO getSkillInfo method stub
    }

    @Override
    public HashMap<String, ArmorInfo> getArmorInfoMap() {
        return null; //TODO getArmorInfoMap method stub
    }

    @Override
    public ArmorInfo getArmorInfo(Armor armor) {
        return null; //TODO getArmorInfo method stub
    }

    @Override
    public Race setArmorInfo(Armor armor, ArmorInfo info) {
        return this; //TODO setArmorInfo method stub
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
    public Race setWeaponInfo(Weapon weapon, WeaponInfo info) {
        return this; //TODO setWeaponInfo method stub
    }

    @Override
    public ArmorRestrictions getArmorRestrictions() {
        return null; //TODO getArmorRestrictions method stub
    }

    @Override
    public SkillRestrictions getSkillRestrictions() {
        return null; //TODO getSkillRestrictions method stub
    }
}
