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

package com.github.championsdev.champions.library.party;

import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YoshiGenius
 */
public class GroupHandler {

    private static List<GroupChecker> checkers = new ArrayList<GroupChecker>();

    public static boolean inSameGroup(CPlayer player1, CPlayer player2) {
        if (player1 == null || player2 == null) return false;
        if (player1.getParty() == null || player2.getParty() == null) return false;
        if (player1.getParty().getMembers().contains(player2)) {
            return true;
        } else {
            if (checkers == null) return false;
            for (GroupChecker checker : checkers) {
                if (checker.inSameGroup(player1, player2)) return true;
            }
        }
        return false;
    }

    protected static void register(GroupChecker groupChecker) {
        if (!checkers.contains(groupChecker)) {
            checkers.add(groupChecker);
        }
    }
}
