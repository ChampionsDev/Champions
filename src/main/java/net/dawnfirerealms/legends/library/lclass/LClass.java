package net.dawnfirerealms.legends.library.lclass;

import net.dawnfirerealms.legends.library.restriction.IDRestrictable;

/**
 * @author YoshiGenius
 */
public class LClass implements IDRestrictable {
    
    private String name;

    public LClass(String name) {
        this.name = name;
    }
    
    @Override
    public String getId() {
        return this.name;
    }

}