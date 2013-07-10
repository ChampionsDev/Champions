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
import com.github.championsdev.champions.library.sounds.Sound;
import com.github.championsdev.champions.library.sounds.SoundPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * @author YoshiGenius
 */
public class BukkitSoundPlayer extends SoundPlayer {

    @Override
    public boolean playSound(CPlayer cp, CLocation loc, float volume, float pitch, Sound sound) {
        Player p = Bukkit.getPlayerExact(cp.getName());
        if (p == null) return false;
        if (LocationUtil.toBukkitLoc(loc) == null) return false;
        switch (sound) {
            case AMBIENCE_CAVE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.AMBIENCE_CAVE, volume, pitch);
                break;
            case AMBIENCE_RAIN:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.AMBIENCE_RAIN, volume, pitch);
                break;
            case AMBIENCE_THUNDER:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.AMBIENCE_THUNDER, volume, pitch);
                break;
            case ANVIL_BREAK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ANVIL_BREAK, volume, pitch);
                break;
            case ANVIL_LAND:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ANVIL_LAND, volume, pitch);
                break;
            case ANVIL_USE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ANVIL_USE, volume, pitch);
                break;
            case ARROW_HIT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ARROW_HIT, volume, pitch);
                break;
            case BREATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BREATH, volume, pitch);
                break;
            case BURP:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BURP, volume, pitch);
                break;
            case CHEST_CLOSE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CHEST_CLOSE, volume, pitch);
                break;
            case CHEST_OPEN:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CHEST_OPEN, volume, pitch);
                break;
            case CLICK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CLICK, volume, pitch);
                break;
            case DOOR_CLOSE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DOOR_CLOSE, volume, pitch);
                break;
            case DOOR_OPEN:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DOOR_OPEN, volume, pitch);
                break;
            case DRINK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DRINK, volume, pitch);
                break;
            case EAT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.EAT, volume, pitch);
                break;
            case EXPLODE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.EXPLODE, volume, pitch);
                break;
            case FALL_BIG:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.FALL_BIG, volume, pitch);
                break;
            case FALL_SMALL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.FALL_SMALL, volume, pitch);
                break;
            case FIRE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.FIRE, volume, pitch);
                break;
            case FIRE_IGNITE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.FIRE_IGNITE, volume, pitch);
                break;
            case FIZZ:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.FIZZ, volume, pitch);
                break;
            case FUSE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.FUSE, volume, pitch);
                break;
            case GLASS:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.GLASS, volume, pitch);
                break;
            case HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.HURT, volume, pitch);
                break;
            case HURT_FLESH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.HURT_FLESH, volume, pitch);
                break;
            case ITEM_BREAK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ITEM_BREAK, volume, pitch);
                break;
            case ITEM_PICKUP:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ITEM_PICKUP, volume, pitch);
                break;
            case LAVA:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.LAVA, volume, pitch);
                break;
            case LAVA_POP:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.LAVA_POP, volume, pitch);
                break;
            case LEVEL_UP:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.LEVEL_UP, volume, pitch);
                break;
            case MINECART_BASE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.MINECART_BASE, volume, pitch);
                break;
            case MINECART_INSIDE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.MINECART_INSIDE, volume, pitch);
                break;
            case NOTE_BASS:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.NOTE_BASS, volume, pitch);
                break;
            case NOTE_PIANO:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.NOTE_PIANO, volume, pitch);
                break;
            case NOTE_BASS_DRUM:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.NOTE_BASS_DRUM, volume, pitch);
                break;
            case NOTE_STICKS:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.NOTE_STICKS, volume, pitch);
                break;
            case NOTE_BASS_GUITAR:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.NOTE_BASS_GUITAR, volume, pitch);
                break;
            case NOTE_SNARE_DRUM:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.NOTE_SNARE_DRUM, volume, pitch);
                break;
            case NOTE_PLING:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.NOTE_PLING, volume, pitch);
                break;
            case ORB_PICKUP:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ORB_PICKUP, volume, pitch);
                break;
            case PISTON_EXTEND:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.PISTON_EXTEND, volume, pitch);
                break;
            case PISTON_RETRACT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.PISTON_RETRACT, volume, pitch);
                break;
            case PORTAL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.PORTAL, volume, pitch);
                break;
            case PORTAL_TRAVEL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.PORTAL_TRAVEL, volume, pitch);
                break;
            case PORTAL_TRIGGER:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.PORTAL_TRIGGER, volume, pitch);
                break;
            case SHOOT_ARROW:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SHOOT_ARROW, volume, pitch);
                break;
            case SPLASH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SPLASH, volume, pitch);
                break;
            case SPLASH2:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SPLASH2, volume, pitch);
                break;
            case STEP_GRASS:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.STEP_GRASS, volume, pitch);
                break;
            case STEP_GRAVEL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.STEP_GRAVEL, volume, pitch);
                break;
            case STEP_LADDER:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.STEP_LADDER, volume, pitch);
                break;
            case STEP_SAND:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.STEP_SAND, volume, pitch);
                break;
            case STEP_SNOW:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.STEP_SNOW, volume, pitch);
                break;
            case STEP_STONE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.STEP_STONE, volume, pitch);
                break;
            case STEP_WOOD:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.STEP_WOOD, volume, pitch);
                break;
            case STEP_WOOL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.STEP_WOOL, volume, pitch);
                break;
            case SWIM:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SWIM, volume, pitch);
                break;
            case WATER:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WATER, volume, pitch);
                break;
            case WOOD_CLICK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOOD_CLICK, volume, pitch);
                break;
            case BAT_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BAT_DEATH, volume, pitch);
                break;
            case BAT_HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BAT_HURT, volume, pitch);
                break;
            case BAT_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BAT_IDLE, volume, pitch);
                break;
            case BAT_LOOP:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BAT_LOOP, volume, pitch);
                break;
            case BAT_TAKEOFF:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BAT_TAKEOFF, volume, pitch);
                break;
            case BLAZE_BREATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BLAZE_BREATH, volume, pitch);
                break;
            case BLAZE_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BLAZE_DEATH, volume, pitch);
                break;
            case BLAZE_HIT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.BLAZE_HIT, volume, pitch);
                break;
            case CAT_HISS:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CAT_HISS, volume, pitch);
                break;
            case CAT_HIT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CAT_HIT, volume, pitch);
                break;
            case CAT_MEOW:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CAT_MEOW, volume, pitch);
                break;
            case CAT_PURR:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CAT_PURR, volume, pitch);
                break;
            case CAT_PURREOW:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CAT_PURREOW, volume, pitch);
                break;
            case CHICKEN_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CHICKEN_IDLE, volume, pitch);
                break;
            case CHICKEN_HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CHICKEN_HURT, volume, pitch);
                break;
            case CHICKEN_EGG_POP:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CHICKEN_EGG_POP, volume, pitch);
                break;
            case CHICKEN_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CHICKEN_WALK, volume, pitch);
                break;
            case COW_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.COW_IDLE, volume, pitch);
                break;
            case COW_HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.COW_HURT, volume, pitch);
                break;
            case COW_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.COW_WALK, volume, pitch);
                break;
            case CREEPER_HISS:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CREEPER_HISS, volume, pitch);
                break;
            case CREEPER_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.CREEPER_DEATH, volume, pitch);
                break;
            case ENDERDRAGON_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERDRAGON_DEATH, volume, pitch);
                break;
            case ENDERDRAGON_GROWL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERDRAGON_GROWL, volume, pitch);
                break;
            case ENDERDRAGON_HIT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERDRAGON_HIT, volume, pitch);
                break;
            case ENDERDRAGON_WINGS:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERDRAGON_WINGS, volume, pitch);
                break;
            case ENDERMAN_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERMAN_DEATH, volume, pitch);
                break;
            case ENDERMAN_HIT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERMAN_HIT, volume, pitch);
                break;
            case ENDERMAN_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERMAN_IDLE, volume, pitch);
                break;
            case ENDERMAN_TELEPORT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERMAN_TELEPORT, volume, pitch);
                break;
            case ENDERMAN_SCREAM:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERMAN_SCREAM, volume, pitch);
                break;
            case ENDERMAN_STARE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ENDERMAN_STARE, volume, pitch);
                break;
            case GHAST_SCREAM:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.GHAST_SCREAM, volume, pitch);
                break;
            case GHAST_SCREAM2:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.GHAST_SCREAM2, volume, pitch);
                break;
            case GHAST_CHARGE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.GHAST_CHARGE, volume, pitch);
                break;
            case GHAST_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.GHAST_DEATH, volume, pitch);
                break;
            case GHAST_FIREBALL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.GHAST_FIREBALL, volume, pitch);
                break;
            case GHAST_MOAN:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.GHAST_MOAN, volume, pitch);
                break;
            case IRONGOLEM_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.IRONGOLEM_DEATH, volume, pitch);
                break;
            case IRONGOLEM_HIT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.IRONGOLEM_HIT, volume, pitch);
                break;
            case IRONGOLEM_THROW:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.IRONGOLEM_THROW, volume, pitch);
                break;
            case IRONGOLEM_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.IRONGOLEM_WALK, volume, pitch);
                break;
            case MAGMACUBE_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.MAGMACUBE_WALK, volume, pitch);
                break;
            case MAGMACUBE_WALK2:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.MAGMACUBE_WALK2, volume, pitch);
                break;
            case MAGMACUBE_JUMP:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.MAGMACUBE_JUMP, volume, pitch);
                break;
            case PIG_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.PIG_IDLE, volume, pitch);
                break;
            case PIG_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.PIG_DEATH, volume, pitch);
                break;
            case PIG_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.PIG_WALK, volume, pitch);
                break;
            case SHEEP_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SHEEP_IDLE, volume, pitch);
                break;
            case SHEEP_SHEAR:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SHEEP_SHEAR, volume, pitch);
                break;
            case SHEEP_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SHEEP_WALK, volume, pitch);
                break;
            case SILVERFISH_HIT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SILVERFISH_HIT, volume, pitch);
                break;
            case SILVERFISH_KILL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SILVERFISH_IDLE, volume, pitch);
                break;
            case SILVERFISH_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SILVERFISH_KILL, volume, pitch);
                break;
            case SILVERFISH_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SILVERFISH_WALK, volume, pitch);
                break;
            case SKELETON_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SKELETON_IDLE, volume, pitch);
                break;
            case SKELETON_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SKELETON_DEATH, volume, pitch);
                break;
            case SKELETON_HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SKELETON_HURT, volume, pitch);
                break;
            case SKELETON_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SKELETON_WALK, volume, pitch);
                break;
            case SLIME_ATTACK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SLIME_ATTACK, volume, pitch);
                break;
            case SLIME_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SLIME_WALK, volume, pitch);
                break;
            case SLIME_WALK2:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SLIME_WALK2, volume, pitch);
                break;
            case SPIDER_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SPIDER_IDLE, volume, pitch);
                break;
            case SPIDER_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SPIDER_DEATH, volume, pitch);
                break;
            case SPIDER_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.SPIDER_WALK, volume, pitch);
                break;
            case WITHER_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WITHER_DEATH, volume, pitch);
                break;
            case WITHER_HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WITHER_HURT, volume, pitch);
                break;
            case WITHER_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WITHER_IDLE, volume, pitch);
                break;
            case WITHER_SHOOT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WITHER_SHOOT, volume, pitch);
                break;
            case WITHER_SPAWN:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WITHER_SPAWN, volume, pitch);
                break;
            case WOLF_BARK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_BARK, volume, pitch);
                break;
            case WOLF_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_DEATH, volume, pitch);
                break;
            case WOLF_GROWL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_GROWL, volume, pitch);
                break;
            case WOLF_HOWL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_HOWL, volume, pitch);
                break;
            case WOLF_HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_HURT, volume, pitch);
                break;
            case WOLF_PANT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_PANT, volume, pitch);
                break;
            case WOLF_SHAKE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_SHAKE, volume, pitch);
                break;
            case WOLF_WALK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_WALK, volume, pitch);
                break;
            case WOLF_WHINE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.WOLF_WHINE, volume, pitch);
                break;
            case ZOMBIE_METAL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_METAL, volume, pitch);
                break;
            case ZOMBIE_WOOD:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_WOOD, volume, pitch);
                break;
            case ZOMBIE_WOODBREAK:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_WOODBREAK, volume, pitch);
                break;
            case ZOMBIE_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_IDLE, volume, pitch);
                break;
            case ZOMBIE_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_DEATH, volume, pitch);
                break;
            case ZOMBIE_HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_HURT, volume, pitch);
                break;
            case ZOMBIE_INFECT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_INFECT, volume, pitch);
                break;
            case ZOMBIE_UNFECT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_UNFECT, volume, pitch);
                break;
            case ZOMBIE_REMEDY:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_REMEDY, volume, pitch);
                break;
            case ZOMBIE_PIG_IDLE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_PIG_IDLE, volume, pitch);
                break;
            case ZOMBIE_PIG_ANGRY:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_PIG_ANGRY, volume, pitch);
                break;
            case ZOMBIE_PIG_DEATH:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_PIG_DEATH, volume, pitch);
                break;
            case ZOMBIE_PIG_HURT:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.ZOMBIE_PIG_HURT, volume, pitch);
                break;
            case DIG_WOOL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DIG_WOOL, volume, pitch);
                break;
            case DIG_GRASS:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DIG_GRASS, volume, pitch);
                break;
            case DIG_GRAVEL:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DIG_GRAVEL, volume, pitch);
                break;
            case DIG_SAND:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DIG_SAND, volume, pitch);
                break;
            case DIG_SNOW:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DIG_SNOW, volume, pitch);
                break;
            case DIG_STONE:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DIG_STONE, volume, pitch);
                break;
            case DIG_WOOD:
                p.playSound(LocationUtil.toBukkitLoc(loc), org.bukkit.Sound.DIG_WOOD, volume, pitch);
                break;
        }
        return true;
    }

}
