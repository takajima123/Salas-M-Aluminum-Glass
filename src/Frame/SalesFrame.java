/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;
import Inputs.AddProduct;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author takajima
 */
public class SalesFrame extends javax.swing.JFrame {
        Connection conn = null;
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        ResultSet rs = null;
        JTable table2 = new JTable();
    /**
     * Creates new form SalesFrame
     */
    public SalesFrame() {
        initComponents();
        conn = DataBase.sqliteConnect.connectorDB();
        FrameInventory();
        CurrentDate();
        SalesTransactionTable.setAutoCreateRowSorter(true);
        SalesTransactionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        UpdatePanel.setVisible(false);
        Paid.setVisible(false);
        Balance.setVisible(false);
        UpdateBalance.setVisible(false);
        NewBalance.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(false);
        Paid.setEnabled(false);
        Balance.setEnabled(false);
        UpdateBalance.setEnabled(false);
        NewBalance.setEnabled(false);
        update.setEnabled(false);
        cancel.setEnabled(false);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
private  void FrameInventory(){
        try
        {
            String sqlQuery = "select * from Sales";
//SELECT Customers.CustomerName, Orders.OrderID
//FROM Customers
//INNER JOIN Orders
//ON Customers.CustomerID=Orders.CustomerID
//ORDER BY Customers.CustomerName;
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            SalesTransactionTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    }
        public void  CurrentDate(){
         Calendar cal= new GregorianCalendar();
         int month = cal.get(Calendar.MONTH);
         int year = cal.get(Calendar.YEAR);
         int day = cal.get(Calendar.DAY_OF_MONTH);
         HiddenDate.setText(""+ year+'.'+(month+1)+'.'+day);
     }

        

    
    public void toExcel(JTable table, File file){
    try{/*
        if (file.getParentFile().mkdir()) {
            file.createNewFile();
        }*/
        
        
        TableModel model = SalesTransactionTable.getModel();
        //TableModel model2 = table2.getModel();
        try (FileWriter excel = new FileWriter(file)) {
            /*
            for(int i = 0; i < model2.getColumnCount(); i++){
                excel.write(model2.getColumnName(i) + ",");
            }
            
            excel.write("\n");
            
            for(int i=0; i< model2.getRowCount(); i++) {
                for(int j=0; j < model2.getColumnCount(); j++) {
                    excel.write(model2.getValueAt(i,j).toString()+",");
                }
                excel.write("\n");
            } */
            
            for(int i = 0; i < model.getColumnCount(); i++){
                excel.write(model.getColumnName(i) + ",");
            }
            
            excel.write("\n");
            
            for(int i=0; i< model.getRowCount(); i++) {
                for(int j=0; j < model.getColumnCount(); j++) {
                  //  System.out.println(model.getValueAt(i, j).toString());
                    excel.write(model.getValueAt(i,j).toString()+",");
                }
                excel.write("\n");
            }
        }

    }catch(IOException e){}
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpdatePanel = new javax.swing.JPanel();
        NewBalance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        update = new javax.swing.JButton();
        Paid = new javax.swing.JTextField();
        Balance = new javax.swing.JTextField();
        UpdateBalance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        InventoryHome = new javax.swing.JButton();
        SalesExport = new javax.swing.JButton();
        Payment = new javax.swing.JButton();
        SalesUpdate = new javax.swing.JButton();
        SalesSearch = new javax.swing.JTextField();
        SalesLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SalesTransactionTable = new javax.swing.JTable();
        SalesBg = new javax.swing.JLabel();
        HiddenDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 620));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UpdatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NewBalance.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewBalance.setText("0");
        NewBalance.setEnabled(false);
        UpdatePanel.add(NewBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("New Balance :");
        UpdatePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        cancel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        UpdatePanel.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        update.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        UpdatePanel.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        Paid.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Paid.setText("0");
        Paid.setEnabled(false);
        Paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaidActionPerformed(evt);
            }
        });
        UpdatePanel.add(Paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 30));

        Balance.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Balance.setText("0");
        Balance.setEnabled(false);
        UpdatePanel.add(Balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 80, 30));

        UpdateBalance.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        UpdateBalance.setText("0");
        UpdateBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBalanceActionPerformed(evt);
            }
        });
        UpdateBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UpdateBalanceKeyPressed(evt);
            }
        });
        UpdatePanel.add(UpdateBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Paid :");
        UpdatePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Update Paid :");
        UpdatePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Balance :");
        UpdatePanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        UpdatePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-650, -240, 800, 620));

        getContentPane().add(UpdatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 150, 280));

        InventoryHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/door13.png"))); // NOI18N
        InventoryHome.setMaximumSize(new java.awt.Dimension(50, 40));
        InventoryHome.setMinimumSize(new java.awt.Dimension(50, 40));
        InventoryHome.setPreferredSize(new java.awt.Dimension(50, 40));
        InventoryHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryHomeActionPerformed(evt);
            }
        });
        getContentPane().add(InventoryHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        SalesExport.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalesExport.setText("Export to excel");
        SalesExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesExportActionPerformed(evt);
            }
        });
        getContentPane().add(SalesExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 210, 140, 40));

        Payment.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Payment.setText("Balance Payment");
        Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentActionPerformed(evt);
            }
        });
        getContentPane().add(Payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 260, 140, 40));

        SalesUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalesUpdate.setText("Refresh Data");
        SalesUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(SalesUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 160, 140, 40));

        SalesSearch.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalesSearch.setText("Find");
        SalesSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SalesSearchMouseReleased(evt);
            }
        });
        SalesSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesSearchActionPerformed(evt);
            }
        });
        SalesSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SalesSearchKeyReleased(evt);
            }
        });
        getContentPane().add(SalesSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 122, 37));

        SalesLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalesLabel4.setForeground(new java.awt.Color(255, 255, 255));
        SalesLabel4.setText("Search :");
        getContentPane().add(SalesLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, -1, -1));

        SalesTransactionTable.setAutoCreateRowSorter(true);
        SalesTransactionTable.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalesTransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        SalesTransactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SalesTransactionTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(SalesTransactionTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 90, 640, 440));

        SalesBg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalesBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        SalesBg.setMaximumSize(new java.awt.Dimension(800, 620));
        SalesBg.setMinimumSize(new java.awt.Dimension(800, 620));
        SalesBg.setPreferredSize(new java.awt.Dimension(800, 620));
        getContentPane().add(SalesBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(HiddenDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InventoryHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryHomeActionPerformed
        dispose();
        MenuFrame Open = new MenuFrame();
        Open.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_InventoryHomeActionPerformed

    private void SalesSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesSearchMouseReleased
       SalesSearch.setText("");
    }//GEN-LAST:event_SalesSearchMouseReleased

    private void SalesSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalesSearchKeyReleased
        String Product = SalesSearch.getText();
        try{
            
            String sqlQuery = "Select * from sales where product like '%"+Product+"%' or CustomerName like '%"+Product+"%' or date like '%"+Product+"%'";
            pst=conn.prepareStatement(sqlQuery);
            rs=pst.executeQuery();
            SalesTransactionTable.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                rs.close();
                pst.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }//GEN-LAST:event_SalesSearchKeyReleased

    private void SalesUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesUpdateActionPerformed
    FrameInventory();
    }//GEN-LAST:event_SalesUpdateActionPerformed

    private void SalesSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalesSearchActionPerformed

    private void SalesExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesExportActionPerformed
