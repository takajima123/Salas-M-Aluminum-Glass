/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author takajima
 */
public class AddProduct extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form AddProduct
     */
    public AddProduct() {
        initComponents();
        conn = DataBase.sqliteConnect.connectorDB();
        FillProductCategoryName();
        FillUpdateProductCategoryName();
        EditCategoryComboBox();
        EditProductComboBox();

//Choices Panel``````````````````````
        //Buttons
        ChoserBtnEdit.setVisible(true);
        ChoserBtnUpdate.setVisible(true);
        ChoserbtnAdd.setVisible(true);
        //Panel
        ChoicesPanel.setVisible(true);
        //Background
        ChoicesBg.setVisible(true);
        //Label
//```````````````````````````````````

        //Edit All###########################
        //Panel
        EditPanel.setVisible(false);
        //Buttons
        EditAdd.setVisible(false);
        EditClear.setVisible(false);
        EditHome.setVisible(false);
        //TextFields
        EditPrice.setVisible(false);
        EditSw.setVisible(false);
        //Label
        Edit1.setVisible(false);
        Edit2.setVisible(false);
        Edit3.setVisible(false);
        Edit5.setVisible(false);
        //BackGround
        EditBackground.setVisible(false);
        //ComboBox
        EditCategory.setVisible(false);
        EditProductName.setVisible(false);
//###################################

//New Product------------------------
        //Panel
        //Buttons
        newAdd.setVisible(false);
        newhome.setVisible(false);
        NewClear.setVisible(false);
        //TextFields
        NewPrice.setVisible(false);
        NewProductName.setVisible(false);
        //Label
        new1.setVisible(false);
        new2.setVisible(false);
        new3.setVisible(false);
        new4.setVisible(false);
        new6.setVisible(false);
        //BackGround
        newBg.setVisible(false);
        //ComboBox
        NewCombobox.setVisible(false);
//-----------------------------------

//Add Quantity***********************
        //Panel
        UpdatePanel.setVisible(false);
        //Buttons
        UpdateButton.setVisible(false);
        UpdateClearButton.setVisible(false);
        UpdateHomeButton.setVisible(false);
        //TextFields
        //Label
        Update14.setVisible(false);
        Update2.setVisible(false);
        Update3.setVisible(false);
        Update4.setVisible(false);
        Update5.setVisible(false);
        Update7.setVisible(false);
        UpdateCategory.setVisible(false);
        UpdatePrice.setVisible(false);
        //BackGround
        UpdateBg.setVisible(false);
        //ComboBox
        UpdateProductName.setVisible(false);
//***********************************

    }

    private void FillProductCategoryName() {
        try {
            String sqlQuery = "SELECT Category from Inventory group by category";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            NewCombobox.addItem("");
            while (rs.next()) {
                String cat = rs.getString("Category");
                if (cat != null) {
                    NewCombobox.addItem(cat);
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

    private void FillUpdateProductCategoryName() {
        try {
            String sqlQuery = "SELECT Product from Inventory";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("Product");
                if (cat != null) {
                    UpdateProductName.addItem(cat);
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

    private void EditProductComboBox() {
        try {
            String sqlQuery = "SELECT Product from Inventory";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("Product");
                if (cat != null) {
                    EditProductName.addItem(cat);
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

    private void EditCategoryComboBox() {
        try {
            String sqlQuery = "SELECT Category from Inventory";
            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("Category");
                if (cat != null) {
                    EditCategory.addItem(cat);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EditPanel = new javax.swing.JPanel();
        Edit15 = new javax.swing.JLabel();
        EditLead = new javax.swing.JTextField();
        EditMin = new javax.swing.JTextField();
        EditMax = new javax.swing.JTextField();
        Edit17 = new javax.swing.JLabel();
        Edit18 = new javax.swing.JLabel();
        EditProductName = new javax.swing.JComboBox();
        Edit1 = new javax.swing.JLabel();
        Edit2 = new javax.swing.JLabel();
        Edit3 = new javax.swing.JLabel();
        Edit4 = new javax.swing.JLabel();
        Edit5 = new javax.swing.JLabel();
        Edit6 = new javax.swing.JLabel();
        Edit7 = new javax.swing.JLabel();
        Edit8 = new javax.swing.JLabel();
        Edit9 = new javax.swing.JLabel();
        Edit10 = new javax.swing.JLabel();
        Edit11 = new javax.swing.JLabel();
        Edit12 = new javax.swing.JLabel();
        Edit13 = new javax.swing.JLabel();
        Edit14 = new javax.swing.JLabel();
        EditA = new javax.swing.JTextField();
        EditSw = new javax.swing.JTextField();
        EditB = new javax.swing.JTextField();
        EditC = new javax.swing.JTextField();
        EditW = new javax.swing.JTextField();
        EditG = new javax.swing.JTextField();
        EditMf = new javax.swing.JTextField();
        EditNoColor = new javax.swing.JTextField();
        EditHa = new javax.swing.JTextField();
        EditCategory = new javax.swing.JComboBox();
        EditPrice = new javax.swing.JTextField();
        EditAdd = new javax.swing.JButton();
        EditClear = new javax.swing.JButton();
        EditHome = new javax.swing.JButton();
        EditBackground = new javax.swing.JLabel();
        UpdatePanel = new javax.swing.JPanel();
        UpdateOldHa = new javax.swing.JTextField();
        UpdateOldA = new javax.swing.JTextField();
        UpdateOldSw = new javax.swing.JTextField();
        UpdateOldW = new javax.swing.JTextField();
        UpdateOldC = new javax.swing.JTextField();
        UpdateOldB = new javax.swing.JTextField();
        UpdateOldG = new javax.swing.JTextField();
        UpdateOldMf = new javax.swing.JTextField();
        UpdateOldNoColor = new javax.swing.JTextField();
        UpdateNewNoColor = new javax.swing.JTextField();
        UpdateNewMf = new javax.swing.JTextField();
        UpdateNewG = new javax.swing.JTextField();
        Edit16 = new javax.swing.JLabel();
        Update15 = new javax.swing.JLabel();
        Update14 = new javax.swing.JLabel();
        UpdateNewW = new javax.swing.JTextField();
        UpdateNewC = new javax.swing.JTextField();
        UpdateNewB = new javax.swing.JTextField();
        Update11 = new javax.swing.JLabel();
        Update12 = new javax.swing.JLabel();
        Update13 = new javax.swing.JLabel();
        UpdateNewSw = new javax.swing.JTextField();
        Update10 = new javax.swing.JLabel();
        Update9 = new javax.swing.JLabel();
        UpdateNewA = new javax.swing.JTextField();
        UpdateNewHa = new javax.swing.JTextField();
        Update8 = new javax.swing.JLabel();
        UpdatePrice = new javax.swing.JLabel();
        UpdateCategory = new javax.swing.JLabel();
        UpdateProductName = new javax.swing.JComboBox();
        Update2 = new javax.swing.JLabel();
        Update3 = new javax.swing.JLabel();
        Update4 = new javax.swing.JLabel();
        Update5 = new javax.swing.JLabel();
        Update7 = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JButton();
        UpdateClearButton = new javax.swing.JButton();
        UpdateHomeButton = new javax.swing.JButton();
        UpdateBg = new javax.swing.JLabel();
        new18 = new javax.swing.JLabel();
        NewMin = new javax.swing.JTextField();
        NewMax = new javax.swing.JTextField();
        new17 = new javax.swing.JLabel();
        NewLead = new javax.swing.JTextField();
        new16 = new javax.swing.JLabel();
        NewSw = new javax.swing.JTextField();
        new13 = new javax.swing.JLabel();
        NewMf = new javax.swing.JTextField();
        new14 = new javax.swing.JLabel();
        new9 = new javax.swing.JLabel();
        NewC = new javax.swing.JTextField();
        NewHa = new javax.swing.JTextField();
        NewG = new javax.swing.JTextField();
        new11 = new javax.swing.JLabel();
        new12 = new javax.swing.JLabel();
        NewNoColor = new javax.swing.JTextField();
        new10 = new javax.swing.JLabel();
        NewW = new javax.swing.JTextField();
        new15 = new javax.swing.JLabel();
        NewB = new javax.swing.JTextField();
        NewA = new javax.swing.JTextField();
        new8 = new javax.swing.JLabel();
        new7 = new javax.swing.JLabel();
        new1 = new javax.swing.JLabel();
        new2 = new javax.swing.JLabel();
        new3 = new javax.swing.JLabel();
        new4 = new javax.swing.JLabel();
        new6 = new javax.swing.JLabel();
        NewCombobox = new javax.swing.JComboBox();
        NewProductName = new javax.swing.JTextField();
        NewPrice = new javax.swing.JTextField();
        newAdd = new javax.swing.JButton();
        NewClear = new javax.swing.JButton();
        newhome = new javax.swing.JButton();
        ChoicesPanel = new javax.swing.JPanel();
        ChoserBtnUpdate = new javax.swing.JButton();
        ChoserbtnAdd = new javax.swing.JButton();
        ChoserBtnEdit = new javax.swing.JButton();
        ChoicesBg = new javax.swing.JLabel();
        newBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Edit15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit15.setForeground(new java.awt.Color(255, 255, 255));
        Edit15.setText("Lead :");
        EditPanel.add(Edit15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, 20));

        EditLead.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditLead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditLeadMouseReleased(evt);
            }
        });
        EditLead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditLeadActionPerformed(evt);
            }
        });
        EditPanel.add(EditLead, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 50, 40));

        EditMin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditMinMouseReleased(evt);
            }
        });
        EditMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMinActionPerformed(evt);
            }
        });
        EditPanel.add(EditMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 50, 40));

        EditMax.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditMaxMouseReleased(evt);
            }
        });
        EditMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMaxActionPerformed(evt);
            }
        });
        EditPanel.add(EditMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 50, 40));

        Edit17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit17.setForeground(new java.awt.Color(255, 255, 255));
        Edit17.setText("Max :");
        EditPanel.add(Edit17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, 20));

        Edit18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit18.setForeground(new java.awt.Color(255, 255, 255));
        Edit18.setText("Min :");
        EditPanel.add(Edit18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 20));

        EditProductName.setEditable(true);
        EditProductName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditProductName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Product" }));
        EditProductName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                EditProductNamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        EditProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProductNamenone(evt);
            }
        });
        EditPanel.add(EditProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 190, 40));

        Edit1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit1.setForeground(new java.awt.Color(255, 255, 255));
        Edit1.setText("Edit Product");
        EditPanel.add(Edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 170, -1));

        Edit2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit2.setForeground(new java.awt.Color(255, 255, 255));
        Edit2.setText("Product Name :");
        EditPanel.add(Edit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

        Edit3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit3.setForeground(new java.awt.Color(255, 255, 255));
        Edit3.setText("Category :");
        EditPanel.add(Edit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 30));

        Edit4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit4.setForeground(new java.awt.Color(255, 255, 255));
        Edit4.setText("Available Quantity ");
        EditPanel.add(Edit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, 20));

        Edit5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit5.setForeground(new java.awt.Color(255, 255, 255));
        Edit5.setText("Peso/Sq.m :");
        EditPanel.add(Edit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 20));

        Edit6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit6.setForeground(new java.awt.Color(255, 255, 255));
        Edit6.setText("Ha :");
        EditPanel.add(Edit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 20));

        Edit7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit7.setForeground(new java.awt.Color(255, 255, 255));
        Edit7.setText("A :");
        EditPanel.add(Edit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 20));

        Edit8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit8.setForeground(new java.awt.Color(255, 255, 255));
        Edit8.setText("Sw :");
        EditPanel.add(Edit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));

        Edit9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit9.setForeground(new java.awt.Color(255, 255, 255));
        Edit9.setText("B :");
        EditPanel.add(Edit9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, 20));

        Edit10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit10.setForeground(new java.awt.Color(255, 255, 255));
        Edit10.setText("C :");
        EditPanel.add(Edit10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, 20));

        Edit11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit11.setForeground(new java.awt.Color(255, 255, 255));
        Edit11.setText("W :");
        EditPanel.add(Edit11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, 20));

        Edit12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit12.setForeground(new java.awt.Color(255, 255, 255));
        Edit12.setText("G :");
        EditPanel.add(Edit12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, 20));

        Edit13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit13.setForeground(new java.awt.Color(255, 255, 255));
        Edit13.setText("Mf :");
        EditPanel.add(Edit13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, 20));

        Edit14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Edit14.setForeground(new java.awt.Color(255, 255, 255));
        Edit14.setText("NoColor :");
        EditPanel.add(Edit14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, 20));

        EditA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditAMouseReleased(evt);
            }
        });
        EditA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditAActionPerformed(evt);
            }
        });
        EditPanel.add(EditA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 100, 40));

        EditSw.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditSw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditSwMouseReleased(evt);
            }
        });
        EditSw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditSwActionPerformed(evt);
            }
        });
        EditPanel.add(EditSw, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 100, 40));

        EditB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditBMouseReleased(evt);
            }
        });
        EditB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBActionPerformed(evt);
            }
        });
        EditPanel.add(EditB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 100, 40));

        EditC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditCMouseReleased(evt);
            }
        });
        EditC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCActionPerformed(evt);
            }
        });
        EditPanel.add(EditC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 100, 40));

        EditW.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditWMouseReleased(evt);
            }
        });
        EditW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditWActionPerformed(evt);
            }
        });
        EditPanel.add(EditW, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 100, 40));

        EditG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditGMouseReleased(evt);
            }
        });
        EditG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditGActionPerformed(evt);
            }
        });
        EditPanel.add(EditG, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 100, 40));

        EditMf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditMf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditMfMouseReleased(evt);
            }
        });
        EditMf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMfActionPerformed(evt);
            }
        });
        EditPanel.add(EditMf, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 100, 40));

        EditNoColor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditNoColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditNoColorMouseReleased(evt);
            }
        });
        EditNoColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditNoColorActionPerformed(evt);
            }
        });
        EditPanel.add(EditNoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 100, 40));

        EditHa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditHa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EditHaMouseReleased(evt);
            }
        });
        EditHa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditHaActionPerformed(evt);
            }
        });
        EditPanel.add(EditHa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 100, 40));

        EditCategory.setEditable(true);
        EditCategory.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        EditCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCategoryActionPerformed(evt);
            }
        });
        EditPanel.add(EditCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 190, 40));

        EditPrice.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditPanel.add(EditPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 190, 40));

        EditAdd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditAdd.setText("Edit");
        EditAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditAddActionPerformed(evt);
            }
        });
        EditPanel.add(EditAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 80, 50));

        EditClear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditClear.setText("Clear");
        EditClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditClearActionPerformed(evt);
            }
        });
        EditPanel.add(EditClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 80, 50));

        EditHome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditHome.setText("Home");
        EditHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditHomeActionPerformed(evt);
            }
        });
        EditPanel.add(EditHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 80, 50));

        EditBackground.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        EditBackground.setMaximumSize(new java.awt.Dimension(500, 500));
        EditBackground.setMinimumSize(new java.awt.Dimension(500, 500));
        EditBackground.setPreferredSize(new java.awt.Dimension(500, 500));
        EditPanel.add(EditBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        UpdatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UpdateOldHa.setEditable(false);
        UpdateOldHa.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldHa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldHaMouseReleased(evt);
            }
        });
        UpdateOldHa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldHaActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldHa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 40, 40));

        UpdateOldA.setEditable(false);
        UpdateOldA.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldAMouseReleased(evt);
            }
        });
        UpdateOldA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldAActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 40, 40));

        UpdateOldSw.setEditable(false);
        UpdateOldSw.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldSw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldSwMouseReleased(evt);
            }
        });
        UpdateOldSw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldSwActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldSw, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 40, 40));

        UpdateOldW.setEditable(false);
        UpdateOldW.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldWMouseReleased(evt);
            }
        });
        UpdateOldW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldWActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldW, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 40, 40));

        UpdateOldC.setEditable(false);
        UpdateOldC.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldCMouseReleased(evt);
            }
        });
        UpdateOldC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldCActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldC, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 40, 40));

        UpdateOldB.setEditable(false);
        UpdateOldB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldBMouseReleased(evt);
            }
        });
        UpdateOldB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldBActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 40, 40));

        UpdateOldG.setEditable(false);
        UpdateOldG.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldGMouseReleased(evt);
            }
        });
        UpdateOldG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldGActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldG, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 40, 40));

        UpdateOldMf.setEditable(false);
        UpdateOldMf.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldMf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldMfMouseReleased(evt);
            }
        });
        UpdateOldMf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldMfActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldMf, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 40, 40));

        UpdateOldNoColor.setEditable(false);
        UpdateOldNoColor.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateOldNoColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateOldNoColorMouseReleased(evt);
            }
        });
        UpdateOldNoColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOldNoColorActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateOldNoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 40, 40));

        UpdateNewNoColor.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewNoColor.setText("0");
        UpdateNewNoColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewNoColorMouseReleased(evt);
            }
        });
        UpdateNewNoColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewNoColorActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewNoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 40, 40));

        UpdateNewMf.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewMf.setText("0");
        UpdateNewMf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewMfMouseReleased(evt);
            }
        });
        UpdateNewMf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewMfActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewMf, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 40, 40));

        UpdateNewG.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewG.setText("0");
        UpdateNewG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewGMouseReleased(evt);
            }
        });
        UpdateNewG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewGActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewG, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 40, 40));

        Edit16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Edit16.setForeground(new java.awt.Color(255, 255, 255));
        Edit16.setText("NoColor :");
        UpdatePanel.add(Edit16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, 20));

        Update15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update15.setForeground(new java.awt.Color(255, 255, 255));
        Update15.setText("Mf :");
        UpdatePanel.add(Update15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, 20));

        Update14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update14.setForeground(new java.awt.Color(255, 255, 255));
        Update14.setText("G :");
        UpdatePanel.add(Update14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 20));

        UpdateNewW.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewW.setText("0");
        UpdateNewW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewWMouseReleased(evt);
            }
        });
        UpdateNewW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewWActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewW, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 40, 40));

        UpdateNewC.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewC.setText("0");
        UpdateNewC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewCMouseReleased(evt);
            }
        });
        UpdateNewC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewCActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 40, 40));

        UpdateNewB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewB.setText("0");
        UpdateNewB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewBMouseReleased(evt);
            }
        });
        UpdateNewB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewBActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 40, 40));

        Update11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update11.setForeground(new java.awt.Color(255, 255, 255));
        Update11.setText("B :");
        UpdatePanel.add(Update11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, 20));

        Update12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update12.setForeground(new java.awt.Color(255, 255, 255));
        Update12.setText("C :");
        UpdatePanel.add(Update12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, 20));

        Update13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update13.setForeground(new java.awt.Color(255, 255, 255));
        Update13.setText("W :");
        UpdatePanel.add(Update13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, 20));

        UpdateNewSw.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewSw.setText("0");
        UpdateNewSw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewSwMouseReleased(evt);
            }
        });
        UpdateNewSw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewSwActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewSw, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 40, 40));

        Update10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update10.setForeground(new java.awt.Color(255, 255, 255));
        Update10.setText("Sw :");
        UpdatePanel.add(Update10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));

        Update9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update9.setForeground(new java.awt.Color(255, 255, 255));
        Update9.setText("A :");
        UpdatePanel.add(Update9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        UpdateNewA.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewA.setText("0");
        UpdateNewA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewAMouseReleased(evt);
            }
        });
        UpdateNewA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewAActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 40, 40));

        UpdateNewHa.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateNewHa.setText("0");
        UpdateNewHa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateNewHaMouseReleased(evt);
            }
        });
        UpdateNewHa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNewHaActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateNewHa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 40, 40));

        Update8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update8.setForeground(new java.awt.Color(255, 255, 255));
        Update8.setText("Ha :");
        UpdatePanel.add(Update8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        UpdatePrice.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        UpdatePrice.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePanel.add(UpdatePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 210, 40));

        UpdateCategory.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        UpdateCategory.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePanel.add(UpdateCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 210, 40));

        UpdateProductName.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateProductName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Product" }));
        UpdateProductName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                UpdateProductNamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        UpdateProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });
        UpdatePanel.add(UpdateProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 210, 40));

        Update2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Update2.setForeground(new java.awt.Color(255, 255, 255));
        Update2.setText("Add Stocks");
        UpdatePanel.add(Update2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 160, -1));

        Update3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Update3.setForeground(new java.awt.Color(255, 255, 255));
        Update3.setText("To Old Products");
        UpdatePanel.add(Update3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 220, -1));

        Update4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update4.setForeground(new java.awt.Color(255, 255, 255));
        Update4.setText("Product Name :");
        UpdatePanel.add(Update4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 30));

        Update5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update5.setForeground(new java.awt.Color(255, 255, 255));
        Update5.setText("Category :");
        UpdatePanel.add(Update5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, 30));

        Update7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Update7.setForeground(new java.awt.Color(255, 255, 255));
        Update7.setText("Peso/Sq.m :");
        UpdatePanel.add(Update7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, 20));

        UpdateButton.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateButton.setText("Add");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 80, 50));

        UpdateClearButton.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateClearButton.setText("Clear");
        UpdateClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateClearButtonActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 80, 50));

        UpdateHomeButton.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateHomeButton.setText("Home");
        UpdateHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateHomeButtonActionPerformed(evt);
            }
        });
        UpdatePanel.add(UpdateHomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 80, 50));

        UpdateBg.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        UpdateBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        UpdateBg.setMaximumSize(new java.awt.Dimension(500, 500));
        UpdateBg.setMinimumSize(new java.awt.Dimension(500, 500));
        UpdateBg.setPreferredSize(new java.awt.Dimension(500, 500));
        UpdatePanel.add(UpdateBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(UpdatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        new18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new18.setForeground(new java.awt.Color(255, 255, 255));
        new18.setText("Min Available:");
        getContentPane().add(new18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, 20));

        NewMin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewMin.setText("0");
        getContentPane().add(NewMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 170, 40));

        NewMax.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewMax.setText("0");
        getContentPane().add(NewMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 170, 40));

        new17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new17.setForeground(new java.awt.Color(255, 255, 255));
        new17.setText("Max Available:");
        getContentPane().add(new17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, 20));

        NewLead.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewLead.setText("0");
        getContentPane().add(NewLead, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 170, 40));

        new16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new16.setForeground(new java.awt.Color(255, 255, 255));
        new16.setText("Estimated Lead:");
        getContentPane().add(new16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, 20));

        NewSw.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewSw.setText("0");
        NewSw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewSwMouseReleased(evt);
            }
        });
        NewSw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewSwActionPerformed(evt);
            }
        });
        getContentPane().add(NewSw, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 100, 40));

        new13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new13.setForeground(new java.awt.Color(255, 255, 255));
        new13.setText("G :");
        getContentPane().add(new13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, 20));

        NewMf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewMf.setText("0");
        NewMf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewMfMouseReleased(evt);
            }
        });
        NewMf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewMfActionPerformed(evt);
            }
        });
        getContentPane().add(NewMf, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 100, 40));

        new14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new14.setForeground(new java.awt.Color(255, 255, 255));
        new14.setText("Mf :");
        getContentPane().add(new14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, 20));

        new9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new9.setForeground(new java.awt.Color(255, 255, 255));
        new9.setText("Sw :");
        getContentPane().add(new9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, 20));

        NewC.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewC.setText("0");
        NewC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewCMouseReleased(evt);
            }
        });
        NewC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewCActionPerformed(evt);
            }
        });
        getContentPane().add(NewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 100, 40));

        NewHa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewHa.setText("0");
        NewHa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewHaMouseReleased(evt);
            }
        });
        NewHa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewHaActionPerformed(evt);
            }
        });
        getContentPane().add(NewHa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 100, 40));

        NewG.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewG.setText("0");
        NewG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewGMouseReleased(evt);
            }
        });
        NewG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGActionPerformed(evt);
            }
        });
        getContentPane().add(NewG, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 100, 40));

        new11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new11.setForeground(new java.awt.Color(255, 255, 255));
        new11.setText("C :");
        getContentPane().add(new11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, 20));

        new12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new12.setForeground(new java.awt.Color(255, 255, 255));
        new12.setText("W :");
        getContentPane().add(new12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, 20));

        NewNoColor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewNoColor.setText("0");
        NewNoColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewNoColorMouseReleased(evt);
            }
        });
        NewNoColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewNoColorActionPerformed(evt);
            }
        });
        getContentPane().add(NewNoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 100, 40));

        new10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new10.setForeground(new java.awt.Color(255, 255, 255));
        new10.setText("B :");
        getContentPane().add(new10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, 20));

        NewW.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewW.setText("0");
        NewW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewWMouseReleased(evt);
            }
        });
        NewW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewWActionPerformed(evt);
            }
        });
        getContentPane().add(NewW, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 100, 40));

        new15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new15.setForeground(new java.awt.Color(255, 255, 255));
        new15.setText("NoColor :");
        getContentPane().add(new15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, 20));

        NewB.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewB.setText("0");
        NewB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewBMouseReleased(evt);
            }
        });
        NewB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBActionPerformed(evt);
            }
        });
        getContentPane().add(NewB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 100, 40));

        NewA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewA.setText("0");
        NewA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NewAMouseReleased(evt);
            }
        });
        NewA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAActionPerformed(evt);
            }
        });
        getContentPane().add(NewA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 100, 40));

        new8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new8.setForeground(new java.awt.Color(255, 255, 255));
        new8.setText("A :");
        getContentPane().add(new8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));

        new7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new7.setForeground(new java.awt.Color(255, 255, 255));
        new7.setText("Ha :");
        getContentPane().add(new7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 20));

        new1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        new1.setForeground(new java.awt.Color(255, 255, 255));
        new1.setText("Enter");
        getContentPane().add(new1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 70, -1));

        new2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        new2.setForeground(new java.awt.Color(255, 255, 255));
        new2.setText("New Product");
        getContentPane().add(new2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 140, -1));

        new3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new3.setForeground(new java.awt.Color(255, 255, 255));
        new3.setText("Product Name :");
        getContentPane().add(new3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        new4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new4.setForeground(new java.awt.Color(255, 255, 255));
        new4.setText("Category :");
        getContentPane().add(new4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        new6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        new6.setForeground(new java.awt.Color(255, 255, 255));
        new6.setText("Peso/Sq.m :");
        getContentPane().add(new6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        NewCombobox.setEditable(true);
        NewCombobox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewComboboxActionPerformed(evt);
            }
        });
        getContentPane().add(NewCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 170, 40));

        NewProductName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProductNameActionPerformed(evt);
            }
        });
        getContentPane().add(NewProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, 40));

        NewPrice.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(NewPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 170, 40));

        newAdd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        newAdd.setText("Add");
        newAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAddActionPerformed(evt);
            }
        });
        getContentPane().add(newAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 80, 50));

        NewClear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        NewClear.setText("Clear");
        NewClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewClearActionPerformed(evt);
            }
        });
        getContentPane().add(NewClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 80, 50));

        newhome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        newhome.setText("Home");
        newhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newhomeActionPerformed(evt);
            }
        });
        getContentPane().add(newhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 80, 50));

        ChoicesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ChoserBtnUpdate.setText("Update Quantity Available");
        ChoserBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoserBtnUpdateActionPerformed(evt);
            }
        });
        ChoicesPanel.add(ChoserBtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 430, 130));

        ChoserbtnAdd.setText("Add New Products");
        ChoserbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoserbtnAddActionPerformed(evt);
            }
        });
        ChoicesPanel.add(ChoserbtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 430, 130));

        ChoserBtnEdit.setText("Edit Products");
        ChoserBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoserBtnEditActionPerformed(evt);
            }
        });
        ChoicesPanel.add(ChoserBtnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 430, 130));

        ChoicesBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        ChoicesBg.setMaximumSize(new java.awt.Dimension(500, 500));
        ChoicesBg.setMinimumSize(new java.awt.Dimension(500, 500));
        ChoicesBg.setPreferredSize(new java.awt.Dimension(500, 500));
        ChoicesPanel.add(ChoicesBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(ChoicesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        newBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgBackgrounds/cacb13ea4246ee699a7c926f83a9ce0c.jpg"))); // NOI18N
        newBg.setMaximumSize(new java.awt.Dimension(500, 500));
        newBg.setMinimumSize(new java.awt.Dimension(500, 500));
        newBg.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(newBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewComboboxActionPerformed

    private void newAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAddActionPerformed
        try {
            String sqlQuery = "insert into Inventory(Product ,Category ,Price ,Ha,A,Sw,B,C,W,G,Mf,NoColor,Lead,Reorder,max,available) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, NewProductName.getText());
            pst.setString(2, NewCombobox.getSelectedItem().toString());
            pst.setString(3, NewPrice.getText());
            pst.setString(4, NewHa.getText());
            pst.setString(5, NewA.getText());
            pst.setString(6, NewSw.getText());
            pst.setString(7, NewB.getText());
            pst.setString(8, NewC.getText());
            pst.setString(9, NewW.getText());
            pst.setString(10, NewG.getText());
            pst.setString(11, NewMf.getText());
            pst.setString(12, NewNoColor.getText());
            pst.setString(13, NewLead.getText());
            pst.setString(14, NewMin.getText());
            pst.setString(15, NewMax.getText());
            double Total = Integer.parseInt(NewHa.getText() + NewA.getText() + NewSw.getText() + NewB.getText() + NewC.getText() + NewW.getText() + NewG.getText() + NewMf.getText() + NewNoColor.getText());
            String Stotal = Double.toString(Total);
            pst.setString(16, Stotal);
            pst.execute();

            JOptionPane.showMessageDialog(null, "New Product added to Inventory", "Inventory ", JOptionPane.INFORMATION_MESSAGE);
            NewProductName.setText("");
            NewCombobox.setSelectedItem("");
            NewPrice.setText("");
            NewHa.setText("");
            NewA.setText("");
            NewSw.setText("");
            NewB.setText("");
            NewW.setText("");
            NewC.setText("");
            NewG.setText("");
            NewMf.setText("");
            NewNoColor.setText("");
            NewLead.setText("");
            NewMin.setText("");
            NewMax.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }//GEN-LAST:event_newAddActionPerformed

    private void NewClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewClearActionPerformed
        NewProductName.setText("");
        NewCombobox.setSelectedItem("");
        NewPrice.setText("");
        NewHa.setText("");
        NewA.setText("");
        NewSw.setText("");
        NewB.setText("");
        NewW.setText("");
        NewC.setText("");
        NewG.setText("");
        NewMf.setText("");
        NewNoColor.setText("");
        NewLead.setText("");
        NewMin.setText("");
        NewMax.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_NewClearActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed

        try {
            String HaNew = UpdateNewHa.getText();
            String HaOld = UpdateOldHa.getText();
            double FHa = Double.parseDouble(HaNew) + Double.parseDouble(HaOld);
            String ANew = UpdateNewA.getText();
            String AOld = UpdateOldA.getText();
            double Fa = Double.parseDouble(ANew) + Double.parseDouble(AOld);
            String SwNew = UpdateNewSw.getText();
            String SwOld = UpdateOldSw.getText();
            double FSw = Double.parseDouble(SwNew) + Double.parseDouble(SwOld);
            String BNew = UpdateNewB.getText();
            String BOld = UpdateOldB.getText();
            double Fb = Double.parseDouble(BNew) + Double.parseDouble(BOld);
            String CNew = UpdateNewC.getText();
            String COld = UpdateOldC.getText();
            double Fc = Double.parseDouble(CNew) + Double.parseDouble(COld);
            String WNew = UpdateNewW.getText();
            String WOld = UpdateOldW.getText();
            double Fw = Double.parseDouble(WNew) + Double.parseDouble(WOld);
            String GNew = UpdateNewG.getText();
            String GOld = UpdateOldG.getText();
            double Fg = Double.parseDouble(GNew) + Double.parseDouble(GOld);
            String MfNew = UpdateNewMf.getText();
            String MfOld = UpdateOldMf.getText();
            double Fmf = Double.parseDouble(MfNew) + Double.parseDouble(MfOld);
            String NoColorNew = UpdateNewNoColor.getText();
            String NoColorOld = UpdateOldNoColor.getText();
            double FNoColor = Double.parseDouble(NoColorNew) + Double.parseDouble(NoColorOld);

            String sqlQuery = "update Inventory set Product = '" + UpdateProductName.getSelectedItem().toString() + "', Category = '" + UpdateCategory.getText() + "', Price = '" + UpdatePrice.getText() + "' ,    "
                    + " Ha = '" + FHa + "',"
                    + " A  = '" + Fa + "',"
                    + " Sw = '" + FSw + "',"
                    + " B  = '" + Fb + "',"
                    + " C  = '" + Fc + "',"
                    + " W  = '" + Fw + "',"
                    + " G  = '" + Fg + "',"
                    + " Mf = '" + Fmf + "',"
                    + " NoColor = '" + FNoColor + "' where Product = '" + UpdateProductName.getSelectedItem().toString() + "'";
            pst = conn.prepareStatement(sqlQuery);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Stocks Added to Inventory", "Stocks ", JOptionPane.INFORMATION_MESSAGE);
            UpdateProductName.setSelectedItem("");
            UpdateCategory.setText("");
            UpdatePrice.setText("");
            //--------old
            UpdateOldHa.setText("");
            UpdateOldA.setText("");
            UpdateOldSw.setText("");
            UpdateOldB.setText("");
            UpdateOldC.setText("");
            UpdateOldW.setText("");
            UpdateOldG.setText("");
            UpdateOldMf.setText("");
            UpdateOldNoColor.setText("");
            //--------new
            UpdateNewA.setText("0");
            UpdateNewB.setText("0");
            UpdateNewC.setText("0");
            UpdateNewG.setText("0");
            UpdateNewHa.setText("0");
            UpdateNewMf.setText("0");
            UpdateNewNoColor.setText("0");
            UpdateNewW.setText("0");
            UpdateNewSw.setText("0");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");

        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

//Update Total
        try {
            String sqlQuery = "UPDATE inventory SET available=ha+a+sw+b+c+w+g+mf+nocolor WHERE product='" + UpdateProductName.getSelectedItem().toString() + "'";
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

    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void UpdateClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateClearButtonActionPerformed
        UpdateProductName.setSelectedItem("");
        UpdateCategory.setText("");
        UpdatePrice.setText("");
        //--------old
        UpdateOldHa.setText("");
        UpdateOldA.setText("");
        UpdateOldSw.setText("");
        UpdateOldB.setText("");
        UpdateOldC.setText("");
        UpdateOldW.setText("");
        UpdateOldG.setText("");
        UpdateOldMf.setText("");
        UpdateOldNoColor.setText("");
        //--------new
        UpdateNewA.setText("0");
        UpdateNewB.setText("0");
        UpdateNewC.setText("0");
        UpdateNewG.setText("0");
        UpdateNewHa.setText("0");
        UpdateNewMf.setText("0");
        UpdateNewNoColor.setText("0");
        UpdateNewW.setText("0");
        UpdateNewSw.setText("0");
    }//GEN-LAST:event_UpdateClearButtonActionPerformed

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void UpdateProductNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_UpdateProductNamePopupMenuWillBecomeInvisible
        String Selected = (String) UpdateProductName.getSelectedItem();
        String sqlQuery = "Select * from Inventory where product=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (rs.next()) {
                String ECategory = rs.getString("Category");
                UpdateCategory.setText(ECategory);
                String EPrice = rs.getString("Price");
                UpdatePrice.setText(EPrice);
                String Ha = rs.getString("Ha");
                UpdateOldHa.setText(Ha);
                String A = rs.getString("A");
                UpdateOldA.setText(A);
                String Sw = rs.getString("Sw");
                UpdateOldSw.setText(Sw);
                String B = rs.getString("B");
                UpdateOldB.setText(B);
                String C = rs.getString("C");
                UpdateOldC.setText(C);
                String W = rs.getString("W");
                UpdateOldW.setText(W);
                String G = rs.getString("G");
                UpdateOldG.setText(G);
                String Mf = rs.getString("Mf");
                UpdateOldMf.setText(Mf);
                String NoColor = rs.getString("NoColor");
                UpdateOldNoColor.setText(NoColor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_UpdateProductNamePopupMenuWillBecomeInvisible

    private void EditSwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditSwActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_EditSwActionPerformed

    private void EditCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditCategoryActionPerformed

    private void EditAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditAddActionPerformed
        try {
            String sqlQuery = "update Inventory set Product = '" + EditProductName.getSelectedItem().toString() + "', Category = '" + EditCategory.getSelectedItem().toString() + "', Price = '" + EditPrice.getText() + "' ,"
                    + " Ha = '" + EditHa.getText() + "',"
                    + " A  = '" + EditA.getText() + "',"
                    + " Sw = '" + EditSw.getText() + "',"
                    + " B  = '" + EditB.getText() + "',"
                    + " C  = '" + EditC.getText() + "',"
                    + " W  = '" + EditW.getText() + "',"
                    + " G  = '" + EditG.getText() + "',"
                    + " Mf = '" + EditMf.getText() + "',"
                    + " NoColor = '" + EditNoColor.getText() + "', lead ='" + EditLead.getText() + "',max ='" + EditMax.getText() + "', Reorder ='" + EditMin.getText() + "' where Product = '" + EditProductName.getSelectedItem().toString() + "'";
            pst = conn.prepareStatement(sqlQuery);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Stocks Added to Inventory", "Stocks ", JOptionPane.INFORMATION_MESSAGE);
            EditPrice.setText("");
            EditHa.setText("");
            EditA.setText("");
            EditSw.setText("");
            EditB.setText("");
            EditC.setText("");
            EditG.setText("");
            EditW.setText("");
            EditMf.setText("");
            EditNoColor.setText("");
            EditProductName.setSelectedItem("");
            EditCategory.setSelectedItem("");
            EditLead.setText("");
            EditMin.setText("");
            EditMax.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");

        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
//Update Total
        try {
            String sqlQuery = "UPDATE inventory SET available=ha+a+sw+b+c+w+g+mf+nocolor WHERE product='" + EditProductName.getSelectedItem().toString() + "'";
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
    }//GEN-LAST:event_EditAddActionPerformed

    private void EditClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditClearActionPerformed
        EditPrice.setText("");
        EditHa.setText("");
        EditA.setText("");
        EditSw.setText("");
        EditB.setText("");
        EditC.setText("");
        EditG.setText("");
        EditW.setText("");
        EditMf.setText("");
        EditNoColor.setText("");
        EditProductName.setSelectedItem("");
        EditCategory.setSelectedItem("");
        EditLead.setText("");
        EditMin.setText("");
        EditMax.setText("");
    }//GEN-LAST:event_EditClearActionPerformed

    private void NewProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewProductNameActionPerformed

    private void EditProductNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_EditProductNamePopupMenuWillBecomeInvisible
        String Selected = (String) EditProductName.getSelectedItem();
        String sqlQuery = "Select * from Inventory where product=?";
        try {
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, Selected);
            rs = pst.executeQuery();
            if (rs.next()) {
                String ECategory = rs.getString("Category");
                EditCategory.setSelectedItem(ECategory);
                String EPrice = rs.getString("Price");
                EditPrice.setText(EPrice);
                String Ha = rs.getString("Ha");
                EditHa.setText(Ha);
                String A = rs.getString("A");
                EditA.setText(A);
                String Sw = rs.getString("Sw");
                EditSw.setText(Sw);
                String B = rs.getString("B");
                EditB.setText(B);
                String C = rs.getString("C");
                EditC.setText(C);
                String W = rs.getString("W");
                EditW.setText(W);
                String G = rs.getString("G");
                EditG.setText(G);
                String Mf = rs.getString("Mf");
                EditMf.setText(Mf);
                String NoColor = rs.getString("NoColor");
                EditNoColor.setText(NoColor);
                String Lead = rs.getString("Lead");
                NewLead.setText(Lead);
                String Max = rs.getString("Max");
                NewMax.setText(Max);
                String Min = rs.getString("ReOrder");
                NewMin.setText(Min);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_EditProductNamePopupMenuWillBecomeInvisible

    private void EditProductNamenone(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProductNamenone
        // TODO add your handling code here:
    }//GEN-LAST:event_EditProductNamenone

    private void EditHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditHomeActionPerformed

//Choices Panel``````````````````````
        //Buttons
        ChoserBtnEdit.setVisible(true);
        ChoserBtnUpdate.setVisible(true);
        ChoserbtnAdd.setVisible(true);
        //Panel
        ChoicesPanel.setVisible(true);
        //Background
        ChoicesBg.setVisible(true);
        //Label
//```````````````````````````````````

        //Edit All###########################
        //Panel
        EditPanel.setVisible(false);
        //Buttons
        EditAdd.setVisible(false);
        EditClear.setVisible(false);
        EditHome.setVisible(false);
        //TextFields
        EditPrice.setVisible(false);
        EditSw.setVisible(false);
        //Label
        Edit1.setVisible(false);
        Edit2.setVisible(false);
        Edit3.setVisible(false);
        Edit5.setVisible(false);
        //BackGround
        EditBackground.setVisible(false);
        //ComboBox
        EditCategory.setVisible(false);
        EditProductName.setVisible(false);
//###################################

//New Product------------------------
        //Panel
        //Buttons
        newAdd.setVisible(false);
        newhome.setVisible(false);
        NewClear.setVisible(false);
        //TextFields
        NewPrice.setVisible(false);
        NewProductName.setVisible(false);
        //Label
        new1.setVisible(false);
        new2.setVisible(false);
        new3.setVisible(false);
        new4.setVisible(false);
        new6.setVisible(false);
        //BackGround
        newBg.setVisible(false);
        //ComboBox
        NewCombobox.setVisible(false);
//-----------------------------------

//Add Quantity***********************
        //Panel
        UpdatePanel.setVisible(false);
        //Buttons
        UpdateButton.setVisible(false);
        UpdateClearButton.setVisible(false);
        UpdateHomeButton.setVisible(false);
        //TextFields
        //Label
        Update14.setVisible(false);
        Update2.setVisible(false);
        Update3.setVisible(false);
        Update4.setVisible(false);
        Update5.setVisible(false);
        Update7.setVisible(false);
        UpdateCategory.setVisible(false);
        UpdatePrice.setVisible(false);
        //BackGround
        UpdateBg.setVisible(false);
        //ComboBox
        UpdateProductName.setVisible(false);
//***********************************
    }//GEN-LAST:event_EditHomeActionPerformed

    private void ChoserBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoserBtnUpdateActionPerformed
//Choices Panel``````````````````````
        //Buttons
        ChoserBtnEdit.setVisible(false);
        ChoserBtnUpdate.setVisible(false);
        ChoserbtnAdd.setVisible(false);
        //Panel
        ChoicesPanel.setVisible(false);
        //Background
        ChoicesBg.setVisible(false);
        //Label
//```````````````````````````````````

        //Edit All###########################
        //Panel
        EditPanel.setVisible(false);
        //Buttons
        EditAdd.setVisible(false);
        EditClear.setVisible(false);
        EditHome.setVisible(false);
        //TextFields
        EditPrice.setVisible(false);
        EditSw.setVisible(false);
        //Label
        Edit1.setVisible(false);
        Edit2.setVisible(false);
        Edit3.setVisible(false);
        Edit5.setVisible(false);
        //BackGround
        EditBackground.setVisible(false);
        //ComboBox
        EditCategory.setVisible(false);
        EditProductName.setVisible(false);
//###################################

//New Product------------------------
        //Panel
        //Buttons
        newAdd.setVisible(false);
        newhome.setVisible(false);
        NewClear.setVisible(false);
        //TextFields
        NewPrice.setVisible(false);
        NewProductName.setVisible(false);
        //Label
        new1.setVisible(false);
        new2.setVisible(false);
        new3.setVisible(false);
        new4.setVisible(false);
        new6.setVisible(false);
        //BackGround
        newBg.setVisible(false);
        //ComboBox
        NewCombobox.setVisible(false);
//-----------------------------------

//Add Quantity***********************
        //Panel
        UpdatePanel.setVisible(true);
        //Buttons
        UpdateButton.setVisible(true);
        UpdateClearButton.setVisible(true);
        UpdateHomeButton.setVisible(true);
        //TextFields
        //Label
        Update14.setVisible(true);
        Update2.setVisible(true);
        Update3.setVisible(true);
        Update4.setVisible(true);
        Update5.setVisible(true);
        Update7.setVisible(true);
        UpdateCategory.setVisible(true);
        UpdatePrice.setVisible(true);
        //BackGround
        UpdateBg.setVisible(true);
        //ComboBox
        UpdateProductName.setVisible(true);
//***********************************
    }//GEN-LAST:event_ChoserBtnUpdateActionPerformed

    private void ChoserBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoserBtnEditActionPerformed
//Choices Panel``````````````````````
        //Buttons
        ChoserBtnEdit.setVisible(false);
        ChoserBtnUpdate.setVisible(false);
        ChoserbtnAdd.setVisible(false);
        //Panel
        ChoicesPanel.setVisible(false);
        //Background
        ChoicesBg.setVisible(false);
        //Label
//```````````````````````````````````

        //Edit All###########################
        //Panel
        EditPanel.setVisible(true);
        //Buttons
        EditAdd.setVisible(true);
        EditClear.setVisible(true);
        EditHome.setVisible(true);
        //TextFields
        EditPrice.setVisible(true);
        EditSw.setVisible(true);
        //Label
        Edit1.setVisible(true);
        Edit2.setVisible(true);
        Edit3.setVisible(true);
        Edit5.setVisible(true);
        //BackGround
        EditBackground.setVisible(true);
        //ComboBox
        EditCategory.setVisible(true);
        EditProductName.setVisible(true);
//###################################

//New Product------------------------
        //Panel
        //Buttons
        newAdd.setVisible(false);
        newhome.setVisible(false);
        NewClear.setVisible(false);
        //TextFields
        NewPrice.setVisible(false);
        NewProductName.setVisible(false);
        //Label
        new1.setVisible(false);
        new2.setVisible(false);
        new3.setVisible(false);
        new4.setVisible(false);
        new6.setVisible(false);
        //BackGround
        newBg.setVisible(false);
        //ComboBox
        NewCombobox.setVisible(false);
//-----------------------------------

//Add Quantity***********************
        //Panel
        UpdatePanel.setVisible(false);
        //Buttons
        UpdateButton.setVisible(false);
        UpdateClearButton.setVisible(false);
        UpdateHomeButton.setVisible(false);
        //TextFields
        //Label
        Update14.setVisible(false);
        Update2.setVisible(false);
        Update3.setVisible(false);
        Update4.setVisible(false);
        Update5.setVisible(false);
        Update7.setVisible(false);
        UpdateCategory.setVisible(false);
        UpdatePrice.setVisible(false);
        //BackGround
        UpdateBg.setVisible(false);
        //ComboBox
        UpdateProductName.setVisible(false);
//***********************************
    }//GEN-LAST:event_ChoserBtnEditActionPerformed

    private void ChoserbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoserbtnAddActionPerformed
//Choices Panel``````````````````````
        //Buttons
        ChoserBtnEdit.setVisible(false);
        ChoserBtnUpdate.setVisible(false);
        ChoserbtnAdd.setVisible(false);
        //Panel
        ChoicesPanel.setVisible(false);
        //Background
        ChoicesBg.setVisible(false);
        //Label
//```````````````````````````````````

        //Edit All###########################
        //Panel
        EditPanel.setVisible(false);
        //Buttons
        EditAdd.setVisible(false);
        EditClear.setVisible(false);
        EditHome.setVisible(false);
        //TextFields
        EditPrice.setVisible(false);
        EditSw.setVisible(false);
        //Label
        Edit1.setVisible(false);
        Edit2.setVisible(false);
        Edit3.setVisible(false);
        Edit5.setVisible(false);
        //BackGround
        EditBackground.setVisible(false);
        //ComboBox
        EditCategory.setVisible(false);
        EditProductName.setVisible(false);
//###################################

//New Product------------------------
        //Panel
        //Buttons
        newAdd.setVisible(true);
        newhome.setVisible(true);
        NewClear.setVisible(true);
        //TextFields
        NewPrice.setVisible(true);
        NewProductName.setVisible(true);
        //Label
        new1.setVisible(true);
        new2.setVisible(true);
        new3.setVisible(true);
        new4.setVisible(true);
        new6.setVisible(true);
        //BackGround
        newBg.setVisible(true);
        //ComboBox
        NewCombobox.setVisible(true);
//-----------------------------------

//Add Quantity***********************
        //Panel
        UpdatePanel.setVisible(false);
        //Buttons
        UpdateButton.setVisible(false);
        UpdateClearButton.setVisible(false);
        UpdateHomeButton.setVisible(false);
        //TextFields
        //Label
        Update14.setVisible(false);
        Update2.setVisible(false);
        Update3.setVisible(false);
        Update4.setVisible(false);
        Update5.setVisible(false);
        Update7.setVisible(false);
        UpdateCategory.setVisible(false);
        UpdatePrice.setVisible(false);
        //BackGround
        UpdateBg.setVisible(false);
        //ComboBox
        UpdateProductName.setVisible(false);
//***********************************
    }//GEN-LAST:event_ChoserbtnAddActionPerformed

    private void newhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newhomeActionPerformed

//Choices Panel``````````````````````
        //Buttons
        ChoserBtnEdit.setVisible(true);
        ChoserBtnUpdate.setVisible(true);
        ChoserbtnAdd.setVisible(true);
        //Panel
        ChoicesPanel.setVisible(true);
        //Background
        ChoicesBg.setVisible(true);
        //Label
//```````````````````````````````````

        //Edit All###########################
        //Panel
        EditPanel.setVisible(false);
        //Buttons
        EditAdd.setVisible(false);
        EditClear.setVisible(false);
        EditHome.setVisible(false);
        //TextFields
        EditPrice.setVisible(false);
        EditSw.setVisible(false);
        //Label
        Edit1.setVisible(false);
        Edit2.setVisible(false);
        Edit3.setVisible(false);
        Edit5.setVisible(false);
        //BackGround
        EditBackground.setVisible(false);
        //ComboBox
        EditCategory.setVisible(false);
        EditProductName.setVisible(false);
//###################################

//New Product------------------------
        //Panel
        //Buttons
        newAdd.setVisible(false);
        newhome.setVisible(false);
        NewClear.setVisible(false);
        //TextFields
        NewPrice.setVisible(false);
        NewProductName.setVisible(false);
        //Label
        new1.setVisible(false);
        new2.setVisible(false);
        new3.setVisible(false);
        new4.setVisible(false);
        new6.setVisible(false);
        //BackGround
        newBg.setVisible(false);
        //ComboBox
        NewCombobox.setVisible(false);
//-----------------------------------

//Add Quantity***********************
        //Panel
        UpdatePanel.setVisible(false);
        //Buttons
        UpdateButton.setVisible(false);
        UpdateClearButton.setVisible(false);
        UpdateHomeButton.setVisible(false);
        //TextFields
        //Label
        Update14.setVisible(false);
        Update2.setVisible(false);
        Update3.setVisible(false);
        Update4.setVisible(false);
        Update5.setVisible(false);
        Update7.setVisible(false);
        UpdateCategory.setVisible(false);
        UpdatePrice.setVisible(false);
        //BackGround
        UpdateBg.setVisible(false);
        //ComboBox
        UpdateProductName.setVisible(false);
//***********************************
    }//GEN-LAST:event_newhomeActionPerformed

    private void UpdateHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateHomeButtonActionPerformed

//Choices Panel``````````````````````
        //Buttons
        ChoserBtnEdit.setVisible(true);
        ChoserBtnUpdate.setVisible(true);
        ChoserbtnAdd.setVisible(true);
        //Panel
        ChoicesPanel.setVisible(true);
        //Background
        ChoicesBg.setVisible(true);
        //Label
//```````````````````````````````````

        //Edit All###########################
        //Panel
        EditPanel.setVisible(false);
        //Buttons
        EditAdd.setVisible(false);
        EditClear.setVisible(false);
        EditHome.setVisible(false);
        //TextFields
        EditPrice.setVisible(false);
        EditSw.setVisible(false);
        //Label
        Edit1.setVisible(false);
        Edit2.setVisible(false);
        Edit3.setVisible(false);
        Edit5.setVisible(false);
        //BackGround
        EditBackground.setVisible(false);
        //ComboBox
        EditCategory.setVisible(false);
        EditProductName.setVisible(false);
//###################################

//New Product------------------------
        //Panel
        //Buttons
        newAdd.setVisible(false);
        newhome.setVisible(false);
        NewClear.setVisible(false);
        //TextFields
        NewPrice.setVisible(false);
        NewProductName.setVisible(false);
        //Label
        new1.setVisible(false);
        new2.setVisible(false);
        new3.setVisible(false);
        new4.setVisible(false);
        new6.setVisible(false);
        //BackGround
        newBg.setVisible(false);
        //ComboBox
        NewCombobox.setVisible(false);
//-----------------------------------

//Add Quantity***********************
        //Panel
        UpdatePanel.setVisible(false);
        //Buttons
        UpdateButton.setVisible(false);
        UpdateClearButton.setVisible(false);
        UpdateHomeButton.setVisible(false);
        //TextFields
        //Label
        Update14.setVisible(false);
        Update2.setVisible(false);
        Update3.setVisible(false);
        Update4.setVisible(false);
        Update5.setVisible(false);
        Update7.setVisible(false);
        UpdateCategory.setVisible(false);
        UpdatePrice.setVisible(false);
        //BackGround
        UpdateBg.setVisible(false);
        //ComboBox
        UpdateProductName.setVisible(false);
//***********************************
    }//GEN-LAST:event_UpdateHomeButtonActionPerformed

    private void EditSwMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditSwMouseReleased

    }//GEN-LAST:event_EditSwMouseReleased

    private void EditAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditAMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditAMouseReleased

    private void EditAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditAActionPerformed

    private void EditBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditBMouseReleased

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditBActionPerformed

    private void EditCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditCMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditCMouseReleased

    private void EditCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditCActionPerformed

    private void EditWMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditWMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditWMouseReleased

    private void EditWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditWActionPerformed

    private void EditGMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditGMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditGMouseReleased

    private void EditGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditGActionPerformed

    private void EditMfMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMfMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMfMouseReleased

    private void EditMfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMfActionPerformed

    private void EditNoColorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditNoColorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditNoColorMouseReleased

    private void EditNoColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditNoColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditNoColorActionPerformed

    private void EditHaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditHaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditHaActionPerformed

    private void EditHaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditHaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditHaMouseReleased

    private void UpdateNewNoColorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewNoColorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewNoColorMouseReleased

    private void UpdateNewNoColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewNoColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewNoColorActionPerformed

    private void UpdateNewMfMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewMfMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewMfMouseReleased

    private void UpdateNewMfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewMfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewMfActionPerformed

    private void UpdateNewGMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewGMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewGMouseReleased

    private void UpdateNewGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewGActionPerformed

    private void UpdateNewWMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewWMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewWMouseReleased

    private void UpdateNewWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewWActionPerformed

    private void UpdateNewCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewCMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewCMouseReleased

    private void UpdateNewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewCActionPerformed

    private void UpdateNewBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewBMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewBMouseReleased

    private void UpdateNewBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewBActionPerformed

    private void UpdateNewSwMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewSwMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewSwMouseReleased

    private void UpdateNewSwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewSwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewSwActionPerformed

    private void UpdateNewAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewAMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewAMouseReleased

    private void UpdateNewAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewAActionPerformed

    private void UpdateNewHaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateNewHaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewHaMouseReleased

    private void UpdateNewHaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNewHaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateNewHaActionPerformed

    private void UpdateOldHaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldHaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldHaMouseReleased

    private void UpdateOldHaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldHaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldHaActionPerformed

    private void UpdateOldAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldAMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldAMouseReleased

    private void UpdateOldAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldAActionPerformed

    private void UpdateOldSwMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldSwMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldSwMouseReleased

    private void UpdateOldSwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldSwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldSwActionPerformed

    private void UpdateOldWMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldWMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldWMouseReleased

    private void UpdateOldWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldWActionPerformed

    private void UpdateOldCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldCMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldCMouseReleased

    private void UpdateOldCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldCActionPerformed

    private void UpdateOldBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldBMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldBMouseReleased

    private void UpdateOldBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldBActionPerformed

    private void UpdateOldGMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldGMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldGMouseReleased

    private void UpdateOldGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldGActionPerformed

    private void UpdateOldMfMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldMfMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldMfMouseReleased

    private void UpdateOldMfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldMfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldMfActionPerformed

    private void UpdateOldNoColorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateOldNoColorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldNoColorMouseReleased

    private void UpdateOldNoColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOldNoColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateOldNoColorActionPerformed

    private void NewNoColorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewNoColorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewNoColorMouseReleased

    private void NewNoColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewNoColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewNoColorActionPerformed

    private void NewMfMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMfMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewMfMouseReleased

    private void NewMfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewMfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewMfActionPerformed

    private void NewGMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewGMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewGMouseReleased

    private void NewGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewGActionPerformed

    private void NewWMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewWMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewWMouseReleased

    private void NewWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewWActionPerformed

    private void NewCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewCMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewCMouseReleased

    private void NewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewCActionPerformed

    private void NewBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewBMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewBMouseReleased

    private void NewBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewBActionPerformed

    private void NewSwMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewSwMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewSwMouseReleased

    private void NewSwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewSwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewSwActionPerformed

    private void NewAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewAMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewAMouseReleased

    private void NewAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewAActionPerformed

    private void NewHaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewHaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NewHaMouseReleased

    private void NewHaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewHaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewHaActionPerformed

    private void EditLeadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditLeadMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditLeadMouseReleased

    private void EditLeadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditLeadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditLeadActionPerformed

    private void EditMinMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMinMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMinMouseReleased

    private void EditMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMinActionPerformed

    private void EditMaxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMaxMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMaxMouseReleased

    private void EditMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMaxActionPerformed

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
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChoicesBg;
    private javax.swing.JPanel ChoicesPanel;
    private javax.swing.JButton ChoserBtnEdit;
    private javax.swing.JButton ChoserBtnUpdate;
    private javax.swing.JButton ChoserbtnAdd;
    private javax.swing.JLabel Edit1;
    private javax.swing.JLabel Edit10;
    private javax.swing.JLabel Edit11;
    private javax.swing.JLabel Edit12;
    private javax.swing.JLabel Edit13;
    private javax.swing.JLabel Edit14;
    private javax.swing.JLabel Edit15;
    private javax.swing.JLabel Edit16;
    private javax.swing.JLabel Edit17;
    private javax.swing.JLabel Edit18;
    private javax.swing.JLabel Edit2;
    private javax.swing.JLabel Edit3;
    private javax.swing.JLabel Edit4;
    private javax.swing.JLabel Edit5;
    private javax.swing.JLabel Edit6;
    private javax.swing.JLabel Edit7;
    private javax.swing.JLabel Edit8;
    private javax.swing.JLabel Edit9;
    private javax.swing.JTextField EditA;
    private javax.swing.JButton EditAdd;
    private javax.swing.JTextField EditB;
    private javax.swing.JLabel EditBackground;
    private javax.swing.JTextField EditC;
    private javax.swing.JComboBox EditCategory;
    private javax.swing.JButton EditClear;
    private javax.swing.JTextField EditG;
    private javax.swing.JTextField EditHa;
    private javax.swing.JButton EditHome;
    private javax.swing.JTextField EditLead;
    private javax.swing.JTextField EditMax;
    private javax.swing.JTextField EditMf;
    private javax.swing.JTextField EditMin;
    private javax.swing.JTextField EditNoColor;
    private javax.swing.JPanel EditPanel;
    private javax.swing.JTextField EditPrice;
    private javax.swing.JComboBox EditProductName;
    private javax.swing.JTextField EditSw;
    private javax.swing.JTextField EditW;
    private javax.swing.JTextField NewA;
    private javax.swing.JTextField NewB;
    private javax.swing.JTextField NewC;
    private javax.swing.JButton NewClear;
    private javax.swing.JComboBox NewCombobox;
    private javax.swing.JTextField NewG;
    private javax.swing.JTextField NewHa;
    private javax.swing.JTextField NewLead;
    private javax.swing.JTextField NewMax;
    private javax.swing.JTextField NewMf;
    private javax.swing.JTextField NewMin;
    private javax.swing.JTextField NewNoColor;
    private javax.swing.JTextField NewPrice;
    private javax.swing.JTextField NewProductName;
    private javax.swing.JTextField NewSw;
    private javax.swing.JTextField NewW;
    private javax.swing.JLabel Update10;
    private javax.swing.JLabel Update11;
    private javax.swing.JLabel Update12;
    private javax.swing.JLabel Update13;
    private javax.swing.JLabel Update14;
    private javax.swing.JLabel Update15;
    private javax.swing.JLabel Update2;
    private javax.swing.JLabel Update3;
    private javax.swing.JLabel Update4;
    private javax.swing.JLabel Update5;
    private javax.swing.JLabel Update7;
    private javax.swing.JLabel Update8;
    private javax.swing.JLabel Update9;
    private javax.swing.JLabel UpdateBg;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel UpdateCategory;
    private javax.swing.JButton UpdateClearButton;
    private javax.swing.JButton UpdateHomeButton;
    private javax.swing.JTextField UpdateNewA;
    private javax.swing.JTextField UpdateNewB;
    private javax.swing.JTextField UpdateNewC;
    private javax.swing.JTextField UpdateNewG;
    private javax.swing.JTextField UpdateNewHa;
    private javax.swing.JTextField UpdateNewMf;
    private javax.swing.JTextField UpdateNewNoColor;
    private javax.swing.JTextField UpdateNewSw;
    private javax.swing.JTextField UpdateNewW;
    private javax.swing.JTextField UpdateOldA;
    private javax.swing.JTextField UpdateOldB;
    private javax.swing.JTextField UpdateOldC;
    private javax.swing.JTextField UpdateOldG;
    private javax.swing.JTextField UpdateOldHa;
    private javax.swing.JTextField UpdateOldMf;
    private javax.swing.JTextField UpdateOldNoColor;
    private javax.swing.JTextField UpdateOldSw;
    private javax.swing.JTextField UpdateOldW;
    private javax.swing.JPanel UpdatePanel;
    private javax.swing.JLabel UpdatePrice;
    private javax.swing.JComboBox UpdateProductName;
    private javax.swing.JLabel new1;
    private javax.swing.JLabel new10;
    private javax.swing.JLabel new11;
    private javax.swing.JLabel new12;
    private javax.swing.JLabel new13;
    private javax.swing.JLabel new14;
    private javax.swing.JLabel new15;
    private javax.swing.JLabel new16;
    private javax.swing.JLabel new17;
    private javax.swing.JLabel new18;
    private javax.swing.JLabel new2;
    private javax.swing.JLabel new3;
    private javax.swing.JLabel new4;
    private javax.swing.JLabel new6;
    private javax.swing.JLabel new7;
    private javax.swing.JLabel new8;
    private javax.swing.JLabel new9;
    private javax.swing.JButton newAdd;
    private javax.swing.JLabel newBg;
    private javax.swing.JButton newhome;
    // End of variables declaration//GEN-END:variables

    private void InventoryFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
