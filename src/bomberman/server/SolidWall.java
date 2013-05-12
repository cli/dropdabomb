/*
 *  DropDaBomb
 *  Copyright (C) 2008-2013 Christian Lins <christian@lins.me>
 *  Copyright (C) 2008 Kai Ritterbusch <kai.ritterbusch@googlemail.com>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package bomberman.server;

/**
 * A solid, not exploadable wall.
 * 
 * @author Christian Lins
 */
class SolidWall extends Wall {
    /**
     * 
     */
    private static final long  serialVersionUID = 5451567671580448604L;
    public static final String IMAGE_FILENAME   = "resource/gfx/solid_wall.png";

    protected SolidWall() {

    }

    public SolidWall(int x, int y) {
        super(x, y);
    }

    /**
     * @return Returns the filename that is used on client side to paint this
     *         wall.
     */
    @Override
    public String getImageFilename() {
        return IMAGE_FILENAME;
    }
}
