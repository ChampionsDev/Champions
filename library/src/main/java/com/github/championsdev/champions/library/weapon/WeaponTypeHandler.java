/*
This file is part of Champions.

    Champions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Champions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Champions.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.github.championsdev.champions.library.weapon;

import com.github.championsdev.champions.library.BasicHandler;
import com.github.championsdev.champions.library.database.DataManager;

/**
 * @author B2OJustin
 */
public class WeaponTypeHandler extends BasicHandler<WeaponType> {
    private static WeaponTypeHandler instance = new WeaponTypeHandler();

    public static WeaponTypeHandler getInstance() {
        return instance;
    }

    public WeaponType load(String id) {
        WeaponType weaponType = super.get(id);
        if(weaponType == null) {
            weaponType = DataManager.getDataSource().loadWeaponType(id);
            if(weaponType != null) super.register(id, weaponType);
        }
        if(weaponType == null) {
            weaponType = new WeaponType();
            super.register(id, weaponType);
        }
        return weaponType;
    }
}
