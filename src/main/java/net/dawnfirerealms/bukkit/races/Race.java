/*
This file is part of DawnFire-Realms.

    DawnFire-Realms is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    DawnFire-Realms is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with DawnFire-Realms.  If not, see <http://www.gnu.org/licenses/>.
*/

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
