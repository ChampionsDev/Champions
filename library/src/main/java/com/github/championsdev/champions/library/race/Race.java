/*
This file is part of Champions

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.championsdev.champions.library.race;


import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorAttributes;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorUser;
import com.github.championsdev.champions.library.behavior.BehaviorGroup;
import com.github.championsdev.champions.library.behavior.Behavioral;
import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cclass.CClassAttributes;
import com.github.championsdev.champions.library.cclass.CClassRestricted;
import com.github.championsdev.champions.library.cclass.CClassUser;
import com.github.championsdev.champions.library.misc.Identifiable;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.skill.SkillAttributes;
import com.github.championsdev.champions.library.skill.SkillRestricted;
import com.github.championsdev.champions.library.skill.SkillUser;
import com.github.championsdev.champions.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class Race implements Informative<Race, RaceAttributes>, Identifiable<Race>,
        ArmorUser<Race>, SkillUser<Race>, WeaponUser<Race>, WeaponTypeUser<Race>,
        CClassUser<Race>, SkillRestricted, WeaponRestricted, WeaponTypeRestricted, ArmorRestricted, CClassRestricted,
        Behavioral<Race>{
    private String name = "";
    private String id = "";
    private ArrayList<String> description = new ArrayList<>();
    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private HashMap<Weapon, WeaponAttributes> weaponInfoMap = new HashMap<>();
    private HashMap<WeaponType, WeaponAttributes> weaponTypeInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorAttributes> armorInfoMap = new HashMap<>();
    private HashMap<Skill, SkillAttributes> skillInfoMap = new HashMap<>();
    private HashMap<CClass, CClassAttributes> lClassInfoMap = new HashMap<>();

    private RaceAttributes raceMeta = new RaceAttributes();

    private BehaviorGroup behaviorGroup = new BehaviorGroup();

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
    public RaceAttributes getAttributes() {
        return raceMeta;
    }

    @Override
    public Race setAttributes(RaceAttributes attributes) {
        this.raceMeta = attributes;
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
    public HashMap<Skill, SkillAttributes> getSkillAttributesMap() {
        return skillInfoMap;
    }

    @Override
    public SkillAttributes getSkillAttributes(Skill skill) {
        return skillInfoMap.get(skill);
    }

    @Override
    public Race setSkillAttributes(Skill skill, SkillAttributes info) {
        if(skill != null) {
            skillInfoMap.put(skill, info);
        }
        return this;
    }

    @Override
    public HashMap<Armor, ArmorAttributes> getArmorAttributesMap() {
        return armorInfoMap;
    }

    @Override
    public ArmorAttributes getArmorAttributes(Armor armor) {
        if(armor != null) {
            ArmorAttributes armorMeta = armorInfoMap.get(armor);
            if(armorMeta == null) {
                armorMeta = new ArmorAttributes();
                armorInfoMap.put(armor, armorMeta);
            }
            return armorMeta;
        }
        return null;
    }

    @Override
    public Race setArmorInfo(Armor armor, ArmorAttributes info) {
        if(armor != null) {
            armorInfoMap.put(armor, info);
        }
        return this;
    }

    @Override
    public HashMap<Weapon, WeaponAttributes> getWeaponAttributesMap() {
        return weaponInfoMap;
    }

    @Override
    public WeaponAttributes getWeaponAttributes(Weapon weapon) {
        if(weapon != null) {
            WeaponAttributes weaponMeta = weaponInfoMap.get(weapon);
            if(weaponMeta == null) {
                weaponMeta = new WeaponAttributes();
                weaponInfoMap.put(weapon, weaponMeta);
            }
            return weaponMeta;
        }
        return null;
    }

    @Override
    public Race setWeaponAttributes(Weapon weapon, WeaponAttributes attributes) {
        if(weapon != null) {
            weaponInfoMap.put(weapon, attributes);
        }
        return this;
    }

    @Override
    public HashMap<CClass, CClassAttributes> getCClassAttributesMap() {
        return lClassInfoMap;
    }

    @Override
    public CClassAttributes getCClassAttributes(CClass cClass) {
        if(cClass != null) {
            CClassAttributes cClassMeta = lClassInfoMap.get(cClass);
            if(cClassMeta == null) {
                cClassMeta = new CClassAttributes();
                lClassInfoMap.put(cClass, cClassMeta);
            }
            return cClassMeta;
        }
        return null;
    }

    @Override
    public Race setCClassAttributes(CClass cClass, CClassAttributes info) {
        if(cClass != null) {
            lClassInfoMap.put(cClass, info);
        }
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Race setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public HashMap<WeaponType, WeaponAttributes> getWeaponTypeAttributesMap() {
        return weaponTypeInfoMap;
    }

    @Override
    public WeaponAttributes getWeaponTypeInfo(WeaponType weaponType) {
        if(weaponType != null) {
            WeaponAttributes weaponMeta = weaponTypeInfoMap.get(weaponType);
            if(weaponMeta == null) {
                weaponMeta = new WeaponAttributes();
                weaponTypeInfoMap.put(weaponType, weaponMeta);
            }
            return weaponMeta;
        }
        return null;
    }

    @Override
    public Race setWeaponTypeInfo(WeaponType weaponType, WeaponAttributes info) {
        if(weaponType != null) {
            weaponTypeInfoMap.put(weaponType, info);
        }
        return this;
    }

    @Override
    public BehaviorGroup getBehavior() {
        return behaviorGroup;
    }

    @Override
    public Race setBehavior(BehaviorGroup behavior) {
        this.behaviorGroup = behavior;
        return this;
    }
}
