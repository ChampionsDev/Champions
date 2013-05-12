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

import com.github.legendsdev.legends.library.LPlayer;
import com.github.legendsdev.legends.library.lclass.LClass;
import com.github.legendsdev.legends.library.race.Race;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class SQLDataSource implements DataSource {
    
    public static enum SQLDatabaseType {
        MYSQL, SQLITE, POSTGRESQL, NOSQL;
    }
    
    private SQLDatabaseType databasetype;

    private SQLDatabaseType getDatabaseType() {
        return this.databasetype;
    }
    
    @Override
    public String getName() {
        switch (this.getDatabaseType()) {
            case MYSQL:
                return "MySQL";
            case SQLITE:
                return "SQLite";
            case POSTGRESQL:
                return "PostGreSQL";
            case NOSQL:
                return "NoSQL";
        }
        return "SQL";
    }

    @Override
    public Logger getLogger() {
        return Logger.getLogger(SQLDataSource.class.getName());
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
