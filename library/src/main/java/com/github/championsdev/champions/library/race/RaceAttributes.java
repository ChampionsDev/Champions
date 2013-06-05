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
package com.github.championsdev.champions.library.race;

import com.github.championsdev.champions.library.BasicAttributes;
import com.github.championsdev.champions.library.StatsInfo;

/**
 * @author B2OJustin
 */
public class RaceAttributes extends BasicAttributes<RaceAttributes> implements StatsInfo<RaceAttributes> {
    public int healthPerLevel = 0;
    public int manaPerLevel = 0;
    public int staminaPerLevel = 0;

    public RaceAttributes setHealthPerLevel(int healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
        return this;
    }

    public RaceAttributes setManaPerLevel(int manaPerLevel) {
        this.manaPerLevel = manaPerLevel;
        return this;
    }

    @Override
    public RaceAttributes setStaminaPerLevel(int staminaPerLevel) {
        this.staminaPerLevel = staminaPerLevel;
        return this;
    }

    public int getHealthPerLevel() {
        return healthPerLevel;
    }

    public int getManaPerLevel() {
        return manaPerLevel;
    }

    @Override
    public int getStaminaPerLevel() {
        return staminaPerLevel;
    }
}
