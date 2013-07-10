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
package com.github.championsdev.champions.library;

import com.github.championsdev.champions.library.misc.Attributes;

import java.util.Arrays;
import java.util.List;

/**
 * A class used for storing the attributes of certain objects.
 * @author B2OJustin
 */

@SuppressWarnings("unchecked")
public class BasicAttributes<SelfType extends BasicAttributes> implements Attributes {
    private int weaponDamage = 0;
    private int minWeaponDamage = 0;
    private int maxWeaponDamage = 0;
    private int skillDamage = 0;
    private int minSkillDamage = 0;
    private int maxSkillDamage = 0;
    private int defense = 0;
    private int health = 0;
    private int mana = 0;
    private int stamina = 0;

    /**
     * Used to combine multiple instances of this class into one instance.
     * @param infos Instances of BasicAttributes to be combined.
     * @return The instance containing the combined instances' data.
     */
    public static BasicAttributes combine(List<BasicAttributes> infos) {
        BasicAttributes info = new BasicAttributes();
        for (BasicAttributes inf : infos) {
            info.addDefense(inf.getDefense());
            info.addSkillDamage(inf.getSkillDamage());
            info.addMana(inf.getMana());
            info.addHealth(inf.getHealth());
            info.addWeaponDamage(inf.getWeaponDamage());
            info.addStamina(inf.getStamina());
        }
        return info;
    }

    /**
     * Used to combine multiple instances of this class into one instance.
     * @param info Instances of BasicAttributes to be combined.
     * @return The instance containing the combined instances' data.
     */
    public static BasicAttributes combine(BasicAttributes... info) {
        return combine(Arrays.asList(info));
    }

    /**
     * Add the data from the given instances to this instance.
     * @param attributesArray The array of instances.
     */
    public void add(BasicAttributes... attributesArray) {
        for(BasicAttributes attributes : attributesArray) {
            weaponDamage += attributes.weaponDamage;
            minWeaponDamage += attributes.minWeaponDamage;
            maxWeaponDamage += attributes.maxWeaponDamage;
            skillDamage += attributes.skillDamage;
            minSkillDamage += attributes.minSkillDamage;
            maxSkillDamage += attributes.maxSkillDamage;
            defense += attributes.defense;
            mana += attributes.mana;
            stamina += attributes.stamina;
        }
    }

    /**
     * Subtract some data from this instance from the given instances.
     * @param attributesArray The array of instances.
     */
    public void subtract(BasicAttributes... attributesArray) {
        for(BasicAttributes attributes : attributesArray) {
            weaponDamage -= attributes.weaponDamage;
            minWeaponDamage -= attributes.minWeaponDamage;
            maxWeaponDamage -= attributes.maxWeaponDamage;
            skillDamage -= attributes.skillDamage;
            minSkillDamage -= attributes.minSkillDamage;
            maxSkillDamage -= attributes.maxSkillDamage;
            defense -= attributes.defense;
            mana -= attributes.mana;
            stamina -= attributes.stamina;
        }
    }

    /**
     * Overridden to use the same data.
     * @return A new BasicAttributes instance containing the data from the current instance.
     */
    public SelfType clone() {
        BasicAttributes attributes = new BasicAttributes();
        attributes.weaponDamage = this.weaponDamage;
        attributes.minWeaponDamage = this.minWeaponDamage;
        attributes.maxWeaponDamage = this.maxWeaponDamage;
        attributes.skillDamage = this.skillDamage;
        attributes.minSkillDamage = this.minSkillDamage;
        attributes.maxSkillDamage = this.maxSkillDamage;
        attributes.defense = this.defense;
        attributes.mana = this.mana;
        attributes.stamina = this.stamina;
        return (SelfType) attributes;
    }

    /**
     * Retrieves the defense.
     * @return The defense.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Adds a specified amount of defense to the current defense.
     * @param bonusDefense The amount of defense to be added.
     * @return The instance with the defense added.
     */
    public SelfType addDefense(int bonusDefense) {
        this.defense += bonusDefense;
        return (SelfType) this;
    }

    /**
     * Sets the defense of the current instance.
     * @param defense The defense to be set to.
     * @return The instance with the new defense.
     */
    public SelfType setDefense(int defense) {
        this.defense = defense;
        return (SelfType) this;
    }

    /**
     * Retrieves the weapon damage.
     * @return The weapon damage.
     */
    public int getWeaponDamage() {
        return weaponDamage;
    }

    /**
     * Adds a specified amount of weapon damage to the current weapon damage.
     * @param bonusDamage The amount of weapon damage to be added.
     * @return The instance with the weapon damage added.
     */
    public SelfType addWeaponDamage(int bonusDamage) {
        this.weaponDamage += bonusDamage;
        return (SelfType) this;
    }

