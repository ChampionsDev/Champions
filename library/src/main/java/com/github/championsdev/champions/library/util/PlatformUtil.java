package com.github.championsdev.champions.library.util;

/**
 * @author YoshiGenius
 *         Date: 26/05/13
 *         Time: 8:31 AM
 */
public class PlatformUtil {

    public static enum Platform {
        BUKKIT, CANARY, OTHER;
    }

    public static PlatformUtil.Platform getCurrentPlatform() {
        try {
            Class.forName("org.bukkit.Bukkit");
            return Platform.BUKKIT;
        } catch (ClassNotFoundException ex) {}
        try {
            Class.forName("net.canarymod.Canary");
            return Platform.CANARY;
        } catch (ClassNotFoundException ex) {}
        return Platform.OTHER;
    }

}
