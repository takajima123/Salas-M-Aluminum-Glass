/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author takajima
 */
public class PosFrame extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst3 = null;
    ResultSet rs = null;

    //Date Picker SYSTEM -------
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    JLabel l = new JLabel("", JLabel.CENTER);
    String day = "";
    JDialog d;
    JButton[] button = new JButton[49];

    ArrayList<String> ppID = new ArrayList<String>();

    public PosFrame() {
        initComponents();
        conn = DataBase.sqliteConnect.connectorDB();
        PosAddPanel.setVisible(false);
        PosCancleAdd.setVisible(false);
        PosCancleAdd.setEnabled(false);
        CurrentDate();
        BoxCategory();
        groupButton();
        FillWorkers();
        ColorCategory();
        TransactionIncrementation();
        PosInventory.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //setDate();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

//Cash**********************
        //Panel
        CashPos.setVisible(false);
        //Label
        CashPosLabel.setVisible(false);
        CashPosLabel1.setVisible(false);
        CashPosLabel2.setVisible(false);
        CashPosLabel3.setVisible(false);
        //Background
        //Textfield
        CashChange.setVisible(false);
        CashPaid.setVisible(false);
        CashTotal.setVisible(false);
        CashWorkerPaid1.setVisible(false);
        CashWorkerPaid2.setVisible(false);
        CashWorkerPaid3.setVisible(false);
        CashWorkerPaid4.setVisible(false);
        CashWorkerPaid5.setVisible(false);
        CashWorkerPaid6.setVisible(false);

        //Buttons
        CashSubmit.setVisible(false);
        CashCancel.setVisible(false);
        //ComboBox
        CashWorker1.setVisible(false);
        CashWorker2.setVisible(false);
        CashWorker3.setVisible(false);
        CashWorker4.setVisible(false);
        CashWorker5.setVisible(false);
        CashWorker6.setVisible(false);
//**************************
//Credit--------------------
        //Panel
        CreditPos.setVisible(false);
        //Label
        CashPosLabel5.setVisible(false);
        CashPosLabel8.setVisible(false);
        CashPosLabel9.setVisible(false);
        CashPosLabel10.setVisible(false);
        CashPosLabel11.setVisible(false);
        CashPosLabel12.setVisible(false);
        CashPosLabel13.setVisible(false);
        //Background
        CashBg1.setVisible(false);
        //Textfield
        creditbalance.setVisible(false);
        creditpay.setVisible(false);
        creditotal.setVisible(false);
        creditprofit.setVisible(false);

        creditday1.setVisible(false);
        creditday2.setVisible(false);
        creditday3.setVisible(false);
        creditday4.setVisible(false);
        creditday5.setVisible(false);
        creditday6.setVisible(false);

        creditday1.setEnabled(false);
        creditday2.setEnabled(false);
        creditday3.setEnabled(false);
        creditday4.setEnabled(false);
        creditday5.setEnabled(false);
        creditday6.setEnabled(false);

        creditworkerpay1.setVisible(false);
        creditworkerpay2.setVisible(false);
        creditworkerpay3.setVisible(false);
        creditworkerpay4.setVisible(false);
        creditworkerpay5.setVisible(false);
        creditworkerpay6.setVisible(false);

        creditworkerpay1.setEnabled(false);
        creditworkerpay2.setEnabled(false);
        creditworkerpay3.setEnabled(false);
        creditworkerpay4.setEnabled(false);
        creditworkerpay5.setEnabled(false);
        creditworkerpay6.setEnabled(false);
        //Buttons
        CashSubmit1.setVisible(false);
        CashCancel1.setVisible(false);
        creditduedate.setVisible(false);
        //ComboBox
        creditworker1.setVisible(false);
        creditworker2.setVisible(false);
        creditworker3.setVisible(false);
        creditworker4.setVisible(false);
        creditworker5.setVisible(false);
        creditworker6.setVisible(false);
//--------------------------
//Check#####################
        //Panel
        CheckPos.setVisible(false);
        //Label
        CheckLabel1.setVisible(false);
        CheckLabel2.setVisible(false);
        CheckLabel3.setVisible(false);
        CheckLabel4.setVisible(false);
        CheckLabel5.setVisible(false);
        CheckLabel6.setVisible(false);
        CheckLabel7.setVisible(false);
        CheckLabel8.setVisible(false);
        //Background
        CheckBg.setVisible(false);
        //Textfield
        CheckWorker1.setVisible(false);
        CheckWorker2.setVisible(false);
        CheckWorker3.setVisible(false);
        CheckWorker4.setVisible(false);
        CheckWorker5.setVisible(false);
        CheckWorker6.setVisible(false);

        CheckWorkerPay1.setVisible(false);
        CheckWorkerPay2.setVisible(false);
        CheckWorkerPay3.setVisible(false);
        CheckWorkerPay4.setVisible(false);
        CheckWorkerPay5.setVisible(false);
        CheckWorkerPay6.setVisible(false);

        Checkday1.setVisible(false);
        Checkday2.setVisible(false);
        Checkday3.setVisible(false);
        Checkday4.setVisible(false);
        Checkday5.setVisible(false);
        Checkday6.setVisible(false);

        CheckWorkerPay1.setEnabled(false);
        CheckWorkerPay2.setEnabled(false);
        CheckWorkerPay3.setEnabled(false);
        CheckWorkerPay4.setEnabled(false);
        CheckWorkerPay5.setEnabled(false);
        CheckWorkerPay6.setEnabled(false);

        Checkday1.setEnabled(false);
        Checkday2.setEnabled(false);
        Checkday3.setEnabled(false);
        Checkday4.setEnabled(false);
        Checkday5.setEnabled(false);
        Checkday6.setEnabled(false);
//##########################

    }

    public void CurrentDate() {
DecimalFormat mFormat= new DecimalFormat("00");
mFormat.format(Double.valueOf(year));
        Calendar cal = new GregorianCalendar();
        int mm = cal.get(Calendar.MONTH);
        int yyyy = cal.get(Calendar.YEAR);
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        PosDate.setText("" + dd + '-' + mFormat.format(Double.valueOf(mm + 1)) + '-' + yyyy);
        CheckDueDateLabel.setText("" + dd + '-' + mFormat.format(Double.valueOf(mm + 1)) + '-' + yyyy);
        CashDueDateLabel.setText("" + dd + '-' + mFormat.format(Double.valueOf(mm + 1)) + '-' + yyyy);
        creditduedatelabel.setText("" + dd + '-' + mFormat.format(Double.valueOf(mm + 1)) + '-' + yyyy);
    }

    private void BoxCategory() {
        try {
            String sqlQuery = "SELECT  Category from Inventory group by category";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("Category");
                if (cat != null) {
                    PosCategory.addItem(cat);
                }
            }

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

    private void groupButton() {

        ButtonGroup bg1 = new ButtonGroup();

        bg1.add(PosRbtCheck);
        bg1.add(PosRbtCash);
        bg1.add(PosRbtCredit);

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

    private void FillWorkers() {
        try {
            String sqlQuery = "SELECT  FirstName from Workers";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("FirstName");
                if (cat != null) {
                    CashWorker1.addItem(cat);
                    CashWorker2.addItem(cat);
                    CashWorker3.addItem(cat);
                    CashWorker4.addItem(cat);
                    CashWorker5.addItem(cat);
                    CashWorker6.addItem(cat);

                    CheckWorker1.addItem(cat);
                    CheckWorker2.addItem(cat);
                    CheckWorker3.addItem(cat);
                    CheckWorker4.addItem(cat);
                    CheckWorker5.addItem(cat);
                    CheckWorker6.addItem(cat);

                    creditworker1.addItem(cat);
                    creditworker2.addItem(cat);
                    creditworker3.addItem(cat);
                    creditworker4.addItem(cat);
                    creditworker5.addItem(cat);
                    creditworker6.addItem(cat);
                }
            }

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

    private void ColorCategory() {
        try {
            String sqlQuery = "select  HA, A , SW , B , C , W , G , MF , nocolor  from Inventory";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            PosInventoryColor.addItem("HA");
            PosInventoryColor.addItem("A");
            PosInventoryColor.addItem("SW");
            PosInventoryColor.addItem("B");
            PosInventoryColor.addItem("C");
            PosInventoryColor.addItem("W");
            PosInventoryColor.addItem("G");
            PosInventoryColor.addItem("MF");
            PosInventoryColor.addItem("NoColor");

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

    private void TransactionIncrementation() {
        try {
            String SqlQuery = "Select TransactionNumber from Sales ";
            pst = conn.prepareStatement(SqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                Integer total = (rs.getInt("TransactionNumber") + 1);
                String Stotal = Integer.toString(total);
                PosTransaction.setText(Stotal);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CheckPos = new javax.swing.JPanel();
        CheckPaydeliveryFee = new javax.swing.JTextField();
        CheckLabel10 = new javax.swing.JLabel();
        CheckPayChange = new javax.swing.JTextField();
        CheckLabel9 = new javax.swing.JLabel();
        Checkday1 = new javax.swing.JTextField();
        Checkday2 = new javax.swing.JTextField();
        Checkday3 = new javax.swing.JTextField();
        Checkday4 = new javax.swing.JTextField();
        Checkday5 = new javax.swing.JTextField();
        Checkday6 = new javax.swing.JTextField();
        CheckPayProfit = new javax.swing.JTextField();
        CheckLabel8 = new javax.swing.JLabel();
        CheckDueDate = new javax.swing.JButton();
        CheckDueDateLabel1 = new javax.swing.JLabel();
        CheckDueDateLabel = new javax.swing.JLabel();
        CheckPayTotal = new javax.swing.JTextField();
        CheckLabel7 = new javax.swing.JLabel();
        CheckDUe = new javax.swing.JButton();
        CheckLabel4 = new javax.swing.JLabel();
        CheckPayNo = new javax.swing.JTextField();
        CheckLabel5 = new javax.swing.JLabel();
        CheckPayBank = new javax.swing.JTextField();
        CheckSubmit = new javax.swing.JButton();
        CheckCanel = new javax.swing.JButton();
        CheckPayAmount = new javax.swing.JTextField();
        CheckLabel6 = new javax.swing.JLabel();
        CheckWorker6 = new javax.swing.JComboBox();
        CheckWorkerPay6 = new javax.swing.JTextField();
        CheckWorkerPay5 = new javax.swing.JTextField();
        CheckWorker5 = new javax.swing.JComboBox();
        CheckWorkerPay4 = new javax.swing.JTextField();
        CheckWorker4 = new javax.swing.JComboBox();
        CheckWorker2 = new javax.swing.JComboBox();
        CheckWorkerPay3 = new javax.swing.JTextField();
        CheckWorkerPay2 = new javax.swing.JTextField();
        CheckWorker3 = new javax.swing.JComboBox();
        CheckWorkerPay1 = new javax.swing.JTextField();
        CheckWorker1 = new javax.swing.JComboBox();
        CheckLabel3 = new javax.swing.JLabel();
        CheckLabel2 = new javax.swing.JLabel();
        CheckLabel1 = new javax.swing.JLabel();
        CheckBg = new javax.swing.JLabel();
        CreditPos = new javax.swing.JPanel();
        creditDelivery = new javax.swing.JTextField();
        CashPosLabel14 = new javax.swing.JLabel();
        creditday5 = new javax.swing.JTextField();
        creditday6 = new javax.swing.JTextField();
        creditday4 = new javax.swing.JTextField();
        creditday3 = new javax.swing.JTextField();
        creditday2 = new javax.swing.JTextField();
        creditday1 = new javax.swing.JTextField();
        creditprofit = new javax.swing.JTextField();
        CashPosLabel5 = new javax.swing.JLabel();
        CashPosLabel8 = new javax.swing.JLabel();
        creditduedatelabel = new javax.swing.JLabel();
        creditduedate = new javax.swing.JButton();
        creditworkerpay2 = new javax.swing.JTextField();
        creditworkerpay6 = new javax.swing.JTextField();
        creditworkerpay3 = new javax.swing.JTextField();
        creditworkerpay4 = new javax.swing.JTextField();
        creditworkerpay5 = new javax.swing.JTextField();
        creditworkerpay1 = new javax.swing.JTextField();
        creditworker2 = new javax.swing.JComboBox();
        creditworker3 = new javax.swing.JComboBox();
        creditworker4 = new javax.swing.JComboBox();
        creditworker5 = new javax.swing.JComboBox();
        creditworker6 = new javax.swing.JComboBox();
        creditworker1 = new javax.swing.JComboBox();
        CashPosLabel9 = new javax.swing.JLabel();
        CashPosLabel10 = new javax.swing.JLabel();
        creditbalance = new javax.swing.JTextField();
        creditotal = new javax.swing.JTextField();
        CashPosLabel11 = new javax.swing.JLabel();
        CashPosLabel12 = new javax.swing.JLabel();
        CashPosLabel13 = new javax.swing.JLabel();
        creditpay = new javax.swing.JTextField();
        CashCancel1 = new javax.swing.JButton();
        CashSubmit1 = new javax.swing.JButton();
        CashBg1 = new javax.swing.JLabel();
        CashPos = new javax.swing.JPanel();
        CashPosLabel15 = new javax.swing.JLabel();
        cashDelivery = new javax.swing.JTextField();
        Cashday5 = new javax.swing.JTextField();
        Cashday6 = new javax.swing.JTextField();
        Cashday4 = new javax.swing.JTextField();
        Cashday3 = new javax.swing.JTextField();
        Cashday2 = new javax.swing.JTextField();
        Cashday1 = new javax.swing.JTextField();
        CashProfit = new javax.swing.JTextField();
        CashPosLabel4 = new javax.swing.JLabel();
        CashPosLabel7 = new javax.swing.JLabel();
        CashDueDateLabel = new javax.swing.JLabel();
        CashDateDUe = new javax.swing.JButton();
        CashWorkerPaid2 = new javax.swing.JTextField();
        CashWorkerPaid6 = new javax.swing.JTextField();
        CashWorkerPaid3 = new javax.swing.JTextField();
        CashWorkerPaid4 = new javax.swing.JTextField();
        CashWorkerPaid5 = new javax.swing.JTextField();
        CashWorkerPaid1 = new javax.swing.JTextField();
        CashWorker2 = new javax.swing.JComboBox();
        CashWorker3 = new javax.swing.JComboBox();
        CashWorker4 = new javax.swing.JComboBox();
        CashWorker5 = new javax.swing.JComboBox();
        CashWorker6 = new javax.swing.JComboBox();
        CashWorker1 = new javax.swing.JComboBox();
        CashPosLabel6 = new javax.swing.JLabel();
        CashPosLabel = new javax.swing.JLabel();
        CashChange = new javax.swing.JTextField();
        CashTotal = new javax.swing.JTextField();
        CashPosLabel1 = new javax.swing.JLabel();
        CashPosLabel2 = new javax.swing.JLabel();
        CashPosLabel3 = new javax.swing.JLabel();
        CashPaid = new javax.swing.JTextField();
        CashCancel = new javax.swing.JButton();
        CashSubmit = new javax.swing.JButton();
        CashBg = new javax.swing.JLabel();
        PosCancleAdd = new javax.swing.JButton();
        PosLabel6 = new javax.swing.JLabel();
        Poshidden = new javax.swing.JLabel();
        RadioButtonPanel = new javax.swing.JPanel();
        PosRbtCheck = new javax.swing.JRadioButton();
        PosRbtCash = new javax.swing.JRadioButton();
        PosRbtCredit = new javax.swing.JRadioButton();
        PosAddPanel = new javax.swing.JPanel();
        PosCategoryLabel1 = new javax.swing.JLabel();
        PosInventoryColor = new javax.swing.JComboBox();
        PosCategoryLabel = new javax.swing.JLabel();
        PosCategory = new javax.swing.JComboBox();
        PosSearchLabel = new javax.swing.JLabel();
        PosSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        PosInventory = new javax.swing.JTable();
        AddQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PosPanel2Background = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PosTable = new javax.swing.JTable();
        PosLabel5 = new javax.swing.JLabel();
        PosContactNumber = new javax.swing.JTextField();
        PosTransaction = new javax.swing.JTextField();
        PosCustomer = new javax.swing.JTextField();
        PosLabel1 = new javax.swing.JLabel();
        PosLabel2 = new javax.swing.JLabel();
        PosDate = new javax.swing.JTextField();
        PosLabel3 = new javax.swing.JLabel();
        PosAdd = new javax.swing.JButton();
        PosRemove = new javax.swing.JButton();
        PosSave = new javax.swing.JButton();
        PosRefresh = new javax.swing.JButton();
        PosLabel4 = new javax.swing.JLabel();
        PosTotalLabel = new javax.swing.JLabel();
        PosHome = new javax.swing.JButton();
        POSBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 620));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CheckPos.setMaximumSize(new java.awt.Dimension(210, 550));
        CheckPos.setMinimumSize(new java.awt.Dimension(210, 550));
        CheckPos.setPreferredSize(new java.awt.Dimension(210, 550));
        CheckPos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CheckPaydeliveryFee.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckPaydeliveryFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPaydeliveryFeeActionPerformed(evt);
            }
        });
        CheckPaydeliveryFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckPaydeliveryFeeKeyPressed(evt);
            }
        });
        CheckPos.add(CheckPaydeliveryFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 90, 30));

        CheckLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckLabel10.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel10.setText("Delivery Fee:");
        CheckPos.add(CheckLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 20));

        CheckPayChange.setEditable(false);
        CheckPayChange.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckPayChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPayChangeActionPerformed(evt);
            }
        });
        CheckPayChange.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckPayChangeKeyReleased(evt);
            }
        });
        CheckPos.add(CheckPayChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 90, 30));

        CheckLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckLabel9.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel9.setText("Change:");
        CheckPos.add(CheckLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, 20));

        Checkday1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Checkday1.setText("1");
        Checkday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Checkday1ActionPerformed(evt);
            }
        });
        Checkday1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Checkday1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Checkday1KeyReleased(evt);
            }
        });
        CheckPos.add(Checkday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 40, 30));

        Checkday2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Checkday2.setText("1");
        Checkday2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Checkday2ActionPerformed(evt);
            }
        });
        Checkday2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Checkday2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Checkday2KeyReleased(evt);
            }
        });
        CheckPos.add(Checkday2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 40, 30));

        Checkday3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Checkday3.setText("1");
        Checkday3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Checkday3ActionPerformed(evt);
            }
        });
        Checkday3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Checkday3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Checkday3KeyReleased(evt);
            }
        });
        CheckPos.add(Checkday3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 40, 30));

        Checkday4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Checkday4.setText("1");
        Checkday4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Checkday4ActionPerformed(evt);
            }
        });
        Checkday4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Checkday4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Checkday4KeyReleased(evt);
            }
        });
        CheckPos.add(Checkday4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 40, 30));

        Checkday5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Checkday5.setText("1");
        Checkday5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Checkday5ActionPerformed(evt);
            }
        });
        Checkday5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Checkday5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Checkday5KeyReleased(evt);
            }
        });
        CheckPos.add(Checkday5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 40, 30));

        Checkday6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Checkday6.setText("1");
        Checkday6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Checkday6ActionPerformed(evt);
            }
        });
        Checkday6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Checkday6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Checkday6KeyReleased(evt);
            }
        });
        CheckPos.add(Checkday6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 40, 30));

        CheckPayProfit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckPayProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPayProfitActionPerformed(evt);
            }
        });
        CheckPayProfit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckPayProfitKeyPressed(evt);
            }
        });
        CheckPos.add(CheckPayProfit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 90, 30));

        CheckLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckLabel8.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel8.setText("Profit :");
        CheckPos.add(CheckLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 10));

        CheckDueDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckDueDate.setText("Issued");
        CheckDueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckDueDateActionPerformed(evt);
            }
        });
        CheckPos.add(CheckDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 80, 20));

        CheckDueDateLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckDueDateLabel1.setForeground(new java.awt.Color(255, 255, 255));
        CheckPos.add(CheckDueDateLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 80, 20));

        CheckDueDateLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckDueDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        CheckPos.add(CheckDueDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 80, 20));

        CheckPayTotal.setEditable(false);
        CheckPayTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckPayTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPayTotalActionPerformed(evt);
            }
        });
        CheckPayTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckPayTotalKeyReleased(evt);
            }
        });
        CheckPos.add(CheckPayTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 90, 30));

        CheckLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckLabel7.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel7.setText("Total Bill:");
        CheckPos.add(CheckLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 10));

        CheckDUe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckDUe.setText("due");
        CheckDUe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckDUeActionPerformed(evt);
            }
        });
        CheckPos.add(CheckDUe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, 20));

        CheckLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckLabel4.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel4.setText("Check No:");
        CheckPos.add(CheckLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, 10));

        CheckPayNo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckPayNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPayNoActionPerformed(evt);
            }
        });
        CheckPayNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckPayNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckPayNoKeyReleased(evt);
            }
        });
        CheckPos.add(CheckPayNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 90, 30));

        CheckLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckLabel5.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel5.setText("Bank :");
        CheckPos.add(CheckLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 10));

        CheckPayBank.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckPayBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPayBankActionPerformed(evt);
            }
        });
        CheckPayBank.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckPayBankKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckPayBankKeyReleased(evt);
            }
        });
        CheckPos.add(CheckPayBank, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 90, 30));

        CheckSubmit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckSubmit.setText("Submit");
        CheckSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckSubmitActionPerformed(evt);
            }
        });
        CheckPos.add(CheckSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 80, -1));

        CheckCanel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckCanel.setText("Cancel");
        CheckCanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckCanelActionPerformed(evt);
            }
        });
        CheckPos.add(CheckCanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 80, -1));

        CheckPayAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckPayAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckPayAmountKeyPressed(evt);
            }
        });
        CheckPos.add(CheckPayAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 90, 30));

        CheckLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckLabel6.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel6.setText("Amount Issued:");
        CheckPos.add(CheckLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, 10));

        CheckWorker6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckWorker6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CheckWorker6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CheckWorker6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CheckWorker6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckWorker6ActionPerformed(evt);
            }
        });
        CheckPos.add(CheckWorker6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, -1));

        CheckWorkerPay6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CheckWorkerPay6.setText("0.00");
        CheckWorkerPay6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckWorkerPay6ActionPerformed(evt);
            }
        });
        CheckWorkerPay6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckWorkerPay6KeyReleased(evt);
            }
        });
        CheckPos.add(CheckWorkerPay6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 40, 30));

        CheckWorkerPay5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CheckWorkerPay5.setText("0.00");
        CheckWorkerPay5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckWorkerPay5ActionPerformed(evt);
            }
        });
        CheckWorkerPay5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckWorkerPay5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckWorkerPay5KeyReleased(evt);
            }
        });
        CheckPos.add(CheckWorkerPay5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 40, 30));

        CheckWorker5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckWorker5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CheckWorker5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CheckWorker5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CheckPos.add(CheckWorker5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 90, -1));

        CheckWorkerPay4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CheckWorkerPay4.setText("0.00");
        CheckWorkerPay4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckWorkerPay4ActionPerformed(evt);
            }
        });
        CheckWorkerPay4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckWorkerPay4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckWorkerPay4KeyReleased(evt);
            }
        });
        CheckPos.add(CheckWorkerPay4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 40, 30));

        CheckWorker4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckWorker4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CheckWorker4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CheckWorker4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CheckPos.add(CheckWorker4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 90, -1));

        CheckWorker2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckWorker2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CheckWorker2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CheckWorker2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CheckPos.add(CheckWorker2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, -1));

        CheckWorkerPay3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CheckWorkerPay3.setText("0.00");
        CheckWorkerPay3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckWorkerPay3ActionPerformed(evt);
            }
        });
        CheckWorkerPay3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckWorkerPay3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckWorkerPay3KeyReleased(evt);
            }
        });
        CheckPos.add(CheckWorkerPay3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 40, 30));

        CheckWorkerPay2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CheckWorkerPay2.setText("0.00");
        CheckWorkerPay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckWorkerPay2ActionPerformed(evt);
            }
        });
        CheckWorkerPay2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckWorkerPay2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckWorkerPay2KeyReleased(evt);
            }
        });
        CheckPos.add(CheckWorkerPay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 40, 30));

        CheckWorker3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckWorker3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CheckWorker3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CheckWorker3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CheckWorker3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckWorker3ActionPerformed(evt);
            }
        });
        CheckPos.add(CheckWorker3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, -1));

        CheckWorkerPay1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CheckWorkerPay1.setText("0.00");
        CheckWorkerPay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckWorkerPay1ActionPerformed(evt);
            }
        });
        CheckWorkerPay1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckWorkerPay1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CheckWorkerPay1KeyReleased(evt);
            }
        });
        CheckPos.add(CheckWorkerPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 40, 30));

        CheckWorker1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckWorker1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CheckWorker1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CheckWorker1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CheckPos.add(CheckWorker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        CheckLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckLabel3.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel3.setText("Salry");
        CheckPos.add(CheckLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        CheckLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckLabel2.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel2.setText("Employee");
        CheckPos.add(CheckLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 20));

        CheckLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckLabel1.setForeground(new java.awt.Color(255, 255, 255));
        CheckLabel1.setText("Payment");
        CheckPos.add(CheckLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        CheckBg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CheckBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        CheckBg.setMaximumSize(new java.awt.Dimension(800, 620));
        CheckBg.setMinimumSize(new java.awt.Dimension(800, 620));
        CheckBg.setPreferredSize(new java.awt.Dimension(800, 620));
        CheckPos.add(CheckBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-700, -90, 900, 700));

        getContentPane().add(CheckPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 190, 550));

        CreditPos.setLayout(null);

        creditDelivery.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        creditDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditDeliveryActionPerformed(evt);
            }
        });
        creditDelivery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditDeliveryKeyPressed(evt);
            }
        });
        CreditPos.add(creditDelivery);
        creditDelivery.setBounds(90, 320, 90, 30);

        CashPosLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel14.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel14.setText("Delivery Fee :");
        CreditPos.add(CashPosLabel14);
        CashPosLabel14.setBounds(10, 330, 90, 20);

        creditday5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditday5.setText("1");
        creditday5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditday5KeyPressed(evt);
            }
        });
        CreditPos.add(creditday5);
        creditday5.setBounds(160, 170, 30, 30);

        creditday6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditday6.setText("1");
        creditday6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditday6KeyPressed(evt);
            }
        });
        CreditPos.add(creditday6);
        creditday6.setBounds(160, 200, 30, 30);

        creditday4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditday4.setText("1");
        creditday4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditday4KeyPressed(evt);
            }
        });
        CreditPos.add(creditday4);
        creditday4.setBounds(160, 140, 30, 30);

        creditday3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditday3.setText("1");
        creditday3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditday3KeyPressed(evt);
            }
        });
        CreditPos.add(creditday3);
        creditday3.setBounds(160, 110, 30, 30);

        creditday2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditday2.setText("1");
        creditday2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditday2KeyPressed(evt);
            }
        });
        CreditPos.add(creditday2);
        creditday2.setBounds(160, 80, 30, 30);

        creditday1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditday1.setText("1");
        creditday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditday1ActionPerformed(evt);
            }
        });
        creditday1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditday1KeyPressed(evt);
            }
        });
        CreditPos.add(creditday1);
        creditday1.setBounds(160, 50, 30, 30);

        creditprofit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        creditprofit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditprofitKeyPressed(evt);
            }
        });
        CreditPos.add(creditprofit);
        creditprofit.setBounds(90, 360, 90, 30);

        CashPosLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel5.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel5.setText("Profit :");
        CreditPos.add(CashPosLabel5);
        CashPosLabel5.setBounds(50, 370, 56, 20);

        CashPosLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashPosLabel8.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel8.setText("Employee");
        CreditPos.add(CashPosLabel8);
        CashPosLabel8.setBounds(30, 30, 62, 17);

        creditduedatelabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        creditduedatelabel.setForeground(new java.awt.Color(255, 255, 255));
        CreditPos.add(creditduedatelabel);
        creditduedatelabel.setBounds(90, 240, 90, 50);

        creditduedate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        creditduedate.setText("Due");
        creditduedate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditduedateActionPerformed(evt);
            }
        });
        CreditPos.add(creditduedate);
        creditduedate.setBounds(10, 245, 70, 40);

        creditworkerpay2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditworkerpay2.setText("0.0");
        creditworkerpay2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creditworkerpay2KeyReleased(evt);
            }
        });
        CreditPos.add(creditworkerpay2);
        creditworkerpay2.setBounds(110, 80, 40, 30);

        creditworkerpay6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditworkerpay6.setText("0.0");
        creditworkerpay6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creditworkerpay6KeyReleased(evt);
            }
        });
        CreditPos.add(creditworkerpay6);
        creditworkerpay6.setBounds(110, 200, 40, 30);

        creditworkerpay3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditworkerpay3.setText("0.0");
        creditworkerpay3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creditworkerpay3KeyReleased(evt);
            }
        });
        CreditPos.add(creditworkerpay3);
        creditworkerpay3.setBounds(110, 110, 40, 30);

        creditworkerpay4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditworkerpay4.setText("0.0");
        creditworkerpay4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creditworkerpay4KeyReleased(evt);
            }
        });
        CreditPos.add(creditworkerpay4);
        creditworkerpay4.setBounds(110, 140, 40, 30);

        creditworkerpay5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditworkerpay5.setText("0.0");
        creditworkerpay5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creditworkerpay5KeyReleased(evt);
            }
        });
        CreditPos.add(creditworkerpay5);
        creditworkerpay5.setBounds(110, 170, 40, 30);

        creditworkerpay1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        creditworkerpay1.setText("0.0");
        creditworkerpay1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creditworkerpay1KeyReleased(evt);
            }
        });
        CreditPos.add(creditworkerpay1);
        creditworkerpay1.setBounds(110, 50, 40, 30);

        creditworker2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        creditworker2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        creditworker2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                creditworker2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        creditworker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditworker2ActionPerformed(evt);
            }
        });
        CreditPos.add(creditworker2);
        creditworker2.setBounds(10, 80, 90, 30);

        creditworker3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        creditworker3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        creditworker3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                creditworker3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CreditPos.add(creditworker3);
        creditworker3.setBounds(10, 110, 90, 30);

        creditworker4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        creditworker4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        creditworker4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                creditworker4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CreditPos.add(creditworker4);
        creditworker4.setBounds(10, 140, 90, 30);

        creditworker5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        creditworker5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        creditworker5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                creditworker5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CreditPos.add(creditworker5);
        creditworker5.setBounds(10, 170, 90, 30);

        creditworker6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        creditworker6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        creditworker6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                creditworker6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        creditworker6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditworker6ActionPerformed(evt);
            }
        });
        CreditPos.add(creditworker6);
        creditworker6.setBounds(10, 200, 90, 30);

        creditworker1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        creditworker1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        creditworker1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                creditworker1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CreditPos.add(creditworker1);
        creditworker1.setBounds(10, 50, 90, 30);

        CashPosLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashPosLabel9.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel9.setText("Salry");
        CreditPos.add(CashPosLabel9);
        CashPosLabel9.setBounds(130, 30, 32, 17);

        CashPosLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel10.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel10.setText("Amount :");
        CreditPos.add(CashPosLabel10);
        CashPosLabel10.setBounds(30, 410, 48, 20);

        creditbalance.setEditable(false);
        creditbalance.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        creditbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditbalanceActionPerformed(evt);
            }
        });
        CreditPos.add(creditbalance);
        creditbalance.setBounds(90, 480, 90, 30);

        creditotal.setEditable(false);
        creditotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CreditPos.add(creditotal);
        creditotal.setBounds(90, 400, 90, 30);

        CashPosLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel11.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel11.setText("Paid :");
        CreditPos.add(CashPosLabel11);
        CashPosLabel11.setBounds(50, 450, 31, 10);

        CashPosLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel12.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel12.setText("Balance :");
        CreditPos.add(CashPosLabel12);
        CashPosLabel12.setBounds(30, 490, 70, 15);

        CashPosLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashPosLabel13.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel13.setText("Payment");
        CreditPos.add(CashPosLabel13);
        CashPosLabel13.setBounds(70, 10, 55, 17);

        creditpay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        creditpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditpayActionPerformed(evt);
            }
        });
        creditpay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditpayKeyPressed(evt);
            }
        });
        CreditPos.add(creditpay);
        creditpay.setBounds(90, 440, 90, 30);

        CashCancel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashCancel1.setText("Cancel");
        CashCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashCancel1ActionPerformed(evt);
            }
        });
        CreditPos.add(CashCancel1);
        CashCancel1.setBounds(100, 540, 80, 25);

        CashSubmit1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashSubmit1.setText("Submit");
        CashSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashSubmit1ActionPerformed(evt);
            }
        });
        CreditPos.add(CashSubmit1);
        CashSubmit1.setBounds(10, 540, 80, 25);

        CashBg1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashBg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        CashBg1.setMaximumSize(new java.awt.Dimension(800, 620));
        CashBg1.setMinimumSize(new java.awt.Dimension(800, 620));
        CashBg1.setPreferredSize(new java.awt.Dimension(800, 620));
        CreditPos.add(CashBg1);
        CashBg1.setBounds(-700, -60, 900, 700);

        getContentPane().add(CreditPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 190, 580));

        CashPos.setLayout(null);

        CashPosLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel15.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel15.setText("Delivery Fee :");
        CashPos.add(CashPosLabel15);
        CashPosLabel15.setBounds(10, 330, 80, 20);

        cashDelivery.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cashDelivery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cashDeliveryKeyPressed(evt);
            }
        });
        CashPos.add(cashDelivery);
        cashDelivery.setBounds(90, 320, 90, 30);

        Cashday5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Cashday5.setText("1");
        Cashday5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Cashday5KeyPressed(evt);
            }
        });
        CashPos.add(Cashday5);
        Cashday5.setBounds(160, 170, 30, 30);

        Cashday6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Cashday6.setText("1");
        Cashday6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Cashday6KeyPressed(evt);
            }
        });
        CashPos.add(Cashday6);
        Cashday6.setBounds(160, 200, 30, 30);

        Cashday4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Cashday4.setText("1");
        Cashday4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Cashday4KeyPressed(evt);
            }
        });
        CashPos.add(Cashday4);
        Cashday4.setBounds(160, 140, 30, 30);

        Cashday3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Cashday3.setText("1");
        Cashday3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Cashday3KeyPressed(evt);
            }
        });
        CashPos.add(Cashday3);
        Cashday3.setBounds(160, 110, 30, 30);

        Cashday2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Cashday2.setText("1");
        Cashday2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Cashday2KeyPressed(evt);
            }
        });
        CashPos.add(Cashday2);
        Cashday2.setBounds(160, 80, 30, 30);

        Cashday1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Cashday1.setText("1");
        Cashday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cashday1ActionPerformed(evt);
            }
        });
        Cashday1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Cashday1KeyPressed(evt);
            }
        });
        CashPos.add(Cashday1);
        Cashday1.setBounds(160, 50, 30, 30);

        CashProfit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashProfit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CashProfitKeyPressed(evt);
            }
        });
        CashPos.add(CashProfit);
        CashProfit.setBounds(90, 360, 90, 30);

        CashPosLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel4.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel4.setText("Profit :");
        CashPos.add(CashPosLabel4);
        CashPosLabel4.setBounds(50, 370, 56, 20);

        CashPosLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashPosLabel7.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel7.setText("Employee");
        CashPos.add(CashPosLabel7);
        CashPosLabel7.setBounds(30, 30, 62, 17);

        CashDueDateLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashDueDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        CashPos.add(CashDueDateLabel);
        CashDueDateLabel.setBounds(90, 240, 90, 50);

        CashDateDUe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashDateDUe.setText("Due");
        CashDateDUe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashDateDUeActionPerformed(evt);
            }
        });
        CashPos.add(CashDateDUe);
        CashDateDUe.setBounds(10, 245, 70, 40);

        CashWorkerPaid2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CashWorkerPaid2.setText("0.0");
        CashWorkerPaid2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashWorkerPaid2KeyReleased(evt);
            }
        });
        CashPos.add(CashWorkerPaid2);
        CashWorkerPaid2.setBounds(110, 80, 40, 30);

        CashWorkerPaid6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CashWorkerPaid6.setText("0.0");
        CashWorkerPaid6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashWorkerPaid6KeyReleased(evt);
            }
        });
        CashPos.add(CashWorkerPaid6);
        CashWorkerPaid6.setBounds(110, 200, 40, 30);

        CashWorkerPaid3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CashWorkerPaid3.setText("0.0");
        CashWorkerPaid3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashWorkerPaid3KeyReleased(evt);
            }
        });
        CashPos.add(CashWorkerPaid3);
        CashWorkerPaid3.setBounds(110, 110, 40, 30);

        CashWorkerPaid4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CashWorkerPaid4.setText("0.0");
        CashWorkerPaid4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashWorkerPaid4KeyReleased(evt);
            }
        });
        CashPos.add(CashWorkerPaid4);
        CashWorkerPaid4.setBounds(110, 140, 40, 30);

        CashWorkerPaid5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CashWorkerPaid5.setText("0.0");
        CashWorkerPaid5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashWorkerPaid5KeyReleased(evt);
            }
        });
        CashPos.add(CashWorkerPaid5);
        CashWorkerPaid5.setBounds(110, 170, 40, 30);

        CashWorkerPaid1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CashWorkerPaid1.setText("0.0");
        CashWorkerPaid1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashWorkerPaid1KeyReleased(evt);
            }
        });
        CashPos.add(CashWorkerPaid1);
        CashWorkerPaid1.setBounds(110, 50, 40, 30);

        CashWorker2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashWorker2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CashWorker2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CashWorker2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CashWorker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashWorker2ActionPerformed(evt);
            }
        });
        CashPos.add(CashWorker2);
        CashWorker2.setBounds(10, 80, 90, 30);

        CashWorker3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashWorker3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CashWorker3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CashWorker3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CashPos.add(CashWorker3);
        CashWorker3.setBounds(10, 110, 90, 30);

        CashWorker4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashWorker4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CashWorker4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CashWorker4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CashPos.add(CashWorker4);
        CashWorker4.setBounds(10, 140, 90, 30);

        CashWorker5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashWorker5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CashWorker5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CashWorker5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CashPos.add(CashWorker5);
        CashWorker5.setBounds(10, 170, 90, 30);

        CashWorker6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashWorker6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CashWorker6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CashWorker6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CashWorker6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashWorker6ActionPerformed(evt);
            }
        });
        CashPos.add(CashWorker6);
        CashWorker6.setBounds(10, 200, 90, 30);

        CashWorker1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashWorker1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        CashWorker1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CashWorker1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CashPos.add(CashWorker1);
        CashWorker1.setBounds(10, 50, 90, 30);

        CashPosLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashPosLabel6.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel6.setText("Salry");
        CashPos.add(CashPosLabel6);
        CashPosLabel6.setBounds(130, 30, 32, 17);

        CashPosLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel.setText("Amount :");
        CashPos.add(CashPosLabel);
        CashPosLabel.setBounds(30, 410, 48, 20);

        CashChange.setEditable(false);
        CashChange.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashChangeActionPerformed(evt);
            }
        });
        CashPos.add(CashChange);
        CashChange.setBounds(90, 480, 90, 30);

        CashTotal.setEditable(false);
        CashTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPos.add(CashTotal);
        CashTotal.setBounds(90, 400, 90, 30);

        CashPosLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel1.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel1.setText("Paid :");
        CashPos.add(CashPosLabel1);
        CashPosLabel1.setBounds(40, 450, 31, 10);

        CashPosLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPosLabel2.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel2.setText("Change :");
        CashPos.add(CashPosLabel2);
        CashPosLabel2.setBounds(30, 490, 50, 15);

        CashPosLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashPosLabel3.setForeground(new java.awt.Color(255, 255, 255));
        CashPosLabel3.setText("Payment");
        CashPos.add(CashPosLabel3);
        CashPosLabel3.setBounds(70, 10, 55, 17);

        CashPaid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CashPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashPaidActionPerformed(evt);
            }
        });
        CashPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CashPaidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashPaidKeyReleased(evt);
            }
        });
        CashPos.add(CashPaid);
        CashPaid.setBounds(90, 440, 90, 30);

        CashCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashCancel.setText("Cancel");
        CashCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashCancelActionPerformed(evt);
            }
        });
        CashPos.add(CashCancel);
        CashCancel.setBounds(100, 520, 80, 25);

        CashSubmit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashSubmit.setText("Submit");
        CashSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashSubmitActionPerformed(evt);
            }
        });
        CashPos.add(CashSubmit);
        CashSubmit.setBounds(10, 520, 80, 25);

        CashBg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CashBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        CashBg.setMaximumSize(new java.awt.Dimension(800, 620));
        CashBg.setMinimumSize(new java.awt.Dimension(800, 620));
        CashBg.setPreferredSize(new java.awt.Dimension(800, 620));
        CashPos.add(CashBg);
        CashBg.setBounds(-700, -60, 900, 700);

        getContentPane().add(CashPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 190, 580));

        PosCancleAdd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PosCancleAdd.setText("Cancel");
        PosCancleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosCancleAddActionPerformed(evt);
            }
        });
        getContentPane().add(PosCancleAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 170, 70));

        PosLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosLabel6.setForeground(new java.awt.Color(255, 255, 255));
        PosLabel6.setText("Labor Fee:");
        getContentPane().add(PosLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, 90, 31));

        Poshidden.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Poshidden.setForeground(new java.awt.Color(255, 255, 255));
        Poshidden.setText("0.00");
        getContentPane().add(Poshidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 640, 90, 31));

        PosRbtCheck.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosRbtCheck.setText("Check");
        RadioButtonPanel.add(PosRbtCheck);

        PosRbtCash.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosRbtCash.setText("Cash");
        RadioButtonPanel.add(PosRbtCash);

        PosRbtCredit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosRbtCredit.setText("Credit");
        PosRbtCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosRbtCreditActionPerformed(evt);
            }
        });
        RadioButtonPanel.add(PosRbtCredit);

        getContentPane().add(RadioButtonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 640, 210, -1));

        PosAddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PosCategoryLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosCategoryLabel1.setForeground(new java.awt.Color(255, 255, 255));
        PosCategoryLabel1.setText("Color :");
        PosAddPanel.add(PosCategoryLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        PosInventoryColor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PosAddPanel.add(PosInventoryColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 100, 30));

        PosCategoryLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosCategoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        PosCategoryLabel.setText("Search Category :");
        PosAddPanel.add(PosCategoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        PosCategory.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PosCategory.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                PosCategoryPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        PosCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PosCategoryMouseReleased(evt);
            }
        });
        PosCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosCategoryActionPerformed(evt);
            }
        });
        PosAddPanel.add(PosCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 140, 30));

        PosSearchLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosSearchLabel.setForeground(new java.awt.Color(255, 255, 255));
        PosSearchLabel.setText("Search :");
        PosAddPanel.add(PosSearchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        PosSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PosSearch.setText("Enter Product");
        PosSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PosSearchMouseReleased(evt);
            }
        });
        PosSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosSearchActionPerformed(evt);
            }
        });
        PosSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PosSearchKeyReleased(evt);
            }
        });
        PosAddPanel.add(PosSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 30));

        PosInventory.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PosInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PosInventory.getTableHeader().setReorderingAllowed(false);
        PosInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PosInventoryMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(PosInventory);

        PosAddPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 660, 410));

        AddQuantity.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosAddPanel.add(AddQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 120, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quantity :");
        PosAddPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 90, 30));

        PosPanel2Background.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosPanel2Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        PosPanel2Background.setMaximumSize(new java.awt.Dimension(800, 620));
        PosPanel2Background.setMinimumSize(new java.awt.Dimension(800, 620));
        PosPanel2Background.setPreferredSize(new java.awt.Dimension(800, 620));
        PosPanel2Background.setVerifyInputWhenFocusTarget(false);
        PosAddPanel.add(PosPanel2Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -140, 900, 700));

        getContentPane().add(PosAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 680, 490));

        PosTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Category", "Price", "Color", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PosTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(PosTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 680, 490));

        PosLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosLabel5.setForeground(new java.awt.Color(255, 255, 255));
        PosLabel5.setText("Contact Number :");
        getContentPane().add(PosLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 24));

        PosContactNumber.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(PosContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 200, 27));

        PosTransaction.setEditable(false);
        PosTransaction.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosTransaction.setText("1");
        PosTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosTransactionActionPerformed(evt);
            }
        });
        getContentPane().add(PosTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 200, 28));

        PosCustomer.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PosCustomerMouseReleased(evt);
            }
        });
        getContentPane().add(PosCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 200, 27));

        PosLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosLabel1.setForeground(new java.awt.Color(255, 255, 255));
        PosLabel1.setText("Transaction No. :");
        getContentPane().add(PosLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 28));

        PosLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosLabel2.setForeground(new java.awt.Color(255, 255, 255));
        PosLabel2.setText("Customer Name :");
        getContentPane().add(PosLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 24));

        PosDate.setEditable(false);
        PosDate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosDateActionPerformed(evt);
            }
        });
        getContentPane().add(PosDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 140, 28));

        PosLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosLabel3.setForeground(new java.awt.Color(255, 255, 255));
        PosLabel3.setText("Date :");
        getContentPane().add(PosLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 70, 30));

        PosAdd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PosAdd.setText("Add ");
        PosAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosAddActionPerformed(evt);
            }
        });
        getContentPane().add(PosAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 170, 70));
        PosAdd.getAccessibleContext().setAccessibleDescription("");

        PosRemove.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PosRemove.setText("Remove");
        PosRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(PosRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 170, 70));
        PosRemove.getAccessibleContext().setAccessibleDescription("");

        PosSave.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PosSave.setText("Save");
        PosSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosSaveActionPerformed(evt);
            }
        });
        getContentPane().add(PosSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 170, 70));
        PosSave.getAccessibleContext().setAccessibleDescription("");

        PosRefresh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PosRefresh.setText("Clear");
        PosRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(PosRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 170, 70));
        PosRefresh.getAccessibleContext().setAccessibleDescription("");

        PosLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosLabel4.setForeground(new java.awt.Color(255, 255, 255));
        PosLabel4.setText("Sub Total:");
        getContentPane().add(PosLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 90, 31));

        PosTotalLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosTotalLabel.setForeground(new java.awt.Color(255, 255, 255));
        PosTotalLabel.setText("0.00");
        getContentPane().add(PosTotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 640, 90, 31));

        PosHome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PosHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/door13.png"))); // NOI18N
        PosHome.setMaximumSize(new java.awt.Dimension(50, 40));
        PosHome.setMinimumSize(new java.awt.Dimension(50, 40));
        PosHome.setPreferredSize(new java.awt.Dimension(50, 40));
        PosHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosHomeActionPerformed(evt);
            }
        });
        getContentPane().add(PosHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        POSBg.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        POSBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        POSBg.setMaximumSize(new java.awt.Dimension(800, 620));
        POSBg.setMinimumSize(new java.awt.Dimension(800, 620));
        POSBg.setPreferredSize(new java.awt.Dimension(800, 620));
        getContentPane().add(POSBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PosTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosTransactionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PosTransactionActionPerformed

    private void PosDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PosDateActionPerformed

    private void PosHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosHomeActionPerformed
        dispose();
        MenuFrame Open = new MenuFrame();
        Open.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_PosHomeActionPerformed

    private void PosRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosRefreshActionPerformed
//--Clear Table  
        DefaultTableModel model1 = (DefaultTableModel) PosTable.getModel();
        while (model1.getRowCount() > 0) {
            for (int i = 0; i < model1.getRowCount(); i++) {
                model1.removeRow(i);
            }
        }

    }//GEN-LAST:event_PosRefreshActionPerformed

    private void PosAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosAddActionPerformed
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(true);

        try {
            String sqlQuery = "select product, Category , HA, A , SW , B , C , W , G , MF , nocolor , Available , Price,qty from Inventory";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            PosInventory.setModel(DbUtils.resultSetToTableModel(rs));
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

        PosAddPanel.setVisible(true);
        PosCancleAdd.setVisible(true);
        PosCancleAdd.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_PosAddActionPerformed

    private void PosInventoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PosInventoryMouseReleased
////    Add Table
//        DecimalFormat df2 = new DecimalFormat("00.00");
//        TableModel model1 = PosInventory.getModel();
//        int[] indexs = PosInventory.getSelectedRows();
//        int Input = Integer.parseInt(AddQuantity.getText().toString());
//        Object[] row = new Object[6];
//        DefaultTableModel model2 = (DefaultTableModel) PosTable.getModel();
//              for(int i = 0; i < indexs.length; i++)
//        {
//        if(!!AddQuantity.getText().isEmpty() && !!PosInventoryColor.getSelectedItem().toString().isEmpty() ){
//            JOptionPane.showMessageDialog(null, "No Quantity Given Or Color Not yet Selected");
//                }
////          if(PosInventoryColor.getSelectedItem().equals("HA")){
////           if(Integer.parseInt(PosInventory.getValueAt(i, 2).toString()) < Input){
////               JOptionPane.showMessageDialog(null, "go");
////           }   
////           
////          }
//         else
//            {
//            row[0] = model1.getValueAt(indexs [i], 0);
//            row[1] = model1.getValueAt(indexs [i], 1);
//            row[2] = model1.getValueAt(indexs [i], 12);
//            row[3] = PosInventoryColor.getSelectedItem().toString();
//            row[4] = AddQuantity.getText();   
//            row[5] = df2.format(Double.parseDouble(row[2].toString())*Double.parseDouble(AddQuantity.getText()));
//        model2.addRow(row);
//        JOptionPane.showMessageDialog(null, "Product Added to Cart");
//       //-- Panel Dispose
//       jScrollPane1.setVisible(true);
//       jScrollPane2.setVisible(false);
//        PosAddPanel.setVisible(false);
//        AddQuantity.setText("");
//        PosAdd.setVisible(true);
//        PosAdd.setEnabled(true);
//        PosCancleAdd.setEnabled(false);
//        PosCancleAdd.setVisible(false);
//                }
//            
//        }
//    {// ------- Sum 
//    //Sum row format
//        int rowsCount = PosTable.getRowCount();
//        double sum = 0;
//        for(int i = 0; i< rowsCount; i++){
//            sum = sum + Double.parseDouble(PosTable.getValueAt(i, 5).toString());
//     PosTotalLabel.setText(String.valueOf(df2.format(sum)));
//        }
//    }

//        order = amount to order
//        qty   = maxavailable
//        available = on hand
//        color = ha,a,sw,b,c,g,w,mf,nocolor
//    Add Table PLAY SAFE
////        DecimalFormat df2 = new DecimalFormat("00.00");
////        TableModel model1 = PosInventory.getModel();
////        int[] indexs = PosInventory.getSelectedRows();
////        int Input = Integer.parseInt(AddQuantity.getText().toString());
////        Object[] row = new Object[6];
////        DefaultTableModel model2 = (DefaultTableModel) PosTable.getModel();
////        for(int i = 0; i < indexs.length; i++)
////        
////try{
////            int rows = PosInventory.getSelectedRow();
////            String clickedRow = (PosInventory.getModel().getValueAt(rows,0).toString());
////    
////    String sqlQuery = "select product,qty,R,available,ha,a,sw,b,c,g,w,mf,nocolor from inventory where product='"+clickedRow+"'";
////    pst=conn.prepareStatement(sqlQuery);
////    rs=pst.executeQuery();
////
////        while(rs.next()){
////            if(rs.getInt("available") <= Input){
////            JOptionPane.showMessageDialog(null, rs.getString("product") + ", Is Insufficient! Order now!/n Remaining stocks Color of stocks Selected : "
////                    +"\n HA :("+rs.getInt("ha")+")." + "\n"
////                    +"\n A  :("+rs.getInt("a")+")." + "\n"
////                    +"\n SW :("+rs.getInt("sw")+")." + "\n"
////                    +"\n B  :("+rs.getInt("b")+")." + "\n"
////                    +"\n C  :("+rs.getInt("c")+")." + "\n"
////                    +"\n W  :("+rs.getInt("w")+")." + "\n"
////                    +"\n G  :("+rs.getInt("g")+")." + "\n"
////                    +"\n MF :("+rs.getInt("mf")+")." + "\n"
////                    +"\nNoColor:("+rs.getInt("NoColor")+")." + "\n");
////            }
////            if(rs.getInt("Available") > Input){
////            row[0] = model1.getValueAt(indexs [i], 0);
////            row[1] = model1.getValueAt(indexs [i], 1);
////            row[2] = model1.getValueAt(indexs [i], 12);
////            row[3] = PosInventoryColor.getSelectedItem().toString();
////            row[4] = AddQuantity.getText();   
////            row[5] = df2.format(Double.parseDouble(row[2].toString())*Double.parseDouble(AddQuantity.getText()));
////        model2.addRow(row);
////        JOptionPane.showMessageDialog(null, "Product Added to Cart");
////       //-- Panel Dispose
////       jScrollPane1.setVisible(true);
////       jScrollPane2.setVisible(false);
////        PosAddPanel.setVisible(false);
////        AddQuantity.setText("");
////        PosAdd.setVisible(true);
////        PosAdd.setEnabled(true);
////        PosCancleAdd.setEnabled(false);
////        PosCancleAdd.setVisible(false);
////        
////            }
////        }//while----
////}//try----
////    catch(Exception e){
////        JOptionPane.showConfirmDialog(null, e);
////    }//catch----
////            {// ------- Sum 
////    //Sum row format
////        int rowsCount = PosTable.getRowCount();
////        double sum = 0;
////        for(int i = 0; i< rowsCount; i++){
////            sum = sum + Double.parseDouble(PosTable.getValueAt(i, 5).toString());
////     PosTotalLabel.setText(String.valueOf(df2.format(sum)));
////        }
//////    }
//        String HA = String.valueOf(PosInventoryColor.getSelectedItem().equals("ha"));  String ha = String.valueOf(rs.getInt("ha"));
//String A = String.valueOf(PosInventoryColor.getSelectedItem().equals("a"));    String a = String.valueOf(rs.getInt("a"));
//String SW = String.valueOf(PosInventoryColor.getSelectedItem().equals("sw"));  String sw = String.valueOf(rs.getInt("sw"));
//String W = String.valueOf(PosInventoryColor.getSelectedItem().equals("w"));    String w = String.valueOf(rs.getInt("w"));
//String B = String.valueOf(PosInventoryColor.getSelectedItem().equals("b"));    String b = String.valueOf(rs.getInt("b"));
//String C = String.valueOf(PosInventoryColor.getSelectedItem().equals("c"));    String c = String.valueOf(rs.getInt("c"));
//String G = String.valueOf(PosInventoryColor.getSelectedItem().equals("g"));    String g = String.valueOf(rs.getInt("g"));
//String MF = String.valueOf(PosInventoryColor.getSelectedItem().equals("mf"));  String mf = String.valueOf(rs.getInt("mf"));
//String NO = String.valueOf(PosInventoryColor.getSelectedItem().equals("nocolor")); String no = String.valueOf(rs.getInt("nocolor"));
//               
//HA = ha ; A = a ; SW = sw ; W = w ; B = b ; C = c ; G = g ; MF = mf ; NO = no ;
        DecimalFormat df2 = new DecimalFormat("00.00");
        TableModel model1 = PosInventory.getModel();
        int[] indexs = PosInventory.getSelectedRows();
        int Input = Integer.parseInt(AddQuantity.getText().toString());
        Object[] row = new Object[6];
        DefaultTableModel model2 = (DefaultTableModel) PosTable.getModel();
        //    new JScrollPane(PosInventory, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (int i = 0; i < indexs.length; i++) {
            try {
                int rows = PosInventory.getSelectedRow();
                String clickedRow = (PosInventory.getModel().getValueAt(rows, 0).toString());

                String sqlQuery = "select product,qty,R,available,ha,a,sw,b,c,g,w,mf,nocolor from inventory where product='" + clickedRow + "'";
                pst = conn.prepareStatement(sqlQuery);
                rs = pst.executeQuery();

                while (rs.next()) {
                    if (rs.getInt("available") <= rs.getInt("R") || rs.getInt("Available") <= Input) {
                        JOptionPane.showMessageDialog(null, rs.getString("product") + ", Reorder Point At Limit Insufficient Stocks Remaining stocks Color of stocks Selected : "
                                + "\n HA :(" + rs.getInt("ha") + ")." + "\n"
                                + "\n A  :(" + rs.getInt("a") + ")." + "\n"
                                + "\n SW :(" + rs.getInt("sw") + ")." + "\n"
                                + "\n B  :(" + rs.getInt("b") + ")." + "\n"
                                + "\n C  :(" + rs.getInt("c") + ")." + "\n"
                                + "\n W  :(" + rs.getInt("w") + ")." + "\n"
                                + "\n G  :(" + rs.getInt("g") + ")." + "\n"
                                + "\n MF :(" + rs.getInt("mf") + ")." + "\n"
                                + "\nNoColor:(" + rs.getInt("NoColor") + ")." + ""
                                + "\nReOrder Point Value  is (" + rs.getInt("R") + ")");
                    } if (rs.getInt("Available") > Input) {
                        String HA = String.valueOf(PosInventoryColor.getSelectedItem().equals("ha"));
                        String ha = String.valueOf(rs.getInt("ha"));
                        String A = String.valueOf(PosInventoryColor.getSelectedItem().equals("a"));
                        String a = String.valueOf(rs.getInt("a"));
                        String SW = String.valueOf(PosInventoryColor.getSelectedItem().equals("sw"));
                        String sw = String.valueOf(rs.getInt("sw"));
                        String W = String.valueOf(PosInventoryColor.getSelectedItem().equals("w"));
                        String w = String.valueOf(rs.getInt("w"));
                        String B = String.valueOf(PosInventoryColor.getSelectedItem().equals("b"));
                        String b = String.valueOf(rs.getInt("b"));
                        String C = String.valueOf(PosInventoryColor.getSelectedItem().equals("c"));
                        String c = String.valueOf(rs.getInt("c"));
                        String G = String.valueOf(PosInventoryColor.getSelectedItem().equals("g"));
                        String g = String.valueOf(rs.getInt("g"));
                        String MF = String.valueOf(PosInventoryColor.getSelectedItem().equals("mf"));
                        String mf = String.valueOf(rs.getInt("mf"));
                        String NO = String.valueOf(PosInventoryColor.getSelectedItem().equals("nocolor"));
                        String no = String.valueOf(rs.getInt("nocolor"));

                        HA = ha;
                        A = a;
                        SW = sw;
                        W = w;
                        B = b;
                        C = c;
                        G = g;
                        MF = mf;
                        NO = no;

                        if (PosInventoryColor.getSelectedItem().equals("HA")) {
                            if (Integer.parseInt(HA) <= Input) {
                                JOptionPane.showMessageDialog(null, "Ha Product Insufficient , Re stock Product Color! or Select Other Color");
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }
                        }
                        if (PosInventoryColor.getSelectedItem().equals("A")) {
                            if (Integer.parseInt(A) <= Input) {
                                JOptionPane.showMessageDialog(null, "A Product Insufficient , Re stock Product Color! or Select Other Color");
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }
                        }
                        if (PosInventoryColor.getSelectedItem().equals("SW")) {
                            if (Integer.parseInt(SW) <= Input) {
                                JOptionPane.showMessageDialog(null, "Sw Product Insufficient , Re stock Product Color! or Select Other Color");
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }
                        }
                        if (PosInventoryColor.getSelectedItem().equals("W")) {
                            if (Integer.parseInt(W) <= Input) {
                                JOptionPane.showMessageDialog(null, "W Product Insufficient , Re stock Product Color! or Select Other Color");
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }
                        }
                        if (PosInventoryColor.getSelectedItem().equals("B")) {
                            if (Integer.parseInt(B) <= Input) {
                                JOptionPane.showMessageDialog(null, "B Product Insufficient , Re stock Product Color! or Select Other Color");;
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }

                        }
                        if (PosInventoryColor.getSelectedItem().equals("C")) {
                            if (Integer.parseInt(C) <= Input) {
                                JOptionPane.showMessageDialog(null, "C Product Insufficient , Re stock Product Color! or Select Other Color");
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }
                        }
                        if (PosInventoryColor.getSelectedItem().equals("G")) {
                            if (Integer.parseInt(G) <= Input) {
                                JOptionPane.showMessageDialog(null, "G Product Insufficient , Re stock Product Color! or Select Other Color");
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }
                        }
                        if (PosInventoryColor.getSelectedItem().equals("MF")) {
                            if (Integer.parseInt(MF) <= Input) {
                                JOptionPane.showMessageDialog(null, "MF Product Insufficient , Re stock Product Color! or Select Other Color");
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }
                        }
                        if (PosInventoryColor.getSelectedItem().equals("NO")) {
                            if (Integer.parseInt(NO) <= Input) {
                                JOptionPane.showMessageDialog(null, "NoColor Product Insufficient , Re stock Product Color! or Select Other Color");
                            } else {
                                row[0] = model1.getValueAt(indexs[i], 0);
                                row[1] = model1.getValueAt(indexs[i], 1);
                                row[2] = model1.getValueAt(indexs[i], 12);
                                row[3] = PosInventoryColor.getSelectedItem().toString();
                                row[4] = AddQuantity.getText();
                                row[5] = df2.format(Double.parseDouble(row[2].toString()) * Double.parseDouble(AddQuantity.getText()));
                                model2.addRow(row);
                                JOptionPane.showMessageDialog(null, "Product Added to Cart");
                                //-- Panel Dispose
                                jScrollPane1.setVisible(true);
                                jScrollPane2.setVisible(false);
                                PosAddPanel.setVisible(false);
                                AddQuantity.setText("");
                                PosAdd.setVisible(true);
                                PosAdd.setEnabled(true);
                                PosCancleAdd.setEnabled(false);
                                PosCancleAdd.setVisible(false);
                            }
                        }
                        if (PosInventoryColor.getSelectedItem().equals("HA")) {
                        }
                    }
                }//while----
            }//try----
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }//catch----
        }
        {// ------- Sum 
            //Sum row format
            int rowsCount = PosTable.getRowCount();
            double sum = 0;
            for (int i = 0; i < rowsCount; i++) {
                sum = sum + Double.parseDouble(PosTable.getValueAt(i, 5).toString());
                PosTotalLabel.setText(String.valueOf(df2.format(sum)));
            }
        }
    }//GEN-LAST:event_PosInventoryMouseReleased

    private void PosRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosRemoveActionPerformed
        DefaultTableModel model = (DefaultTableModel) PosTable.getModel();
        int[] rows = PosTable.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            model.removeRow(rows[i] - i);
        }
        {
            DecimalFormat df2 = new DecimalFormat("00.00");
            int rowsCount = PosTable.getRowCount();
            double sum = 0;
            for (int i = 0; i < rowsCount; i++) {
                sum = sum + Double.parseDouble(PosTable.getValueAt(i, 4).toString());
                PosTotalLabel.setText(String.valueOf(df2.format(sum)));
            }
        }
    }//GEN-LAST:event_PosRemoveActionPerformed

    private void PosSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosSaveActionPerformed

        try {
            if (PosRbtCash.isSelected()) {
                PosAdd.setEnabled(false);
                PosCancleAdd.setEnabled(false);
                PosRemove.setEnabled(false);
                PosSave.setEnabled(false);
                PosAdd.setEnabled(false);
                PosRefresh.setEnabled(false);
                PosAdd.setVisible(false);
                PosCancleAdd.setVisible(false);
                PosRemove.setVisible(false);
                PosSave.setVisible(false);
                PosRefresh.setVisible(false);
//Cash**********************
                CashTotal.setText(PosTotalLabel.getText());
                //Panel
                CashPos.setVisible(true);
                //Label
                CashPosLabel.setVisible(true);
                CashPosLabel1.setVisible(true);
                CashPosLabel2.setVisible(true);
                CashPosLabel3.setVisible(true);
                //Background
                //Textfield
                CashChange.setVisible(true);
                CashPaid.setVisible(true);
                CashTotal.setVisible(true);
                CashWorkerPaid1.setVisible(true);
                CashWorkerPaid2.setVisible(true);
                CashWorkerPaid3.setVisible(true);
                CashWorkerPaid4.setVisible(true);
                CashWorkerPaid5.setVisible(true);
                CashWorkerPaid6.setVisible(true);

                CashWorkerPaid1.setEnabled(false);
                CashWorkerPaid2.setEnabled(false);
                CashWorkerPaid3.setEnabled(false);
                CashWorkerPaid4.setEnabled(false);
                CashWorkerPaid5.setEnabled(false);
                CashWorkerPaid6.setEnabled(false);

                Cashday1.setEnabled(false);
                Cashday2.setEnabled(false);
                Cashday3.setEnabled(false);
                Cashday4.setEnabled(false);
                Cashday5.setEnabled(false);
                Cashday6.setEnabled(false);

                //Buttons
                CashSubmit.setVisible(true);
                CashCancel.setVisible(true);
                //ComboBox
                CashWorker1.setVisible(true);
                CashWorker2.setVisible(true);
                CashWorker3.setVisible(true);
                CashWorker4.setVisible(true);
                CashWorker5.setVisible(true);
                CashWorker6.setVisible(true);
//**************************
                PosRbtCheck.setEnabled(false);
                PosRbtCredit.setEnabled(false);
            } else if (PosRbtCheck.isSelected()) {
                PosRbtCash.setEnabled(false);
                PosRbtCredit.setEnabled(false);
                PosAdd.setEnabled(false);
                PosCancleAdd.setEnabled(false);
                PosRemove.setEnabled(false);
                PosSave.setEnabled(false);
                PosAdd.setEnabled(false);
                PosRefresh.setEnabled(false);
                PosAdd.setVisible(false);
                PosRemove.setVisible(false);
                PosSave.setVisible(false);
                PosRefresh.setVisible(false);
//Check#####################
                //Panel
                CheckPos.setVisible(true);
                //Label
                CheckLabel1.setVisible(true);
                CheckLabel2.setVisible(true);
                CheckLabel3.setVisible(true);
                CheckLabel4.setVisible(true);
                CheckLabel5.setVisible(true);
                CheckLabel6.setVisible(true);
                CheckLabel7.setVisible(true);
                CheckLabel8.setVisible(true);
                //Background
                CheckBg.setVisible(true);
                //Textfield
                CheckWorker1.setVisible(true);
                CheckWorker2.setVisible(true);
                CheckWorker3.setVisible(true);
                CheckWorker4.setVisible(true);
                CheckWorker5.setVisible(true);
                CheckWorker6.setVisible(true);

                CheckWorkerPay1.setVisible(true);
                CheckWorkerPay2.setVisible(true);
                CheckWorkerPay3.setVisible(true);
                CheckWorkerPay4.setVisible(true);
                CheckWorkerPay5.setVisible(true);
                CheckWorkerPay6.setVisible(true);

                Checkday1.setVisible(true);
                Checkday2.setVisible(true);
                Checkday3.setVisible(true);
                Checkday4.setVisible(true);
                Checkday5.setVisible(true);
                Checkday6.setVisible(true);

                CheckWorkerPay1.setEnabled(false);
                CheckWorkerPay2.setEnabled(false);
                CheckWorkerPay3.setEnabled(false);
                CheckWorkerPay4.setEnabled(false);
                CheckWorkerPay5.setEnabled(false);
                CheckWorkerPay6.setEnabled(false);

                Checkday1.setEnabled(false);
                Checkday2.setEnabled(false);
                Checkday3.setEnabled(false);
                Checkday4.setEnabled(false);
                Checkday5.setEnabled(false);
                Checkday6.setEnabled(false);
//##########################

                PosRbtCash.setEnabled(false);
                PosRbtCredit.setEnabled(false);
            } else if (PosRbtCredit.isSelected()) {
//Credit--------------------
                //Panel
                CreditPos.setVisible(true);
                //Label
                CashPosLabel5.setVisible(true);
                CashPosLabel8.setVisible(true);
                CashPosLabel9.setVisible(true);
                CashPosLabel10.setVisible(true);
                CashPosLabel11.setVisible(true);
                CashPosLabel12.setVisible(true);
                CashPosLabel13.setVisible(true);
                //Background
                CashBg1.setVisible(true);
                //Textfield
                creditbalance.setVisible(true);
                creditpay.setVisible(true);
                creditotal.setVisible(true);
                creditprofit.setVisible(true);

                creditday1.setVisible(true);
                creditday2.setVisible(true);
                creditday3.setVisible(true);
                creditday4.setVisible(true);
                creditday5.setVisible(true);
                creditday6.setVisible(true);

                creditday1.setEnabled(false);
                creditday2.setEnabled(false);
                creditday3.setEnabled(false);
                creditday4.setEnabled(false);
                creditday5.setEnabled(false);
                creditday6.setEnabled(false);

                creditworkerpay1.setVisible(true);
                creditworkerpay2.setVisible(true);
                creditworkerpay3.setVisible(true);
                creditworkerpay4.setVisible(true);
                creditworkerpay5.setVisible(true);
                creditworkerpay6.setVisible(true);

                creditworkerpay1.setEnabled(false);
                creditworkerpay2.setEnabled(false);
                creditworkerpay3.setEnabled(false);
                creditworkerpay4.setEnabled(false);
                creditworkerpay5.setEnabled(false);
                creditworkerpay6.setEnabled(false);
                //Buttons
                CashSubmit1.setVisible(true);
                CashCancel1.setVisible(true);
                creditduedate.setVisible(true);
                //ComboBox
                creditworker1.setVisible(true);
                creditworker2.setVisible(true);
                creditworker3.setVisible(true);
                creditworker4.setVisible(true);
                creditworker5.setVisible(true);
                creditworker6.setVisible(true);
//--------------------------
                PosRbtCash.setEnabled(false);
                PosRbtCheck.setEnabled(false);
                PosAdd.setEnabled(false);
                PosCancleAdd.setEnabled(false);
                PosRemove.setEnabled(false);
                PosSave.setEnabled(false);
                PosAdd.setEnabled(false);
                PosRefresh.setEnabled(false);
                PosAdd.setVisible(false);
                PosRemove.setVisible(false);
                PosSave.setVisible(false);
                PosRefresh.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Enter Transacton type");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_PosSaveActionPerformed

    private void PosSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PosSearchMouseReleased
        PosSearch.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_PosSearchMouseReleased

    private void PosSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PosSearchActionPerformed

    private void PosSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PosSearchKeyReleased

        String Product = PosSearch.getText();
        try {

            String sqlQuery = "Select * from Inventory where product like '%" + Product + "%'";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            PosInventory.setModel(DbUtils.resultSetToTableModel(rs));

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
    }//GEN-LAST:event_PosSearchKeyReleased

    private void PosCategoryPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_PosCategoryPopupMenuWillBecomeInvisible
        String Selected = (String) PosCategory.getSelectedItem();
        String sqlQuery = "Select * from Inventory where category=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            PosInventory.setModel(DbUtils.resultSetToTableModel(rs));
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

    }//GEN-LAST:event_PosCategoryPopupMenuWillBecomeInvisible

    private void PosCategoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PosCategoryMouseReleased

    }//GEN-LAST:event_PosCategoryMouseReleased

    private void PosRbtCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosRbtCreditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PosRbtCreditActionPerformed

    private void CashChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CashChangeActionPerformed

    private void CashCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashCancelActionPerformed
