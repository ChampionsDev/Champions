/*
This file is part of Legends.

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends.  If not, see <http://www.gnu.org/licenses/>.
*/

package net.dawnfirerealms.legends.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

/**
 * @author teunie-nl
 */
public class BedListener implements Listener{
    // TODO add config checks
    Plugin plugin;
    HashMap<String, Integer> scheduleMap;

    public BedListener(Plugin plugin) {
        this.plugin = plugin;
        scheduleMap = new HashMap<>();
    }
    
    @EventHandler(ignoreCancelled = false)
    public void onBedEnter(PlayerBedEnterEvent event){
        final Player player = event.getPlayer();
        if(player.isSleeping()){
            int task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
                @Override
                public void run() {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 1));
                }
            }, 0L, 20L);
            scheduleMap.put(player.getName(), task);
        }
    }
    
    @EventHandler(ignoreCancelled = false)
    public void onBedLeave(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        if(scheduleMap.containsKey(player.getName())){
            Bukkit.getScheduler().cancelTask(scheduleMap.get(player.getName()));
            scheduleMap.remove(player.getName());
        }else{
            plugin.getLogger().warning("Could not stop player regeneration!");
        }
    }
}
