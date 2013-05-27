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
import com.github.championsdev.champions.library.BasicCategory;
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
import com.github.championsdev.champions.library.misc.CLocatable;
import com.github.championsdev.champions.library.misc.Informative;
import com.github.championsdev.champions.library.party.Party;
import com.github.championsdev.champions.library.race.Race;
import com.github.championsdev.champions.library.race.RaceRestricted;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.skill.SkillAttributes;
import com.github.championsdev.champions.library.skill.SkillRestricted;
import com.github.championsdev.champions.library.skill.SkillUser;
import com.github.championsdev.champions.library.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author B2OJustin
 */
public class CPlayer implements CEntity, Behavioral<CPlayer>,
        Informative<CPlayer, CPlayerAttributes>,
        WeaponUser<CPlayer>, ArmorUser<CPlayer>, SkillUser<CPlayer>,
        WeaponRestricted, ArmorRestricted, SkillRestricted, LevelRestricted, CClassRestricted, RaceRestricted, CLocatable {

    private Race race = new Race();

    private CClass primaryClass;
    private CClassAttributes primaryClassInfo = new CClassAttributes();

    private CClass secondaryClass;
    private CClassAttributes secondaryClassInfo = new CClassAttributes();

    private String playerName = "";
    private ArrayList<String> description = new ArrayList<>();

    private CPlayerAttributes fullAttributes = new CPlayerAttributes();
    private CPlayerAttributes playerBonusAttributes = new CPlayerAttributes();

    private LinkedHashMap<CClass, Level> previousPrimaryClasses = new LinkedHashMap<>();
    private LinkedHashMap<CClass, Level> previousSecondaryClasses = new LinkedHashMap<>();

    private HashMap<Skill, SkillAttributes> skillAttributesMap = new HashMap<>();

    private HashMap<Weapon, WeaponAttributes> weaponAttributesMap = new HashMap<>();
    private HashMap<BasicCategory<WeaponAttributes>, WeaponAttributes> weaponCategoryAttributesMap = new HashMap<>();

    private HashMap<Armor, ArmorAttributes> armorAttributesMap = new HashMap<>();

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
        updateAttributes();
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
            fullAttributes.subtract(this.primaryClass.getAttributes());
            fullAttributes.add(primaryClass.getAttributes());
        } else {
            behaviorGroup.attach(primaryClass.getBehavior());
        }
        this.primaryClass = primaryClass;
        return this;
    }

    public CPlayer setSecondaryClass(CClass secondaryClass) {
        if(this.secondaryClass != null) {
            behaviorGroup.swap(this.secondaryClass.getBehavior(), secondaryClass.getBehavior());
            fullAttributes.subtract(this.secondaryClass.getAttributes());
            fullAttributes.add(secondaryClass.getAttributes());
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

            fullAttributes.subtract(
                    currentWeapon.getAttributes(),
                    race.getWeaponAttributes(currentWeapon),
                    primaryClass.getWeaponAttributes(currentWeapon),
                    secondaryClass.getWeaponAttributes(currentWeapon),
                    getWeaponAttributes(currentWeapon));

            fullAttributes.add(
                    weapon.getAttributes(),
                    race.getWeaponAttributes(weapon),
                    primaryClass.getWeaponAttributes(weapon),
                    secondaryClass.getWeaponAttributes(weapon),
                    getWeaponAttributes(weapon));
            currentWeapon = weapon;
        }
        return this;
    }

    public CPlayer setArmor(Armor armor) {
        if(armor != null) {
            behaviorGroup.swap(currentArmor.getBehavior(), armor.getBehavior());

            fullAttributes.subtract(
                    currentArmor.getAttributes(),
                    race.getArmorAttributes(currentArmor),
                    primaryClass.getArmorAttributes(currentArmor),
                    secondaryClass.getArmorAttributes(currentArmor),
                    getArmorAttributes(currentArmor));

            fullAttributes.add(
                    currentArmor.getAttributes(),
                    race.getArmorAttributes(armor),
                    primaryClass.getArmorAttributes(armor),
                    secondaryClass.getArmorAttributes(armor),
                    getArmorAttributes(armor));
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

    public CPlayer updateAttributes() {
        BasicAttributes[] attrArray = new BasicAttributes[] {
            // Class bonuses
            primaryClass.getArmorAttributes(currentArmor),
            primaryClass.getWeaponAttributes(currentWeapon),
            secondaryClass.getArmorAttributes(currentArmor),
            secondaryClass.getWeaponAttributes(currentWeapon),
            primaryClass.getAttributes(),
            secondaryClass.getAttributes(),

            // Race bonuses
            race.getArmorAttributes(currentArmor),
            race.getWeaponAttributes(currentWeapon),
            race.getCClassAttributes(primaryClass),
            race.getCClassAttributes(secondaryClass),
            race.getAttributes(),

            // Player bonuses
                playerBonusAttributes,
            getArmorAttributes(currentArmor),
            getWeaponAttributes(currentWeapon),

            // Weapon bonuses
            currentWeapon.getAttributes(),
            currentArmor.getAttributes()
        };

        fullAttributes = new CPlayerAttributes();
        fullAttributes.add(attrArray);
        return this;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getSkillDamage(Skill skill) {
        return (skillDamage + skillAttributesMap.get(skill).getDamage());
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
        return skillAttributesMap;
    }

    @Override
    public CPlayer setSkillAttributes(Skill skill, SkillAttributes info) {
        if(skill != null) {
            skillAttributesMap.put(skill, info);
        }
        return this;
    }

    @Override
    public SkillAttributes getSkillAttributes(Skill skill) {
        if (!skillAttributesMap.containsKey(skill)) {
            skillAttributesMap.put(skill, new SkillAttributes());
        }
        return skillAttributesMap.get(skill);
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

    public WeaponAttributes getCurrentWeaponInfo() {
        WeaponAttributes info = weaponAttributesMap.get(currentWeapon);
        if(info == null) {
            info = new WeaponAttributes();
            weaponAttributesMap.put(currentWeapon, info);
        }
        return info;
    }

    @Override
    public CPlayer setWeaponAttributes(Weapon weapon, WeaponAttributes attributes) {
        if(weapon != null) {
            weaponAttributesMap.put(weapon, attributes);
        }
        return this;
    }

    @Override
    public HashMap<BasicCategory<WeaponAttributes>, WeaponAttributes> getWeaponCategoryAttributesMap() {
        return weaponCategoryAttributesMap;
    }

    @Override
    public WeaponAttributes getWeaponCategoryAttributes(BasicCategory<WeaponAttributes> weaponCategory) {
        return null; //TODO getWeaponCategoryAttributes method stub
    }

    @Override
    public CPlayer setWeaponCategoryAttributes(BasicCategory<WeaponAttributes> weaponCategory, WeaponAttributes info) {
        return null; //TODO setWeaponCategoryAttributes method stub
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
    public CPlayer setArmorAttributes(Armor armor, ArmorAttributes info) {
        if(armor != null) {
            armorAttributesMap.put(armor, info);
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
    public CPlayerAttributes getAttributes() {
        return fullAttributes;
    }

    public CPlayerAttributes getBonusAttributes() {
        return playerBonusAttributes.clone();
    }

    public CPlayer setBonusAttributes(CPlayerAttributes playerBonusAttributes) {
        fullAttributes.subtract(this.playerBonusAttributes);
        fullAttributes.add(playerBonusAttributes);
        this.playerBonusAttributes = playerBonusAttributes;
        return this;
    }

    @Override
    public CPlayer setAttributes(CPlayerAttributes attributes) {
        fullAttributes = attributes;
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

    public CClassAttributes getPrimaryClassAttributes() {
        return primaryClassInfo;
    }

    public CClassAttributes getSecondaryClassAttributes() {
        return secondaryClassInfo;
    }
}
