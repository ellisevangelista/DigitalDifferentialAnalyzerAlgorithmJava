/*
 * Copyright (C) 2018 Jerome Cases, Ellis Evangelista 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Model;

public class DDA_Bean {
    private static double startX;
    private static double startY;
    private static double endX;
    private static double endY;    

    public static double getStartX() {
        return startX;
    }

    public static void setStartX(double startX) {
        DDA_Bean.startX = startX;
    }

    public static double getStartY() {
        return startY;
    }

    public static void setStartY(double startY) {
        DDA_Bean.startY = startY;
    }

    public static double getEndX() {
        return endX;
    }

    public static void setEndX(double endX) {
        DDA_Bean.endX = endX;
    }

    public static double getEndY() {
        return endY;
    }

    public static void setEndY(double endY) {
        DDA_Bean.endY = endY;
    }
}
