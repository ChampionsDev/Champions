package net.dawnfirerealms.legends.library.database;

import net.dawnfirerealms.legends.core.LPlayer;
import net.dawnfirerealms.legends.library.lclass.LClass;
import net.dawnfirerealms.legends.library.race.Race;

/**
 * @author YoshiGenius
 */
public abstract class DataManager {
    
    public enum DataType {
        ORACLE, MYSQL, POSTGRE, H2, SQLITE, DAT, YAML;
    }
    
    private static DataType dataType;
    
    public static DataType getType() {
        return dataType;
    }
    
    public static DataManager getInUse() {
        return DataManagers.getCurrent();
    }
    
    public abstract LPlayer loadLPlayer(String name);
    
    public abstract Race loadRace(String name);
    
    public abstract LClass loadLClass(String name);

}