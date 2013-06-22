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

package com.github.championsdev.champions.library.server;

/**
 * @author YoshiGenius
 */
public class ServerHandler {

    private static ServerBridge serverBridge;

    public static ServerBridge getServerBridge() {
        return serverBridge;
    }

    public static boolean setServerBridge(ServerBridge serverBridge) {
        if (ServerHandler.serverBridge == null && serverBridge != null) {
            ServerHandler.serverBridge = serverBridge;
            serverBridge.init();
            return true;
        }
        return false;
    }

}
