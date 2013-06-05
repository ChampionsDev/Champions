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
