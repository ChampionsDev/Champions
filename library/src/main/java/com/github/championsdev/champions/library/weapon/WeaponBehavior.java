package com.github.championsdev.champions.library.weapon;

import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponHitEvent;

/**
 * @author YoshiGenius
 */
public interface WeaponBehavior {
    public void onClick(WeaponClickEvent event);
    public void onHit(WeaponHitEvent event);
}
