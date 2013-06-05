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
    
    public static BasicAttributes combine(BasicAttributes... info) {
        return combine(Arrays.asList(info));
    }

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
    
    public BasicAttributes() {
    }

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

    public int getDefense() {
        return defense;
    }

    public SelfType addDefense(int bonusDefense) {
        this.defense += bonusDefense;
        return (SelfType) this;
    }

    public SelfType setDefense(int defense) {
        this.defense = defense;
        return (SelfType) this;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public SelfType addWeaponDamage(int bonusDamage) {
        this.weaponDamage += bonusDamage;
        return (SelfType) this;
    }

    public int getSkillDamage() {
        return skillDamage;
    }

    public SelfType setSkillDamage(int bonusDamage) {
        skillDamage = bonusDamage;
        return (SelfType) this;
    }

    public SelfType addSkillDamage(int bonusDamage) {
        skillDamage += bonusDamage;
        return (SelfType) this;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getHealth() {
        return health;
    }
    
    public SelfType addHealth(int bonusHealth) {
        this.health += bonusHealth;
        return (SelfType) this;
    }

    public SelfType setHealth(int health) {
        this.health = health;
        return (SelfType) this;
    }

    public int getMana() {
        return mana;
    }
    
    public SelfType addMana(int bonusMana) {
        this.mana += bonusMana;
        return (SelfType) this;
    }

    public SelfType setMana(int mana) {
        this.mana = mana;
        return (SelfType) this;
    }

    public SelfType addStamina(int bonusStamina) {
        this.stamina += bonusStamina;
        return (SelfType) this;
    }

    public SelfType setStamina(int stamina) {
        this.stamina = stamina;
        return (SelfType) this;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMinWeaponDamage() {
        return minWeaponDamage;
    }

    public SelfType setMinWeaponDamage(int minWeaponDamage) {
        this.minWeaponDamage = minWeaponDamage;
        return (SelfType) this;
    }

    public SelfType addBonusMinWeaponDamage(int bonusMinWeaponDamage) {
        this.minWeaponDamage += bonusMinWeaponDamage;
        return (SelfType) this;
    }

    public int getMaxWeaponDamage() {
        return maxWeaponDamage;
    }

    public SelfType setMaxWeaponDamage(int maxWeaponDamage) {
        this.maxWeaponDamage = maxWeaponDamage;
        return (SelfType) this;
    }

    public SelfType addBonusMaxWeaponDamage(int bonusMaxWeaponDamage) {
        this.maxWeaponDamage += bonusMaxWeaponDamage;
        return (SelfType) this;
    }

    public int getMinSkillDamage() {
        return minSkillDamage;
    }

    public SelfType setMinSkillDamage(int minSkillDamage) {
        this.minSkillDamage = minSkillDamage;
        return (SelfType) this;
    }

    public SelfType addBonusMinSkillDamage(int bonusMinSkillDamage) {
        this.minSkillDamage += bonusMinSkillDamage;
        return (SelfType) this;
    }

    public int getMaxSkillDamage() {
        return maxSkillDamage;
    }

    public SelfType setMaxSkillDamage(int maxSkillDamage) {
        this.maxSkillDamage = maxSkillDamage;
        return (SelfType) this;
    }

    public SelfType addBonusMaxSkillDamage(int bonusMaxSkillDamage) {
        this.maxSkillDamage += bonusMaxSkillDamage;
        return (SelfType) this;
    }
}
