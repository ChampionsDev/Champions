package com.github.legendsdev.legends.library.event;

import com.github.legendsdev.legends.library.LPlayer;

/**
 * @author YoshiGenius
 */
public class LPlayerEvent extends LegendsEvent {
    private final LPlayer player;
    
    public LPlayerEvent(LPlayer player) {
        this.player = player;
    }
    
    public LPlayer getPlayer() {
        return this.player;
    }

}
