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

import java.util.HashMap;

/**
 * @author YoshiGenius
 */
public class DataManager {
    private static DataSource dataSource;
    private static DataManager instance;

    private static HashMap<String, DataSource> dataSources = new HashMap<>();

    public static DataManager getInstance() {
        if(instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    private DataManager() {
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
    
    public static void setDataSource(DataSource dataSource) {
        if(!dataSources.containsKey(dataSource.getDataSourceName())) {
            dataSources.put(dataSource.getDataSourceName(), dataSource);
        }
        DataManager.dataSource = dataSource;
    }

    public static void registerDataSource(String name, DataSource dataSource) {
        dataSources.put(name, dataSource);
    }
    


}