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
package com.github.championsdev.champions.library.cclass;

import com.github.championsdev.champions.library.BasicInfo;
import com.github.championsdev.champions.library.StatsInfo;
import com.github.championsdev.champions.library.level.Level;
import com.github.championsdev.champions.library.level.LevelUser;

/**
 * @author B2OJustin
 */
public class CClassInfo extends BasicInfo<CClassInfo> implements LevelUser, StatsInfo<CClassInfo> {
    private Level level = new Level(0);
    private int healthPerLevel = 0;
    private int manaPerLevel = 0;
    private int staminaPerLevel = 0;
    private Level masteryLevel = new Level(0);

    public CClassInfo setMasteryLevel(Level level) {
        masteryLevel = level;
        return this;
    }

    public Level getMasteryLevel() {
        return masteryLevel;
    }

    @Override
    public CClassInfo setHealthPerLevel(int healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
        return this;
    }

    @Override
    public CClassInfo setManaPerLevel(int manaPerLevel) {
        this.manaPerLevel = manaPerLevel;
        return this;
    }

    @Override
    public CClassInfo setStaminaPerLevel(int staminaPerLevel) {
        this.staminaPerLevel = staminaPerLevel;
        return this;
    }

    @Override
    public int getHealthPerLevel() {
        return healthPerLevel;
    }

    @Override
    public int getManaPerLevel() {
        return manaPerLevel;
    }

    @Override
    public int getStaminaPerLevel() {
        return staminaPerLevel;
    }

    @Override
    public Level getLevel() {
        return level;
    }
}
