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

package com.github.championsdev.champions.library.util;

import com.github.championsdev.champions.library.CLocation;

/**
 * @author YoshiGenius
 */
public class DistanceUtil {

    public static double distance(CLocation one, CLocation two) {
        return one.distance(two);
    }

    public static boolean isInRadius(CLocation one, CLocation two, double radius) {
        return (distance(one, two) <= radius);
    }

}
