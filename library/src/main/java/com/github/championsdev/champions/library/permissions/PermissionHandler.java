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

package com.github.championsdev.champions.library.permissions;

import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 */
public abstract class PermissionHandler {

    private static ArrayList<PermissionChecker> permissionCheckers = new ArrayList<>();

    public static boolean register(PermissionChecker checker) {
        return permissionCheckers.add(checker);
    }

    public static boolean hasPermission(CPlayer cPlayer, String permission) {
        if (cPlayer == null || permission == null) return false;
        if (permissionCheckers.isEmpty()) return false;
        for (PermissionChecker pc : permissionCheckers) {
            if (pc.hasPermission(cPlayer, permission)) return true;
        }
        return false;
    }
}
