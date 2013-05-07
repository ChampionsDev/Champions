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

package net.dawnfirerealms.legends.library.skill;

/**
 * @author YoshiGenius
 */
public class SkillInfo {
    private int level = 0;
    private int manaCost = 0;
    private int cooldownSeconds = 0;
    private double healthCost = 0;
    private double hungerCost = 0;
    
    public SkillInfo() {
    }
    
    public int getLevel() {
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
    
    public SkillInfo setLevel(int level) {
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

}