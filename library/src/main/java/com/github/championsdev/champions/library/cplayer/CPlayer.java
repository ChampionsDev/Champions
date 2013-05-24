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


import com.github.championsdev.champions.library.BasicAttributes;
import com.github.championsdev.champions.library.CEntity;
import com.github.championsdev.champions.library.CLocation;
import com.github.championsdev.champions.library.armor.Armor;
import com.github.championsdev.champions.library.armor.ArmorAttributes;
import com.github.championsdev.champions.library.armor.ArmorRestricted;
import com.github.championsdev.champions.library.armor.ArmorUser;
import com.github.championsdev.champions.library.behavior.BehaviorGroup;
import com.github.championsdev.champions.library.behavior.Behavioral;
import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cclass.CClassAttributes;
import com.github.championsdev.champions.library.cclass.CClassRestricted;
import com.github.championsdev.champions.library.level.Level;
import com.github.championsdev.champions.library.level.LevelRestricted;
import com.github.championsdev.champions.library.level.exp.Exp;
import com.github.championsdev.champions.library.level.exp.sources.ExpSource;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.misc.Positionable;
import com.github.championsdev.champions.library.party.Party;
import com.github.championsdev.champions.library.race.Race;
import com.github.championsdev.champions.library.race.RaceRestricted;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.skill.SkillAttributes;
import com.github.championsdev.champions.library.skill.SkillRestricted;
import com.github.championsdev.champions.library.skill.SkillUser;
import com.github.championsdev.champions.library.weapon.Weapon;
import com.github.championsdev.champions.library.weapon.WeaponAttributes;
import com.github.championsdev.champions.library.weapon.WeaponRestricted;
import com.github.championsdev.champions.library.weapon.WeaponUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author B2OJustin
 */