//
//        String filedir = "Sales Data Sheet, Date Exported:"+HiddenDate.getText()+".csv";
//        File file = new File(filedir);
//        toExcel(SalesTransactionTable, file);
//      JOptionPane.showMessageDialog(null, "File Saved");
//      System.out.println(SalesTransactionTable);
      
        String filedir = "Sales Data Sheet("+HiddenDate.getText()+").csv";
        File file = new File(filedir);
        toExcel(SalesTransactionTable, file);
      JOptionPane.showMessageDialog(null, "File Saved");
    }//GEN-LAST:event_SalesExportActionPerformed

    private void PaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaidActionPerformed

    private void SalesTransactionTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesTransactionTableMouseReleased
   try
        {
            
            int row = SalesTransactionTable.getSelectedRow();
            String clickedRow = (SalesTransactionTable.getModel().getValueAt(row,0).toString());
            
            String sqlQuery = "select Totals,Balance from Sales where transactionnumber = '" + clickedRow + "'";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();

            if(rs.next())
            {
                String first = rs.getString("Totals");
                Paid.setText(first);
                String last = rs.getString("Balance");
                Balance.setText(last);

            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }  
    }//GEN-LAST:event_SalesTransactionTableMouseReleased

    private void UpdateBalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UpdateBalanceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double OB = Double.parseDouble(Balance.getText());
            double NB = Double.parseDouble(UpdateBalance.getText());
            double NEWB = OB - NB;
            if(NB >= OB){
            NewBalance.setText(Double.valueOf("0").toString());
            update.requestFocusInWindow();
            }
            else {
            NewBalance.setText(Double.valueOf(NEWB).toString());
            update.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_UpdateBalanceKeyPressed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        Paid.setText("0");
        Balance.setText("0");
        UpdateBalance.setText("0");
        NewBalance.setText("0");
        UpdatePanel.setVisible(false);
        Paid.setVisible(false);
        Balance.setVisible(false);
        UpdateBalance.setVisible(false);
        NewBalance.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(false);
        Paid.setEnabled(false);
        Balance.setEnabled(false);
        UpdateBalance.setEnabled(false);
        NewBalance.setEnabled(false);
        update.setEnabled(false);
        cancel.setEnabled(false);
        Payment.setVisible(true);
        Payment.setEnabled(true);
    }//GEN-LAST:event_cancelActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try{
            int row = SalesTransactionTable.getSelectedRow();
            String clickedRow = (SalesTransactionTable.getModel().getValueAt(row,0).toString());
            double NB = Double.parseDouble(NewBalance.getText());
            String Customer = (SalesTransactionTable.getModel().getValueAt(row, 1).toString());
            if(NB == 0){
               String sqlQuery = "update Sales set balance = '" + NB + "' where transactionnumber = '" + clickedRow + "'";
               pst = conn.prepareStatement(sqlQuery);
               pst.execute();
               JOptionPane.showMessageDialog(null, "Mr./Ms."+Customer +"Paid all balance remaining \n","Balance Payment ",JOptionPane.INFORMATION_MESSAGE);
        Paid.setText("0");
        Balance.setText("0");
        UpdateBalance.setText("0");
        NewBalance.setText("0");
        UpdatePanel.setVisible(false);
        Paid.setVisible(false);
        Balance.setVisible(false);
        UpdateBalance.setVisible(false);
        NewBalance.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(false);
        Paid.setEnabled(false);
        Balance.setEnabled(false);
        UpdateBalance.setEnabled(false);
        NewBalance.setEnabled(false);
        update.setEnabled(false);
        cancel.setEnabled(false);
        Payment.setVisible(true);
        Payment.setEnabled(true);
        String sqlQuery1 = "update totals set balance = '" + NB + "' where transactionumber = '" + clickedRow + "'";
        pst1 = conn.prepareStatement(sqlQuery1);
        pst1.execute();
            }
            else{

               String sqlQuery = "update Sales set balance = '" + NB + "' where transactionnumber = '" + clickedRow + "'";
               pst = conn.prepareStatement(sqlQuery);
               pst.execute();
               JOptionPane.showMessageDialog(null, "Mr./Ms. "+Customer+" Still Has Balance of "+ NB+" Pesos","Balance Payment ",JOptionPane.INFORMATION_MESSAGE);
               String sqlQuery1 = "update totals set balance = '" + NB + "' where transactionumber = '" + clickedRow + "'";
               pst1 = conn.prepareStatement(sqlQuery1);
               pst1.execute();
            }
                Paid.setText("0");
        Balance.setText("0");
        UpdateBalance.setText("0");
        NewBalance.setText("0");
        UpdatePanel.setVisible(false);
        Paid.setVisible(false);
        Balance.setVisible(false);
        UpdateBalance.setVisible(false);
        NewBalance.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(false);
        Paid.setEnabled(false);
        Balance.setEnabled(false);
        UpdateBalance.setEnabled(false);
        NewBalance.setEnabled(false);
        update.setEnabled(false);
        cancel.setEnabled(false);
        Payment.setVisible(true);
        Payment.setEnabled(true);    

        }
        catch(Exception e){
         //  JOptionPane.showMessageDialog(null, "Error");

                }
        finally
        {
            try
            {
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentActionPerformed
        UpdatePanel.setVisible(true);
        UpdatePanel.setEnabled(true);
        Paid.setVisible(true);
        Balance.setVisible(true);
        UpdateBalance.setVisible(true);
        NewBalance.setVisible(true);
        update.setVisible(true);
        cancel.setVisible(true);
        Paid.setEnabled(true);
        Balance.setEnabled(true);
        UpdateBalance.setEnabled(true);
        NewBalance.setEnabled(true);
        update.setEnabled(true);
        cancel.setEnabled(true);
        Payment.setVisible(false);
        Payment.setEnabled(false);
    }//GEN-LAST:event_PaymentActionPerformed

    private void UpdateBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBalanceActionPerformed

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
            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Balance;
    private javax.swing.JLabel HiddenDate;
    private javax.swing.JButton InventoryHome;
    private javax.swing.JTextField NewBalance;
    private javax.swing.JTextField Paid;
    private javax.swing.JButton Payment;
    private javax.swing.JLabel SalesBg;
    private javax.swing.JButton SalesExport;
    private javax.swing.JLabel SalesLabel4;
    private javax.swing.JTextField SalesSearch;
    private javax.swing.JTable SalesTransactionTable;
    private javax.swing.JButton SalesUpdate;
    private javax.swing.JTextField UpdateBalance;
    private javax.swing.JPanel UpdatePanel;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables


}
