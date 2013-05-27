/*
 * This file is part of Champions.
 *
 *     Champions is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Champions is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Champions.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.championsdev.champions.library;

/**
 * @author YoshiGenius
 */
public class CLocation {

    private final CWorld world;
    private final double x;
    private final double y;
    private final double z;
    private final float yaw;
    private final float pitch;

    public CLocation(CWorld world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.z = z;
        this.y = y;
        this.x = x;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public CLocation(CWorld world, double x, double y, double z) {
        this(world, x, y, z, 0, 0);
    }

    public CWorld getWorld() {
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

    public CBlock getBlock() {
        return this.getWorld().getBlockAt(this);
    }

    public double distance(CLocation o) {
        return Math.sqrt(distanceSquared(o));
    }
    public double distanceSquared(CLocation o) {
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
