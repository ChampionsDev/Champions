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

package com.github.championsdev.champions.library.commands;

import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author YoshiGenius
 */
public class CommandHandler {

    public static enum CommandResult {
        BAD_ARG, SUCCESS, NO_PERMISSION, FAILURE;
    }

    private static CommandHandler instance = new CommandHandler();
    private CommandHandler(){};

    private static String commandName = "champ";

    public static String getCommandName() {return commandName;}

    private static HashMap<String, SubCommand> subCommands = new HashMap<>();

    protected static boolean registerSubCommand(SubCommand cmd) {
        if (subCommands.containsKey(cmd.getFirstArg())) {
            return false;
        }
        subCommands.put(cmd.getFirstArg(), cmd);
        return true;
    }

    protected static boolean isRegistered(SubCommand cmd) {
        if (subCommands.containsKey(cmd.getFirstArg())) return true;
        return false;
    }

    public static CommandHandler.CommandResult exec(CPlayer cPlayer, String commandName, String[] arg) {
        String firstArg = arg[0].toLowerCase();
        if (firstArg.equalsIgnoreCase("help")) {
            help(cPlayer);
            return CommandResult.SUCCESS;
        }
        if (subCommands.containsKey(firstArg)) {
            SubCommand cmd = subCommands.get(firstArg);
            if (cmd.hasPermission(cPlayer)) {
                if (cmd.exec(cPlayer, arg)) {
                    return CommandResult.SUCCESS;
                }  else {
                    return CommandResult.FAILURE;
                }
            } else {
                return CommandResult.NO_PERMISSION;
            }
        } else {
            return CommandResult.BAD_ARG;
        }
    }

    private static void help(CPlayer cPlayer) {
        ArrayList<String> help = new ArrayList<>();
        for (String cmdName : subCommands.keySet()) {
            SubCommand cmd = subCommands.get(cmdName);
            if (cmd.getHelpText() != null) {
                help.add(cmd.getHelpText());
            }
        }
    }

}
