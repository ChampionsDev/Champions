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

package com.github.championsdev.champions.library.event.cplayer;

import com.github.championsdev.champions.library.cplayer.CPlayer;

/**
 * @author YoshiGenius
 */
public class AsyncCPlayerChatEvent extends CPlayerEvent {

    private final boolean async;
    private String format;
    private String message;

    public AsyncCPlayerChatEvent(CPlayer player, String message, String format, boolean async) {
        super(player);
        this.message = message;
        this.format = format;
        this.async = async;
    }

    public String getMessage() {
        return this.message;
    }

    public AsyncCPlayerChatEvent setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getFormat() {
        return this.format;
    }

    public AsyncCPlayerChatEvent setFormat(String format) {
        this.format = format;
        return this;
    }

    public boolean isAsync() {
        return this.async;
    }

}
