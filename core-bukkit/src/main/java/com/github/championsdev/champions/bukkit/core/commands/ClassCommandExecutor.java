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
package com.github.championsdev.champions.bukkit.core.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.github.championsdev.champions.library.cclass.CClass;
import com.github.championsdev.champions.library.cclass.CClassHandler;

/**
 * @author B2OJustin
 */
public class ClassCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] params) {
        if(!command.getName().equalsIgnoreCase("class") || params.length == 0)
            return false;

        switch(params[0].toLowerCase()) {
        case "info": {
            if(params.length < 2)
                return false;

            CClass cClass = CClassHandler.getInstance().load(params[1]);
            if(cClass != null) {
                ArrayList<String> description = cClass.getDescription();
                commandSender.sendMessage(description.toArray(new String[description.size()]));
            } else
                commandSender.sendMessage("Sorry, we don't have any class named '" + params[1] + "'");
            break;
        }
        }

        return true;
    }

}
