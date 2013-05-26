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

import com.github.championsdev.champions.library.BasicCategory;
import com.github.championsdev.champions.library.BasicHandler;
import com.github.championsdev.champions.library.database.DataManager;

/**
 * @author B2OJustin
 */
public class WeaponCategoryHandler extends BasicHandler<BasicCategory<WeaponAttributes>> {
    private static WeaponCategoryHandler instance = new WeaponCategoryHandler();

    public static WeaponCategoryHandler getInstance() {
        return instance;
    }

    public BasicCategory<WeaponAttributes> load(String id) {
        BasicCategory<WeaponAttributes> weaponCategory = super.get(id);
        if(weaponCategory == null) {
            weaponCategory = DataManager.getDataSource().loadWeaponCategory(id);
            if(weaponCategory != null) super.register(id, weaponCategory);
        }
        if(weaponCategory == null) {
            weaponCategory = new BasicCategory<>();
            super.register(id, weaponCategory);
        }
        return weaponCategory;
    }
}
