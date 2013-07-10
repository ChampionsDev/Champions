/*
 * ****************************************************************************
 *     This file is part of Champions.
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
 * ****************************************************************************
 */

package com.github.championsdev.champions.library.effects;

import com.github.championsdev.champions.library.BlockFace;
import com.github.championsdev.champions.library.CLocation;
import com.github.championsdev.champions.library.cplayer.CPlayer;

/**
 * @author YoshiGenius
 */
public abstract class EffectPlayer {

    public abstract boolean playEffect(CPlayer p, CLocation loc, byte data, Effect effect);
    public abstract boolean playSmokeEffect(CPlayer p, CLocation loc, BlockFace face);

}
