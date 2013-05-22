package com.github.championsdev.champions.library.event;

/**
 * The base class for all Champions events.
 *
 * @author YoshiGenius
 */
public class ChampionsEvent {
    private boolean isCancelled = false;

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public boolean isCancelled() {
        return isCancelled;
    }
}
