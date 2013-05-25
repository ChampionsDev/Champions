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
package com.github.championsdev.champions.library.party;

import com.github.championsdev.champions.library.cplayer.CPlayer;
import com.github.championsdev.champions.library.level.exp.sources.ExpSource;

import java.util.ArrayList;

/**
 * @author B2OJustin
 */
public class Party {
    private ArrayList<CPlayer> members = new ArrayList<>();
    private CPlayer partyLeader;

    public Party(CPlayer partyLeader) {
        this.partyLeader = partyLeader;
        addMember(partyLeader);
    }

    public Party addMember(CPlayer player) {
        if(!members.contains(player)) {
            members.add(player);
            player.setParty(this);
        }
        return this;
    }

    public Party removeMember(CPlayer player) {
        members.remove(player);
        if(partyLeader == player) {
            partyLeader = members.get(0);
            player.setParty(new Party(player));
        }
        return this;
    }

    public Party setLeader(CPlayer player) {
        addMember(player);
        partyLeader = player;
        return this;
    }

    public ArrayList<CPlayer> getMembers() {
        return members;
    }

    public Party addExp(double exp) {
        //addExp(new Exp(exp));
        return this;
    }

    public Party addExp(ExpSource source) {
        for(CPlayer player : members) {
            player.addExp(source);
        }
        return this;
    }
}
