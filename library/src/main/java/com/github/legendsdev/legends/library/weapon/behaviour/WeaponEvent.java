package com.github.legendsdev.legends.library.weapon.behaviour;

import com.github.legendsdev.legends.library.event.LegendsEvent;
import com.github.legendsdev.legends.library.weapon.Weapon;

/**
 * @author YoshiGenius
 */
public class WeaponEvent extends LegendsEvent {
    private final Weapon weapon;
    
    public WeaponEvent(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public Weapon getWeapon() {
        return this.weapon;
    }

}
