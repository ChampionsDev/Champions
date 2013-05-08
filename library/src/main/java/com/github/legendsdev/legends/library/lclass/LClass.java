package com.github.legendsdev.legends.library.lclass;

import com.github.legendsdev.legends.library.misc.Describable;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 */
public class LClass implements Describable<LClass> {
    private ArrayList<String> description = new ArrayList<>();
    private String name = "";

    public LClass() {
    }

    public LClass(String name, ArrayList<String> description) {
        this.name = name;
        this.description = description;
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