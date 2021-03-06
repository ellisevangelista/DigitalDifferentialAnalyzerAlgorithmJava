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
package View;

import Logic.DDA_Action;
import Model.DDA_Bean;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DDA_PlotW extends JPanel {

    DDA_Bean bean = new DDA_Bean();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2D = (Graphics2D) g;
        DDA_Action A = new DDA_Action();
        Map<String, ArrayList<Double>> map = new HashMap<>(A.calculate(bean.getEndX(), bean.getEndY(), bean.getStartX(), bean.getStartY()));
        ArrayList<Double> xValues = map.get("xValues");
        ArrayList<Double> yValues = map.get("yValues");
        g2D.setStroke(new BasicStroke(2.0f));
        AffineTransform transform = new AffineTransform();

        //X & Y axis
        Rectangle r = this.getBounds();
        double h = r.height;
        double w = r.width;

        g2D.setPaint(Color.GRAY);
        g2D.setStroke(new BasicStroke(3.0f));
        Line2D yAxis = new Line2D.Double(15, 0, 15, h);
        g2D.draw(yAxis);
        Line2D xAxis = new Line2D.Double(15, 450, w, 450);
        g2D.draw(xAxis);

        //numbers on the x axis
        g2D.setPaint(Color.BLACK);
        g2D.setFont(new Font("Arial", Font.PLAIN, 8));
        for (int i = 0; i < w; i++) {
            if (i == 0) {
                g2D.drawString("0", 15, 450);                
            }else{
            i--;
            i = i+5;
            String n = Integer.toString(i);
            g2D.drawString(n, i*5, 450);            
            }
        }        
        //numbers on the y-axis (positive)
        for (int i = 0; i < w; i++) {
            if (i == 0) {
                g2D.drawString("0", 15, 400);                
            }else{
            i--;
            i = i+5;
            String n = Integer.toString(i);
            g2D.drawString(n, 15, 400 - i*5);            
            }
        }
        //numbers on the y-axis (negative)
        for (int i = 0; i < w; i++) {
            if (i == 0) {
                g2D.drawString("0", 15, 400);                
            }else{
            i--;
            i = i+5;
            String n = Integer.toString(i);
            g2D.drawString(n, 15, 400 + i*5);            
            }
        }
     
        //PLotting of Points
        g2D.translate(15, 450); // To flip the Y coordinate
        g2D.scale(1.0, -1.0);  // To flip the Y coordinate
        try{
        g2D.setPaint(Color.BLUE);
        for (int i = 0; i < xValues.size() - 1; i++) {
            Line2D line = new Line2D.Double(xValues.get(i) * 5, yValues.get(i) * 5, xValues.get(i + 1) * 5, yValues.get(i + 1) * 5);
            g2D.draw(transform.createTransformedShape(line)); //plotting per points                
        }

        g2D.setPaint(Color.RED);
        Line2D line = new Line2D.Double(xValues.get(0) * 5, yValues.get(0) * 5, xValues.get(xValues.size() - 1) * 5, yValues.get(xValues.size() - 1) * 5);
        g2D.draw(transform.createTransformedShape(line)); //plotting from starting point to end point
        }catch(IndexOutOfBoundsException e){
            System.out.println("out of bounds");
        }
    }

    public static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new DDA_PlotW());
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.setTitle("Plot");

    }

    public static void Plot() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
