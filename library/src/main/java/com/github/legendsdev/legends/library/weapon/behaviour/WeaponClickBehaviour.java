package com.github.legendsdev.legends.library.weapon.behaviour;

/**
 * @author YoshiGenius
 */
public abstract class WeaponClickBehaviour {

    public abstract boolean onLeftClick(WeaponLeftClickEvent event);
    
    public abstract boolean onRightClick(WeaponRightClickEvent event);

}
