package net.dawnfirerealms.legends.library.lclass;

import net.dawnfirerealms.legends.library.misc.Describable;
import net.dawnfirerealms.legends.library.restriction.IDRestrictable;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 */
public class LClass implements IDRestrictable, Describable<LClass> {
    private ArrayList<String> description = new ArrayList<>();
    private String name = "";

    public LClass() {
    }

    public LClass(String name, ArrayList<String> description) {
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String getId() {
        return name;
    }

    @Override
    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LClass setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }
}