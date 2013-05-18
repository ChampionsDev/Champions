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
package com.github.championsdev.champions.library.lplayer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author B2OJustin
 */
public class LPlayerCache {
    private static int cacheSize = 20;
    private static LinkedHashMap<String, LPlayer> cacheMap = new LinkedHashMap<String, LPlayer>(cacheSize, 0.75f) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, LPlayer> eldest) {
            return size() > cacheSize;
        }
    };

    public static void setCacheSize(int cacheSize) {
        LPlayerCache.cacheSize = cacheSize;
    }

    public static void cachePlayer(String playerName, LPlayer player) {
        cacheMap.put(playerName, player);
    }

    public static void removePlayer(String playerName) {
        cacheMap.remove(playerName);
    }

    public static LPlayer getPlayer(String playerName) {
        return cacheMap.get(playerName);
    }
}
