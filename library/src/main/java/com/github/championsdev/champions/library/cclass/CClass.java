package com.github.championsdev.champions.library.cclass;

import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorInfo;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorUser;
import com.github.championsdev.champions.library.level.LevelRestricted;
import com.github.championsdev.champions.library.level.exp.Exp;
import com.github.championsdev.champions.library.level.exp.ExpGroup;
import com.github.championsdev.champions.library.level.exp.sources.ExpSource;
import com.github.championsdev.champions.library.misc.Identifiable;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.skill.SkillInfo;
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
public class CClass implements Informative<CClass, CClassInfo>, Identifiable<CClass>,
        WeaponRestricted, WeaponTypeRestricted, ArmorRestricted, SkillRestricted,
        WeaponUser<CClass>, WeaponTypeUser<CClass>, SkillUser<CClass>, ArmorUser<CClass> {

    private ArrayList<String> description = new ArrayList<>();
    private String name = "";
    private String id = "";

    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private HashMap<Weapon, WeaponInfo> weaponInfoMap = new HashMap<>();
    private HashMap<WeaponType, WeaponInfo> weaponTypeInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorInfo> armorInfoMap = new HashMap<>();

    private LinkedHashMap<ExpGroup, Double> expGroups = new LinkedHashMap<>();

    private CClassInfo cClassInfo = new CClassInfo();


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
    public HashMap<WeaponType, WeaponInfo> getWeaponTypeInfoMap() {
        return weaponTypeInfoMap;
    }

    @Override
    public WeaponInfo getWeaponTypeInfo(WeaponType weaponType) {
        if(weaponType != null) {
            WeaponInfo weaponInfo = weaponTypeInfoMap.get(weaponType);
            if(weaponInfo == null) {
                weaponInfo = new WeaponInfo();
                weaponTypeInfoMap.put(weaponType, weaponInfo);
            }
            return weaponInfo;
        }
        return null;
    }

    @Override
    public CClass setWeaponTypeInfo(WeaponType weaponType, WeaponInfo info) {
        if(weaponType != null) {
            weaponTypeInfoMap.put(weaponType, info);
        }
        return this;
    }
}