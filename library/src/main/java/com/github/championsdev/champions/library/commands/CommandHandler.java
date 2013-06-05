package com.github.championsdev.champions.library.commands;

import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author YoshiGenius
 *         Date: 31/05/13
 *         Time: 7:38 PM
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
