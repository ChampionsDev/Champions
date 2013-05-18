package com.github.championsdev.champions.library.event.weapon;

import com.github.championsdev.champions.library.event.cplayer.CPlayerEvent;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.weapon.Weapon;

/**
 * @author YoshiGenius
 */
public class WeaponEvent extends CPlayerEvent {
    private final Weapon weapon;

    public WeaponEvent(Weapon weapon, CPlayer player) {
        super(player);
        this.weapon = weapon;
    }
    
    public Weapon getWeapon() {
        return this.weapon;
    }

}
