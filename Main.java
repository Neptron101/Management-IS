/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Sarah Froemming 11587806
 */
public class Main extends javax.swing.JFrame {
    int col;
    int rowInd;
    int row;
    Connection con;
    Statement stmt;
    Statement pst;
    ResultSet rs;
    ResultSet rsP;
    /**
     * Creates new form Display
     * @throws java.sql.SQLException
     */
    public Main() throws SQLException {
        initComponents();
        FillTable(jTable1,"Select * from sql12175092.Employee");
        FillTable(jTable2,"Select * from Projects");
    }
        /**
     * Creates new form Main
     */
    
    /**
     *
     * @throws SQLException
     */
    public void Connect() throws SQLException {    
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            System.out.print("Driver success");
            con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12175092?zeroDateTimeBehavior=convertToNull","sql12175092","IKiL6BaUyu");
            System.out.print("Database Connected");

    }
    
    public void FillTable(JTable table, String Query){
        try {
            Connect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(Query);
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] rows = new Object[columns];
                for (int i = 1;i <= columns; i++) {
                    rows[i - 1] = rs.getObject(i);
                }
                Object column1 = rows[0];
                Object column2 = rows[1];
                Object column3 = rows[2];
                
                Object[] row2 = new Object[columns];
                row2[0] = column1;
                row2[1] = column2;
                row2[2] = column3;
                
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row2);
            }
            TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());
            table.setRowSorter(sort);

            List<RowSorter.SortKey> sortKeys = new ArrayList<>();

            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            sort.setSortKeys(sortKeys);

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void SearchResult(JTable table, String Query) {
        try {
            Connect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(Query);

            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }

            int columns = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Object[] rows = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    rows[i - 1] = rs.getObject(i);
                }

                Object column1 = rows[0];
                Object column2 = rows[1];
                Object column3 = rows[2];
                
                Object[] row2 = new Object[columns];
                row2[0] = column1;
                row2[1] = column2;
                row2[2] = column3;
     
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row2);
            }
            if (table.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Please make sure your spelling is correct and try again.", "Search did not return results", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getSName(String Query) {
        try {
            Connect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(Query);
            rs.next();
            String name = rs.getString("Name");

            //lblInf.setText(name);

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        SearchEmp = new javax.swing.JButton();
        SearchProj = new javax.swing.JButton();
        txtSearchEmp = new javax.swing.JTextField();
        txtSearchProj = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        SearchEmp.setText("Search");
        SearchEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchEmpActionPerformed(evt);
            }
        });

        SearchProj.setText("Search");
        SearchProj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchProjActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Employees");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Projects");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtSearchEmp)
                            .addGap(18, 18, 18)
                            .addComponent(SearchEmp))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtSearchProj)
                            .addGap(18, 18, 18)
                            .addComponent(SearchProj))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchEmp)
                    .addComponent(SearchProj)
                    .addComponent(txtSearchEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchProj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchEmpActionPerformed
        if ("".equals(txtSearchEmp.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Please enter an employee id or name and try again.", "No data entered", JOptionPane.ERROR_MESSAGE);
        }
        SearchResult(jTable1, "Select * from sql12175092.Employee where LastName like '%" + txtSearchEmp.getText() + "%' OR FirstName like '%" + txtSearchEmp.getText() + "%' OR ID like '%" + txtSearchEmp.getText() + "%'");
    }//GEN-LAST:event_SearchEmpActionPerformed

    private void SearchProjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchProjActionPerformed
        if ("".equals(txtSearchProj.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a project id or name and try again.", "No data entered", JOptionPane.ERROR_MESSAGE);
        }
        SearchResult(jTable2, "Select * from sql12175092.Projects where Name like '%" + txtSearchProj.getText() + "%' OR ID like '%" + txtSearchProj.getText() + "%'");
    }//GEN-LAST:event_SearchProjActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchEmp;
    private javax.swing.JButton SearchProj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtSearchEmp;
    private javax.swing.JTextField txtSearchProj;
    // End of variables declaration//GEN-END:variables
}