public class CPlayer implements CEntity, Behavioral<CPlayer>,
        Informative<CPlayer, CPlayerAttributes>,
        WeaponUser<CPlayer>, ArmorUser<CPlayer>, SkillUser<CPlayer>,
        WeaponRestricted, ArmorRestricted, SkillRestricted, LevelRestricted, CClassRestricted, RaceRestricted, Positionable {

    private Race race = new Race();

    private CClass primaryClass;
    private CClassAttributes primaryClassInfo = new CClassAttributes();

    private CClass secondaryClass;
    private CClassAttributes secondaryClassInfo = new CClassAttributes();

    private String playerName = "";
    private ArrayList<String> description = new ArrayList<>();
    private CPlayerAttributes cPlayerMeta = new CPlayerAttributes();

    private LinkedHashMap<CClass, Level> previousPrimaryClasses = new LinkedHashMap<>();
    private LinkedHashMap<CClass, Level> previousSecondaryClasses = new LinkedHashMap<>();

    private HashMap<Skill, SkillAttributes> skillInfoMap = new HashMap<>();
    private HashMap<Weapon, WeaponAttributes> weaponInfoMap = new HashMap<>();
    private HashMap<Armor, ArmorAttributes> armorInfoMap = new HashMap<>();

    private ArrayList<Skill> currentSkills = new ArrayList<>();

    private Weapon currentWeapon = new Weapon();
    private Armor currentArmor = new Armor();

    private BehaviorGroup behaviorGroup = new BehaviorGroup();

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
        setPrimaryClass(primaryClass);
        setSecondaryClass(secondaryClass);
        update();
        party = new Party(this);
        // TODO loading of current health, mana, stamina
        currentHealth = maxHealth;
        currentMana = maxMana;
        currentStamina = maxStamina;
    }

    public Race getRace() {
        return this.race;
    }

    public CPlayer setRace(Race race) {
        behaviorGroup.swap(this.race.getBehavior(), race.getBehavior());
        this.race = race;
        return this;
    }

    public LinkedHashMap<CClass, Level> getPreviousPrimaryClasses() {
        return previousPrimaryClasses;
    }

    public LinkedHashMap<CClass, Level> getPreviousSecondaryClasses() {
        return previousSecondaryClasses;
    }

    public CPlayer addPreviousPrimaryClass(CClass primaryClass, Level level) {
        previousPrimaryClasses.put(primaryClass, level);
        return this;
    }

    public CPlayer addPreviousSecondaryClass(CClass secondaryClass, Level level) {
        previousSecondaryClasses.put(secondaryClass, level);
        return this;
    }

    public CPlayer setPrimaryClass(CClass primaryClass) {
        if(this.primaryClass != null) {
            behaviorGroup.swap(this.primaryClass.getBehavior(), primaryClass.getBehavior());
        } else {
            behaviorGroup.attach(primaryClass.getBehavior());
        }
        this.primaryClass = primaryClass;
        return this;
    }

    public CPlayer setSecondaryClass(CClass secondaryClass) {
        if(this.secondaryClass != null) {
            behaviorGroup.swap(this.secondaryClass.getBehavior(), secondaryClass.getBehavior());
        } else {
            behaviorGroup.attach(secondaryClass.getBehavior());
        }
        this.secondaryClass = secondaryClass;
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

    public CClassAttributes getSecondaryClassInfo() {
        return secondaryClassInfo;
    }

    public CClassAttributes getPrimaryClassInfo() {
        return primaryClassInfo;
    }

    // Experience wrapper methods
    public Exp addExp(ExpSource source) {
        Exp pExp = primaryClass.getExpGain(source);
        Exp sExp = secondaryClass.getExpGain(source);
        if(pExp.getExp() != 0 | sExp.getExp() != 0) {
            primaryClassInfo.getLevel().addExp(pExp);
            secondaryClassInfo.getLevel().addExp(sExp);
        }
        return pExp.addExp(sExp);
    }

    public Weapon getWeapon() {
        return currentWeapon;
    }

    public CPlayer setWeapon(Weapon weapon) {
        if(weapon != null) {
            behaviorGroup.swap(currentWeapon.getBehavior(), weapon.getBehavior());
            currentWeapon = weapon;
        }
        return this;
    }

    public CPlayer setArmor(Armor armor) {
        if(armor != null) {
            behaviorGroup.swap(currentArmor.getBehavior(), armor.getBehavior());
            currentArmor = armor;
        }
        return this;
    }

    public Armor getArmor() {
        return currentArmor;
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
        ArrayList<BasicAttributes> infoList = new ArrayList<>();
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
        infoList.add(cPlayerMeta);
        infoList.add(getArmorInfo(currentArmor));
        infoList.add(getWeaponInfo(currentWeapon));

        BasicAttributes basicAttributes = BasicAttributes.combine(infoList);

        maxMana = basicAttributes.getBonusMana();
        maxHealth = basicAttributes.getBonusHealth();
        maxStamina = basicAttributes.getBonusStamina();
        weaponDamage = basicAttributes.getBonusWeaponDamage();
        skillDamage = basicAttributes.getBonusSkillDamage();
        defense = basicAttributes.getBonusDefense();

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
    public HashMap<Skill, SkillAttributes> getSkillAttributesMap() {
        return skillInfoMap;
    }

    @Override
    public CPlayer setSkillInfo(Skill skill, SkillAttributes info) {
        if(skill != null) {
            skillInfoMap.put(skill, info);
        }
        return this;
    }

    @Override
    public SkillAttributes getSkillInfo(Skill skill) {
        if (!skillInfoMap.containsKey(skill)) {
            skillInfoMap.put(skill, new SkillAttributes());
        }
        return skillInfoMap.get(skill);
    }

    @Override
    public HashMap<Weapon, WeaponAttributes> getWeaponAttributesMap() {
        return weaponInfoMap;
    }

    @Override
    public WeaponAttributes getWeaponInfo(Weapon weapon) {
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

    public WeaponAttributes getCurrentWeaponInfo() {
        WeaponAttributes info = weaponInfoMap.get(currentWeapon);
        if(info == null) {
            info = new WeaponAttributes();
            weaponInfoMap.put(currentWeapon, info);
        }
        return info;
    }

    @Override
    public CPlayer setWeaponInfo(Weapon weapon, WeaponAttributes info) {
        if(weapon != null) {
            weaponInfoMap.put(weapon, info);
        }
        return this;
    }

    @Override
    public HashMap<Armor, ArmorAttributes> getArmorAttributesMap() {
        return armorInfoMap;
    }

    @Override
    public ArmorAttributes getArmorInfo(Armor armor) {
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
    public CPlayer setArmorInfo(Armor armor, ArmorAttributes info) {
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
    public CPlayerAttributes getDefaultInfo() {
        if (this.cPlayerMeta == null) {
            cPlayerMeta = new CPlayerAttributes();
        }
        return cPlayerMeta;
    }

    @Override
    public CPlayer setDefaultInfo(CPlayerAttributes info) {
        if(info == null) {
            cPlayerMeta = new CPlayerAttributes();
        }
        else cPlayerMeta = info;
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
    public BehaviorGroup getBehavior() {
        return behaviorGroup;
    }

    @Override
    public CPlayer setBehavior(BehaviorGroup behavior) {
        behaviorGroup = behavior;
        return this;
    }
}
