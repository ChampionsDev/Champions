package com.github.championsdev.champions.library.event.weapon;

import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.event.Cancellable;
import com.github.championsdev.champions.library.weapon.Weapon;

/**
 * @author YoshiGenius
 */
public class WeaponClickEvent extends WeaponEvent implements Cancellable {
    private ClickType clickType;

    public enum ClickType {
        LEFT_CLICK, RIGHT_CLICK
    }

    public WeaponClickEvent(Weapon weapon, CPlayer player, ClickType clickType) {
        super(weapon, player);
        this.clickType = clickType;
    }

    public ClickType getClickType() {
        return clickType;
    }

    private boolean isCancelled = false;

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

}
