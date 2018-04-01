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
package Logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class DDA_Action {

    public Map<String, ArrayList<Double>> calculate(double endX, double endY, double startX, double startY) {
        double num = Math.abs(endY - startY);
        double denom = Math.abs(endX - startX);

        System.out.println("num " + num);
        System.out.println("denom " + denom);
        double slope = num / denom;
        System.out.println("slope " + slope);
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<Double> z = new ArrayList<>();

        if ((denom == 0) || (num == 0)) {
            infoBox("Slope must not be 0 or undefined", "Error");
        } else if (num < denom) {
            if (startX < endX) {
                for (double i = startX; i < endX + 1; i++) {                   
                    x.add(i);
                }
            } else {               
                for (double i = startX; i > endX - 1; i--) {
                    x.add(i);
                }
            }
            if (startY < endY) {
                y.add(startY);
                z.add(startY);
                double hld;

                for (int i = 0; i < x.size() - 2; i++) {
                    if (slope < 1) {
                        hld = z.get(i) + slope;
                    } else {
                        hld = z.get(i) + (1 / slope);
                    }
                    double rounded = Math.round(hld);
                    z.add(hld);
                    y.add(rounded);
                }
                y.add(endY);
            } else {
                y.add(startY);
                z.add(startY);
                double hld;

                for (int i = 0; i < x.size() - 2; i++) {
                    if (slope < 1) {
                        hld = z.get(i) - slope;
                    } else {
                        hld = z.get(i) - (1 / slope);
                    }
                    double rounded = Math.round(hld);
                    z.add(hld);
                    y.add(rounded);
                }
                y.add(endY);
            }
        } else {
            if (startY < endY) {
                for (double i = startY; i < endY + 1; i++) {
                    y.add(i);
                }
            } else {
                for (double i = startY; i > endY - 1; i--) {
                    y.add(i);
                }
            }
            if (startX < endX) {
                x.add(startX);
                z.add(startX);
                double hld;

                for (int i = 0; i < y.size() - 2; i++) {
                    if (slope > 1) {
                        hld = z.get(i) + (1 / slope);
                    } else {
                        hld = z.get(i) + slope;
                    }
                    double round = Math.round(hld);
                    z.add(hld);
                    x.add(round);
                }
                x.add(endX);
            } else {
                x.add(startX);
                z.add(startX);
                double hld;

                for (int i = 0; i < y.size() - 2; i++) {
                    if (slope > 1) {
                        hld = z.get(i) - (1 / slope);
                    } else {
                        hld = z.get(i) - slope;
                    }
                    double round = Math.round(hld);
                    z.add(hld);
                    x.add(round);
                }
                x.add(endX);
            }
        }
        System.out.println("X " + x);
        System.out.println("Y " + y);

        Map<String, ArrayList<Double>> map = new HashMap();
        map.put("xValues", x);
        map.put("yValues", y);
        return map;
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}
