package com.github.legendsdev.legends.library.lclass;

import com.github.legendsdev.legends.library.armor.*;
import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.level.LevelRestrictions;
import com.github.legendsdev.legends.library.misc.Informative;
import com.github.legendsdev.legends.library.skill.*;
import com.github.legendsdev.legends.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author YoshiGenius
 */
public class LClass implements Informative<LClass, LClassInfo>,
        LevelRestricted, WeaponRestricted, ArmorRestricted, SkillRestricted,
        WeaponUser<LClass>, SkillUser<LClass>, ArmorUser<LClass> {

    private ArrayList<String> description = new ArrayList<>();
    private String name = "";

    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private HashMap<Weapon, WeaponInfo> weaponInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorInfo> armorInfoMap = new HashMap<>();

    private LClassInfo lClassInfo = new LClassInfo();

    private LevelRestrictions levelRestrictions = new LevelRestrictions();
    private WeaponRestrictions weaponRestrictions = new WeaponRestrictions();
    private ArmorRestrictions armorRestrictions = new ArmorRestrictions();
    private SkillRestrictions skillRestrictions = new SkillRestrictions();


    public LClass() {
    }

    public LClass(String name, ArrayList<String> description) {
        this.name = name;
        this.description = description;
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
    public LClass setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public LClassInfo getDefaultInfo() {
        return lClassInfo;
    }

    @Override
    public LClass setDefaultInfo(LClassInfo info) {
        lClassInfo = info;
        return this;
    }

    @Override
    public ArmorRestrictions getArmorRestrictions() {
        return armorRestrictions;
    }

    @Override
    public LevelRestrictions getLevelRestrictions() {
        return levelRestrictions;
    }

    @Override
    public SkillRestrictions getSkillRestrictions() {
        return skillRestrictions;
    }

    @Override
    public WeaponRestrictions getWeaponRestrictions() {
        return weaponRestrictions;
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
    public LClass setArmorInfo(Armor armor, ArmorInfo info) {
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
    public LClass addSkill(Skill skill) {
        if(skill != null) {
            currentSkills.add(skill);
        }
        return this;
    }

    @Override
    public LClass removeSkill(Skill skill) {
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
    public LClass setSkillInfo(Skill skill, SkillInfo info) {
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
    public LClass setWeaponInfo(Weapon weapon, WeaponInfo info) {
        if(weapon != null) {
            weaponInfoMap.put(weapon, info);
        }
        return this;
    }
}