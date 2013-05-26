package com.github.championsdev.champions.library.util;

/**
 * @author YoshiGenius
 *         Date: 26/05/13
 *         Time: 8:31 AM
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
