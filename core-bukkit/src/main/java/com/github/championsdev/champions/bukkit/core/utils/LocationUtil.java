package com.github.championsdev.champions.bukkit.core.utils;

import com.github.championsdev.champions.library.CLocation;
import com.github.championsdev.champions.library.server.ServerHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * @author YoshiGenius
 *         Date: 12/06/13
 *         Time: 5:07 PM
 */
public class LocationUtil {

    public static CLocation toChampionsLoc(Location location) {
        CLocation loc = new CLocation(ServerHandler.getServer().getCWorld(location.getWorld().getName()), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        return loc;
    }

    public static Location toBukkitLoc(CLocation location) {
        Location loc = new Location(Bukkit.getWorld(location.getWorld().getName()), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        return loc;
    }
}
