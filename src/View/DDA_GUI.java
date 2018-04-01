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

import Model.DDA_Bean;
import Logic.DDA_Action;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;

public class DDA_GUI extends javax.swing.JFrame {

    DDA_Bean bean = new DDA_Bean();   
    
    public DDA_GUI() {
        initComponents();    
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("DDA Calculator");
        
        submit.setContentAreaFilled(false);
        submit.setOpaque(true);
        submit.setBackground(Color.WHITE);
        plotButton.setContentAreaFilled(false);
        plotButton.setOpaque(true);
        plotButton.setBackground(Color.WHITE);
        about.setContentAreaFilled(false);
        about.setOpaque(true);
        about.setBackground(Color.WHITE);
    }
    
    public void mapOutput() {       
        DDA_Action A = new DDA_Action();
        Map<String, ArrayList<Double>> map = new HashMap<>(A.calculate(bean.getEndX(), bean.getEndY(), bean.getStartX(), bean.getStartY()));
        ArrayList<Double> xValues = map.get("xValues");
        ArrayList<Double> yValues = map.get("yValues");
        Object[][] data = new String[xValues.size()][3];
        String[] columnNames = {"n", "X", "Y"};
        // x and y values from ArrayList -> data , creates a table
        for (int i = 0; i < xValues.size(); i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        data[i][j] = Integer.toString(i);                        
                        break;
                    case 1:
                        data[i][j] = xValues.get(i).toString();                        
                        break;
                    default:
                        data[i][j] = yValues.get(i).toString();                        
                        break;
                }
            }
        }
        JTable table = new JTable(data, columnNames);
        jScrollPane2.setViewportView(table);
    }

    public void varAssign() {
        bean.setStartX((Integer) startX.getValue());
        bean.setStartY((Integer) startY.getValue());
        bean.setEndX((Integer) endX.getValue());
        bean.setEndY((Integer) endY.getValue());      
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        startX = new javax.swing.JSpinner();
        startY = new javax.swing.JSpinner();
        endX = new javax.swing.JSpinner();
        endY = new javax.swing.JSpinner();
        submit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        plotButton = new javax.swing.JButton();
        about = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startX.setName("startX"); // NOI18N

        startY.setName("startY"); // NOI18N

        endX.setName("endX"); // NOI18N

        endY.setName("endY"); // NOI18N

        submit.setText("Calculate");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        plotButton.setText("Plot");
        plotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotButtonActionPerformed(evt);
            }
        });

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(endX, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(endY, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(startX, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startY, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(submit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plotButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(about, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plotButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(about)
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        varAssign();
        mapOutput();
    }//GEN-LAST:event_submitActionPerformed

    private void plotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotButtonActionPerformed
        DDA_PlotW d = new DDA_PlotW();
        d.Plot();
    }//GEN-LAST:event_plotButtonActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        DDA_About A = new DDA_About();
        A.About();
    }//GEN-LAST:event_aboutActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DDA_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton about;
    private javax.swing.JSpinner endX;
    private javax.swing.JSpinner endY;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton plotButton;
    private javax.swing.JSpinner startX;
    private javax.swing.JSpinner startY;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
