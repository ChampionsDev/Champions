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

package com.github.championsdev.champions.library.cclass;

import com.github.championsdev.champions.library.BasicCategory;
import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorAttributes;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorUser;
import com.github.championsdev.champions.library.behavior.BehaviorGroup;
import com.github.championsdev.champions.library.behavior.Behavioral;
import com.github.championsdev.champions.library.level.exp.Exp;
import com.github.championsdev.champions.library.level.exp.ExpGroup;
import com.github.championsdev.champions.library.level.exp.sources.ExpSource;
import com.github.championsdev.champions.library.misc.Identifiable;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.restriction.Restrictable;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.skill.SkillAttributes;
import com.github.championsdev.champions.library.skill.SkillRestricted;
import com.github.championsdev.champions.library.skill.SkillUser;
import com.github.championsdev.champions.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author YoshiGenius
 */
public class CClass implements Informative<CClass, CClassAttributes>, Identifiable<CClass>,
        WeaponRestricted, WeaponCategoryRestricted, ArmorRestricted, SkillRestricted,
        WeaponUser<CClass>, SkillUser<CClass>, ArmorUser<CClass>,
        Behavioral<CClass>,Restrictable {

    private ArrayList<String> description = new ArrayList<>();
    private String name = "";
    private String id = "";

    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private HashMap<Skill, SkillAttributes> skillAttributesMap = new HashMap<>();
    private HashMap<Weapon, WeaponAttributes> weaponAttributesMap = new HashMap<>();
    private HashMap<BasicCategory<WeaponAttributes>, WeaponAttributes> weaponCategoryAttributesMap = new HashMap<>();
    private HashMap<Armor, ArmorAttributes> armorAttributesMap = new HashMap<>();

    private BehaviorGroup behaviorGroup = new BehaviorGroup();

    private LinkedHashMap<ExpGroup, Double> expGroups = new LinkedHashMap<>();

    private CClassAttributes cClassMeta = new CClassAttributes();


    public CClass() {
    }

    public CClass(String id, ArrayList<String> description) {
        this.name = id;
        this.id = id;
        this.description = description;
    }

    public Exp getExpGain(ExpSource source) {
        Exp exp = new Exp();
        for(Map.Entry<ExpGroup, Double> entry : expGroups.entrySet()) {
            exp.addExp(entry.getKey().getExp(source).getExp() * entry.getValue());
        }
        return exp;
    }

    public CClass addExpGroup(ExpGroup expGroup, double modifier) {
        expGroups.put(expGroup, modifier);
        return this;
    }

    public CClass addExpGroup(ExpGroup expGroup) {
        addExpGroup(expGroup, 1f);
        return this;
    }

    public CClass removeExpGroup(ExpGroup expGroup) {
        expGroups.remove(expGroup);
        return this;
    }

    @Override
    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CClass setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CClass setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public CClassAttributes getAttributes() {
        return cClassMeta;
    }

    @Override
    public CClass setAttributes(CClassAttributes attributes) {
        cClassMeta = attributes;
        return this;
    }

    @Override
    public HashMap<Armor, ArmorAttributes> getArmorAttributesMap() {
        return armorAttributesMap;
    }

    @Override
    public ArmorAttributes getArmorAttributes(Armor armor) {
        if(armor != null) {
            ArmorAttributes armorMeta = armorAttributesMap.get(armor);
            if(armorMeta == null) {
                armorMeta = new ArmorAttributes();
                armorAttributesMap.put(armor, armorMeta);
            }
            return armorMeta;
        }
        return null;
    }

    @Override
    public CClass setArmorAttributes(Armor armor, ArmorAttributes info) {
        if(armor != null) {
            armorAttributesMap.put(armor, info);
        }
        return this;
    }

    @Override
    public HashMap<BasicCategory<ArmorAttributes>, ArmorAttributes> getArmorCategoryAttributesMap() {
        return null; //TODO getArmorCategoryAttributesMap method stub
    }

    @Override
    public ArmorAttributes getArmorCategoryAttributes(BasicCategory<ArmorAttributes> category) {
        return null; //TODO getArmorCategoryAttributes method stub
    }

    @Override
    public CClass setArmorCategoryAttributes(BasicCategory<ArmorAttributes> category, ArmorAttributes info) {
        return null; //TODO setArmorCategoryAttributes method stub
    }

    @Override
    public ArrayList<Skill> getSkills() {
        return currentSkills;
    }

    @Override
    public CClass addSkill(Skill skill) {
        if(skill != null) {
            currentSkills.add(skill);
        }
        return this;
    }

    @Override
    public CClass removeSkill(Skill skill) {
        currentSkills.remove(skill);
        return this;
    }

    @Override
    public HashMap<Skill, SkillAttributes> getSkillAttributesMap() {
        return skillAttributesMap;
    }

    @Override
    public SkillAttributes getSkillAttributes(Skill skill) {
        if(skill != null) {
            SkillAttributes skillAttributes = skillAttributesMap.get(skill);
            if(skillAttributes == null) {
                skillAttributes = new SkillAttributes();
                skillAttributesMap.put(skill, skillAttributes);
            }
            return skillAttributes;
        }
        return null;
    }

    @Override
    public CClass setSkillAttributes(Skill skill, SkillAttributes info) {
        if(skill != null) {
            skillAttributesMap.put(skill, info);
        }
        return this;
    }

    @Override
    public HashMap<BasicCategory<SkillAttributes>, SkillAttributes> getSkillCategoryAttributesMap() {
        return null; //TODO getSkillCategoryAttributesMap method stub
    }

    @Override
    public SkillAttributes getSkillCategoryAttributes(BasicCategory<SkillAttributes> category) {
        return null; //TODO getSkillCategoryAttributes method stub
    }

    @Override
    public CClass setSkillCategoryAttributes(BasicCategory<SkillAttributes> category, SkillAttributes info) {
        return null; //TODO setSkillCategoryAttributes method stub
    }

    @Override
    public HashMap<Weapon, WeaponAttributes> getWeaponAttributesMap() {
        return weaponAttributesMap;
    }

    @Override
    public WeaponAttributes getWeaponAttributes(Weapon weapon) {
        if(weapon != null) {
            WeaponAttributes weaponMeta = weaponAttributesMap.get(weapon);
            if(weaponMeta == null) {
                weaponMeta = new WeaponAttributes();
                weaponAttributesMap.put(weapon, weaponMeta);
            }
            return weaponMeta;
        }
        return null;
    }

    @Override
    public CClass setWeaponAttributes(Weapon weapon, WeaponAttributes attributes) {
        if(weapon != null) {
            weaponAttributesMap.put(weapon, attributes);
        }
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public CClass setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public HashMap<BasicCategory<WeaponAttributes>, WeaponAttributes> getWeaponCategoryAttributesMap() {
        return weaponCategoryAttributesMap;
    }

    @Override
    public WeaponAttributes getWeaponCategoryAttributes(BasicCategory<WeaponAttributes> weaponCategory) {
        if(weaponCategory != null) {
            WeaponAttributes weaponMeta = weaponCategoryAttributesMap.get(weaponCategory);
            if(weaponMeta == null) {
                weaponMeta = new WeaponAttributes();
                weaponCategoryAttributesMap.put(weaponCategory, weaponMeta);
            }
            return weaponMeta;
        }
        return null;
    }

    @Override
    public CClass setWeaponCategoryAttributes(BasicCategory<WeaponAttributes> weaponCategory, WeaponAttributes info) {
        if(weaponCategory != null) {
            weaponCategoryAttributesMap.put(weaponCategory, info);
        }
        return this;
    }

    @Override
    public BehaviorGroup getBehavior() {
        return behaviorGroup;
    }

    @Override
    public CClass setBehavior(BehaviorGroup behavior) {
        behaviorGroup = behavior;
        return this;
    }
}