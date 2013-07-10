/*******************************************************************************
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
 ******************************************************************************/

package com.github.championsdev.champions.library.module;

import com.github.championsdev.champions.library.misc.Descriptor;
import com.github.championsdev.champions.library.server.ServerBridge;
import com.github.championsdev.champions.library.server.ServerHandler;

import java.io.File;

/**
 * @author YoshiGenius
 */
public abstract class Module {
    protected File file;
    protected Descriptor descriptor;

    public abstract void onEnable();
    public abstract void onDisable();

    public String getName() {
        return this.getDescriptor().getName();
    }

    public Descriptor getDescriptor() {
        return this.descriptor;
    }

    protected void init(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public String[] getSupportedPlatforms() {
        return this.descriptor.getPlatforms();
    }

    public ServerBridge getServer() {
        return ServerHandler.getServerBridge();
    }

    public boolean isEnabled() {
        return ModuleLoader.isEnabled(this);
    }



}
