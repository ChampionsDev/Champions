/*
This file is part of Legends.

    Legends is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Legends is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Legends.  If not, see <http://www.gnu.org/licenses/>.
*/
package net.dawnfirerealms.legends.library.weapon;

import java.util.HashMap;
import net.dawnfirerealms.legends.library.BasicHandler;
import net.dawnfirerealms.legends.library.Registrable;

/**
 * @author B2OJustin
 */
public class WeaponHandler extends BasicHandler {
    private static HashMap<String, Weapon> weaponMap = new HashMap<>();
    private static WeaponHandler instance = new WeaponHandler();
    
    public static WeaponHandler getInstance() {
        return instance;
    }
    
    @Override
    public void registerOption(String option, Registrable registerable) {
        if (registerable instanceof Weapon) {
            weaponMap.put(option, (Weapon) registerable);
        }
    }

    @Override
    public Weapon getOption(String option) {
        return weaponMap.get(option);
    }
}
