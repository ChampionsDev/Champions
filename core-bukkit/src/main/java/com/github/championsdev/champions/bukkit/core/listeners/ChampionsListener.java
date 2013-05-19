/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.bukkit.core.listeners;

import com.github.championsdev.champions.bukkit.core.ChampionsCore;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.cplayer.CPlayerHandler;
import com.github.championsdev.champions.library.event.BaseListener;
import com.github.championsdev.champions.library.event.EventManager;
import com.github.championsdev.champions.library.event.cplayer.*;
import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.level.exp.sources.MobKillExpSource;
import com.github.championsdev.champions.library.level.exp.sources.PlayerKillExpSource;
import com.github.championsdev.champions.library.weapon.Weapon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author B2OJustin
 */
public class ChampionsListener implements Listener {

    public ChampionsListener() {
        EventManager.registerEvents(new BaseListener());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        CPlayer player = CPlayerHandler.getInstance().load(event.getPlayer().getName());
        EventManager.callEvent(new CPlayerJoinEvent(player));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        CPlayer cPlayer = CPlayerHandler.getInstance().load(event.getPlayer().getName());
        EventManager.callEvent(new CPlayerQuitEvent(cPlayer));
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        CPlayer player = CPlayerHandler.getInstance().get(event.getPlayer().getName());
        Weapon playerWeapon = player.getWeapon();
        if(playerWeapon != null) {
            WeaponClickEvent lEvent;
            if(event.getAction() == Action.LEFT_CLICK_AIR | event.getAction() == Action.LEFT_CLICK_BLOCK) {
                lEvent = new WeaponClickEvent(playerWeapon, player, WeaponClickEvent.ClickType.LEFT_CLICK);
            }
            else if(event.getAction() == Action.RIGHT_CLICK_AIR | event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                lEvent = new WeaponClickEvent(playerWeapon, player, WeaponClickEvent.ClickType.RIGHT_CLICK);
            }
            else return;
            EventManager.callEvent(lEvent);
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        CPlayer player = CPlayerHandler.getInstance().get(event.getEntity().getKiller().getName());
        if(player != null) {
            if(event.getEntity() instanceof Player) {
                CPlayer deadPlayer = CPlayerHandler.getInstance().load(((Player) event.getEntity()).getName());
                EventManager.callEvent(new CPlayerKillEvent(player, deadPlayer));
            }
            else {
                EventManager.callEvent(new CPlayerMobKillEvent(player, event.getEntity().getType().name()));
            }
        }
    }

}
