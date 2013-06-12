package com.github.championsdev.champions.library.server;

/**
 * @author YoshiGenius
 *         Date: 12/06/13
 *         Time: 4:29 PM
 */
public class ServerHandler {

    private static Server server;

    public static Server getServer() {
        return server;
    }

    public static boolean setServer(Server server) {
        if (ServerHandler.server == null && server != null) {
            ServerHandler.server = server;
            return true;
        }
        return false;
    }

}
