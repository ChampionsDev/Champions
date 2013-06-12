package com.github.championsdev.champions.library.server;

import com.github.championsdev.champions.library.CEntity;
import com.github.championsdev.champions.library.CWorld;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.util.PlatformUtil;

import java.net.InetAddress;
import java.util.List;

/**
 * @author YoshiGenius
 *         Date: 12/06/13
 *         Time: 4:28 PM
 */
public interface Server {

    public String getServerVersion();

    public String getChampionsCoreVersion();

    public String getChampionsLibVersion();

    public PlatformUtil.PlatformType getServerPlatform();

    public CPlayer[] getOnlineCPlayers();

    public int getMaxCPlayers();

    public CPlayer getCPlayer(String partialName);

    public CPlayer getCPlayerExact(String exactName);

    public List<CPlayer> matchCPlayer(String name);

    public CWorld getCWorld(String name);

    public List<CWorld> getWorlds();

    public void broadcast(String message);

    public void broadcast(String message, String permission);

    public InetAddress getIp();

    public int getPort();

}
