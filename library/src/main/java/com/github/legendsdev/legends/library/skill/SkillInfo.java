/*
    This file is part of Legends

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.legendsdev.legends.library.skill;

import com.github.legendsdev.legends.library.level.Level;
import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.level.LevelRestrictions;
import com.github.legendsdev.legends.library.level.LevelUser;

/**
 * @author YoshiGenius
 */
public class SkillInfo implements LevelUser, LevelRestricted {
    private Level level = new Level(1);
    private int manaCost = 0;
    private int cooldownSeconds = 0;
    private double healthCost = 0;
    private double hungerCost = 0;
    private int damage = 0;

    private LevelRestrictions levelRestrictions = new LevelRestrictions();
    
    public SkillInfo() {
    }

    @Override
    public Level getLevel() {
        return this.level;
    }
    
    public int getManaCost() {
        return this.manaCost;
    }
    
    public int getCooldownSeconds() {
        return this.cooldownSeconds;
    }
    
    public double getHealthCost() {
        return this.healthCost;
    }
    
    public double getHungerCost() {
        return this.hungerCost;
    }
    
    public SkillInfo setLevel(Level level) {
        this.level = level;
        return this;
    }
    
    public SkillInfo setManaCost(int manaCost) {
        this.manaCost = manaCost;
        return this;
    }
    
    public SkillInfo setCooldownSeconds(int cooldownSeconds) {
        this.cooldownSeconds = cooldownSeconds;
        return this;
    }
    
    public SkillInfo setHealthCost(int healthCost) {
        this.healthCost = healthCost;
        return this;
    }
    
    public SkillInfo setHungerCost(int hungerCost) {
        this.hungerCost = hungerCost;
        return this;
    }

    public int getDamage() {
        return damage;
    }

    public SkillInfo setDamage(int damage) {
        this.damage = damage;
        return this;
    }
}