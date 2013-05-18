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

import com.github.championsdev.champions.library.Configuration;

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

    /**
     * Sets the current DataSource
     * it is automatically registered if necessary.
     *
     * @param dataSource
     */
    public static void setDataSource(DataSource dataSource) {
        if(!dataSources.containsKey(dataSource.getName())) {
            dataSources.put(dataSource.getName(), dataSource);
        }
        DataManager.dataSource = dataSource;
    }

    public static void registerDataSource(DataSource dataSource) {
        dataSources.put(dataSource.getName(), dataSource);
    }

    /**
     * Initializes the DataManager using the Configuration instance.
     *
     * @param config Configuration to retrieve database settings.
     */
    public static void init(Configuration config) {
        switch(config.getDatabaseType().toUpperCase()) {
            case "YAML":
                setDataSource(new YAMLDataSource(config.getYamlConfigPath()));
                break;
        }
    }
    


}