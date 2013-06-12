package com.github.championsdev.champions.library.cplayer;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 *         Date: 11/06/13
 *         Time: 7:17 PM
 */
public class CPlayerOnlineHandler {

    private static final ArrayList<CPlayerOnlineChecker> checkers = new ArrayList<>();

    public static boolean register(CPlayerOnlineChecker checker) {
        return checkers.add(checker);
    }

    public static boolean isOnline(CPlayer cPlayer) {
        if (cPlayer == null || cPlayer.getName() == null) return false;
        if (checkers.isEmpty()) return false;
        for (CPlayerOnlineChecker checker : checkers) {
            if (checker.isOnline(cPlayer)) return true;
        }
        return false;
    }

}
