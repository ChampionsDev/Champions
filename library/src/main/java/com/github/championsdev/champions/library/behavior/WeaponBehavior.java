package com.github.championsdev.champions.library.behavior;

import com.github.championsdev.champions.library.event.weapon.WeaponClickEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponEvent;
import com.github.championsdev.champions.library.event.weapon.WeaponHitEvent;

/**
 * @author YoshiGenius
 */
public interface WeaponBehavior extends Behavior {
    public void onClick(WeaponClickEvent event);
    public void onHit(WeaponHitEvent event);
    public void onSelect(WeaponEvent event);
}
