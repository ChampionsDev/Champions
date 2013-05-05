package net.dawnfirerealms.legends.library.level;

import net.dawnfirerealms.legends.library.BaseUser;

/**
 * @author YoshiGenius
 */
public interface ExpUser extends BaseUser {
    public Exp getExpPerLevel();
    public Level getMaxLevels();
    
}