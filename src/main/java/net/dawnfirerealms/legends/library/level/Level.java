package net.dawnfirerealms.legends.library.level;

/**
 * @author YoshiGenius
 */
public class Level extends Number {
    
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
}