/*
    This file is part of Champions

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.championsdev.champions.library.skill;

import com.github.championsdev.champions.library.level.Level;
import com.github.championsdev.champions.library.level.LevelRestricted;
import com.github.championsdev.champions.library.level.LevelRestrictions;
import com.github.championsdev.champions.library.level.LevelUser;

/**
 * @author YoshiGenius
 */
public class SkillAttributes implements LevelUser, LevelRestricted {
    private Level level = new Level(1);
    private int manaCost = 0;
    private int cooldownSeconds = 0;
    private int healthCost = 0;
    private int staminaCost = 0;
    private int damage = 0;

    private LevelRestrictions levelRestrictions = new LevelRestrictions();
    
    public SkillAttributes() {
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
    
    public int getHealthCost() {
        return this.healthCost;
    }
    
    public int getStaminaCost() {
        return this.staminaCost;
    }
    
    public SkillAttributes setLevel(Level level) {
        this.level = level;
        return this;
    }
    
    public SkillAttributes setManaCost(int manaCost) {
        this.manaCost = manaCost;
        return this;
    }
    
    public SkillAttributes setCooldownSeconds(int cooldownSeconds) {
        this.cooldownSeconds = cooldownSeconds;
        return this;
    }
    
    public SkillAttributes setHealthCost(int healthCost) {
        this.healthCost = healthCost;
        return this;
    }
    
    public SkillAttributes setStaminaCost(int staminaCost) {
        this.staminaCost = staminaCost;
        return this;
    }

    public int getDamage() {
        return damage;
    }

    public SkillAttributes setDamage(int damage) {
        this.damage = damage;
        return this;
    }
}