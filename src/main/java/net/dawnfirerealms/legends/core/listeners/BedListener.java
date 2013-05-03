package net.dawnfirerealms.legends.core.listeners;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BedListener implements Listener{
    //Todo list for this class:
    //Add a configuration to look for
    //Set main with plugin
    YamlConfiguration config = new YamlConfiguration();
    plugin;
    ArrayList<String> players = new ArrayList<String>();
    HashMap<String, Integer> schedule = new HashMap<String, Integer>();
    int task;
    
    @EventHandler(ignoreCancelled = false)
        public void onBedEnter(PlayerBedEnterEvent event){
            final Player player = event.getPlayer();
                if(player.isSleeping()){
                if(config.getBoolean("messageonbedenter") == true){
                    player.sendMessage(ChatColor.RED + config.getString("bedentermessage"));
                }
                players.add(player.getName());
                task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
                    @Override
                    public void run() {
                        if(!schedule.containsKey(player.getName())){
                            schedule.put(player.getName(), task);
                        }
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, config.getInt("ampiflier")));
                    }
                }, 0L, 20L);
            }
    }
    
    @EventHandler(ignoreCancelled = false)
        public void onBedLeave(PlayerBedLeaveEvent event){
            Player player = event.getPlayer();
            if(players.contains(player.getName())){
                players.remove(player.getName());
            }
                if(schedule.containsKey(player.getName())){
                Bukkit.getScheduler().cancelTask(schedule.get(player.getName()));
                }else{
                    Bukkit.getScheduler().cancelTasks(plugin);
                }
                
                if(config.getBoolean("messageonbedleave") == true){
                    player.sendMessage(ChatColor.RED + config.getString("bedleavemessage"));
                }
            }
    }
