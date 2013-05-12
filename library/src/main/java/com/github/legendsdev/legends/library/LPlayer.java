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
import com.github.legendsdev.legends.library.misc.Informative;
import com.github.legendsdev.legends.library.race.*;
import com.github.legendsdev.legends.library.skill.*;
import com.github.legendsdev.legends.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author B2OJustin
 */
public class LPlayer implements LEntity,
        Informative<LPlayer, LPlayerInfo>,
        WeaponUser<LPlayer>, ArmorUser<LPlayer>, SkillUser<LPlayer>,
        WeaponRestricted, ArmorRestricted, SkillRestricted, LevelRestricted, LClassRestricted, RaceRestricted {

    private Race race = new Race();

    private LClass primaryClass = new LClass();
    private LClass secondaryClass = new LClass();

    private String playerName = "";
    private ArrayList<String> description = new ArrayList<>();
    private LPlayerInfo lPlayerInfo = new LPlayerInfo();

    private LevelRestrictions levelRestrictions = new LevelRestrictions();
    private WeaponRestrictions weaponRestrictions = new WeaponRestrictions();
    private ArmorRestrictions armorRestrictions = new ArmorRestrictions();
    private LClassRestrictions lClassRestrictions = new LClassRestrictions();
    private RaceRestrictions raceRestrictions = new RaceRestrictions();
    private SkillRestrictions skillRestrictions = new SkillRestrictions();

    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private HashMap<Weapon, WeaponInfo> weaponInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorInfo> armorInfoMap = new HashMap<>();

    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private Weapon currentWeapon = new Weapon();
    private Armor currentArmor = new Armor();

    private int weaponDamage = 0;
    private int currentHealth = 0;
    private int maxHealth = 0;

    private int currentMana = 0;
    private int maxMana = 0;

    private int currentStamina = 0;
    private int maxStamina = 0;

    public LPlayer(Race race, LClass primaryClass, LClass secondaryClass) {
    }

    public Race getRace() {
        return this.race;
    }

    public LClass getPrimaryClass() {
        return primaryClass;
    }

    public LClass getSecondaryClass() {
        return secondaryClass;
    }

    public Weapon getWeapon() {
        return currentWeapon;
    }

    public LPlayer setWeapon(Weapon weapon) {
        if(weapon != null) {
            currentWeapon = weapon;

            // Weapon damage
            weaponDamage = 0;
            weaponDamage += getWeaponInfo(currentWeapon).getBonusWeaponDamage();
            weaponDamage += getArmorInfo(currentArmor).getBonusWeaponDamage();
            weaponDamage += lPlayerInfo.getBonusWeaponDamage();
            // Class bonuses
            weaponDamage += primaryClass.getWeaponInfo(currentWeapon).getBonusWeaponDamage();
            weaponDamage += primaryClass.getArmorInfo(currentArmor).getBonusWeaponDamage();
            weaponDamage += secondaryClass.getWeaponInfo(currentWeapon).getBonusWeaponDamage();
            weaponDamage += secondaryClass.getArmorInfo(currentArmor).getBonusWeaponDamage();
            // Race bonuses
            weaponDamage += race.getWeaponInfo(currentWeapon).getBonusWeaponDamage();
            weaponDamage += race.getArmorInfo(currentArmor).getBonusWeaponDamage();
            weaponDamage += race.getLClassInfo(primaryClass).getBonusWeaponDamage();
            weaponDamage += race.getLClassInfo(secondaryClass).getBonusWeaponDamage();
        }
        return this;
    }

    public LPlayer update() {
        // Weapon damage
        weaponDamage = 0;
        weaponDamage += getWeaponInfo(currentWeapon).getBonusWeaponDamage();
        weaponDamage += getArmorInfo(currentArmor).getBonusWeaponDamage();
        weaponDamage += lPlayerInfo.getBonusWeaponDamage();
        // Class bonuses
        weaponDamage += primaryClass.getWeaponInfo(currentWeapon).getBonusWeaponDamage();
        weaponDamage += primaryClass.getArmorInfo(currentArmor).getBonusWeaponDamage();
        weaponDamage += secondaryClass.getWeaponInfo(currentWeapon).getBonusWeaponDamage();
        weaponDamage += secondaryClass.getArmorInfo(currentArmor).getBonusWeaponDamage();
        // Race bonuses
        weaponDamage += race.getWeaponInfo(currentWeapon).getBonusWeaponDamage();
        weaponDamage += race.getArmorInfo(currentArmor).getBonusWeaponDamage();
        weaponDamage += race.getLClassInfo(primaryClass).getBonusWeaponDamage();
        weaponDamage += race.getLClassInfo(secondaryClass).getBonusWeaponDamage();

        // Max health
        maxHealth = 0;
        maxHealth += getWeaponInfo(currentWeapon).getBonusHealth();
        maxHealth += getArmorInfo(currentArmor).getBonusHealth();
        maxHealth += lPlayerInfo.getBonusHealth();
        // Class bonuses
        maxHealth += primaryClass.getArmorInfo(currentArmor).getBonusHealth();
        maxHealth += primaryClass.getWeaponInfo(currentWeapon).getBonusHealth();
        maxHealth += secondaryClass.getArmorInfo(currentArmor).getBonusHealth();
        maxHealth += secondaryClass.getWeaponInfo(currentWeapon).getBonusHealth();
        // Race bonuses
        maxHealth += race.getWeaponInfo(currentWeapon).getBonusHealth();
        maxHealth += race.getArmorInfo(currentArmor).getBonusHealth();
        maxHealth += race.getLClassInfo(primaryClass).getBonusHealth();
        maxHealth += race.getLClassInfo(secondaryClass).getBonusHealth();

        // Max mana
        maxMana = 0;
        maxMana += getWeaponInfo(currentWeapon).getBonusMana();
        maxMana += getArmorInfo(currentArmor).getBonusMana();
        maxMana += lPlayerInfo.getBonusMana();
        // Class bonuses
        maxMana += primaryClass.getArmorInfo(currentArmor).getBonusMana();
        maxMana += primaryClass.getWeaponInfo(currentWeapon).getBonusMana();
        maxMana += secondaryClass.getArmorInfo(currentArmor).getBonusMana();
        maxMana += secondaryClass.getWeaponInfo(currentWeapon).getBonusMana();
        return this;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public LPlayer updateInfo() {

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
    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public LPlayer setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public LPlayerInfo getDefaultInfo() {
        return lPlayerInfo;
    }

    @Override
    public LPlayer setDefaultInfo(LPlayerInfo info) {
        if(info == null) {
            lPlayerInfo = new LPlayerInfo();
        }
        else lPlayerInfo = info;
        return this;
    }
}
