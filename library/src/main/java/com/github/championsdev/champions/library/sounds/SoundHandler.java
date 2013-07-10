/*******************************************************************************
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
 ******************************************************************************/

package com.github.championsdev.champions.library.sounds;

import com.github.championsdev.champions.library.CLocation;
import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 */
public class SoundHandler {

    private static final ArrayList<SoundPlayer> players = new ArrayList<SoundPlayer>();

    private SoundHandler(){}

    public static boolean addSoundPlayer(SoundPlayer player) {
        return players.add(player);
    }

    public static boolean playSound(CPlayer p, CLocation loc, Sound sound) {
        for (SoundPlayer player : players) {
            if (player.playSound(p, loc, sound)) return true;
        }
        return false;
    }

}
