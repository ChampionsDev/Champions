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
public class H2DataSource implements DataSource {
    @Override
    public String getName() {
        return "H2";
    }

    @Override
    public Logger getLogger() {
        return null; //TODO getLogger method stub
    }

    @Override
    public CPlayer loadLPlayer(String name) {
        return null; //TODO loadLPlayer method stub
    }

    @Override
    public void saveLPlayer(CPlayer lPlayer) {
        //TODO saveLPlayer method stub
    }

    @Override
    public Race loadRace(String name) {
        return null; //TODO loadRace method stub
    }

    @Override
    public CClass loadLClass(String name) {
        return null; //TODO loadLClass method stub
    }

    @Override
    public Skill loadSkill(String name) {
        return null; //TODO loadSkill method stub
    }

    @Override
    public Weapon loadWeapon(String name) {
        return null; //TODO loadWeapon method stub
    }

    @Override
    public BasicCategory<WeaponAttributes> loadWeaponCategory(String name) {
        return null; //TODO loadWeaponCategory method stub
    }

    @Override
    public Party loadParty(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ExpGroup loadExpGroup(String name) {
        return null; //TODO loadExpGroup method stub
    }
}