//Cash**********************
        //Panel
        CashPos.setVisible(false);
        //Label
        CashPosLabel.setVisible(false);
        CashPosLabel1.setVisible(false);
        CashPosLabel2.setVisible(false);
        CashPosLabel3.setVisible(false);
        //Background
        //Textfield
        CashChange.setVisible(false);
        CashPaid.setVisible(false);
        CashTotal.setVisible(false);
        CashWorkerPaid1.setVisible(false);
        CashWorkerPaid2.setVisible(false);
        CashWorkerPaid3.setVisible(false);
        CashWorkerPaid4.setVisible(false);
        CashWorkerPaid5.setVisible(false);
        CashWorkerPaid6.setVisible(false);

        //Buttons
        CashSubmit.setVisible(false);
        CashCancel.setVisible(false);
        //ComboBox
        CashWorker1.setVisible(false);
        CashWorker2.setVisible(false);
        CashWorker3.setVisible(false);
        CashWorker4.setVisible(false);
        CashWorker5.setVisible(false);
        CashWorker6.setVisible(false);
//**************************
        PosRbtCheck.setEnabled(true);
        PosRbtCredit.setEnabled(true);
        PosAdd.setEnabled(true);
        PosCancleAdd.setEnabled(true);
        PosRemove.setEnabled(true);
        PosSave.setEnabled(true);
        PosAdd.setEnabled(true);
        PosRefresh.setEnabled(true);
        PosAdd.setVisible(true);
        PosRemove.setVisible(true);
        PosSave.setVisible(true);
        PosRefresh.setVisible(true);

        PosTotalLabel.setText("00.00");
        Poshidden.setText("00.00");
        //Textfield
        CashChange.setText("0.00");
        CashPaid.setText("0.00");
        CashTotal.setText("0.00");
        CashWorkerPaid1.setText("0.00");
        CashWorkerPaid2.setText("0.00");
        CashWorkerPaid3.setText("0.00");
        CashWorkerPaid4.setText("0.00");
        CashWorkerPaid5.setText("0.00");
        CashWorkerPaid6.setText("0.00");

        //ComboBox
        CashWorker1.setSelectedItem("");
        CashWorker2.setSelectedItem("");
        CashWorker3.setSelectedItem("");
        CashWorker4.setSelectedItem("");
        CashWorker5.setSelectedItem("");
        CashWorker6.setSelectedItem("");
    }//GEN-LAST:event_CashCancelActionPerformed

    private void CashWorker2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashWorker2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CashWorker2ActionPerformed

    private void CashWorker6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashWorker6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CashWorker6ActionPerformed

    private void CheckCanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckCanelActionPerformed
        PosAdd.setEnabled(false);
        PosCancleAdd.setEnabled(false);
        PosRemove.setEnabled(false);
        PosSave.setEnabled(false);
        //Check#####################
        //Panel
        CheckPos.setVisible(false);
        //Label
        CheckLabel1.setVisible(false);
        CheckLabel2.setVisible(false);
        CheckLabel3.setVisible(false);
        CheckLabel4.setVisible(false);
        CheckLabel5.setVisible(false);
        CheckLabel6.setVisible(false);
        CheckLabel7.setVisible(false);
        CheckLabel8.setVisible(false);
        //Background
        CheckBg.setVisible(false);
        //Textfield
        CheckWorker1.setVisible(false);
        CheckWorker2.setVisible(false);
        CheckWorker3.setVisible(false);
        CheckWorker4.setVisible(false);
        CheckWorker5.setVisible(false);
        CheckWorker6.setVisible(false);

        CheckWorkerPay1.setVisible(false);
        CheckWorkerPay2.setVisible(false);
        CheckWorkerPay3.setVisible(false);
        CheckWorkerPay4.setVisible(false);
        CheckWorkerPay5.setVisible(false);
        CheckWorkerPay6.setVisible(false);

        Checkday1.setVisible(false);
        Checkday2.setVisible(false);
        Checkday3.setVisible(false);
        Checkday4.setVisible(false);
        Checkday5.setVisible(false);
        Checkday6.setVisible(false);

        CheckWorkerPay1.setEnabled(false);
        CheckWorkerPay2.setEnabled(false);
        CheckWorkerPay3.setEnabled(false);
        CheckWorkerPay4.setEnabled(false);
        CheckWorkerPay5.setEnabled(false);
        CheckWorkerPay6.setEnabled(false);

        Checkday1.setEnabled(false);
        Checkday2.setEnabled(false);
        Checkday3.setEnabled(false);
        Checkday4.setEnabled(false);
        Checkday5.setEnabled(false);
        Checkday6.setEnabled(false);
