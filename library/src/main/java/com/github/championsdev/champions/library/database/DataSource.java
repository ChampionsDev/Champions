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
package com.github.championsdev.champions.library.database;

import com.github.championsdev.champions.library.BasicCategory;
import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.level.exp.ExpGroup;
import com.github.championsdev.champions.library.party.Party;
import com.github.championsdev.champions.library.race.Race;
import com.github.championsdev.champions.library.skill.Skill;
import com.github.championsdev.champions.library.weapon.Weapon;
import com.github.championsdev.champions.library.weapon.WeaponAttributes;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public interface DataSource {
    public String getName();
    public Logger getLogger();

    public CPlayer loadLPlayer(String name);
    public void saveLPlayer(CPlayer lPlayer);
    public Race loadRace(String name);
    public CClass loadLClass(String name);
    public Skill loadSkill(String name);
    public Weapon loadWeapon(String name);
    public BasicCategory<WeaponAttributes> loadWeaponCategory(String name);
    public Party loadParty(String name);

    public ExpGroup loadExpGroup(String name);
}
