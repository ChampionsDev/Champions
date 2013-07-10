/*
 * ****************************************************************************
 *     This file is part of Champions.
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
 * ****************************************************************************
 */

package com.github.championsdev.champions.library.effects;

import com.github.championsdev.champions.library.CLocation;
import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 */
public class EffectHandler {

    private static ArrayList<EffectPlayer> players = new ArrayList<EffectPlayer>();

    private EffectHandler(){}

    public static boolean addEffectPlayer(EffectPlayer player) {
        return players.add(player);
    }

    public static boolean playEffect(CPlayer p, CLocation loc, byte data, Effect e) {
        for (EffectPlayer player : players) {
            if (player.playEffect(p, loc, data, e)) return true;
        }
        return false;
    }

    public static boolean playEffect(CPlayer p, CLocation loc, Class<?> data, Effect e) {
        for (EffectPlayer player : players) {
            if (player.playEffect(p, loc, data, e)) return true;
        }
        return false;
    }

}
