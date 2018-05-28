/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.collections.ObservableList;
import javax.swing.*;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author takajima
 */
public class MenuFrame extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ObservableList<String> minStk;
    ObservableList<String> maxStk;

    //Date Picker SYSTEM -------
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    JLabel l = new JLabel("", JLabel.CENTER);
    String day = "";
    JDialog d;
    JButton[] button = new JButton[49];
    ArrayList<String> ppID = new ArrayList<String>();
    ArrayList<String> MaxS = new ArrayList<String>();
    ArrayList<String> MinS = new ArrayList<String>();

    /**
     * Creates new form MenuFrame
     */
    public MenuFrame() {
        initComponents();
        conn = DataBase.sqliteConnect.connectorDB();
        FrameInventory();
        CurrentDate();
        TopFill();
        SalesTopTable.setAutoCreateRowSorter(true);
        SalesTableTotals.setAutoCreateRowSorter(true);
//        datesearch();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    private void FrameInventory() {
        try {
            String sqlQuery = "select product,category,quantity,price,date from sales  ";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            SalesTableTotals.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

///DATE PICKER SYSTEM-----------------------------------------------------------
    public void displayDate() {
        for (int x = 7; x < button.length; x++) {
            button[x].setText("");
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, 1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
            button[x].setText("" + day);
        }
        l.setText(sdf.format(cal.getTime()));
        d.setTitle("Date Picker");

    }
//    public void setDate(){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/m/d");
//	String date = sdf.format(new java.util.Date());
//        CashDueDateLabel.setText(date);
//    }
//------------------------------------------------------------------------------

    public void CurrentDate() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        MenuStart.setText("" + year + '-' + (month + 1) + '-' + day);
        MenuEnd.setText("" + year + '-' + (month + 1) + '-' + day);
    }

    private void TopFill() {
        try {
            String sqlQuery = "SELECT Product,date FROM sales WHERE date BETWEEN '" + MenuStart.getText() + "' AND '" + MenuEnd.getText() + "' ";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            SalesTopTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

//private void datesearch(){
//    String var = MenuStart.getText().toString();
//    String var2 = MenuEnd.getText().toString();
//
//        try
//        {
//            String sqlQuery = "SELECT Product FROM sales WHERE date BETWEEN '"+MenuStart.getText()+"'  AND '"+MenuEnd.getText()+"'  ";
//            pst = conn.prepareStatement(sqlQuery);
//            rs = pst.executeQuery();
//            SalesTopTable.setModel(DbUtils.resultSetToTableModel(rs));
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        finally
//        {
//            try
//            {
//                rs.close();
//                pst.close();
//            }
//            catch(Exception e)
//            {
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
//}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SalesLabel5 = new javax.swing.JLabel();
        SalesLabel4 = new javax.swing.JLabel();
        MenuEnd = new javax.swing.JButton();
        MenuStart = new javax.swing.JButton();
        MenuEdit = new javax.swing.JButton();
        SalesLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SalesTopTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        SalesTableTotals = new javax.swing.JTable();
        SalesLogs = new javax.swing.JButton();
        MenuPos = new javax.swing.JButton();
        MenuSales = new javax.swing.JButton();
        MenuInventory = new javax.swing.JButton();
        MenuLogout = new javax.swing.JButton();
        MenuBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SalesLabel5.setBackground(new java.awt.Color(255, 255, 255));
        SalesLabel5.setFont(new java.awt.Font("Ubuntu Titling Rg", 1, 18)); // NOI18N
        SalesLabel5.setForeground(new java.awt.Color(255, 255, 255));
        SalesLabel5.setText("End Date:");
        getContentPane().add(SalesLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 120, -1));

        SalesLabel4.setBackground(new java.awt.Color(255, 255, 255));
        SalesLabel4.setFont(new java.awt.Font("Ubuntu Titling Rg", 1, 18)); // NOI18N
        SalesLabel4.setForeground(new java.awt.Color(255, 255, 255));
        SalesLabel4.setText("Start Date:");
        getContentPane().add(SalesLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 120, -1));

        MenuEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEndActionPerformed(evt);
            }
        });
        getContentPane().add(MenuEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 120, 30));

        MenuStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuStartActionPerformed(evt);
            }
        });
        getContentPane().add(MenuStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 120, 30));

        MenuEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings48.png"))); // NOI18N
        MenuEdit.setToolTipText("");
        MenuEdit.setMaximumSize(new java.awt.Dimension(128, 128));
        MenuEdit.setMinimumSize(new java.awt.Dimension(128, 128));
        MenuEdit.setPreferredSize(new java.awt.Dimension(128, 128));
        MenuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEditActionPerformed(evt);
            }
        });
        getContentPane().add(MenuEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 60, 50));

        SalesLabel1.setBackground(new java.awt.Color(255, 255, 255));
        SalesLabel1.setFont(new java.awt.Font("Ubuntu Titling Rg", 1, 18)); // NOI18N
        SalesLabel1.setForeground(new java.awt.Color(255, 255, 255));
        SalesLabel1.setText("Top Sold Materials");
        getContentPane().add(SalesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 180, -1));

        SalesTopTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Product"
            }
        ));
        jScrollPane3.setViewportView(SalesTopTable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 380, 110));

        SalesTableTotals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Quantity", "Amount"
            }
        ));
        jScrollPane4.setViewportView(SalesTableTotals);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 720, 430));

        SalesLogs.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalesLogs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/chart44.png"))); // NOI18N
        SalesLogs.setText("View Totals");
        SalesLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesLogsActionPerformed(evt);
            }
        });
        getContentPane().add(SalesLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, -1));

        MenuPos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MenuPos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/shopping122.png"))); // NOI18N
        MenuPos.setText("pos");
        MenuPos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuPosMouseReleased(evt);
            }
        });
        MenuPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });
        getContentPane().add(MenuPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 60));

        MenuSales.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MenuSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tasks2.png"))); // NOI18N
        MenuSales.setText("Sales");
        MenuSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalesActionPerformed(evt);
            }
        });
        getContentPane().add(MenuSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 130, 60));

        MenuInventory.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MenuInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/factories1.png"))); // NOI18N
        MenuInventory.setText("Inventory");
        MenuInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInventoryActionPerformed(evt);
            }
        });
        getContentPane().add(MenuInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 60));
        MenuInventory.getAccessibleContext().setAccessibleDescription("");

        MenuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/door13.png"))); // NOI18N
        MenuLogout.setToolTipText("");
        MenuLogout.setMaximumSize(new java.awt.Dimension(128, 128));
        MenuLogout.setMinimumSize(new java.awt.Dimension(128, 128));
        MenuLogout.setPreferredSize(new java.awt.Dimension(128, 128));
        MenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(MenuLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 60, 50));

        MenuBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        getContentPane().add(MenuBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        dispose();
        PosFrame open = new PosFrame();
        open.setVisible(true);


    }//GEN-LAST:event_none

    private void MenuSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalesActionPerformed
        dispose();
        SalesFrame open = new SalesFrame();
        open.setVisible(true);
    }//GEN-LAST:event_MenuSalesActionPerformed

    private void MenuInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInventoryActionPerformed
        dispose();
        InventoryFrame open = new InventoryFrame();
        open.setVisible(true);
    }//GEN-LAST:event_MenuInventoryActionPerformed

    private void MenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLogoutActionPerformed
        dispose();
        LoginFrame open = new LoginFrame();
        open.setVisible(true);
    }//GEN-LAST:event_MenuLogoutActionPerformed

    private void MenuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditActionPerformed
        Inputs.Configuration open = new Inputs.Configuration();
        open.setVisible(true);
        MenuFrame Halt = new MenuFrame();
        Halt.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuEditActionPerformed

    private void MenuStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuStartActionPerformed
        JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        MenuStart.setText(new DatePicker(f).setPickedDate());

        try {
            String sqlQuery = "SELECT Product FROM sales WHERE date BETWEEN '" + MenuStart.getText() + "'  AND '" + MenuEnd.getText() + "' group by product ";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            SalesTopTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }


    }//GEN-LAST:event_MenuStartActionPerformed

    private void MenuEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEndActionPerformed
        JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        MenuEnd.setText(new DatePicker(f).setPickedDate());

        try {
            String sqlQuery = "SELECT Product FROM sales WHERE date BETWEEN '" + MenuStart.getText() + "'  AND '" + MenuEnd.getText() + "' group by product  ";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            SalesTopTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_MenuEndActionPerformed

    private void MenuPosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPosMouseReleased

        String mx = "", mn = "";

        try {
            String sqlQuery = "SELECT Product,Available,Reorder,Order FROM inventory";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt("Available") <= rs.getInt("Reorder")) {
                    MinS.add(rs.getString("Product") + " has reached minimum stock value, Order now! Remaining "
                            + "Available(" + rs.getInt("Available") + ")." + "\n");
                }
                if (rs.getInt("Available") > rs.getInt("Reorder")) {
                    MaxS.add(rs.getString("Product") + " has reached maximum stock value." + "\n");
                }
            }

            for (int i = 0; i < MinS.size(); i++) {
                mn = mn.concat(MinS.get(i));
                if (i == (MinS.size() - 1)) {
                    JTextArea textArea = new JTextArea(mn);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                    scrollPane.setPreferredSize(new Dimension(600, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, null,
                            WARNING_MESSAGE);
                    //JOptionPane.showMessageDialog(null, mn);
                }
            }

            for (int i = 0; i < MaxS.size(); i++) {
                mx = mx.concat(MaxS.get(i));
                if (i == (MaxS.size() - 1)) {
                    JTextArea textArea = new JTextArea(mx);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                    scrollPane.setPreferredSize(new Dimension(400, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, null,
                            WARNING_MESSAGE);
                    //JOptionPane.showMessageDialog(null, mx);
                }
            }

        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null,ex);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_MenuPosMouseReleased

    private void SalesLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesLogsActionPerformed
        TotalsFrame open = new TotalsFrame();
        open.setVisible(true);
    }//GEN-LAST:event_SalesLogsActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MenuBg;
    private javax.swing.JButton MenuEdit;
    private javax.swing.JButton MenuEnd;
    private javax.swing.JButton MenuInventory;
    private javax.swing.JButton MenuLogout;
    private javax.swing.JButton MenuPos;
    private javax.swing.JButton MenuSales;
    private javax.swing.JButton MenuStart;
    private javax.swing.JLabel SalesLabel1;
    private javax.swing.JLabel SalesLabel4;
    private javax.swing.JLabel SalesLabel5;
    private javax.swing.JButton SalesLogs;
    private javax.swing.JTable SalesTableTotals;
    private javax.swing.JTable SalesTopTable;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