//##########################
        PosRbtCash.setEnabled(true);
        PosRbtCredit.setEnabled(true);
        PosAdd.setEnabled(true);
        PosCancleAdd.setEnabled(true);
        PosRemove.setEnabled(true);
        PosSave.setEnabled(true);
        PosAdd.setEnabled(true);
        PosRefresh.setEnabled(true);
        PosAdd.setVisible(true);
        PosRemove.setVisible(true);
        PosSave.setVisible(true);
        PosRefresh.setVisible(true);
    }//GEN-LAST:event_CheckCanelActionPerformed

    private void CheckPayNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPayNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayNoActionPerformed

    private void CheckPayNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPayNoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayNoKeyReleased

    private void CheckPayBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPayBankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayBankActionPerformed

    private void CheckPayBankKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPayBankKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayBankKeyReleased

    private void CheckDUeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckDUeActionPerformed
        JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        CheckDueDateLabel.setText(new DatePicker(f).setPickedDate());
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckDUeActionPerformed

    private void CheckPayTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPayTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayTotalActionPerformed

    private void CheckPayTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPayTotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayTotalKeyReleased

    private void CashSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashSubmitActionPerformed
        try {
            double Pay = Double.parseDouble(CashPaid.getText());
            double Amount = Double.parseDouble(CashTotal.getText());
            if (Pay >= Amount) {
//Cash Order -------------------------------------------------------------------
                for (int x = 0; x < PosTable.getRowCount(); x++) {

                    try {
                        String sqlQuery = "insert into Sales (TransactionNumber , CustomerName , CustomerNumber , Product , Category , Color, Quantity , Price , Totals ,Date, DueDate , Type , Balance ) values ('" + PosTransaction.getText() + "','" + PosCustomer.getText() + "','" + PosContactNumber.getText() + "','" + PosTable.getValueAt(x, 0).toString() + "','" + PosTable.getValueAt(x, 1).toString() + "','" + PosTable.getValueAt(x, 3).toString() + "','" + PosTable.getValueAt(x, 4).toString() + "','" + PosTotalLabel.getText() + "','" + CashTotal.getText() + "','" + PosDate.getText() + "','" + CashDueDateLabel.getText() + "','" + PosRbtCash.getText() + "', '"+CashChange.getText()+"')";
                        pst1 = conn.prepareStatement(sqlQuery);
                        pst1.execute();
////                pst1.setString(1, PosTransaction.getText());
////                pst1.setString(2, PosCustomer.getText());
////                pst1.setString(3, PosContactNumber.getText());
////                pst1.setString(4, PosTable.getValueAt(x, 0).toString());
////                pst1.setString(5, PosTable.getValueAt(x, 1).toString());
////                pst1.setString(6, PosTable.getValueAt(x, 3).toString());
////                pst1.setString(7, PosTable.getValueAt(x, 4).toString());
////                pst1.setString(8, PosTotalLabel.getText());
////                pst1.setString(9, CashTotal.getText());
////                pst1.setString(10, PosDate.getText());
////                pst1.setString(11, CashDueDateLabel.getText());
////                pst.setString(12, PosRbtCash.getText());
                        System.out.println(PosTable.getValueAt(x, 0));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    } finally {
                        try {
                            rs.close();
                            pst1.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                }
//CASH WORKER-------------------------------------------------------------------
                try {
                    String sqlQuery1 = "insert into Cashworker (TransactionNumber , CostumerName , CustomerNumber , Worker , WorkerPay , DueDate, Date) values(?,?,?,?,?,?,?)";
                    if (!CashWorker1.getSelectedItem().toString().isEmpty() && !CheckWorkerPay1.getText().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CashWorker1.getSelectedItem().toString());
                        pst.setString(5, CashWorkerPaid1.getText());
                        pst.setString(6, CashDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }

                    if (!CashWorker2.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CashWorker2.getSelectedItem().toString());
                        pst.setString(5, CashWorkerPaid2.getText());
                        pst.setString(6, CashDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }

                    if (!CashWorker3.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CashWorker3.getSelectedItem().toString());
                        pst.setString(5, CashWorkerPaid3.getText());
                        pst.setString(6, CashDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }

                    if (!CashWorker4.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CashWorker4.getSelectedItem().toString());
                        pst.setString(5, CashWorkerPaid4.getText());
                        pst.setString(6, CashDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }
                    if (!CashWorker5.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CashWorker5.getSelectedItem().toString());
                        pst.setString(5, CashWorkerPaid5.getText());
                        pst.setString(6, CashDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }
                    if (!CashWorker6.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CashWorker6.getSelectedItem().toString());
                        pst.setString(5, CashWorkerPaid6.getText());
                        pst.setString(6, CashDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    } else if (PosCustomer.getText().isEmpty() && PosContactNumber.getText().isEmpty()
                            && CheckDUe.getText().isEmpty()
                            && CashWorker1.getSelectedItem().toString().isEmpty() && CashWorkerPaid1.getText().isEmpty()
                            && CashWorker2.getSelectedItem().toString().isEmpty() && CashWorkerPaid2.getText().isEmpty()
                            && CashWorker3.getSelectedItem().toString().isEmpty() && CashWorkerPaid3.getText().isEmpty()
                            && CashWorker4.getSelectedItem().toString().isEmpty() && CashWorkerPaid4.getText().isEmpty()
                            && CashWorker5.getSelectedItem().toString().isEmpty() && CashWorkerPaid5.getText().isEmpty()
                            && CashWorker6.getSelectedItem().toString().isEmpty() && CashWorkerPaid6.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Incomplete Data");
                    } else {
                        JOptionPane.showMessageDialog(null, "Order Successful");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                } finally {
                    try {

                        rs.close();
                        pst1.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }

//CASH TOTAL -------------------------------------------------------------------
                try {

                    String sqlite = "Insert into Totals(TransactioNumber , CustomerName , CustomerNumber , TotalAmount , Paid ,Balance ,Profit , Date , Datedue)values(?,?,?,?,?,?,?,?,?)";
                    pst2 = conn.prepareStatement(sqlite);
                    pst2.setString(1, PosTransaction.getText());
                    pst2.setString(2, PosCustomer.getText());
                    pst2.setString(3, PosContactNumber.getText());
                    pst2.setString(4, CashTotal.getText());
                    pst2.setString(5, CashPaid.getText());
                    pst2.setString(6, "0");
                    pst2.setString(7, CashProfit.getText());
                    pst2.setString(8, PosDate.getText());
                    pst2.setString(9, CashDueDateLabel.getText());
                    pst2.execute();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                } finally {
                    try {
                        rs.close();
                        pst2.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
//Update Inventory -------------------------------------------------------------
                for (int x = 0; x < PosTable.getRowCount(); x++) {
                    try {
                        if (PosTable.getValueAt(x, 3).equals("HA")) {
                            //String sqlQuery = "UPDATE Inventory SET HA=(HA-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET ha=(ha-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("HA");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("A")) {
                            //String sqlQuery = "UPDATE Inventory SET A=(A-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET a=(a-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("A");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("SW")) {
                            //String sqlQuery = "UPDATE Inventory SET SW=(SW-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET sw=(sw-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("SW");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("B")) {
                            //String sqlQuery = "UPDATE Inventory SET B=(B-'"+PosTable.getValueAt(x, 4)+"')  WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET b=(b-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("B");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("C")) {
                            //String sqlQuery = "UPDATE Inventory SET C=(C-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET c=(c-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("C");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("W")) {
                            //String sqlQuery = "UPDATE Inventory SET W=(W-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET w=(w-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("W");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("G")) {
                            //String sqlQuery = "UPDATE Inventory SET G =(G-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET g=(g-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("G");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("MF")) {
                            //String sqlQuery = "UPDATE Inventory SET MF =(MF-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET mf=(mf-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("MF");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("NoColor")) {
                            //String sqlQuery = "UPDATE Inventory SET nocolor=(nocolor-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET NoColor=(NoColor-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("NoColor");
                            System.out.println(PosTable.getValueAt(x, 4));
                        }
//System.out.println( PosTable.getValueAt(x, 0));
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
//Update Total
                for (int x = 0; x < PosTable.getRowCount(); x++) {
                    try {
                        String sqlQuery = "UPDATE inventory SET available=ha+a+sw+b+c+w+g+mf+nocolor WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                        pst = conn.prepareStatement(sqlQuery);
                        pst.execute();
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
                TransactionIncrementation();
                PosTotalLabel.setText("00.00");
                Poshidden.setText("00.00");
                //Textfield
                CashChange.setText("0.00");
                CashPaid.setText("0.00");
                CashTotal.setText("0.00");
                CashWorkerPaid1.setText("0.00");
                CashWorkerPaid2.setText("0.00");
                CashWorkerPaid3.setText("0.00");
                CashWorkerPaid4.setText("0.00");
                CashWorkerPaid5.setText("0.00");
                CashWorkerPaid6.setText("0.00");
                Cashday1.setText("1");
                Cashday2.setText("1");
                Cashday3.setText("1");
                Cashday4.setText("1");
                Cashday5.setText("1");
                Cashday6.setText("1");

                //ComboBox
                CashWorker1.setSelectedItem("");
                CashWorker2.setSelectedItem("");
                CashWorker3.setSelectedItem("");
                CashWorker4.setSelectedItem("");
                CashWorker5.setSelectedItem("");
                CashWorker6.setSelectedItem("");
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient Please Pay The alloted bill");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_CashSubmitActionPerformed

    private void CashDateDUeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashDateDUeActionPerformed
        JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        CashDueDateLabel.setText(new DatePicker(f).setPickedDate().toString());
    }//GEN-LAST:event_CashDateDUeActionPerformed

    private void PosCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PosCategoryActionPerformed

    private void CashWorker1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CashWorker1PopupMenuWillBecomeInvisible
        String Selected = (String) CashWorker1.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CashWorkerPaid1.setEnabled(false);

            } else {
                CashWorkerPaid1.setEnabled(true);
            }
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
    }//GEN-LAST:event_CashWorker1PopupMenuWillBecomeInvisible

    private void CashPaidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashPaidKeyPressed
        DecimalFormat df2 = new DecimalFormat("00.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Double.parseDouble(CashPaid.getText()) < Double.parseDouble(CashTotal.getText().toString())) {
                double Change = Double.parseDouble(CashPaid.getText()) - Double.parseDouble(CashTotal.getText().toString());
                CashChange.setText(df2.format(Change).toString());
                System.out.println(Change);
                CashSubmit.requestFocusInWindow();
            } else {
                double Change = Double.parseDouble(CashPaid.getText()) - Double.parseDouble(CashTotal.getText().toString());
                CashChange.setText(df2.format(Change).toString());
                System.out.println(Change);
                CashSubmit.requestFocusInWindow();
            }
        }

    }//GEN-LAST:event_CashPaidKeyPressed

    private void CashWorker2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CashWorker2PopupMenuWillBecomeInvisible
        String Selected = (String) CashWorker2.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CashWorkerPaid2.setEnabled(false);

            } else {
                CashWorkerPaid2.setEnabled(true);
            }
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
    }//GEN-LAST:event_CashWorker2PopupMenuWillBecomeInvisible

    private void CashWorker3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CashWorker3PopupMenuWillBecomeInvisible
        String Selected = (String) CashWorker3.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CashWorkerPaid3.setEnabled(false);

            } else {
                CashWorkerPaid3.setEnabled(true);
            }
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
    }//GEN-LAST:event_CashWorker3PopupMenuWillBecomeInvisible

    private void CashWorker4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CashWorker4PopupMenuWillBecomeInvisible
        String Selected = (String) CashWorker4.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CashWorkerPaid4.setEnabled(false);

            } else {
                CashWorkerPaid4.setEnabled(true);
            }
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
    }//GEN-LAST:event_CashWorker4PopupMenuWillBecomeInvisible

    private void CashWorker5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CashWorker5PopupMenuWillBecomeInvisible
        String Selected = (String) CashWorker5.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CashWorkerPaid5.setEnabled(false);

            } else {
                CashWorkerPaid5.setEnabled(true);
            }
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
    }//GEN-LAST:event_CashWorker5PopupMenuWillBecomeInvisible

    private void CashWorker6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CashWorker6PopupMenuWillBecomeInvisible
        String Selected = (String) CashWorker6.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CashWorkerPaid6.setEnabled(false);

            } else {
                CashWorkerPaid6.setEnabled(true);
            }
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
    }//GEN-LAST:event_CashWorker6PopupMenuWillBecomeInvisible

    private void CheckSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckSubmitActionPerformed
        try {
            double Pay = Double.parseDouble(CheckPayAmount.getText());
            double Amount = Double.parseDouble(CheckPayTotal.getText());
            if (Pay >= Amount) {

//Cash Order -------------------------------------------------------------------
                for (int x = 0; x < PosTable.getRowCount(); x++) {

                    try {
//                        String sqlQuery = "insert into Sales (TransactionNumber , CustomerName , CustomerNumber , Product , Category , Color, Quantity , Price , Totals ,Date, DueDate , Type ) values (?,?,?,?,?,?,?,?,?,?,?,?)";
//                        pst1 = conn.prepareStatement(sqlQuery);
//                        pst1.execute();
//                        pst1.setString(1, PosTransaction.getText());
//                        pst1.setString(2, PosCustomer.getText());
//                        pst1.setString(3, PosContactNumber.getText());
//                        pst1.setString(4, PosTable.getValueAt(x, 0).toString());
//                        pst1.setString(5, PosTable.getValueAt(x, 1).toString());
//                        pst1.setString(6, PosTable.getValueAt(x, 3).toString());
//                        pst1.setString(7, PosTable.getValueAt(x, 4).toString());
//                        pst1.setString(8, PosTotalLabel.getText());
//                        pst1.setString(9, CheckPayTotal.getText());
//                        pst1.setString(10, PosDate.getText());
//                        pst1.setString(11, CheckDueDateLabel.getText());
//                        pst1.setString(12, PosRbtCheck.getText());
//                        System.out.println(PosTransaction.getText());

        String sqlQuery = "insert into Sales (TransactionNumber , CustomerName , CustomerNumber , Product , Category , Color, Quantity , Price , Totals ,Date, DueDate , Type ,Balance ) values ('" + PosTransaction.getText() + "','" + PosCustomer.getText() + "','" + PosContactNumber.getText() + "','" + PosTable.getValueAt(x, 0).toString() + "','" + PosTable.getValueAt(x, 1).toString() + "','" + PosTable.getValueAt(x, 3).toString() + "','" + PosTable.getValueAt(x, 4).toString() + "','" + PosTotalLabel.getText() + "','" + CheckPayTotal.getText() + "','" + PosDate.getText() + "','" + CheckDueDateLabel.getText() + "','" + PosRbtCheck.getText() + "','"+CheckPayChange.getText()+"')";
        pst1 = conn.prepareStatement(sqlQuery);
        pst1.execute();
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    } finally {
                        try {
                            rs.close();
                            pst1.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                }

////Check 
////                pst1.setString(8, CheckPayNo.getText());
////                pst1.setString(9, CheckPayBank.getText());
////                pst1.setString(10, CheckPayAmount.getText());
////                pst1.setString(11, CheckPayTotal.getText());
////                pst.setString(12, PosRbtCheck.getText());       
                for (int x = 0; x < PosTable.getRowCount(); x++) {

                    try {
                        String sqlQuery = "insert into CheckPayments (TransactionNumber , CustomerName , CustomerNumber , Checkno , bank , amount, issued , due , date) values ('" + PosTransaction.getText() + "','" + PosCustomer.getText() + "','" + PosContactNumber.getText() + "','" + CheckPayNo.getText() + "','" + CheckPayBank.getText() + "','" + CheckPayAmount.getText() + "','" + CheckDueDateLabel1.getText() + "','" + CheckDUe.getText() + "','" + PosDate.getText() + "')";
                        //String sqlQuery  = "insert into Check (TransactionNumber , CustomerName , CustomerNumber , Checkno , bank , amount, issued , due , date ) values (?,?,?,?,?,?,?,?,?)";
                        pst2 = conn.prepareStatement(sqlQuery);
                        pst2.execute();
//                pst1.setString(1, PosTransaction.getText());
//                pst1.setString(2, PosCustomer.getText());
//                pst1.setString(3, PosContactNumber.getText());
//                pst1.setString(4, CheckPayNo.getText());
//                pst1.setString(5, CheckPayBank.getText());
//                pst1.setString(6, CheckPayAmount.getText());
//                pst1.setString(7, CheckDueDate.getText());
//                pst1.setString(8, CheckDUe.getText());
//                pst.setString(9, PosDate.getText());
//            System.out.println(PosTable.getValueAt(x, 0));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    } finally {
                        try {
                            rs.close();
                            pst2.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                }
// WORKER-------------------------------------------------------------------
                try {
                    String sqlQuery1 = "insert into Cashworker (TransactionNumber , CostumerName , CustomerNumber , Worker , WorkerPay , DueDate, Date) values(?,?,?,?,?,?,?)";
                    if (!CheckWorker1.getSelectedItem().toString().isEmpty() && !CheckWorkerPay1.getText().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CheckWorker1.getSelectedItem().toString());
                        pst.setString(5, CheckWorkerPay1.getText());
                        pst.setString(6, CheckDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }

                    if (!CheckWorker2.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CheckWorker2.getSelectedItem().toString());
                        pst.setString(5, CheckWorkerPay2.getText());
                        pst.setString(6, CheckDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }

                    if (!CheckWorker3.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CheckWorker3.getSelectedItem().toString());
                        pst.setString(5, CheckWorkerPay3.getText());
                        pst.setString(6, CheckDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }

                    if (!CheckWorker4.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CheckWorker4.getSelectedItem().toString());
                        pst.setString(5, CheckWorkerPay4.getText());
                        pst.setString(6, CashDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }
                    if (!CheckWorker5.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CheckWorker5.getSelectedItem().toString());
                        pst.setString(5, CheckWorkerPay5.getText());
                        pst.setString(6, CheckDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    }
                    if (!CheckWorker6.getSelectedItem().toString().isEmpty()) {
                        pst = conn.prepareStatement(sqlQuery1);
                        pst.setString(1, PosTransaction.getText());
                        pst.setString(2, PosCustomer.getText());
                        pst.setString(3, PosContactNumber.getText());
                        pst.setString(4, CheckWorker6.getSelectedItem().toString());
                        pst.setString(5, CheckWorkerPay6.getText());
                        pst.setString(6, CheckDueDateLabel.getText());
                        pst.setString(7, PosDate.getText());
                        pst.execute();
                    } else if (PosCustomer.getText().isEmpty() && PosContactNumber.getText().isEmpty()
                            && CheckDUe.getText().isEmpty()
                            && CheckWorker1.getSelectedItem().toString().isEmpty() && CheckWorkerPay1.getText().isEmpty()
                            && CheckWorker2.getSelectedItem().toString().isEmpty() && CheckWorkerPay2.getText().isEmpty()
                            && CheckWorker3.getSelectedItem().toString().isEmpty() && CheckWorkerPay3.getText().isEmpty()
                            && CheckWorker4.getSelectedItem().toString().isEmpty() && CheckWorkerPay4.getText().isEmpty()
                            && CheckWorker5.getSelectedItem().toString().isEmpty() && CheckWorkerPay5.getText().isEmpty()
                            && CheckWorker6.getSelectedItem().toString().isEmpty() && CheckWorkerPay6.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Incomplete Data");
                    } else {
                        JOptionPane.showMessageDialog(null, "Order Successful");
                    }
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

//CASH TOTAL -------------------------------------------------------------------
                try {

                    String sqlite = "Insert into Totals(TransactioNumber , CustomerName , CustomerNumber , TotalAmount , Paid ,Balance ,Profit , Date , Datedue)values(?,?,?,?,?,?,?,?,?)";
                    pst3 = conn.prepareStatement(sqlite);
                    pst3.setString(1, PosTransaction.getText());
                    pst3.setString(2, PosCustomer.getText());
                    pst3.setString(3, PosContactNumber.getText());
                    pst3.setString(4, CheckPayTotal.getText());
                    pst3.setString(5, CheckPayAmount.getText());
                    pst3.setString(6, "0");
                    pst3.setString(7, CheckPayProfit.getText());
                    pst3.setString(8, PosDate.getText());
                    pst3.setString(9, CheckDueDateLabel.getText());
                    pst3.execute();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                } finally {
                    try {
                        rs.close();
                        pst3.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
//Update Inventory -------------------------------------------------------------
                for (int x = 0; x < PosTable.getRowCount(); x++) {
                    try {
                        if (PosTable.getValueAt(x, 3).equals("HA")) {
                            //String sqlQuery = "UPDATE Inventory SET HA=(HA-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET ha=(ha-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("HA");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("A")) {
                            //String sqlQuery = "UPDATE Inventory SET A=(A-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET a=(a-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("A");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("SW")) {
                            //String sqlQuery = "UPDATE Inventory SET SW=(SW-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET sw=(sw-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("SW");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("B")) {
                            //String sqlQuery = "UPDATE Inventory SET B=(B-'"+PosTable.getValueAt(x, 4)+"')  WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET b=(b-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("B");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("C")) {
                            //String sqlQuery = "UPDATE Inventory SET C=(C-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET c=(c-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("C");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("W")) {
                            //String sqlQuery = "UPDATE Inventory SET W=(W-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET w=(w-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("W");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("G")) {
                            //String sqlQuery = "UPDATE Inventory SET G =(G-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET g=(g-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("G");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("MF")) {
                            //String sqlQuery = "UPDATE Inventory SET MF =(MF-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET mf=(mf-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("MF");
                            System.out.println(PosTable.getValueAt(x, 4));
                        } else if (PosTable.getValueAt(x, 3).equals("NoColor")) {
                            //String sqlQuery = "UPDATE Inventory SET nocolor=(nocolor-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                            String sqlQuery = "UPDATE inventory SET NoColor=(NoColor-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                            pst = conn.prepareStatement(sqlQuery);
                            pst.execute();
                            System.out.println("NoColor");
                            System.out.println(PosTable.getValueAt(x, 4));
                        }
//System.out.println( PosTable.getValueAt(x, 0));
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
//Update Total
                for (int x = 0; x < PosTable.getRowCount(); x++) {
                    try {
                        String sqlQuery = "UPDATE inventory SET available=ha+a+sw+b+c+w+g+mf+nocolor WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                        pst = conn.prepareStatement(sqlQuery);
                        pst.execute();
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
                PosTable.removeAll();
                TransactionIncrementation();
                CheckPaydeliveryFee.setText("0");
                CheckPayProfit.setText("0");
                CheckPayNo.setText("0");
                CheckPayBank.setText("0");
                CheckPayAmount.setText("0");
                CheckPayTotal.setText("0");
                CheckPayChange.setText("0");
                CheckDueDateLabel.setText("0");
                CheckDueDateLabel1.setText("0");
                CheckWorkerPay1.setText("0");
                CheckWorkerPay2.setText("0");
                CheckWorkerPay3.setText("0");
                CheckWorkerPay4.setText("0");
                CheckWorkerPay5.setText("0");
                CheckWorkerPay6.setText("0");
                Checkday1.setText("1");
                Checkday2.setText("1");
                Checkday3.setText("1");
                Checkday4.setText("1");
                Checkday5.setText("1");
                Checkday6.setText("1");
                CheckWorker1.setSelectedItem("");
                CheckWorker2.setSelectedItem("");
                CheckWorker3.setSelectedItem("");
                CheckWorker4.setSelectedItem("");
                CheckWorker5.setSelectedItem("");
                CheckWorker6.setSelectedItem("");
                PosTotalLabel.setText("");
                Poshidden.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Check amount issued not enough \n Please pay the alloted bill");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_CheckSubmitActionPerformed

    private void CheckDueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckDueDateActionPerformed
        JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        CheckDueDateLabel1.setText(new DatePicker(f).setPickedDate());
    }//GEN-LAST:event_CheckDueDateActionPerformed

    private void CashProfitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashProfitKeyPressed
        DecimalFormat df2 = new DecimalFormat("00.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double profit = Double.parseDouble(CashProfit.getText());
            double Total = Double.parseDouble(CashTotal.getText());
            double delivery = Double.parseDouble(cashDelivery.getText());
            double F1total = Total + profit + delivery;
            double laborfee = Double.parseDouble(Poshidden.getText());
            double P1total = F1total + laborfee;
            CashTotal.setText(df2.format(P1total));
            CashPaid.requestFocusInWindow();
        }
    }//GEN-LAST:event_CashProfitKeyPressed

    private void CheckPayAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPayAmountKeyPressed
        DecimalFormat df2 = new DecimalFormat("00.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Double.parseDouble(CheckPayAmount.getText()) < Double.parseDouble(CheckPayTotal.getText().toString())) {
                double Change = Double.parseDouble(CheckPayAmount.getText()) - Double.parseDouble(CheckPayTotal.getText().toString());
                CheckPayChange.setText(df2.format(Change).toString());
                System.out.println(Change);
                CheckSubmit.requestFocusInWindow();
            } else {
                double Change = Double.parseDouble(CheckPayAmount.getText()) - Double.parseDouble(CheckPayTotal.getText().toString());
                CheckPayChange.setText(df2.format(Change).toString());
                System.out.println(Change);
                CheckSubmit.requestFocusInWindow();
            }
        }

    }//GEN-LAST:event_CheckPayAmountKeyPressed

    private void CheckPayProfitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPayProfitKeyPressed
        DecimalFormat df2 = new DecimalFormat("00.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double profit = Double.parseDouble(CheckPayProfit.getText());
            double Total = Double.parseDouble(PosTotalLabel.getText());
            double Delivery = Double.parseDouble(CheckPaydeliveryFee.getText());
            double F1total = Total + profit + Delivery;
            double laborfee = Double.parseDouble(Poshidden.getText());
            double P1total = F1total + laborfee;
            CheckPayTotal.setText(df2.format(P1total));
            CheckDueDate.requestFocusInWindow();
        }
    }//GEN-LAST:event_CheckPayProfitKeyPressed

    private void Cashday1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashday1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w1 = Double.parseDouble(CashWorkerPaid1.getText());
            double day = Double.parseDouble(Cashday1.getText());
            double F1total = day * w1;
            CashWorkerPaid1.setText(Double.valueOf(F1total).toString());
            Cashday1.setEnabled(false);
            Poshidden.setText(CashWorkerPaid1.getText());
        }
    }//GEN-LAST:event_Cashday1KeyPressed

    private void Cashday2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashday2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w2 = Double.parseDouble(CashWorkerPaid2.getText());
            double day = Double.parseDouble(Cashday2.getText());
            double F1total = day * w2;
            CashWorkerPaid2.setText(Double.valueOf(F1total).toString());
            Cashday2.setEnabled(false);

            double w1 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w1;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Cashday2KeyPressed

    private void Cashday4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashday4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w4 = Double.parseDouble(CashWorkerPaid4.getText());
            double day = Double.parseDouble(Cashday4.getText());
            double F1total = day * w4;
            CashWorkerPaid4.setText(Double.valueOf(F1total).toString());
            Cashday4.setEnabled(false);

            double w3 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w3;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Cashday4KeyPressed

    private void Cashday3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashday3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w3 = Double.parseDouble(CashWorkerPaid3.getText());
            double day = Double.parseDouble(Cashday3.getText());
            double F1total = day * w3;
            CashWorkerPaid3.setText(Double.valueOf(F1total).toString());
            Cashday3.setEnabled(false);

            double w2 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w2;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Cashday3KeyPressed

    private void Cashday5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashday5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w5 = Double.parseDouble(CashWorkerPaid5.getText());
            double day = Double.parseDouble(Cashday5.getText());
            double F1total = day * w5;
            CashWorkerPaid5.setText(Double.valueOf(F1total).toString());
            Cashday5.setEnabled(false);

            double w4 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w4;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Cashday5KeyPressed

    private void Cashday6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cashday6KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w6 = Double.parseDouble(CashWorkerPaid6.getText());
            double day = Double.parseDouble(Cashday6.getText());
            double F1total = day * w6;
            CashWorkerPaid6.setText(Double.valueOf(F1total).toString());
            Cashday6.setEnabled(false);

            double w5 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w5;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Cashday6KeyPressed

    private void CashWorkerPaid1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashWorkerPaid1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashWorkerPaid1.setEnabled(false);
            Cashday1.setEnabled(true);
        }
    }//GEN-LAST:event_CashWorkerPaid1KeyReleased

    private void CashWorkerPaid2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashWorkerPaid2KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashWorkerPaid2.setEnabled(false);
            Cashday2.setEnabled(true);
        }
    }//GEN-LAST:event_CashWorkerPaid2KeyReleased

    private void CashWorkerPaid3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashWorkerPaid3KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashWorkerPaid3.setEnabled(false);
            Cashday3.setEnabled(true);
        }
    }//GEN-LAST:event_CashWorkerPaid3KeyReleased

    private void CashWorkerPaid4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashWorkerPaid4KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashWorkerPaid4.setEnabled(false);
            Cashday4.setEnabled(true);
        }
    }//GEN-LAST:event_CashWorkerPaid4KeyReleased

    private void CashWorkerPaid5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashWorkerPaid5KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashWorkerPaid5.setEnabled(false);
            Cashday5.setEnabled(true);
        }
    }//GEN-LAST:event_CashWorkerPaid5KeyReleased

    private void CashWorkerPaid6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashWorkerPaid6KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashWorkerPaid6.setEnabled(false);
            Cashday6.setEnabled(true);
        }
    }//GEN-LAST:event_CashWorkerPaid6KeyReleased

    private void PosCancleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosCancleAddActionPerformed
        jScrollPane1.setVisible(true);
        jScrollPane2.setVisible(false);
        PosAddPanel.setVisible(false);
        AddQuantity.setText("");
        PosAdd.setVisible(true);
        PosAdd.setEnabled(true);
        PosCancleAdd.setEnabled(false);
        PosCancleAdd.setVisible(false);

    }//GEN-LAST:event_PosCancleAddActionPerformed

    private void PosCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PosCustomerMouseReleased

    }//GEN-LAST:event_PosCustomerMouseReleased

    private void CheckWorkerPay1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay1KeyReleased

    private void CheckWorkerPay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckWorkerPay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay1ActionPerformed

    private void CheckWorkerPay2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay2KeyReleased

    private void CheckWorkerPay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckWorkerPay2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay2ActionPerformed

    private void CheckWorker3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckWorker3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorker3ActionPerformed

    private void CheckWorkerPay3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay3KeyReleased

    private void CheckWorkerPay3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckWorkerPay3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay3ActionPerformed

    private void CheckWorkerPay4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay4KeyReleased

    private void CheckWorkerPay4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckWorkerPay4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay4ActionPerformed

    private void CheckWorkerPay5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay5KeyReleased

    private void CheckWorkerPay5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckWorkerPay5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay5ActionPerformed

    private void CheckWorker6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckWorker6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorker6ActionPerformed

    private void CheckWorkerPay6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay6KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckWorkerPay6.setEnabled(false);
            Checkday6.setEnabled(true);
        }
    }//GEN-LAST:event_CheckWorkerPay6KeyReleased

    private void CheckWorkerPay6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckWorkerPay6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay6ActionPerformed

    private void CheckWorker1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CheckWorker1PopupMenuWillBecomeInvisible
        String Selected = (String) CheckWorker1.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CheckWorkerPay1.setEnabled(false);

            } else {
                CheckWorkerPay1.setEnabled(true);
            }
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
    }//GEN-LAST:event_CheckWorker1PopupMenuWillBecomeInvisible

    private void CheckWorker2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CheckWorker2PopupMenuWillBecomeInvisible
        String Selected = (String) CheckWorker2.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CheckWorkerPay2.setEnabled(false);

            } else {
                CheckWorkerPay2.setEnabled(true);
            }
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
    }//GEN-LAST:event_CheckWorker2PopupMenuWillBecomeInvisible

    private void CheckWorker3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CheckWorker3PopupMenuWillBecomeInvisible
        String Selected = (String) CheckWorker3.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CheckWorkerPay3.setEnabled(false);

            } else {
                CheckWorkerPay3.setEnabled(true);
            }
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
    }//GEN-LAST:event_CheckWorker3PopupMenuWillBecomeInvisible

    private void CheckWorker4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CheckWorker4PopupMenuWillBecomeInvisible
        String Selected = (String) CheckWorker4.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CheckWorkerPay4.setEnabled(false);

            } else {
                CheckWorkerPay4.setEnabled(true);
            }
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
    }//GEN-LAST:event_CheckWorker4PopupMenuWillBecomeInvisible

    private void CheckWorker5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CheckWorker5PopupMenuWillBecomeInvisible
        String Selected = (String) CheckWorker5.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CheckWorkerPay5.setEnabled(false);

            } else {
                CheckWorkerPay5.setEnabled(true);
            }
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
    }//GEN-LAST:event_CheckWorker5PopupMenuWillBecomeInvisible

    private void CheckWorker6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CheckWorker6PopupMenuWillBecomeInvisible
        String Selected = (String) CheckWorker5.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                CheckWorkerPay5.setEnabled(false);

            } else {
                CheckWorkerPay5.setEnabled(true);
            }
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
    }//GEN-LAST:event_CheckWorker6PopupMenuWillBecomeInvisible

    private void CheckWorkerPay1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckWorkerPay1.setEnabled(false);
            Checkday1.setEnabled(true);
        }
    }//GEN-LAST:event_CheckWorkerPay1KeyPressed

    private void Checkday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Checkday1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday1ActionPerformed

    private void Checkday1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w1 = Double.parseDouble(CheckWorkerPay1.getText());
            double day = Double.parseDouble(Checkday1.getText());
            double F1total = day * w1;
            CheckWorkerPay1.setText(Double.valueOf(F1total).toString());
            Checkday1.setEnabled(false);
            Poshidden.setText(CheckWorkerPay1.getText());
        }
    }//GEN-LAST:event_Checkday1KeyPressed

    private void Checkday1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday1KeyReleased

    private void Checkday2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Checkday2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday2ActionPerformed

    private void Checkday2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday2KeyReleased

    private void Checkday3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Checkday3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday3ActionPerformed

    private void Checkday3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday3KeyReleased

    private void Checkday4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Checkday4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday4ActionPerformed

    private void Checkday4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday4KeyReleased

    private void Checkday5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Checkday5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday5ActionPerformed

    private void Checkday5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday5KeyReleased

    private void Checkday6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Checkday6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday6ActionPerformed

    private void Checkday6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Checkday6KeyReleased

    private void CheckWorkerPay2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckWorkerPay2.setEnabled(false);
            Checkday2.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckWorkerPay2KeyPressed

    private void CheckWorkerPay3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckWorkerPay3.setEnabled(false);
            Checkday3.setEnabled(true);
        }
    }//GEN-LAST:event_CheckWorkerPay3KeyPressed

    private void CheckWorkerPay4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckWorkerPay4.setEnabled(false);
            Checkday4.setEnabled(true);
        }
    }//GEN-LAST:event_CheckWorkerPay4KeyPressed

    private void CheckWorkerPay5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckWorkerPay5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckWorkerPay5.setEnabled(false);
            Checkday5.setEnabled(true);
        }
    }//GEN-LAST:event_CheckWorkerPay5KeyPressed

    private void Checkday2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w5 = Double.parseDouble(CheckWorkerPay2.getText());
            double day = Double.parseDouble(Checkday2.getText());
            double F1total = day * w5;
            CheckWorkerPay2.setText(Double.valueOf(F1total).toString());
            Checkday1.setEnabled(false);

            double w4 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w4;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Checkday2KeyPressed

    private void Checkday3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w5 = Double.parseDouble(CheckWorkerPay3.getText());
            double day = Double.parseDouble(Checkday3.getText());
            double F1total = day * w5;
            CheckWorkerPay3.setText(Double.valueOf(F1total).toString());
            Checkday3.setEnabled(false);

            double w4 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w4;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Checkday3KeyPressed

    private void Checkday4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w5 = Double.parseDouble(CheckWorkerPay4.getText());
            double day = Double.parseDouble(Checkday4.getText());
            double F1total = day * w5;
            CheckWorkerPay4.setText(Double.valueOf(F1total).toString());
            Checkday4.setEnabled(false);

            double w4 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w4;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Checkday4KeyPressed

    private void Checkday5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w5 = Double.parseDouble(CheckWorkerPay5.getText());
            double day = Double.parseDouble(Checkday5.getText());
            double F1total = day * w5;
            CheckWorkerPay5.setText(Double.valueOf(F1total).toString());
            Checkday5.setEnabled(false);

            double w4 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w4;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Checkday5KeyPressed

    private void Checkday6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Checkday6KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w5 = Double.parseDouble(CheckWorkerPay6.getText());
            double day = Double.parseDouble(Checkday6.getText());
            double F1total = day * w5;
            CheckWorkerPay6.setText(Double.valueOf(F1total).toString());
            Checkday6.setEnabled(false);

            double w4 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w4;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_Checkday6KeyPressed

    private void CheckPayNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPayNoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckPayBank.requestFocusInWindow();
        }
    }//GEN-LAST:event_CheckPayNoKeyPressed

    private void CheckPayProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPayProfitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayProfitActionPerformed

    private void CheckPayBankKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPayBankKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckPayAmount.requestFocusInWindow();
        }
    }//GEN-LAST:event_CheckPayBankKeyPressed

    private void Cashday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cashday1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cashday1ActionPerformed

    private void CashPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CashPaidActionPerformed

    private void CheckPayChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPayChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayChangeActionPerformed

    private void CheckPayChangeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPayChangeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPayChangeKeyReleased

    private void creditday5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditday5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w2 = Double.parseDouble(creditworkerpay5.getText());
            double day = Double.parseDouble(creditday5.getText());
            double F1total = day * w2;
            creditworkerpay5.setText(Double.valueOf(F1total).toString());
            creditday5.setEnabled(false);

            double w1 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w1;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }  // TODO add your handling code here:
    }//GEN-LAST:event_creditday5KeyPressed

    private void creditday6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditday6KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w2 = Double.parseDouble(creditworkerpay6.getText());
            double day = Double.parseDouble(creditday6.getText());
            double F1total = day * w2;
            creditworkerpay6.setText(Double.valueOf(F1total).toString());
            creditday6.setEnabled(false);

            double w1 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w1;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }         // TODO add your handling code here:
    }//GEN-LAST:event_creditday6KeyPressed

    private void creditday4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditday4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w2 = Double.parseDouble(creditworkerpay4.getText());
            double day = Double.parseDouble(creditday4.getText());
            double F1total = day * w2;
            creditworkerpay4.setText(Double.valueOf(F1total).toString());
            creditday4.setEnabled(false);

            double w1 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w1;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }
    }//GEN-LAST:event_creditday4KeyPressed

    private void creditday3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditday3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w2 = Double.parseDouble(creditworkerpay3.getText());
            double day = Double.parseDouble(creditday3.getText());
            double F1total = day * w2;
            creditworkerpay3.setText(Double.valueOf(F1total).toString());
            creditday3.setEnabled(false);

            double w1 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w1;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }         // TODO add your handling code here:
    }//GEN-LAST:event_creditday3KeyPressed

    private void creditday2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditday2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w2 = Double.parseDouble(creditworkerpay2.getText());
            double day = Double.parseDouble(creditday2.getText());
            double F1total = day * w2;
            creditworkerpay2.setText(Double.valueOf(F1total).toString());
            creditday2.setEnabled(false);

            double w1 = Double.parseDouble(Poshidden.getText());
            double F2total = F1total + w1;
            Poshidden.setText(Double.valueOf(F2total).toString());

        }    // TODO add your handling code here:
    }//GEN-LAST:event_creditday2KeyPressed

    private void creditday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditday1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditday1ActionPerformed

    private void creditday1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditday1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double w1 = Double.parseDouble(creditworkerpay1.getText());
            double day = Double.parseDouble(Cashday1.getText());
            double F1total = day * w1;
            creditworkerpay1.setText(Double.valueOf(F1total).toString());
            creditday1.setEnabled(false);
            Poshidden.setText(creditworkerpay1.getText());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_creditday1KeyPressed

    private void creditprofitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditprofitKeyPressed
        DecimalFormat df2 = new DecimalFormat("00.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double profit = Double.parseDouble(creditprofit.getText());
            double Total = Double.parseDouble(PosTotalLabel.getText());
            double delivery = Double.parseDouble(creditDelivery.getText());
            double F1total = Total + profit + delivery;
            double laborfee = Double.parseDouble(Poshidden.getText());
            double P1total = F1total + laborfee;
            creditotal.setText(df2.format(P1total));
            creditpay.requestFocusInWindow();
        }            // TODO add your handling code here:
    }//GEN-LAST:event_creditprofitKeyPressed

    private void creditduedateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditduedateActionPerformed
        JPanel p = new JPanel();
        final JFrame f = new JFrame();
        f.getContentPane().add(p);
        f.pack();
        f.setVisible(false);
        p.setVisible(false);
        creditduedatelabel.setText(new DatePicker(f).setPickedDate());        // TODO add your handling code here:
    }//GEN-LAST:event_creditduedateActionPerformed

    private void creditworkerpay2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditworkerpay2KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            creditworkerpay2.setEnabled(false);
            creditday2.setEnabled(true);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_creditworkerpay2KeyReleased

    private void creditworkerpay6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditworkerpay6KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            creditworkerpay6.setEnabled(false);
            creditday6.setEnabled(true);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_creditworkerpay6KeyReleased

    private void creditworkerpay3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditworkerpay3KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            creditworkerpay3.setEnabled(false);
            creditday3.setEnabled(true);
        }
    }//GEN-LAST:event_creditworkerpay3KeyReleased

    private void creditworkerpay4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditworkerpay4KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            creditworkerpay4.setEnabled(false);
            creditday4.setEnabled(true);
        }
    }//GEN-LAST:event_creditworkerpay4KeyReleased

    private void creditworkerpay5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditworkerpay5KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            creditworkerpay5.setEnabled(false);
            creditday5.setEnabled(true);
        }
    }//GEN-LAST:event_creditworkerpay5KeyReleased

    private void creditworkerpay1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditworkerpay1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            creditworkerpay1.setEnabled(false);
            creditday1.setEnabled(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_creditworkerpay1KeyReleased

    private void creditworker2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_creditworker2PopupMenuWillBecomeInvisible
        String Selected = (String) creditworker2.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                creditworkerpay2.setEnabled(false);

            } else {
                creditworkerpay2.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_creditworker2PopupMenuWillBecomeInvisible

    private void creditworker2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditworker2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditworker2ActionPerformed

    private void creditworker3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_creditworker3PopupMenuWillBecomeInvisible
        String Selected = (String) creditworker3.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                creditworkerpay3.setEnabled(false);

            } else {
                creditworkerpay3.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_creditworker3PopupMenuWillBecomeInvisible

    private void creditworker4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_creditworker4PopupMenuWillBecomeInvisible
        String Selected = (String) creditworker4.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                creditworkerpay4.setEnabled(false);

            } else {
                creditworkerpay4.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_creditworker4PopupMenuWillBecomeInvisible

    private void creditworker5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_creditworker5PopupMenuWillBecomeInvisible
        String Selected = (String) creditworker5.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                creditworkerpay5.setEnabled(false);

            } else {
                creditworkerpay5.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_creditworker5PopupMenuWillBecomeInvisible

    private void creditworker6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_creditworker6PopupMenuWillBecomeInvisible
        String Selected = (String) creditworker6.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                creditworkerpay6.setEnabled(false);

            } else {
                creditworkerpay6.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_creditworker6PopupMenuWillBecomeInvisible

    private void creditworker6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditworker6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditworker6ActionPerformed

    private void creditworker1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_creditworker1PopupMenuWillBecomeInvisible
        String Selected = (String) creditworker1.getSelectedItem();
        String sqlQuery = "Select FirstName from Workers where Firstname=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (Selected == "") {
                creditworkerpay1.setEnabled(false);

            } else {
                creditworkerpay1.setEnabled(true);
            }
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
    }//GEN-LAST:event_creditworker1PopupMenuWillBecomeInvisible

    private void creditbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditbalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditbalanceActionPerformed

    private void creditpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditpayActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_creditpayActionPerformed

    private void creditpayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditpayKeyPressed
        DecimalFormat df2 = new DecimalFormat("00.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Double.parseDouble(creditpay.getText()) < Double.parseDouble(creditotal.getText().toString())) {
                double Change = -Double.parseDouble(creditpay.getText()) + Double.parseDouble(creditotal.getText().toString());
                creditbalance.setText(df2.format(Change).toString());
                System.out.println(Change);
                CashSubmit1.requestFocusInWindow();
            }
