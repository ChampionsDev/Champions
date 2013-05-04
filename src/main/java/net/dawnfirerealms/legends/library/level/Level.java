package net.dawnfirerealms.legends.library.level;

import net.dawnfirerealms.legends.library.restriction.LevelRestrictable;
import net.dawnfirerealms.legends.library.restriction.Restrictable;

/**
 * @author YoshiGenius
 */
public class Level extends Number implements LevelRestrictable {
    
    private int level;

    public Level(int level) {
        this.level = level;
    }
    
    @Override
    public int intValue() {
        return level;
    }

    @Override
    public long longValue() {
        return level;
    }

    @Override
    public float floatValue() {
        return level;
    }

    @Override
    public double doubleValue() {
        return level;
    }

    @Override
    public int getLevel() {
        return level;
    }
}