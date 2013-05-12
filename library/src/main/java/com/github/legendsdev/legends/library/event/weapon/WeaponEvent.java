package com.github.legendsdev.legends.library.event.weapon;

import com.github.legendsdev.legends.library.event.LegendsEvent;
import com.github.legendsdev.legends.library.event.lplayer.LPlayerEvent;
import com.github.legendsdev.legends.library.lplayer.LPlayer;
import com.github.legendsdev.legends.library.weapon.Weapon;

/**
 * @author YoshiGenius
 */
public class WeaponEvent extends LPlayerEvent {
    private final Weapon weapon;

    public WeaponEvent(Weapon weapon, LPlayer player) {
        super(player);
        this.weapon = weapon;
    }
    
    public Weapon getWeapon() {
        return this.weapon;
    }

}
