/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library.database;

import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.level.exp.ExpGroup;
import com.github.championsdev.champions.library.race.Race;
import com.github.championsdev.champions.library.skill.Skill;

import java.util.logging.Logger;

/**
 * @author B2OJustin
 */
public class SQLDataSource implements DataSource {
    
    public static enum SQLDatabaseType {
        MYSQL, SQLITE, POSTGRESQL, NOSQL;
    }

    public SQLDataSource(SQLDataSource.SQLDatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    private SQLDatabaseType databaseType;

    public SQLDatabaseType getDatabaseType() {
        return this.databaseType;
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
    public ExpGroup loadExpGroup(String name) {
        return null; //TODO loadExpGroup method stub
    }
}
