/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library.cplayer;


import com.github.championsdev.champions.library.BasicInfo;
import com.github.championsdev.champions.library.CEntity;
import com.github.championsdev.champions.library.CLocation;
import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorInfo;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorUser;
import com.github.championsdev.champions.library.behavior.Behavioral;
import com.github.championsdev.champions.library.behavior.CPlayerBehavior;
import com.github.championsdev.champions.library.behavior.CPlayerBehaviorGroup;
import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cclass.CClassInfo;
import com.github.championsdev.champions.library.cclass.CClassRestricted;
import com.github.championsdev.champions.library.level.Level;
import com.github.championsdev.champions.library.level.LevelRestricted;
import com.github.championsdev.champions.library.level.exp.sources.ExpSource;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.misc.Positionable;
import com.github.championsdev.champions.library.party.Party;
import com.github.championsdev.champions.library.race.Race;
import com.github.championsdev.champions.library.race.RaceRestricted;
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

/**
 * @author B2OJustin
 */
public class CPlayer implements CEntity, Behavioral<CPlayer, CPlayerBehaviorGroup>,
        Informative<CPlayer, CPlayerInfo>,
        WeaponUser<CPlayer>, ArmorUser<CPlayer>, SkillUser<CPlayer>,
        WeaponRestricted, ArmorRestricted, SkillRestricted, LevelRestricted, CClassRestricted, RaceRestricted, Positionable {

    private Race race = new Race();

    private CClass primaryClass;
    private CClassInfo primaryClassInfo = new CClassInfo();

    private CClass secondaryClass;
    private CClassInfo secondaryClassInfo = new CClassInfo();

    private String playerName = "";
    private ArrayList<String> description = new ArrayList<>();
    private CPlayerInfo cPlayerInfo = new CPlayerInfo();

    private LinkedHashMap<CClass, Level> previousPrimaryClasses = new LinkedHashMap<>();
    private LinkedHashMap<CClass, Level> previousSecondaryClasses = new LinkedHashMap<>();

    private HashMap<Skill, SkillInfo> skillInfoMap = new HashMap<>();
    private HashMap<Weapon, WeaponInfo> weaponInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorInfo> armorInfoMap = new HashMap<>();

    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private Weapon currentWeapon = new Weapon();
    private Armor currentArmor = new Armor();

    private CPlayerBehaviorGroup cPlayerBehaviorGroup = new CPlayerBehaviorGroup();

    private Party party;

    private int weaponDamage = 0;
    private int skillDamage = 0;
    private int defense = 0;
    private int currentHealth = 0;
    private int maxHealth = 0;
    private int currentMana = 0;
    private int maxMana = 0;
    private int currentStamina = 0;
    private int maxStamina = 0;
    private CLocation location;

    public CPlayer(Race race, CClass primaryClass, CClass secondaryClass) {
        this.race = race;
        this.primaryClass = primaryClass;
        this.secondaryClass = secondaryClass;
        update();
        party = new Party(this);
        // TODO loading of current health, mana, stamina
        currentHealth = maxHealth;
        currentMana = maxMana;
        currentStamina = maxStamina;
        this.location = null;
    }

    public Race getRace() {
        return this.race;
    }

    public LinkedHashMap<CClass, Level> getPreviousPrimaryClasses() {
        return previousPrimaryClasses;
    }

    public LinkedHashMap<CClass, Level> getPreviousSecondaryClasses() {
        return previousSecondaryClasses;
    }

    public CPlayer addPreviousPrimaryClass(CClass cClass, Level level) {
        previousPrimaryClasses.put(cClass, level);
        return this;
    }

    public CPlayer addPreviousSecondaryClass(CClass cClass, Level level) {
        previousSecondaryClasses.put(cClass, level);
        return this;
    }

    public CPlayer setParty(Party party) {
        if(party == null) this.party = new Party(this);
        else this.party = party;
        return this;
    }

    public Party getParty() {
        return party;
    }

    public CClass getPrimaryClass() {
        return primaryClass;
    }

    public CClass getSecondaryClass() {
        return secondaryClass;
    }

    public CClassInfo getSecondaryClassInfo() {
        return secondaryClassInfo;
    }

    public CClassInfo getPrimaryClassInfo() {
        return primaryClassInfo;
    }

    // Experience wrapper methods
    public CPlayer addExp(ExpSource source) {
        primaryClassInfo.getLevel().addExp(primaryClass.getExpGain(source));
        secondaryClassInfo.getLevel().addExp(secondaryClass.getExpGain(source));
        return this;
    }

    public Weapon getWeapon() {
        return currentWeapon;
    }

    public CPlayer setWeapon(Weapon weapon) {
        if(weapon != null) {
            currentWeapon = weapon;
        }
        return this;
    }

    public int getHealth() {
        return currentHealth;
    }

    public CPlayer removeHealth(int health) {
        currentHealth -= health;
        return this;
    }

    public int getMana() {
        return currentMana;
    }

    public CPlayer setMana(int mana) {
        currentMana = mana;
        return this;
    }

    public CPlayer removeMana(int mana) {
        currentMana -= mana;
        return this;
    }

    public CPlayer addMana(int mana) {
        currentMana += mana;
        return this;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getStamina() {
        return currentStamina;
    }

    public CPlayer removeStamina(int stamina) {
        currentStamina -= stamina;
        return this;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDefense() {
        return defense;
    }

    public CPlayer update() {
        ArrayList<BasicInfo> infoList = new ArrayList<>();
        // Class bonuses
        infoList.add(primaryClass.getArmorInfo(currentArmor));
        infoList.add(primaryClass.getWeaponInfo(currentWeapon));
        infoList.add(secondaryClass.getArmorInfo(currentArmor));
        infoList.add(secondaryClass.getWeaponInfo(currentWeapon));
        infoList.add(primaryClass.getDefaultInfo());
        infoList.add(secondaryClass.getDefaultInfo());

        // Race bonuses
        infoList.add(race.getArmorInfo(currentArmor));
        infoList.add(race.getWeaponInfo(currentWeapon));
        infoList.add(race.getLClassInfo(primaryClass));
        infoList.add(race.getLClassInfo(secondaryClass));
        infoList.add(race.getDefaultInfo());

        // Player bonuses
        infoList.add(cPlayerInfo);
        infoList.add(getArmorInfo(currentArmor));
        infoList.add(getWeaponInfo(currentWeapon));

        BasicInfo basicInfo = BasicInfo.combine(infoList);

        maxMana = basicInfo.getBonusMana();
        maxHealth = basicInfo.getBonusHealth();
        maxStamina = basicInfo.getBonusStamina();
        weaponDamage = basicInfo.getBonusWeaponDamage();
        skillDamage = basicInfo.getBonusSkillDamage();
        defense = basicInfo.getBonusDefense();

        return this;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getSkillDamage(Skill skill) {
        return (skillDamage + skillInfoMap.get(skill).getDamage());
    }

    @Override
    public ArrayList<Skill> getSkills() {
        return currentSkills;
    }

    @Override
    public CPlayer addSkill(Skill skill) {
        if(skill != null) {
            currentSkills.add(skill);
        }
        return this;
    }

    @Override
    public CPlayer removeSkill(Skill skill) {
        currentSkills.remove(skill);
        return this;
    }

    @Override
    public HashMap<Skill, SkillInfo> getSkillInfoMap() {
        return skillInfoMap;
    }

    @Override
    public CPlayer setSkillInfo(Skill skill, SkillInfo info) {
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
    public CPlayer setWeaponInfo(Weapon weapon, WeaponInfo info) {
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
    public CPlayer setArmorInfo(Armor armor, ArmorInfo info) {
        if(armor != null) {
            armorInfoMap.put(armor, info);
        }
        return this;
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
    public CPlayer setName(String name) {
        this.playerName = name;
        return this;
    }

    @Override
    public CPlayer setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public CPlayerInfo getDefaultInfo() {
        if (this.cPlayerInfo == null) {
            cPlayerInfo = new CPlayerInfo();
        }
        return cPlayerInfo;
    }

    @Override
    public CPlayer setDefaultInfo(CPlayerInfo info) {
        if(info == null) {
            cPlayerInfo = new CPlayerInfo();
        }
        else cPlayerInfo = info;
        return this;
    }

    @Override
    public CLocation getPosition() {
        return this.location;
    }

    @Override
    public void setLocation(CLocation location) {
        this.location = location;
    }

    @Override
    public CPlayerBehaviorGroup getBehavior() {
        return cPlayerBehaviorGroup;
    }

    @Override
    public CPlayer setBehavior(CPlayerBehaviorGroup behavior) {
        cPlayerBehaviorGroup = behavior;
        return this;
    }
}
