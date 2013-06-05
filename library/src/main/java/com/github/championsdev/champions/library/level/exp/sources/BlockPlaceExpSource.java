/*******************************************************************************
 * This file is part of Champions.
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
 ******************************************************************************/
package com.github.championsdev.champions.library.level.exp.sources;

/**
 * @author B2OJustin
 */
public class BlockPlaceExpSource extends ExpSource {
    private String blockId;

    public BlockPlaceExpSource(String blockId) {
        super(ExpSourceType.BLOCK_PLACE);
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BlockPlaceExpSource that = (BlockPlaceExpSource) o;

        if (blockId != null ? !blockId.equals(that.blockId) : that.blockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (blockId != null ? blockId.hashCode() : 0);
        return result;
    }
}
