package com.github.championsdev.champions.bukkit.core;

import com.github.championsdev.champions.bukkit.core.utils.LocationUtil;
import com.github.championsdev.champions.library.CBlock;
import com.github.championsdev.champions.library.CLocation;
import com.github.championsdev.champions.library.CWorld;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.cplayer.CPlayerHandler;
import com.github.championsdev.champions.library.server.Server;
import com.github.championsdev.champions.library.util.PlatformUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YoshiGenius
 *         Date: 12/06/13
 *         Time: 4:53 PM
 */
public class BukkitChampionsServer implements Server {

    @Override
    public String getServerVersion() {
        return Bukkit.getServer().getVersion();
    }

    @Override
    public String getChampionsCoreVersion() {
        return ChampionsCore.getInstance().getDescription().getVersion();
    }

    @Override
    public String getChampionsLibVersion() {
        return "0.0.1";
    }

    @Override
    public PlatformUtil.PlatformType getServerPlatform() {
        return PlatformUtil.PlatformType.BUKKIT;
    }

    @Override
    public CPlayer[] getOnlineCPlayers() {
        CPlayer[] players = new CPlayer[]{};
        for (Player p : Bukkit.getOnlinePlayers()) {
            CPlayer cPlayer = CPlayerHandler.getInstance().get(p.getName());
            if (cPlayer == null) {
                cPlayer = CPlayerHandler.getInstance().load(p.getName());
            }
            if (cPlayer != null) {
                players[players.length] = cPlayer;
            }
        }
        return players;
    }

    @Override
    public int getMaxCPlayers() {
        return Bukkit.getServer().getMaxPlayers();
    }

    @Override
    public CPlayer getCPlayer(String partialName) {
        if (partialName == null) return null;
        CPlayer exact = getCPlayerExact(partialName);
        if (exact != null) return exact;
        for (CPlayer p : getOnlineCPlayers()) {
            if (p.getName().contains(partialName)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public CPlayer getCPlayerExact(String exactName) {
        if (exactName == null) return null;
        for (CPlayer p : getOnlineCPlayers()) {
            if (p.getName().equalsIgnoreCase(exactName)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<CPlayer> matchCPlayer(String name) {
        if (name == null) return null;
        List<CPlayer> players = new ArrayList<>();
        CPlayer exact = getCPlayerExact(name);
        if (exact != null) {
            players.clear();
            players.add(exact);
            return players;
        }
        for (CPlayer p : getOnlineCPlayers()) {
            if (p.getName().contains(name)) {
                players.add(p);
            }
        }
        return players;
    }

    @Override
    public CWorld getCWorld(String name) {
        if (name == null) return null;
        for (CWorld world : getWorlds()) {
            if (world.getName().equalsIgnoreCase(name)) return world;
        }
        return null;
    }

    @Override
    public List<CWorld> getWorlds() {
        List<CWorld> worlds = new ArrayList<>();
        for (final World bWorld : Bukkit.getWorlds()) {
            CWorld world = new CWorld() {
                @Override
                public CBlock getBlockAt(CLocation location) {
                    Block b = bWorld.getBlockAt(LocationUtil.toBukkitLoc(location));
                    CBlock block = new CBlock(location, b.getTypeId(), b.getData());
                    return block;
                }

                @Override
                public String getName() {
                    return bWorld.getName();
                }

                @Override
                public CPlayer[] getPlayers() {
                    CPlayer[] players = new CPlayer[]{};
                    for (Player player : bWorld.getPlayers()) {
                        CPlayer cPlayer = getCPlayerExact(player.getName());
                        if (cPlayer != null) {
                            players[players.length] = cPlayer;
                        }
                    }
                    return players;
                }
            };
        }
        return worlds;
    }

    @Override
    public void broadcastMessage(String message) {
        if (message == null) return;
        Bukkit.broadcastMessage(message);
    }

    @Override
    public void broadcast(String message, String permission) {
        if (message == null || permission == null) return;
        Bukkit.broadcast(message, permission);
    }

    @Override
    public String getIp() {
        return Bukkit.getIp();
    }

    @Override
    public int getPort() {
        return Bukkit.getPort();
    }
}
