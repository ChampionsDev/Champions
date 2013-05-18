package com.github.championsdev.champions.library;

/**
 * @author YoshiGenius
 */
public class CBlock {

    private final CLocation location;
    private CWorld world;
    private final short dataValue;
    private final int id;

    public CBlock(CLocation location, int id, short dataValue) {
        this.location = location;
        this.world = location.getWorld();
        this.id = id;
        this.dataValue = dataValue;
    }

    public CLocation getLocation() {
        return this.location;
    }

    public CWorld getWorld() {
        return this.world;
    }

    public int getID() {
        return this.id;
    }

    public short getDataValue() {
        return this.dataValue;
    }

}
