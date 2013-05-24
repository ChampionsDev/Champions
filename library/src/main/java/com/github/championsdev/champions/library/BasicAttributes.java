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
package com.github.championsdev.champions.library;

import java.util.Arrays;
import java.util.List;

/**
 * @author B2OJustin
 */

@SuppressWarnings("unchecked")
public class BasicAttributes<SelfType extends BasicAttributes> {
    private int bonusWeaponDamage = 0;
    private int bonusMinWeaponDamage = 0;
    private int bonusMaxWeaponDamage = 0;
    private int bonusSkillDamage = 0;
    private int bonusMinSkillDamage = 0;
    private int bonusMaxSkillDamage = 0;
    private int bonusDefense = 0;
    private int bonusHealth = 0;
    private int bonusMana = 0;
    private int bonusStamina = 0;

    public static BasicAttributes combine(List<BasicAttributes> infos) {
        BasicAttributes info = new BasicAttributes();
        for (BasicAttributes inf : infos) {
            info.addBonusDefense(inf.getBonusDefense());
            info.addBonusSkillDamage(inf.getBonusSkillDamage());
            info.addBonusMana(inf.getBonusMana());
            info.addBonusHealth(inf.getBonusHealth());
            info.addBonusWeaponDamage(inf.getBonusWeaponDamage());
            info.addBonusStamina(inf.getBonusStamina());
        }
        return info;
    }
    
    public static BasicAttributes combine(BasicAttributes... info) {
        return combine(Arrays.asList(info));
    }
    
    public BasicAttributes() {
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

    public SelfType addBonusDefense(int bonusDefense) {
        this.bonusDefense += bonusDefense;
        return (SelfType) this;
    }

    public SelfType setBonusDefense(int bonusDefense) {
        this.bonusDefense = bonusDefense;
        return (SelfType) this;
    }

    public int getBonusWeaponDamage() {
        return bonusWeaponDamage;
    }

    public SelfType addBonusWeaponDamage(int bonusDamage) {
        this.bonusWeaponDamage += bonusDamage;
        return (SelfType) this;
    }

    public int getBonusSkillDamage() {
        return bonusSkillDamage;
    }

    public SelfType setBonusSkillDamage(int bonusDamage) {
        bonusSkillDamage = bonusDamage;
        return (SelfType) this;
    }

    public SelfType addBonusSkillDamage(int bonusDamage) {
        bonusSkillDamage += bonusDamage;
        return (SelfType) this;
    }

    public void setBonusWeaponDamage(int bonusWeaponDamage) {
        this.bonusWeaponDamage = bonusWeaponDamage;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }
    
    public SelfType addBonusHealth(int bonusHealth) {
        this.bonusHealth += bonusHealth;
        return (SelfType) this;
    }

    public SelfType setBonusHealth(int bonusHealth) {
        this.bonusHealth = bonusHealth;
        return (SelfType) this;
    }

    public int getBonusMana() {
        return bonusMana;
    }
    
    public SelfType addBonusMana(int bonusMana) {
        this.bonusMana += bonusMana;
        return (SelfType) this;
    }

    public SelfType setBonusMana(int bonusMana) {
        this.bonusMana = bonusMana;
        return (SelfType) this;
    }

    public SelfType addBonusStamina(int bonusStamina) {
        this.bonusStamina += bonusStamina;
        return (SelfType) this;
    }

    public SelfType setBonusStamina(int bonusStamina) {
        this.bonusStamina = bonusStamina;
        return (SelfType) this;
    }

    public int getBonusStamina() {
        return bonusStamina;
    }

    public int getBonusMinWeaponDamage() {
        return bonusMinWeaponDamage;
    }

    public SelfType setBonusMinWeaponDamage(int bonusMinWeaponDamage) {
        this.bonusMinWeaponDamage = bonusMinWeaponDamage;
        return (SelfType) this;
    }

    public SelfType addBonusMinWeaponDamage(int bonusMinWeaponDamage) {
        this.bonusMinWeaponDamage += bonusMinWeaponDamage;
        return (SelfType) this;
    }

    public int getBonusMaxWeaponDamage() {
        return bonusMaxWeaponDamage;
    }

    public SelfType setBonusMaxWeaponDamage(int bonusMaxWeaponDamage) {
        this.bonusMaxWeaponDamage = bonusMaxWeaponDamage;
        return (SelfType) this;
    }

    public SelfType addBonusMaxWeaponDamage(int bonusMaxWeaponDamage) {
        this.bonusMaxWeaponDamage += bonusMaxWeaponDamage;
        return (SelfType) this;
    }

    public int getBonusMinSkillDamage() {
        return bonusMinSkillDamage;
    }

    public SelfType setBonusMinSkillDamage(int bonusMinSkillDamage) {
        this.bonusMinSkillDamage = bonusMinSkillDamage;
        return (SelfType) this;
    }

    public SelfType addBonusMinSkillDamage(int bonusMinSkillDamage) {
        this.bonusMinSkillDamage += bonusMinSkillDamage;
        return (SelfType) this;
    }

    public int getBonusMaxSkillDamage() {
        return bonusMaxSkillDamage;
    }

    public SelfType setBonusMaxSkillDamage(int bonusMaxSkillDamage) {
        this.bonusMaxSkillDamage = bonusMaxSkillDamage;
        return (SelfType) this;
    }

    public SelfType addBonusMaxSkillDamage(int bonusMaxSkillDamage) {
        this.bonusMaxSkillDamage += bonusMaxSkillDamage;
        return (SelfType) this;
    }
}
