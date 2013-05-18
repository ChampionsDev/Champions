package com.github.championsdev.champions.canary.core;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.HookHandler;
import net.canarymod.plugin.PluginListener;

/**
 * @author YoshiGenius
 */
public class LegendsMainListener implements PluginListener {

    private final LegendsCore core;
    
    public LegendsMainListener(LegendsCore core) {
        this.core = core;
    }
    
    public LegendsCore getCore() {
        return this.core;
    }
    
    @HookHandler
    public void onJoin(net.canarymod.hook.player.ConnectionHook hook) {
        Player p = hook.getPlayer();
        LPlayer lp = LPlayerManager.get(p.getName());
    }

}
