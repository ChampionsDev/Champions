package com.github.championsdev.champions.library;

import com.github.championsdev.champions.library.cplayer.CPlayer;

/**
 * @author YoshiGenius
 * @date 14/05/13
 * @time 6:02 PM
 */
public abstract class CWorld {

    public abstract CBlock getBlockAt(CLocation location);
    public CBlock getBlockAt(int x, int y, int z) {
        return getBlockAt(new CLocation(this, x, y, z));
    }
    public abstract String getName();
    public abstract CPlayer[] getPlayers();
    public CPlayer getPlayerNearest(CLocation location) {
        if (!location.getWorld().getName().equals(getName())) {
            return null;
        }
        for (CPlayer p : getPlayers()) {
            if (p.getPosition().equals(location)) {
                return p;
            }
        }
        CPlayer closest = getPlayers()[0];
        double distance = closest.getPosition().distance(location);
        for (CPlayer p : getPlayers()) {
            double pDist = p.getPosition().distance(location);
            if (pDist <= distance) {
                distance = pDist;
                closest = p;
            }
        }
        return closest;
    }

}
