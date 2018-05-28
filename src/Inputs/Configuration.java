/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import Frame.MenuFrame;
import java.awt.*;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author takajima
 */
public class Configuration extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Configuration
     */
    public Configuration() {
        initComponents();
        conn = DataBase.sqliteConnect.connectorDB();
        UpdateTable();
        WorkersBtnUpdate.setEnabled(false);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

                try{
            String sqlQuery = "select * from Administrator";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            if (rs.next()){
                String txtFirstValue = rs.getString("FirstName");
                first.setText(txtFirstValue);
                String txtLastValue = rs.getString("LastName");
                last.setText(txtLastValue);
                String txtAgeValue= rs.getString("UserName");
                user.setText(txtAgeValue);
                String password= rs.getString("Password");
                pass.setText(password);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
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
    private void UpdateTable(){
        
        try
        {
            String sqlQuery = "select * from Workers";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            WorkersTable.setModel(DbUtils.resultSetToTableModel(rs));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConfigurePage = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ConfigurationBtnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        user = new javax.swing.JTextField();
        last = new javax.swing.JTextField();
        first = new javax.swing.JTextField();
        ConfigurationLabel = new javax.swing.JLabel();
        ConfigurationBg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        WorkersBtnSave1 = new javax.swing.JButton();
        WorkersBtnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        WorkersTable = new javax.swing.JTable();
        WorkersBtnUpdate = new javax.swing.JButton();
        WorkersNumber = new javax.swing.JLabel();
        WorkerContact = new javax.swing.JTextField();
        WorkersLastName = new javax.swing.JLabel();
        WorkerLast = new javax.swing.JTextField();
        Workerfirst = new javax.swing.JTextField();
        WorkersFirstName = new javax.swing.JLabel();
        ConfigurationBg2 = new javax.swing.JLabel();
        workerid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        ConfigurePage.setMinimumSize(new java.awt.Dimension(525, 658));
        ConfigurePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ConfigurePageMouseReleased(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ConfigurationBtnUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ConfigurationBtnUpdate.setText("Update Data");
        ConfigurationBtnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ConfigurationBtnUpdateMouseReleased(evt);
            }
        });
        ConfigurationBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigurationBtnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(ConfigurationBtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 110, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        pass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 240, 40));

        user.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 240, 40));

        last.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 240, 40));

        first.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstActionPerformed(evt);
            }
        });
        jPanel1.add(first, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 240, 40));

        ConfigurationLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ConfigurationLabel.setForeground(new java.awt.Color(255, 255, 255));
        ConfigurationLabel.setText("Change Credentials");
        jPanel1.add(ConfigurationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        ConfigurationBg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ConfigurationBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        ConfigurationBg.setMaximumSize(new java.awt.Dimension(500, 500));
        ConfigurationBg.setMinimumSize(new java.awt.Dimension(500, 500));
        ConfigurationBg.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.add(ConfigurationBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, -30, 500, 500));

        ConfigurePage.addTab("Change Personal Data", jPanel1);

        jPanel2.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel2.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 380, 80, 50));

        WorkersBtnSave1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkersBtnSave1.setText("Clear");
        WorkersBtnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkersBtnSave1ActionPerformed(evt);
            }
        });
        jPanel2.add(WorkersBtnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 80, 50));

        WorkersBtnSave.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkersBtnSave.setText("Save");
        WorkersBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkersBtnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(WorkersBtnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 80, 50));

        WorkersTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        WorkersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "FirstName", "LastName", "ContactNo."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        WorkersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                WorkersTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(WorkersTable);
        if (WorkersTable.getColumnModel().getColumnCount() > 0) {
            WorkersTable.getColumnModel().getColumn(0).setResizable(false);
            WorkersTable.getColumnModel().getColumn(1).setResizable(false);
            WorkersTable.getColumnModel().getColumn(2).setResizable(false);
            WorkersTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 475, 90));

        WorkersBtnUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkersBtnUpdate.setText("Update");
        WorkersBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkersBtnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(WorkersBtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 80, 50));

        WorkersNumber.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkersNumber.setForeground(new java.awt.Color(255, 255, 255));
        WorkersNumber.setText("Contact # :");
        jPanel2.add(WorkersNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 80, 40));

        WorkerContact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(WorkerContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 290, 40));

        WorkersLastName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkersLastName.setForeground(new java.awt.Color(255, 255, 255));
        WorkersLastName.setText("Last Name :");
        jPanel2.add(WorkersLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 80, 40));

        WorkerLast.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkerLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkerLastActionPerformed(evt);
            }
        });
        jPanel2.add(WorkerLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 290, 40));

        Workerfirst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Workerfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkerfirstActionPerformed(evt);
            }
        });
        jPanel2.add(Workerfirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 290, 40));

        WorkersFirstName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        WorkersFirstName.setForeground(new java.awt.Color(255, 255, 255));
        WorkersFirstName.setText("First Name :");
        jPanel2.add(WorkersFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 80, 40));

        ConfigurationBg2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ConfigurationBg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        ConfigurationBg2.setMaximumSize(new java.awt.Dimension(500, 500));
        ConfigurationBg2.setMinimumSize(new java.awt.Dimension(500, 500));
        ConfigurationBg2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel2.add(ConfigurationBg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 500, 500));

        workerid.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(workerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        ConfigurePage.addTab("Employed Workers", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ConfigurePage, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ConfigurePage, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void WorkerfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkerfirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WorkerfirstActionPerformed

    private void WorkerLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkerLastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WorkerLastActionPerformed

    private void ConfigurationBtnUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfigurationBtnUpdateMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfigurationBtnUpdateMouseReleased

    private void ConfigurationBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigurationBtnUpdateActionPerformed
         try{
        String sqlQuery = "update Administrator set FirstName ='"+first.getText()+"',"
                + "LastName='"+last.getText()+"',"
                + "UserName='"+user.getText()+"',"
                + "Password='"+pass.getText()+"' where rowid ='1'";
        pst = conn.prepareStatement(sqlQuery);
        pst.execute();
        JOptionPane.showMessageDialog(null, "The account has been modified and saved!","Account message",JOptionPane.INFORMATION_MESSAGE);
        WorkersBtnUpdate.setEnabled(false);
         }
        catch(Exception e){
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
            
        UpdateTable();
        }
    }//GEN-LAST:event_ConfigurationBtnUpdateActionPerformed

    private void WorkersBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkersBtnUpdateActionPerformed

         try{
        String sqlQuery = "update Workers set FirstName = '" + Workerfirst.getText() + "', LastName = '" + WorkerLast.getText()  + "', ContactNumber = '" + WorkerContact.getText() + "' where id = '" + workerid.getText() + "'";
        pst = conn.prepareStatement(sqlQuery);
        pst.execute();
        JOptionPane.showMessageDialog(null, "The account has been modified and saved!","Account message",JOptionPane.INFORMATION_MESSAGE);
        WorkersBtnUpdate.setEnabled(false);
         }
        catch(Exception e){
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
            
        UpdateTable();
        }
    }//GEN-LAST:event_WorkersBtnUpdateActionPerformed

    private void ConfigurePageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfigurePageMouseReleased

    }//GEN-LAST:event_ConfigurePageMouseReleased

    private void WorkersTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WorkersTableMouseReleased
        WorkersBtnUpdate.setEnabled(true);
        try
        {
            
            int row = WorkersTable.getSelectedRow();
            String clickedRow = (WorkersTable.getModel().getValueAt(row,0).toString());
            
            String sqlQuery = "select * from Workers where id = '" + clickedRow + "'";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();

            if(rs.next())
            {
                String Id    = rs.getString("Id");
                workerid.setText(Id);
                String first = rs.getString("FirstName");
                Workerfirst.setText(first);
                String last  = rs.getString("LastName");
                WorkerLast.setText(last);
                String userName = rs.getString("ContactNumber");
                WorkerContact.setText(userName);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_WorkersTableMouseReleased

    private void WorkersBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkersBtnSaveActionPerformed
        try{
            String sqlQuery = "insert into Workers(FirstName ,LastName ,ContactNumber ) values(?,?,?)";
            pst = conn.prepareStatement(sqlQuery);
          //pst.setString(1, workerid.getText());
            pst.setString(1, Workerfirst.getText());
            pst.setString(2, WorkerLast.getText());
            pst.setString(3, WorkerContact.getText());
            pst.execute();

          JOptionPane.showMessageDialog(null, "New Worker Added","Workers ",JOptionPane.INFORMATION_MESSAGE);
       // workerid.setText("");
          Workerfirst.setText("");
          WorkerLast.setText("");
          WorkerContact.setText("");
        }
        catch(Exception e){
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
            
        UpdateTable();
        }
    }//GEN-LAST:event_WorkersBtnSaveActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        MenuFrame open = new MenuFrame();
        open.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void WorkersBtnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkersBtnSave1ActionPerformed
       Workerfirst.setText("");
       WorkerLast.setText("");
       WorkerContact.setText("");
    }//GEN-LAST:event_WorkersBtnSave1ActionPerformed

    private void firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "This will Permanently Delete The Employee '"+"\n"+"' Continue?","Warning",JOptionPane.YES_NO_OPTION);
        
        if(p==0)
        {
            String sqlQuery = "DELETE from Workers where firstname =?";
            try{
                pst = conn.prepareStatement(sqlQuery);
                pst.setString(1, Workerfirst.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Record Deleted");   
       Workerfirst.setText("");
       WorkerLast.setText("");
       WorkerContact.setText("");

            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "No employee to be deleted");
                           UpdateTable();
           }
            finally{
                        try{
                rs.close();
                pst.close();
                UpdateTable();
        }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
      
        }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConfigurationBg;
    private javax.swing.JLabel ConfigurationBg2;
    private javax.swing.JButton ConfigurationBtnUpdate;
    private javax.swing.JLabel ConfigurationLabel;
    private javax.swing.JTabbedPane ConfigurePage;
    private javax.swing.JTextField WorkerContact;
    private javax.swing.JTextField WorkerLast;
    private javax.swing.JTextField Workerfirst;
    private javax.swing.JButton WorkersBtnSave;
    private javax.swing.JButton WorkersBtnSave1;
    private javax.swing.JButton WorkersBtnUpdate;
    private javax.swing.JLabel WorkersFirstName;
    private javax.swing.JLabel WorkersLastName;
    private javax.swing.JLabel WorkersNumber;
    private javax.swing.JTable WorkersTable;
    private javax.swing.JTextField first;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField last;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    private javax.swing.JLabel workerid;
    // End of variables declaration//GEN-END:variables
}