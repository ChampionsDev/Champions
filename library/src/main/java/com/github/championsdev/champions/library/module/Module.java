package com.github.championsdev.champions.library.module;

import java.io.File;

/**
 * @author YoshiGenius
 *         Date: 23/05/13
 *         Time: 6:57 PM
 */
public class Module {

    private File file;
    private boolean initialized;
    private ModuleDescriptionFile description;

    public Module() {
    }

    public String getName() {
        return this.getDescription().getName();
    }

    public ModuleDescriptionFile getDescription() {
        return this.description;
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    protected final void initialize(ModuleDescriptionFile description, File file) {
        if (!initialized) {
            this.initialized = true;
            this.file = file;
            this.description = description;
        }
    }

}