//            else {
//                double Change = Double.parseDouble(creditpay.getText()) - Double.parseDouble(creditotal.getText().toString());
//                creditbalance.setText(df2.format(Change).toString());
//                System.out.println(Change);
//                CashSubmit1.requestFocusInWindow();
//            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_creditpayKeyPressed

    private void CashCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashCancel1ActionPerformed
//Credit--------------------
        //Panel
        CreditPos.setVisible(false);
        //Label
        CashPosLabel5.setVisible(false);
        CashPosLabel8.setVisible(false);
        CashPosLabel9.setVisible(false);
        CashPosLabel10.setVisible(false);
        CashPosLabel11.setVisible(false);
        CashPosLabel12.setVisible(false);
        CashPosLabel13.setVisible(false);
        //Background
        CashBg1.setVisible(false);
        //Textfield
        creditbalance.setVisible(false);
        creditpay.setVisible(false);
        creditotal.setVisible(false);
        creditprofit.setVisible(false);

        creditday1.setVisible(false);
        creditday2.setVisible(false);
        creditday3.setVisible(false);
        creditday4.setVisible(false);
        creditday5.setVisible(false);
        creditday6.setVisible(false);

        creditday1.setEnabled(false);
        creditday2.setEnabled(false);
        creditday3.setEnabled(false);
        creditday4.setEnabled(false);
        creditday5.setEnabled(false);
        creditday6.setEnabled(false);

        creditworkerpay1.setVisible(false);
        creditworkerpay2.setVisible(false);
        creditworkerpay3.setVisible(false);
        creditworkerpay4.setVisible(false);
        creditworkerpay5.setVisible(false);
        creditworkerpay6.setVisible(false);

        creditworkerpay1.setEnabled(false);
        creditworkerpay2.setEnabled(false);
        creditworkerpay3.setEnabled(false);
        creditworkerpay4.setEnabled(false);
        creditworkerpay5.setEnabled(false);
        creditworkerpay6.setEnabled(false);
        //Buttons
        CashSubmit1.setVisible(false);
        CashCancel1.setVisible(false);
        creditduedate.setVisible(false);
        //ComboBox
        creditworker1.setVisible(false);
        creditworker2.setVisible(false);
        creditworker3.setVisible(false);
        creditworker4.setVisible(false);
        creditworker5.setVisible(false);
        creditworker6.setVisible(false);
