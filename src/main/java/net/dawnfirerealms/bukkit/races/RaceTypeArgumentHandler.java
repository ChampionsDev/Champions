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

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import se.ranzdo.bukkit.methodcommand.ArgumentHandler;
import se.ranzdo.bukkit.methodcommand.ArgumentVariable;
import se.ranzdo.bukkit.methodcommand.CommandArgument;
import se.ranzdo.bukkit.methodcommand.CommandError;
import se.ranzdo.bukkit.methodcommand.TransformError;


public class RaceTypeArgumentHandler extends ArgumentHandler<RaceType> {

	public RaceTypeArgumentHandler(final RaceHandler handler) {
		addVariable("sender", "The commandsenders classtype", new ArgumentVariable<RaceType>() {
			public RaceType var(CommandSender sender, CommandArgument argument, String varName) throws CommandError {
				if(sender instanceof Player) {
					return handler.getRace((Player)sender).getType();
				}
				
				throw new CommandError(argument.getMessage("cant_as_console"));
			}
		});
	}

	@Override
	public RaceType transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
		try {
			return RaceType.valueOf(value.toUpperCase());
		}
		catch(IllegalArgumentException e) {
			throw new TransformError("Invalid classtype");
		}
	}

}
