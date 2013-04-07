package net.dawnfirerealms.bukkit.races;

import net.dawnfirerealms.bukkit.utils.CField;
import net.dawnfirerealms.bukkit.utils.ConfigHandler;

import org.bukkit.entity.Player;

import com.mmiillkkaa.supernaturals.SuperNPlayer;

public abstract class Race {
	Player player;
	@CField RaceType type;
	RaceHandler handler;
	ConfigHandler configHandler;
	SuperNPlayer superNplayer;
	
	protected abstract void init();
	
	protected abstract void uninit();
	
	public final void save() {
		configHandler.saveInstance(RaceHandler.INSTANCE_PATH + player.getName(), this);
	}
	
	public final Player getPlayer() {
		return player;
	}
	
	public SuperNPlayer getSuperNplayer() {
		return superNplayer;
	}
	
	public final RaceType getType() {
		return type;
	}
}
