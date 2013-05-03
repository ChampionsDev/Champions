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
