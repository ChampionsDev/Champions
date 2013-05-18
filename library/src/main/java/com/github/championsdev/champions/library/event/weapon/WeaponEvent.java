package com.github.championsdev.champions.library.event.weapon;

import com.github.championsdev.champions.library.event.lplayer.LPlayerEvent;
import com.github.championsdev.champions.library.lplayer.LPlayer;
import com.github.championsdev.champions.library.weapon.Weapon;

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