    /**
     * Sets the weapon damage of the current instance.
     * @param weaponDamage The weapon damage to be set to.
     * @return The instance with the new weapon damage.
     */
    public SelfType setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
        return (SelfType) this;
    }

    /**
     * Retrieves the skill damage.
     * @return The skill damage.
     */
    public int getSkillDamage() {
        return skillDamage;
    }

    /**
     * Adds the specified amount of skill damage to the current instance.
     * @param bonusDamage The amount of skill damage to be added.
     * @return The instance with the skill damage added.
     */
    public SelfType addSkillDamage(int bonusDamage) {
        skillDamage += bonusDamage;
        return (SelfType) this;
    }

    /**
     * Sets the skill damage of the current instance.
     * @param bonusDamage The skill damage to be set to.
     * @return The instance with the new skill damage.
     */
    public SelfType setSkillDamage(int bonusDamage) {
        skillDamage = bonusDamage;
        return (SelfType) this;
    }

    /**
     * Retrieves the bonus health that this instance adds.
     * @return The bonus health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Adds a specified amount of bonus health to this instance.
     * @param bonusHealth The amount of bonus health to be added.
     * @return The instance with the bonus health added.
     */
    public SelfType addHealth(int bonusHealth) {
        this.health += bonusHealth;
        return (SelfType) this;
    }

    /**
     * Sets the bonus health of the current instance.
     * @param health The bonus health to be set to.
     * @return The instance with the new bonus health.
     */
    public SelfType setHealth(int health) {
        this.health = health;
        return (SelfType) this;
    }

    /**
     * Retrieves the mana.
     * @return The mana.
     */
    public int getMana() {
        return mana;
    }

    /**
     * Adds a specified amount of mana to this instance.
     * @param bonusMana The amount of mana to be added.
     * @return The instance with the mana added.
     */
    public SelfType addMana(int bonusMana) {
        this.mana += bonusMana;
        return (SelfType) this;
    }

    /**
     * Sets the mana of the current instance.
     * @param mana The mana to be set to.
     * @return The instance with the new mana.
     */
    public SelfType setMana(int mana) {
        this.mana = mana;
        return (SelfType) this;
    }

    /**
     * Retrieves the stamina.
     * @return The stamina.
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Adds a specified amount of stamina to this instance.
     * @param bonusStamina The amount of stamina to be added.
     * @return The instance with the stamina added.
     */
    public SelfType addStamina(int bonusStamina) {
        this.stamina += bonusStamina;
        return (SelfType) this;
    }

    /**
     * Sets the stamina of the current instance.
     * @param stamina The stamina to be set to.
     * @return The instance with the new stamina.
     */
    public SelfType setStamina(int stamina) {
        this.stamina = stamina;
        return (SelfType) this;
    }

    public int getMinWeaponDamage() {
        return minWeaponDamage;
    }

    public SelfType addBonusMinWeaponDamage(int bonusMinWeaponDamage) {
        this.minWeaponDamage += bonusMinWeaponDamage;
        return (SelfType) this;
    }

    public SelfType setMinWeaponDamage(int minWeaponDamage) {
        this.minWeaponDamage = minWeaponDamage;
        return (SelfType) this;
    }

    public int getMaxWeaponDamage() {
        return maxWeaponDamage;
    }

    public SelfType addBonusMaxWeaponDamage(int bonusMaxWeaponDamage) {
        this.maxWeaponDamage += bonusMaxWeaponDamage;
        return (SelfType) this;
    }

    public SelfType setMaxWeaponDamage(int maxWeaponDamage) {
        this.maxWeaponDamage = maxWeaponDamage;
        return (SelfType) this;
    }

    public int getMinSkillDamage() {
        return minSkillDamage;
    }

    public SelfType addBonusMinSkillDamage(int bonusMinSkillDamage) {
        this.minSkillDamage += bonusMinSkillDamage;
        return (SelfType) this;
    }

    public SelfType setMinSkillDamage(int minSkillDamage) {
        this.minSkillDamage = minSkillDamage;
        return (SelfType) this;
    }

    public int getMaxSkillDamage() {
        return maxSkillDamage;
    }

    public SelfType addBonusMaxSkillDamage(int bonusMaxSkillDamage) {
        this.maxSkillDamage += bonusMaxSkillDamage;
        return (SelfType) this;
    }

    public SelfType setMaxSkillDamage(int maxSkillDamage) {
        this.maxSkillDamage = maxSkillDamage;
        return (SelfType) this;
    }
}
