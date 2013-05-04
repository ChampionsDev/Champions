package net.dawnfirerealms.legends.library.database;

import java.io.File;
import net.dawnfirerealms.legends.core.LPlayer;
import net.dawnfirerealms.legends.core.LegendsCore;

/**
 * @author YoshiGenius
 */
public class DataManager {
    
    public enum DataType {
        ORACLE, MYSQL, POSTGRE, H2, SQLITE, DAT, YAML;
    }
    
    private DataType dataType;
    
    public DataManager(DataManager.DataType dataType) {
        this.dataType = dataType;
    }
    
    public DataType getCurrentDataType() {
        return this.dataType;
    }
    
    public LPlayer loadLPlayer(String name) {
        switch (getCurrentDataType()) {
            case ORACLE:
            case MYSQL:
            case POSTGRE:
            case H2:
            case SQLITE:
            case DAT:
            case YAML:
                File playerFolder = new File(LegendsCore.instance.getDataFolder(), "players");
                File playerData = new File(playerFolder, name + ".yml");
                
        }
    }

}