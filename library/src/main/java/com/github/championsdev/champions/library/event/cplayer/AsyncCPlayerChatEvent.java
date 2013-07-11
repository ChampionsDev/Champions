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
import com.github.championsdev.champions.library.event.Cancellable;

import java.util.List;

/**
 * @author YoshiGenius
 */
public class AsyncCPlayerChatEvent extends CPlayerEvent implements Cancellable {

    private final boolean async;
    private final List<CPlayer> recipients;
    private String format;
    private String message;
    private boolean cancelled;

    public AsyncCPlayerChatEvent(CPlayer player, String message, String format, boolean async, List<CPlayer> recipients) {
        super(player);
        this.message = message;
        this.format = format;
        this.async = async;
        this.recipients = recipients;
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

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    public List<CPlayer> getRecipients() {
        return this.recipients;
    }
}
