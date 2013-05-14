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
package com.github.legendsdev.legends.library.party;

import com.github.legendsdev.legends.library.level.expsource.ExpSource;
import com.github.legendsdev.legends.library.lplayer.LPlayer;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class Party {
    private ArrayList<LPlayer> members = new ArrayList<>();
    private LPlayer partyLeader;

    public Party(LPlayer partyLeader) {
        this.partyLeader = partyLeader;
        addMember(partyLeader);
    }

    public Party addMember(LPlayer player) {
        if(!members.contains(player)) {
            members.add(player);
            player.setParty(this);
        }
        return this;
    }

    public Party removeMember(LPlayer player) {
        members.remove(player);
        if(partyLeader == player) {
            partyLeader = members.get(0);
            player.setParty(new Party(player));
        }
        return this;
    }

    public Party setLeader(LPlayer player) {
        if(!members.contains(player)) {
            members.add(player);
        }
        partyLeader = player;
        return this;
    }

    public ArrayList<LPlayer> getMembers() {
        return members;
    }

    public Party addExp(double exp) {
        //addExp(new Exp(exp));
        return this;
    }

    public Party addExp(ExpSource source) {
        for(LPlayer player : members) {
            player.addExp(source);
        }
        return this;
    }
}
