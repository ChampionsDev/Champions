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

import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.level.LevelRestrictions;

/**
 * @author B2OJustin
 */

@SuppressWarnings("unchecked")
public class BasicInfo<SelfType extends BasicInfo> {
    private int bonusWeaponDamage = 0;
    private int bonusSkillDamage = 0;
    private int bonusDefense = 0;
    private int bonusHealth = 0;
    private int bonusMana = 0;

    public BasicInfo() {
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

    public SelfType setBonusHealth(int bonusHealth) {
        this.bonusHealth = bonusHealth;
        return (SelfType) this;
    }

    public int getBonusMana() {
        return bonusMana;
    }

    public SelfType setBonusMana(int bonusMana) {
        this.bonusMana = bonusMana;
        return (SelfType) this;
    }

    public SelfType
}
