package com.github.championsdev.champions.library.event;

/**
 * @author YoshiGenius
 *         Date: 27/05/13
 *         Time: 4:19 PM
 */
public interface Cancellable {

    public void setCancelled(boolean isCancelled);

    public boolean isCancelled();
}
