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

package com.github.championsdev.champions.canary.core;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.HookHandler;
import net.canarymod.plugin.PluginListener;

/**
 * @author YoshiGenius
 */
public class ChampionsMainListener implements PluginListener {

    private final ChampionsCore core;
    
    public ChampionsMainListener(ChampionsCore core) {
        this.core = core;
    }
    
    public ChampionsCore getCore() {
        return this.core;
    }
    
    @HookHandler
    public void onJoin(net.canarymod.hook.player.ConnectionHook hook) {
        Player p = hook.getPlayer();
        LPlayer lp = LPlayerManager.get(p.getName());
    }

}
