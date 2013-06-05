package com.github.championsdev.champions.library.commands;

import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.util.PermissionChecker;

/**
 * @author YoshiGenius
 *         Date: 31/05/13
 *         Time: 7:39 PM
 */
public abstract class SubCommand {

    private String firstArg;

    public SubCommand(String firstArg) {
        this.firstArg = firstArg;
        if (!CommandHandler.isRegistered(this)) {
            CommandHandler.registerSubCommand(this);
        }
    }

    public String getFirstArg() {
        return this.firstArg;
    }

    public abstract String getHelpText();

    public abstract boolean exec(CPlayer sender, String[] args);

    public boolean hasPermission(CPlayer sender) {
        String permission = "champions.cmd." + getFirstArg();
        return PermissionChecker.checkPermission(sender, permission);
    }

}
