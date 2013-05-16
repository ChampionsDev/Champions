package com.github.legendsdev.legends.library;

/**
 * @author YoshiGenius
 */
public class LLocation {

    private final LWorld world;
    private final double x;
    private final double y;
    private final double z;
    private final float yaw;
    private final float pitch;

    public LLocation(LWorld world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.z = z;
        this.y = y;
        this.x = x;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public LLocation(LWorld world, double x, double y, double z) {
        this(world, x, y, z, 0, 0);
    }

    public LWorld getWorld() {
        return this.world;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public int getBlockX() {
        return locToBlock(this.getX());
    }

    public int getBlockY() {
        return locToBlock(this.getY());
    }

    public int getBlockZ() {
        return locToBlock(this.getZ());
    }

    public LBlock getBlock() {
        return this.getWorld().getBlockAt(this);
    }

    public double distance(LLocation o) {
        return Math.sqrt(distanceSquared(o));
    }
    public double distanceSquared(LLocation o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null location");
        } else if (o.getWorld() == null || getWorld() == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null world");
        } else if (o.getWorld() != getWorld()) {
            throw new IllegalArgumentException("Cannot measure distance between " + getWorld().getName() + " and " + o.getWorld().getName());
        }

        return Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2) + Math.pow(z - o.z, 2);
    }

    public static int locToBlock(double num) {
        final int floor = (int) num;
        return floor == num ? floor : floor - (int) (Double.doubleToRawLongBits(num) >>> 63);
    }
}
