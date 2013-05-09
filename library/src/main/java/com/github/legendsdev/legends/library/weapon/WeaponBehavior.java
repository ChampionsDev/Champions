package com.github.legendsdev.legends.library.weapon;

import com.github.legendsdev.legends.library.event.weapon.WeaponClickEvent;
import com.github.legendsdev.legends.library.event.weapon.WeaponHitEvent;

/**
 * @author YoshiGenius
 */
public interface WeaponBehavior {
    public void onClick(WeaponClickEvent event);
    public void onHit(WeaponHitEvent event);
}
