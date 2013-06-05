/*
 * This file is part of Champions.
 *
 *     Champions is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Champions is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Champions.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.championsdev.champions.library.module;

import java.io.File;

/**
 * @author YoshiGenius
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

    public String[] getSupportedPlatforms() {
        return this.description.getPlatforms();
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