//--------------------------   

        PosTotalLabel.setText("00.00");
        Poshidden.setText("00.00");
        //Textfield
        creditbalance.setText("0.00");
        creditpay.setText("0.00");
        creditotal.setText("0.00");
        creditworkerpay1.setText("0.00");
        creditworkerpay2.setText("0.00");
        creditworkerpay3.setText("0.00");
        creditworkerpay4.setText("0.00");
        creditworkerpay5.setText("0.00");
        creditworkerpay6.setText("0.00");

        //ComboBox
        creditworker1.setSelectedItem("");
        creditworker2.setSelectedItem("");
        creditworker3.setSelectedItem("");
        creditworker4.setSelectedItem("");
        creditworker5.setSelectedItem("");
        creditworker6.setSelectedItem("");

        PosRbtCheck.setEnabled(true);
        PosRbtCash.setEnabled(true);
        PosAdd.setEnabled(true);
        PosCancleAdd.setEnabled(true);
        PosRemove.setEnabled(true);
        PosSave.setEnabled(true);
        PosAdd.setEnabled(true);
        PosRefresh.setEnabled(true);
        PosAdd.setVisible(true);
        PosRemove.setVisible(true);
        PosSave.setVisible(true);
        PosRefresh.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_CashCancel1ActionPerformed

    private void CashSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashSubmit1ActionPerformed
