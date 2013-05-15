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
package com.github.legendsdev.legends.library.lclass;

import com.github.legendsdev.legends.library.BasicInfo;
import com.github.legendsdev.legends.library.StatsInfo;
import com.github.legendsdev.legends.library.level.Level;
import com.github.legendsdev.legends.library.level.LevelUser;

/**
 * @author B2OJustin
 */
public class LClassInfo extends BasicInfo<LClassInfo> implements LevelUser, StatsInfo<LClassInfo> {
    private Level level = new Level(0);
    public int healthPerLevel = 0;
    public int manaPerLevel = 0;

    public LClassInfo setHealthPerLevel(int healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
        return this;
    }

    public LClassInfo setManaPerLevel(int manaPerLevel) {
        this.manaPerLevel = manaPerLevel;
        return this;
    }

    public int getHealthPerLevel() {
        return healthPerLevel;
    }

    public int getManaPerLevel() {
        return manaPerLevel;
    }
    @Override
    public Level getLevel() {
        return level;
    }
}
