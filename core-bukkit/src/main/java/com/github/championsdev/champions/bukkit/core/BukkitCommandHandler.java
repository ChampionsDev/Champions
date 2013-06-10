package com.github.championsdev.champions.bukkit.core;

import com.github.championsdev.champions.library.commands.CommandHandler;
import com.github.championsdev.champions.library.commands.CommandResult;
import com.github.championsdev.champions.library.commands.SubCommand;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.cplayer.CPlayerHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author B2OJustin
 */
public class BukkitCommandHandler implements CommandExecutor {
    private CPlayerHandler playerHandler = CPlayerHandler.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) return false;
        CPlayer player = playerHandler.get(commandSender.getName());
        CommandResult result = CommandHandler.exec(player, command.getName(), args);
        switch(result) {
            case FAILURE:
                return false;
            case SUCCESS:
                return true;
            case NO_PERMISSION:
                player.sendMessage(ChatColor.RED + "Sorry, you don't have permission to use that command.");
                return false;
            case BAD_ARG:
                SubCommand cmd = CommandHandler.getSubCommand(command.getName());
                if(cmd == null) {
                    player.sendMessage(ChatColor.RED + "Invalid command.");
                } else {
                    player.sendMessage(cmd.getHelpText());
                }
                return false;
            default:
                return false;
        }
    }
}
