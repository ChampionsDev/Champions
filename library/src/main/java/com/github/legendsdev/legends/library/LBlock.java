package com.github.legendsdev.legends.library;

/**
 * @author YoshiGenius
 */
public class LBlock {

    private final LLocation location;
    private LWorld world;
    private final short dataValue;
    private final int id;

    public LBlock(LLocation location, int id, short dataValue) {
        this.location = location;
        this.world = location.getWorld();
        this.id = id;
        this.dataValue = dataValue;
    }

    public LLocation getLocation() {
        return this.location;
    }

    public LWorld getWorld() {
        return this.world;
    }

    public int getID() {
        return this.id;
    }

    public short getDataValue() {
        return this.dataValue;
    }

}
