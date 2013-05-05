/*
    This file is part of Legends

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends  If not, see <http://www.gnu.org/licenses/>.
*/

package net.dawnfirerealms.legends.library.database;

import java.util.HashMap;

/**
 * @author YoshiGenius
 */
public class DataManagers {
    
    private static HashMap<DataManager.DataType, DataManager> managers = new HashMap<>();
    
    public static HashMap<DataManager.DataType, DataManager> getManagers() {
        if (managers.isEmpty()) {
            addDefaultManagers();
        }
        return DataManagers.managers;
    }

    public static DataManager getCurrent() {
        if (managers.isEmpty()) {
            addDefaultManagers();
        }
        return managers.get(DataManager.getType());
    }
    
    private static void addDefaultManagers() {
        managers.put(DataManager.DataType.DAT, new DATDataManager());
        managers.put(DataManager.DataType.H2, new H2DataManager());
        managers.put(DataManager.DataType.MYSQL, new MySQLDataManager());
        managers.put(DataManager.DataType.ORACLE, new OracleDataManager());
        managers.put(DataManager.DataType.POSTGRE, new PostGREDataManager());
        managers.put(DataManager.DataType.SQLITE, new SQLiteDataManager());
        managers.put(DataManager.DataType.YAML, new YAMLDataManager());
    }

}