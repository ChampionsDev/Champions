package utils.util;

import com.github.championsdev.champions.library.cplayer.CPlayer;

import java.util.ArrayList;

/**
 * @author YoshiGenius
 *         Date: 31/05/13
 *         Time: 7:56 PM
 */
public abstract class Messenger {

    private static ArrayList<Messenger> messengers = new ArrayList<>();

    public static boolean registerSender(Messenger messenger) {
        return messengers.add(messenger);
    }

    public static boolean sendMessage(CPlayer cPlayer, String message) {
        if (messengers.isEmpty()) return false;
        for (Messenger m : messengers) {
            if (m.send(cPlayer, message)) return true;
        }
        return false;
    }

    public abstract boolean send(CPlayer cPlayer, String message);

}
