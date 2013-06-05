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

package com.github.championsdev.champions.library.util;

/**
 * @author YoshiGenius
 */
public class PlatformUtil {

    public static enum PlatformType {
        BUKKIT("bukkit"), CANARY("canary"), OTHER("other");
        private final String platformName;

        private PlatformType(String platformName) {
            this.platformName = platformName;
        }

        public String getName() {
            return this.platformName;
        }

    }

    public static PlatformUtil.PlatformType getCurrentPlatform() {
        try {
            Class.forName("org.bukkit.Bukkit");
            return PlatformType.BUKKIT;
        } catch (ClassNotFoundException ex) {}
        try {
            Class.forName("net.canarymod.Canary");
            return PlatformType.CANARY;
        } catch (ClassNotFoundException ex) {}
        return PlatformType.OTHER;
    }

}
