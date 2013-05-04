package net.dawnfirerealms.legends.library.exp;

import net.dawnfirerealms.legends.library.restriction.Restrictable;

/**
 * @author YoshiGenius
 */
public class Level extends Number implements Restrictable {
    
    private int level;

    public Level(int level) {
        this.level = level;
    }
    
    @Override
    public int intValue() {
        return this.level;
    }

    @Override
    public long longValue() {
        return this.level;
    }

    @Override
    public float floatValue() {
        return this.level;
    }

    @Override
    public double doubleValue() {
        return this.level;
    }

}