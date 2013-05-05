package net.dawnfirerealms.legends.library.database;

import net.dawnfirerealms.legends.core.LPlayer;
import net.dawnfirerealms.legends.library.lclass.LClass;
import net.dawnfirerealms.legends.library.race.Race;

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