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

import com.github.legendsdev.legends.library.armor.ArmorRestricted;
import com.github.legendsdev.legends.library.armor.ArmorRestrictions;
import com.github.legendsdev.legends.library.level.Level;
import com.github.legendsdev.legends.library.level.LevelRestricted;
import com.github.legendsdev.legends.library.level.LevelRestrictions;
import com.github.legendsdev.legends.library.level.LevelUser;
import com.github.legendsdev.legends.library.race.RaceRestricted;
import com.github.legendsdev.legends.library.race.RaceRestrictions;
import com.github.legendsdev.legends.library.skill.SkillRestricted;
import com.github.legendsdev.legends.library.skill.SkillRestrictions;
import com.github.legendsdev.legends.library.weapon.WeaponRestricted;
import com.github.legendsdev.legends.library.weapon.WeaponRestrictions;

/**
 * @author B2OJustin
 */
public class LClassInfo implements LevelUser, SkillRestricted, ArmorRestricted, WeaponRestricted, LevelRestricted {
    private Level level = new Level(0);

    private WeaponRestrictions weaponRestrictions = new WeaponRestrictions();
    private ArmorRestrictions armorRestrictions = new ArmorRestrictions();
    private SkillRestrictions skillRestrictions = new SkillRestrictions();
    private LevelRestrictions levelRestrictions = new LevelRestrictions();

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public ArmorRestrictions getArmorRestrictions() {
        return armorRestrictions;
    }

    @Override
    public LevelRestrictions getLevelRestrictions() {
        return levelRestrictions;
    }

    @Override
    public SkillRestrictions getSkillRestrictions() {
        return skillRestrictions;
    }

    @Override
    public WeaponRestrictions getWeaponRestrictions() {
        return weaponRestrictions;
    }
}
