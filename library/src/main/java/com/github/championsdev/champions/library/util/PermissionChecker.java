package com.github.championsdev.champions.library.util;

import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 *         Date: 1/06/13
 *         Time: 7:38 AM
 */
public abstract class PermissionChecker {

    private static ArrayList<PermissionChecker> permissionCheckers = new ArrayList<>();

    public static boolean registerChecker(PermissionChecker checker) {
        return permissionCheckers.add(checker);
    }

    public static boolean checkPermission(CPlayer cPlayer, String permission) {
        if (permissionCheckers.isEmpty()) return false;
        for (PermissionChecker pc : permissionCheckers) {
            if (pc.check(cPlayer, permission)) return true;
        }
        return false;
    }

    public abstract boolean check(CPlayer cPlayer, String permission);
}
