package com.github.legendsdev.legends.library;

import com.github.legendsdev.legends.library.lplayer.LPlayer;

/**
 * @author YoshiGenius
 * @date 14/05/13
 * @time 6:02 PM
 */
public abstract class LWorld {

    public abstract LBlock getBlockAt(LLocation location);
    public LBlock getBlockAt(int x, int y, int z) {
        return getBlockAt(new LLocation(this, x, y, z));
    }
    public abstract String getName();
    public abstract LPlayer[] getPlayers();
    public LPlayer getPlayerNearest(LLocation location) {
        if (!location.getWorld().getName().equals(getName())) {
            return null;
        }
        for (LPlayer p : getPlayers()) {
            if (p.getPosition().equals(location)) {
                return p;
            }
        }
        LPlayer closest = getPlayers()[0];
        double distance = closest.getPosition().distance(location);
        for (LPlayer p : getPlayers()) {
            double pDist = p.getPosition().distance(location);
            if (pDist <= distance) {
                distance = pDist;
                closest = p;
            }
        }
        return closest;
    }

}
