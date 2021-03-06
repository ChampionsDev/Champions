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

package com.github.championsdev.champions.bukkit.core;

import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.messaging.Messenger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author B2OJustin
 */
public class BukkitMessenger implements Messenger {
    private JavaPlugin plugin;

    public BukkitMessenger(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean send(CPlayer cPlayer, String message) {
        plugin.getServer().getPlayerExact(cPlayer.getName()).sendMessage(message);
        return true;
    }

}
