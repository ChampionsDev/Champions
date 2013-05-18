package com.github.championsdev.champions.library.event;

import com.github.championsdev.champions.library.cplayer.CPlayer;

/**
 * Base class for all CPlayer events
 *
 * @author YoshiGenius
 */
public class PlayerEvent extends ChampionsEvent {
    private final CPlayer player;
    
    public PlayerEvent(CPlayer player) {
        this.player = player;
    }
    
    public CPlayer getPlayer() {
        return this.player;
    }

}
