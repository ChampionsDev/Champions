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

package com.github.championsdev.champions.library.messaging;

import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 */
public abstract class MessageHandler {

    private static ArrayList<Messenger> messengers = new ArrayList<>();

    public static boolean register(Messenger sender) {
        return messengers.add(sender);
    }

    public static boolean unregister(Messenger sender) {
        return messengers.remove(sender);
    }

    public static boolean sendMessage(CPlayer cPlayer, String message) {
        if (messengers.isEmpty()) return false;
        boolean handled = false;
        for (Messenger m : messengers) {
            if(m.send(cPlayer, message)) handled = true;
        }
        return handled;
    }
}
