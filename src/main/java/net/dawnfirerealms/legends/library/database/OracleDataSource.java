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
package net.dawnfirerealms.legends.library.database;

import net.dawnfirerealms.legends.library.LPlayer;
import net.dawnfirerealms.legends.library.lclass.LClass;
import net.dawnfirerealms.legends.library.race.Race;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class OracleDataSource implements DataSource {
    @Override
    public String getName() {
        return "Oracle";
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
    public Race loadRace(String name) {
        return null; //TODO loadRace method stub
    }

    @Override
    public LClass loadLClass(String name) {
        return null; //TODO loadLClass method stub
    }
}
