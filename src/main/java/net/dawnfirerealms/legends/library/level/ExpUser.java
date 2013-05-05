package net.dawnfirerealms.legends.library.level;

import net.dawnfirerealms.legends.library.BaseUser;
import net.dawnfirerealms.legends.library.restriction.Restrictions;

/**
 * @author YoshiGenius
 */
public interface ExpUser extends BaseUser {
    public Restrictions<Exp> getMaxExpPerLevel();
    public Restrictions<Level> getMaxLevels();
    
}