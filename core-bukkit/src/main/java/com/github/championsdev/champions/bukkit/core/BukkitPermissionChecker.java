package com.github.championsdev.champions.bukkit.core;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.permissions.PermissionChecker;

/**
 * @author B2OJustin
 */
public class BukkitPermissionChecker implements PermissionChecker {
    private JavaPlugin plugin;

    public BukkitPermissionChecker(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean hasPermission(CPlayer cPlayer, String permission) {
        return plugin.getServer().getPlayerExact(cPlayer.getName()).hasPermission(permission);
    }

}
