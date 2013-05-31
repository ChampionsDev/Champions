package utils.util;

import com.github.championsdev.champions.library.CLocation;

/**
 * @author YoshiGenius
 *         Date: 26/05/13
 *         Time: 8:37 AM
 */
public class DistanceUtil {

    public static double distance(CLocation one, CLocation two) {
        return one.distance(two);
    }

    public static boolean isInRadius(CLocation one, CLocation two, double radius) {
        return (distance(one, two) <= radius);
    }

}
