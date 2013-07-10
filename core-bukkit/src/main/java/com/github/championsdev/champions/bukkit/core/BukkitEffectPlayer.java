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

package com.github.championsdev.champions.bukkit.core;

import com.github.championsdev.champions.bukkit.core.utils.LocationUtil;
import com.github.championsdev.champions.library.CLocation;
import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.effects.Effect;
import com.github.championsdev.champions.library.effects.EffectPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * @author YoshiGenius
 */
public class BukkitEffectPlayer extends EffectPlayer {

    @Override
    public boolean playEffect(CPlayer cp, CLocation loc, byte data, Effect effect) {
        Player p = Bukkit.getPlayerExact(cp.getName());
        if (p == null) return false;
        if (LocationUtil.toBukkitLoc(loc) == null) return false;
        switch (effect) {
            case CLICK2:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK2, data);
                break;
            case CLICK1:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case BOW_FIRE:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case DOOR_TOGGLE:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case EXTINGUISH:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case RECORD_PLAY:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case GHAST_SHRIEK:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case GHAST_SHOOT:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case BLAZE_SHOOT:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case ZOMBIE_CHEW_WOODEN_DOOR:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case ZOMBIE_CHEW_IRON_DOOR:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case ZOMBIE_DESTROY_DOOR:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case SMOKE:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case STEP_SOUND:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case POTION_BREAK:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case ENDER_SIGNAL:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case MOBSPAWNER_FLAMES:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
        }
        return true;
    }

    @Override
    public boolean playEffect(CPlayer cp, CLocation loc, Class<?> data, Effect effect) {
        Player p = Bukkit.getPlayerExact(cp.getName());
        if (p == null) return false;
        if (LocationUtil.toBukkitLoc(loc) == null) return false;
        switch (effect) {
            case CLICK2:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK2, data);
                break;
            case CLICK1:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case BOW_FIRE:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case DOOR_TOGGLE:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case EXTINGUISH:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case RECORD_PLAY:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case GHAST_SHRIEK:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case GHAST_SHOOT:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case BLAZE_SHOOT:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case ZOMBIE_CHEW_WOODEN_DOOR:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case ZOMBIE_CHEW_IRON_DOOR:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case ZOMBIE_DESTROY_DOOR:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case SMOKE:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case STEP_SOUND:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case POTION_BREAK:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case ENDER_SIGNAL:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
            case MOBSPAWNER_FLAMES:
                p.playEffect(LocationUtil.toBukkitLoc(loc), org.bukkit.Effect.CLICK1, data);
                break;
        }
        return true;
    }

}
