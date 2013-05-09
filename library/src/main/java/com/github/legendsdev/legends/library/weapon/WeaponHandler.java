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
package com.github.legendsdev.legends.library.weapon;

import com.github.legendsdev.legends.library.BasicHandler;

/**
 * @author B2OJustin
 */
public class WeaponHandler extends BasicHandler<Weapon> {
    private static WeaponHandler instance = new WeaponHandler();
    
    public static WeaponHandler getInstance() {
        return instance;
    }

    // Allow new weapons to be registered automatically
    @Override
    public Weapon get(String id) {
        Weapon weapon = super.get(id);
        if(weapon == null) {
            weapon = new Weapon();
            register(id, weapon);
        }
        return weapon;
    }
}