//Cash Order -------------------------------------------------------------------
        for (int x = 0; x < PosTable.getRowCount(); x++) {

            try {
                String sqlQuery = "insert into Sales (TransactionNumber , CustomerName , CustomerNumber , Product , Category , Color, Quantity , Price , Totals ,Date, DueDate , Type , Balance ) values ('" + PosTransaction.getText() + "','" + PosCustomer.getText() + "','" + PosContactNumber.getText() + "','" + PosTable.getValueAt(x, 0).toString() + "','" + PosTable.getValueAt(x, 1).toString() + "','" + PosTable.getValueAt(x, 3).toString() + "','" + PosTable.getValueAt(x, 4).toString() + "','" + PosTotalLabel.getText() + "','" + creditotal.getText() + "','" + PosDate.getText() + "','" + creditduedatelabel.getText() + "','" + PosRbtCredit.getText() + "','"+creditbalance.getText()+"')";
                pst1 = conn.prepareStatement(sqlQuery);
                pst1.execute();
////                pst1.setString(1, PosTransaction.getText());
////                pst1.setString(2, PosCustomer.getText());
////                pst1.setString(3, PosContactNumber.getText());
////                pst1.setString(4, PosTable.getValueAt(x, 0).toString());
////                pst1.setString(5, PosTable.getValueAt(x, 1).toString());
////                pst1.setString(6, PosTable.getValueAt(x, 3).toString());
////                pst1.setString(7, PosTable.getValueAt(x, 4).toString());
////                pst1.setString(8, PosTotalLabel.getText());
////                pst1.setString(9, CashTotal.getText());
////                pst1.setString(10, PosDate.getText());
////                pst1.setString(11, CashDueDateLabel.getText());
////                pst.setString(12, PosRbtCash.getText());
                System.out.println(PosTable.getValueAt(x, 0));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    rs.close();
                    pst1.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
//CASH WORKER-------------------------------------------------------------------
        try {
            String sqlQuery1 = "insert into Cashworker (TransactionNumber , CostumerName , CustomerNumber , Worker , WorkerPay , DueDate, Date) values(?,?,?,?,?,?,?)";
            if (!creditworker1.getSelectedItem().toString().isEmpty() && !creditworkerpay1.getText().isEmpty()) {
                pst = conn.prepareStatement(sqlQuery1);
                pst.setString(1, PosTransaction.getText());
                pst.setString(2, PosCustomer.getText());
                pst.setString(3, PosContactNumber.getText());
                pst.setString(4, creditworker1.getSelectedItem().toString());
                pst.setString(5, creditworkerpay1.getText());
                pst.setString(6, creditduedatelabel.getText());
                pst.setString(7, PosDate.getText());
                pst.execute();
            }

            if (!creditworker2.getSelectedItem().toString().isEmpty()) {
                pst = conn.prepareStatement(sqlQuery1);
                pst.setString(1, PosTransaction.getText());
                pst.setString(2, PosCustomer.getText());
                pst.setString(3, PosContactNumber.getText());
                pst.setString(4, creditworker2.getSelectedItem().toString());
                pst.setString(5, creditworkerpay2.getText());
                pst.setString(6, creditduedatelabel.getText());
                pst.setString(7, PosDate.getText());
                pst.execute();
            }

            if (!creditworker3.getSelectedItem().toString().isEmpty()) {
                pst = conn.prepareStatement(sqlQuery1);
                pst.setString(1, PosTransaction.getText());
                pst.setString(2, PosCustomer.getText());
                pst.setString(3, PosContactNumber.getText());
                pst.setString(4, creditworker3.getSelectedItem().toString());
                pst.setString(5, creditworkerpay3.getText());
                pst.setString(6, creditduedatelabel.getText());
                pst.setString(7, PosDate.getText());
                pst.execute();
            }

            if (!creditworker4.getSelectedItem().toString().isEmpty()) {
                pst = conn.prepareStatement(sqlQuery1);
                pst.setString(1, PosTransaction.getText());
                pst.setString(2, PosCustomer.getText());
                pst.setString(3, PosContactNumber.getText());
                pst.setString(4, creditworker4.getSelectedItem().toString());
                pst.setString(5, creditworkerpay4.getText());
                pst.setString(6, creditduedatelabel.getText());
                pst.setString(7, PosDate.getText());
                pst.execute();
            }
            if (!creditworker5.getSelectedItem().toString().isEmpty()) {
                pst = conn.prepareStatement(sqlQuery1);
                pst.setString(1, PosTransaction.getText());
                pst.setString(2, PosCustomer.getText());
                pst.setString(3, PosContactNumber.getText());
                pst.setString(4, creditworker5.getSelectedItem().toString());
                pst.setString(5, creditworkerpay5.getText());
                pst.setString(6, creditduedatelabel.getText());
                pst.setString(7, PosDate.getText());
                pst.execute();
            }
            if (!creditworker6.getSelectedItem().toString().isEmpty()) {
                pst = conn.prepareStatement(sqlQuery1);
                pst.setString(1, PosTransaction.getText());
                pst.setString(2, PosCustomer.getText());
                pst.setString(3, PosContactNumber.getText());
                pst.setString(4, creditworker6.getSelectedItem().toString());
                pst.setString(5, creditworkerpay6.getText());
                pst.setString(6, creditduedatelabel.getText());
                pst.setString(7, PosDate.getText());
                pst.execute();
            } else if (PosCustomer.getText().isEmpty() && PosContactNumber.getText().isEmpty()
                    && creditduedatelabel.getText().isEmpty()
                    && creditworker1.getSelectedItem().toString().isEmpty() && creditworkerpay1.getText().isEmpty()
                    && creditworker2.getSelectedItem().toString().isEmpty() && creditworkerpay2.getText().isEmpty()
                    && creditworker3.getSelectedItem().toString().isEmpty() && creditworkerpay3.getText().isEmpty()
                    && creditworker4.getSelectedItem().toString().isEmpty() && creditworkerpay4.getText().isEmpty()
                    && creditworker5.getSelectedItem().toString().isEmpty() && creditworkerpay5.getText().isEmpty()
                    && creditworker6.getSelectedItem().toString().isEmpty() && creditworkerpay6.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Incomplete Data");
            } else {
                JOptionPane.showMessageDialog(null, "Order Successful");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {

                rs.close();
                pst1.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

//CASH TOTAL -------------------------------------------------------------------
        try {

            String sqlite = "Insert into Totals(TransactioNumber , CustomerName , CustomerNumber , TotalAmount , Paid ,Balance ,Profit , Date , Datedue)values(?,?,?,?,?,?,?,?,?)";
            pst2 = conn.prepareStatement(sqlite);
            pst2.setString(1, PosTransaction.getText());
            pst2.setString(2, PosCustomer.getText());
            pst2.setString(3, PosContactNumber.getText());
            pst2.setString(4, creditotal.getText());
            pst2.setString(5, creditpay.getText());
            pst2.setString(6, creditbalance.getText());
            pst2.setString(7, creditprofit.getText());
            pst2.setString(8, PosDate.getText());
            pst2.setString(9, creditduedatelabel.getText());
            pst2.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                rs.close();
                pst2.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
//Update Inventory -------------------------------------------------------------
        for (int x = 0; x < PosTable.getRowCount(); x++) {
            try {
                if (PosTable.getValueAt(x, 3).equals("HA")) {
                    //String sqlQuery = "UPDATE Inventory SET HA=(HA-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET ha=(ha-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("HA");
                    System.out.println(PosTable.getValueAt(x, 4));
                } else if (PosTable.getValueAt(x, 3).equals("A")) {
                    //String sqlQuery = "UPDATE Inventory SET A=(A-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET a=(a-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("A");
                    System.out.println(PosTable.getValueAt(x, 4));
                } else if (PosTable.getValueAt(x, 3).equals("SW")) {
                    //String sqlQuery = "UPDATE Inventory SET SW=(SW-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET sw=(sw-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("SW");
                    System.out.println(PosTable.getValueAt(x, 4));
                } else if (PosTable.getValueAt(x, 3).equals("B")) {
                    //String sqlQuery = "UPDATE Inventory SET B=(B-'"+PosTable.getValueAt(x, 4)+"')  WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET b=(b-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("B");
                    System.out.println(PosTable.getValueAt(x, 4));
                } else if (PosTable.getValueAt(x, 3).equals("C")) {
                    //String sqlQuery = "UPDATE Inventory SET C=(C-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET c=(c-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("C");
                    System.out.println(PosTable.getValueAt(x, 4));
                } else if (PosTable.getValueAt(x, 3).equals("W")) {
                    //String sqlQuery = "UPDATE Inventory SET W=(W-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET w=(w-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("W");
                    System.out.println(PosTable.getValueAt(x, 4));
                } else if (PosTable.getValueAt(x, 3).equals("G")) {
                    //String sqlQuery = "UPDATE Inventory SET G =(G-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET g=(g-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("G");
                    System.out.println(PosTable.getValueAt(x, 4));
                } else if (PosTable.getValueAt(x, 3).equals("MF")) {
                    //String sqlQuery = "UPDATE Inventory SET MF =(MF-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET mf=(mf-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("MF");
                    System.out.println(PosTable.getValueAt(x, 4));
                } else if (PosTable.getValueAt(x, 3).equals("NoColor")) {
                    //String sqlQuery = "UPDATE Inventory SET nocolor=(nocolor-'"+PosTable.getValueAt(x, 4)+"') WHERE category='"+PosTable.getValueAt(x, 2)+"' AND product='"+PosTable.getValueAt(x, 0)+"'";
                    String sqlQuery = "UPDATE inventory SET NoColor=(NoColor-'" + PosTable.getValueAt(x, 4) + "') WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                    pst = conn.prepareStatement(sqlQuery);
                    pst.execute();
                    System.out.println("NoColor");
                    System.out.println(PosTable.getValueAt(x, 4));
                }
//System.out.println( PosTable.getValueAt(x, 0));
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
//Update Total
        for (int x = 0; x < PosTable.getRowCount(); x++) {
            try {
                String sqlQuery = "UPDATE inventory SET available=ha+a+sw+b+c+w+g+mf+nocolor WHERE product='" + PosTable.getValueAt(x, 0) + "'";
                pst = conn.prepareStatement(sqlQuery);
                pst.execute();
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
        TransactionIncrementation();
        PosTotalLabel.setText("00.00");
        Poshidden.setText("00.00");
        //Textfield
        creditbalance.setText("0.00");
        creditpay.setText("0.00");
        creditotal.setText("0.00");
        creditworkerpay1.setText("0.00");
        creditworkerpay2.setText("0.00");
        creditworkerpay3.setText("0.00");
        creditworkerpay4.setText("0.00");
        creditworkerpay5.setText("0.00");
        creditworkerpay6.setText("0.00");
        
        creditday1.setText("1");
        creditday2.setText("1");
        creditday3.setText("1");
        creditday4.setText("1");
        creditday5.setText("1");
        creditday6.setText("1");

        //ComboBox
        creditworker1.setSelectedItem("");
        CashWorker2.setSelectedItem("");
        CashWorker3.setSelectedItem("");
        CashWorker4.setSelectedItem("");
        CashWorker5.setSelectedItem("");
        CashWorker6.setSelectedItem("");
        // TODO add your handling code here:
    }//GEN-LAST:event_CashSubmit1ActionPerformed

    private void CashPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashPaidKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CashPaidKeyReleased

    private void CheckPaydeliveryFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPaydeliveryFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckPaydeliveryFeeActionPerformed

    private void CheckPaydeliveryFeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckPaydeliveryFeeKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckPayProfit.requestFocusInWindow();
        }
    }//GEN-LAST:event_CheckPaydeliveryFeeKeyPressed

    private void creditDeliveryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditDeliveryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            creditprofit.requestFocusInWindow();
        }
    }//GEN-LAST:event_creditDeliveryKeyPressed

    private void cashDeliveryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashDeliveryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashProfit.requestFocusInWindow();
        }
    }//GEN-LAST:event_cashDeliveryKeyPressed

    private void creditDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditDeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditDeliveryActionPerformed

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
            java.util.logging.Logger.getLogger(PosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddQuantity;
    private javax.swing.JLabel CashBg;
    private javax.swing.JLabel CashBg1;
    private javax.swing.JButton CashCancel;
    private javax.swing.JButton CashCancel1;
    private javax.swing.JTextField CashChange;
    private javax.swing.JButton CashDateDUe;
    private javax.swing.JLabel CashDueDateLabel;
    private javax.swing.JTextField CashPaid;
    private javax.swing.JPanel CashPos;
    private javax.swing.JLabel CashPosLabel;
    private javax.swing.JLabel CashPosLabel1;
    private javax.swing.JLabel CashPosLabel10;
    private javax.swing.JLabel CashPosLabel11;
    private javax.swing.JLabel CashPosLabel12;
    private javax.swing.JLabel CashPosLabel13;
    private javax.swing.JLabel CashPosLabel14;
    private javax.swing.JLabel CashPosLabel15;
    private javax.swing.JLabel CashPosLabel2;
    private javax.swing.JLabel CashPosLabel3;
    private javax.swing.JLabel CashPosLabel4;
    private javax.swing.JLabel CashPosLabel5;
    private javax.swing.JLabel CashPosLabel6;
    private javax.swing.JLabel CashPosLabel7;
    private javax.swing.JLabel CashPosLabel8;
    private javax.swing.JLabel CashPosLabel9;
    private javax.swing.JTextField CashProfit;
    private javax.swing.JButton CashSubmit;
    private javax.swing.JButton CashSubmit1;
    private javax.swing.JTextField CashTotal;
    private javax.swing.JComboBox CashWorker1;
    private javax.swing.JComboBox CashWorker2;
    private javax.swing.JComboBox CashWorker3;
    private javax.swing.JComboBox CashWorker4;
    private javax.swing.JComboBox CashWorker5;
    private javax.swing.JComboBox CashWorker6;
    private javax.swing.JTextField CashWorkerPaid1;
    private javax.swing.JTextField CashWorkerPaid2;
    private javax.swing.JTextField CashWorkerPaid3;
    private javax.swing.JTextField CashWorkerPaid4;
    private javax.swing.JTextField CashWorkerPaid5;
    private javax.swing.JTextField CashWorkerPaid6;
    private javax.swing.JTextField Cashday1;
    private javax.swing.JTextField Cashday2;
    private javax.swing.JTextField Cashday3;
    private javax.swing.JTextField Cashday4;
    private javax.swing.JTextField Cashday5;
    private javax.swing.JTextField Cashday6;
    private javax.swing.JLabel CheckBg;
    private javax.swing.JButton CheckCanel;
    private javax.swing.JButton CheckDUe;
    private javax.swing.JButton CheckDueDate;
    private javax.swing.JLabel CheckDueDateLabel;
    private javax.swing.JLabel CheckDueDateLabel1;
    private javax.swing.JLabel CheckLabel1;
    private javax.swing.JLabel CheckLabel10;
    private javax.swing.JLabel CheckLabel2;
    private javax.swing.JLabel CheckLabel3;
    private javax.swing.JLabel CheckLabel4;
    private javax.swing.JLabel CheckLabel5;
    private javax.swing.JLabel CheckLabel6;
    private javax.swing.JLabel CheckLabel7;
    private javax.swing.JLabel CheckLabel8;
    private javax.swing.JLabel CheckLabel9;
    private javax.swing.JTextField CheckPayAmount;
    private javax.swing.JTextField CheckPayBank;
    private javax.swing.JTextField CheckPayChange;
    private javax.swing.JTextField CheckPayNo;
    private javax.swing.JTextField CheckPayProfit;
    private javax.swing.JTextField CheckPayTotal;
    private javax.swing.JTextField CheckPaydeliveryFee;
    private javax.swing.JPanel CheckPos;
    private javax.swing.JButton CheckSubmit;
    private javax.swing.JComboBox CheckWorker1;
    private javax.swing.JComboBox CheckWorker2;
    private javax.swing.JComboBox CheckWorker3;
    private javax.swing.JComboBox CheckWorker4;
    private javax.swing.JComboBox CheckWorker5;
    private javax.swing.JComboBox CheckWorker6;
    private javax.swing.JTextField CheckWorkerPay1;
    private javax.swing.JTextField CheckWorkerPay2;
    private javax.swing.JTextField CheckWorkerPay3;
    private javax.swing.JTextField CheckWorkerPay4;
    private javax.swing.JTextField CheckWorkerPay5;
    private javax.swing.JTextField CheckWorkerPay6;
    private javax.swing.JTextField Checkday1;
    private javax.swing.JTextField Checkday2;
    private javax.swing.JTextField Checkday3;
    private javax.swing.JTextField Checkday4;
    private javax.swing.JTextField Checkday5;
    private javax.swing.JTextField Checkday6;
    private javax.swing.JPanel CreditPos;
    private javax.swing.JLabel POSBg;
    private javax.swing.JButton PosAdd;
    private javax.swing.JPanel PosAddPanel;
    private javax.swing.JButton PosCancleAdd;
    private javax.swing.JComboBox PosCategory;
    private javax.swing.JLabel PosCategoryLabel;
    private javax.swing.JLabel PosCategoryLabel1;
    private javax.swing.JTextField PosContactNumber;
    private javax.swing.JTextField PosCustomer;
    private javax.swing.JTextField PosDate;
    private javax.swing.JButton PosHome;
    private javax.swing.JTable PosInventory;
    private javax.swing.JComboBox PosInventoryColor;
    private javax.swing.JLabel PosLabel1;
    private javax.swing.JLabel PosLabel2;
    private javax.swing.JLabel PosLabel3;
    private javax.swing.JLabel PosLabel4;
    private javax.swing.JLabel PosLabel5;
    private javax.swing.JLabel PosLabel6;
    private javax.swing.JLabel PosPanel2Background;
    private javax.swing.JRadioButton PosRbtCash;
    private javax.swing.JRadioButton PosRbtCheck;
    private javax.swing.JRadioButton PosRbtCredit;
    private javax.swing.JButton PosRefresh;
    private javax.swing.JButton PosRemove;
    private javax.swing.JButton PosSave;
    private javax.swing.JTextField PosSearch;
    private javax.swing.JLabel PosSearchLabel;
    private javax.swing.JTable PosTable;
    private javax.swing.JLabel PosTotalLabel;
    private javax.swing.JTextField PosTransaction;
    private javax.swing.JLabel Poshidden;
    private javax.swing.JPanel RadioButtonPanel;
    private javax.swing.JTextField cashDelivery;
    private javax.swing.JTextField creditDelivery;
    private javax.swing.JTextField creditbalance;
    private javax.swing.JTextField creditday1;
    private javax.swing.JTextField creditday2;
    private javax.swing.JTextField creditday3;
    private javax.swing.JTextField creditday4;
    private javax.swing.JTextField creditday5;
    private javax.swing.JTextField creditday6;
    private javax.swing.JButton creditduedate;
    private javax.swing.JLabel creditduedatelabel;
    private javax.swing.JTextField creditotal;
    private javax.swing.JTextField creditpay;
    private javax.swing.JTextField creditprofit;
    private javax.swing.JComboBox creditworker1;
    private javax.swing.JComboBox creditworker2;
    private javax.swing.JComboBox creditworker3;
    private javax.swing.JComboBox creditworker4;
    private javax.swing.JComboBox creditworker5;
    private javax.swing.JComboBox creditworker6;
    private javax.swing.JTextField creditworkerpay1;
    private javax.swing.JTextField creditworkerpay2;
    private javax.swing.JTextField creditworkerpay3;
    private javax.swing.JTextField creditworkerpay4;
    private javax.swing.JTextField creditworkerpay5;
    private javax.swing.JTextField creditworkerpay6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
