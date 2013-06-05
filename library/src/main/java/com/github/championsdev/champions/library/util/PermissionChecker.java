/*******************************************************************************
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
 ******************************************************************************/

package com.github.championsdev.champions.library.util;

import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;

/**
 * @author YoshiGenius
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
