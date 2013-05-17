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
package com.github.legendsdev.legends.library.database;

import com.github.legendsdev.legends.library.lclass.LClass;
import com.github.legendsdev.legends.library.level.exp.ExpGroup;
import com.github.legendsdev.legends.library.lplayer.LPlayer;
import com.github.legendsdev.legends.library.race.Race;
import com.github.legendsdev.legends.library.skill.Skill;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class DATDataSource implements DataSource {
    @Override
    public String getName() {
        return "DAT";
    }

    @Override
    public Logger getLogger() {
        return null; //TODO getLogger method stub
    }

    @Override
    public LPlayer loadLPlayer(String name) {
        return null; //TODO loadLPlayer method stub
    }

    @Override
    public void saveLPlayer(LPlayer lPlayer) {
        //TODO saveLPlayer method stub
    }

    @Override
    public Race loadRace(String name) {
        return null; //TODO loadRace method stub
    }

    @Override
    public LClass loadLClass(String name) {
        return null; //TODO loadLClass method stub
    }

    @Override
    public Skill loadSkill(String name) {
        return null; //TODO loadSkill method stub
    }

    @Override
    public ExpGroup loadExpGroup(String name) {
        return null; //TODO loadExpGroup method stub
    }
}
