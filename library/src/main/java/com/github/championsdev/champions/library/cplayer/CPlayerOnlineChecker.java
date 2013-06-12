package com.github.championsdev.champions.library.cplayer;

/**
 * @author YoshiGenius
 *         Date: 11/06/13
 *         Time: 7:18 PM
 */
public abstract class CPlayerOnlineChecker {

    public abstract boolean isOnline(String cPlayer);

    public boolean isOnline(CPlayer cPlayer) {
        if (cPlayer == null || cPlayer.getName() == null) return false;
        return isOnline(cPlayer.getName());
    }

}
