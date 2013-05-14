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
package com.github.legendsdev.legends.library.lplayer;

import com.github.legendsdev.legends.library.BasicHandler;

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

    private static LPlayerCache instance = new LPlayerCache();

    public static LPlayerCache getInstance() {
        return instance;
    }

    public static LPlayerCache setCacheSize(int cacheSize) {
        LPlayerCache.cacheSize = cacheSize;
        return instance;
    }

    public static LPlayerCache cachePlayer(String playerName, LPlayer player) {
        cacheMap.put(playerName, player);
        return instance;
    }

    public static LPlayerCache removePlayer(String playerName) {
        cacheMap.remove(playerName);
        return instance;
    }

    public static LPlayer getPlayer(String playerName, LPlayer player) {
        return cacheMap.get(playerName);
    }
}
