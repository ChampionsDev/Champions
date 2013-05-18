package com.github.championsdev.champions.library.cclass;

import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorInfo;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorUser;
import com.github.championsdev.champions.library.level.exp.Exp;
import com.github.championsdev.champions.library.level.LevelRestricted;
import com.github.championsdev.champions.library.level.exp.ExpGroup;
import com.github.championsdev.champions.library.level.exp.sources.ExpSource;
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
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author YoshiGenius
 */
public class CClass implements Informative<CClass, CClassInfo>,
        LevelRestricted, WeaponRestricted, ArmorRestricted, SkillRestricted,
        WeaponUser<CClass>, SkillUser<CClass>, ArmorUser<CClass> {

    private ArrayList<String> description = new ArrayList<>();
    private String name = "";

    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private HashMap<Weapon, WeaponInfo> weaponInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorInfo> armorInfoMap = new HashMap<>();

    private LinkedHashMap<ExpGroup, Float> expGroups = new LinkedHashMap<>();

    private CClassInfo cClassInfo = new CClassInfo();


    public CClass() {
    }

    public CClass(String name, ArrayList<String> description) {
        this.name = name;
        this.description = description;
    }

    public Exp getExpGain(ExpSource source) {
        Exp exp = new Exp();
        for(Map.Entry<ExpGroup, Float> entry : expGroups.entrySet()) {
            exp.addExp(entry.getKey().getExp(source).getExp() * entry.getValue());
        }
        return exp;
    }

    public CClass addExpGroup(ExpGroup expGroup, float modifier) {
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
    public CClassInfo getDefaultInfo() {
        return cClassInfo;
    }

    @Override
    public CClass setDefaultInfo(CClassInfo info) {
        cClassInfo = info;
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
    public CClass setArmorInfo(Armor armor, ArmorInfo info) {
        if(armor != null) {
            armorInfoMap.put(armor, info);
        }
        return this;
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
    public HashMap<Skill, SkillInfo> getSkillInfoMap() {
        return skillInfoMap;
    }

    @Override
    public SkillInfo getSkillInfo(Skill skill) {
        if(skill != null) {
            SkillInfo skillInfo = skillInfoMap.get(skill);
            if(skillInfo == null) {
                skillInfo = new SkillInfo();
                skillInfoMap.put(skill, skillInfo);
            }
            return skillInfo;
        }
        return null;
    }

    @Override
    public CClass setSkillInfo(Skill skill, SkillInfo info) {
        if(skill != null) {
            skillInfoMap.put(skill, info);
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
    public CClass setWeaponInfo(Weapon weapon, WeaponInfo info) {
        if(weapon != null) {
            weaponInfoMap.put(weapon, info);
        }
        return this;
    }
}