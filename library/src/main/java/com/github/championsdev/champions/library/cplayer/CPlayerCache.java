/*
This file is part of Legends.

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library.cplayer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author B2OJustin
 */
public class CPlayerCache {
    private static int cacheSize = 20;
    private static LinkedHashMap<String, CPlayer> cacheMap = new LinkedHashMap<String, CPlayer>(cacheSize, 0.75f) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, CPlayer> eldest) {
            return size() > cacheSize;
        }
    };

    public static void setCacheSize(int cacheSize) {
        CPlayerCache.cacheSize = cacheSize;
    }

    public static void cachePlayer(String playerName, CPlayer player) {
        cacheMap.put(playerName, player);
    }

    public static void removePlayer(String playerName) {
        cacheMap.remove(playerName);
    }

    public static CPlayer getPlayer(String playerName) {
        return cacheMap.get(playerName);
    }
}
