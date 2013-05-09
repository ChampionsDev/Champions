package com.github.legendsdev.legends.library.event.weapon;

import com.github.legendsdev.legends.library.weapon.Weapon;

/**
 * @author YoshiGenius
 */
public class WeaponClickEvent extends WeaponEvent {
    private ClickType clickType;

    public enum ClickType {
        LEFT_CLICK, RIGHT_CLICK
    }

    public WeaponClickEvent(Weapon weapon, ClickType clickType) {
        super(weapon);
        this.clickType = clickType;
    }

    public ClickType getClickType() {
        return clickType;
    }

}
