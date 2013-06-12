/*******************************************************************************
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
 ******************************************************************************/

package com.github.championsdev.champions.library.server;

import com.github.championsdev.champions.library.CWorld;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.util.PlatformUtil;

import java.util.List;

/**
 * @author YoshiGenius
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

    public void broadcastMessage(String message);

    public void broadcast(String message, String permission);

    public String getIp();

    public int getPort();

}
