/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.ListSo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author eawarnong
 */
public class ListSO_view extends javax.swing.JFrame {

    /**
     * Creates new form ListSO_view
     */
    ListSo list;

    public ListSO_view() {
        list = new ListSo();
        list.connect();

        initComponents();
        addListSOs(list.getAllSaleOrders()); //default listSOs

        list.disconnect();
    }

    public void searchingSO() {
        list.connect();
        String selectItem = String.valueOf(searchBox.getSelectedItem());
        String text = searchText.getText();

        mainPanel.removeAll();
        mainPanel.revalidate();

        switch (selectItem) {
            case "เลขที่ใบสั่งขาย":
                if (isNumeric(text)) {
                    addListSOs(list.getSO(Integer.parseInt(text)));
                }
                break;
            case "วันที่เอกสารใบสั่งขาย":
                addListSOs(list.getDateSO(text));
                break;
            case "รหัสลูกค้า":
                if (isNumeric(text)) {
                    addListSOs(list.getCusIdSO(Integer.parseInt(text)));
                }
                break;
            case "ชื่อลูกค้า":
                addListSOs(list.getCusNameSO(text));
                break;
            case "ชื่อบริษัท":
                addListSOs(list.getCompanySO(text));
                break;
            case "ใบสั่งขายปกติ":
                searchText.setText("");
                addListSOs(list.getNormalSoIDs());
                break;
            case "ใบสั่งขายผิดปกติ":
                searchText.setText("");
                addListSOs(list.getProblemSoIDs());
                break;
            default:
                addListSOs(list.getAllSaleOrders());
        }

        mainPanel.repaint();
        list.disconnect();
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean checkProblemSOs(int soid) {
        ArrayList<HashMap> SOs = list.getProblemSoIDs();
        for (HashMap SO : SOs) {
            if (Integer.parseInt(String.valueOf(SO.get("SOID"))) == soid) {
                return true;
            }
        }
        return false;
    }

    public void addListSOs(ArrayList<HashMap> lists) {
        for (HashMap list : lists) {
            int soid = Integer.parseInt(String.valueOf(list.get("SOID")));
            PnlLine pnlLine = new PnlLine();
            JPanel pnlButton = new JPanel();
            JLabel lbl = new JLabel();

            lbl.setText(soid + "");
            lbl.setFont(new java.awt.Font("Angsana New", 0, 20));
            lbl.setBorder(new EmptyBorder(0, 5, 0, 0));
            pnlLine.add(lbl, BorderLayout.WEST);

            pnlButton.setLayout(new BorderLayout());
            //pnlButton.add(new SOButton(), BorderLayout.EAST); // Button for go to Sale Order page
            //pnlLine.add(pnlButton, BorderLayout.EAST);

            if (checkProblemSOs(soid)) {
                pnlLine.setColor(Color.RED);
            } else {
                pnlLine.setColor(Color.WHITE);
            }
            mainPanel.add(pnlLine);
        }
    }

    class PnlLine extends JPanel {

        public PnlLine() {
            init();
        }

        public void init() {
            // set proporty of pnlLine
            setLayout(new BorderLayout());
            setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1, false));
            setMinimumSize(new Dimension(mainPanel.getWidth() - 15, 40));
            setPreferredSize(new Dimension(mainPanel.getWidth() - 15, 40));
            setMaximumSize(new Dimension(mainPanel.getWidth() - 15, 40));
        }

        public void setColor(Color color) {
            setBackground(color);
        }

    }

    class SOButton extends JButton {

        public SOButton() {
            init();
        }

        public void init() {
            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    new SaleOrder_view().setVisible(true);
                }
            });
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

        jPanel1 = new javax.swing.JPanel();
        searchBox = new javax.swing.JComboBox();
        searchText = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPanel = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBox.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        searchBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "เลขที่ใบสั่งขาย", "วันที่เอกสารใบสั่งขาย", "รหัสลูกค้า", "ชื่อลูกค้า", "ชื่อบริษัท", "ใบสั่งขายปกติ", "ใบสั่งขายผิดปกติ" }));
        jPanel1.add(searchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));

        searchText.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 200, 30));

        searchBtn.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        searchBtn.setText("ค้นหา");
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 700, 60));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("List Sale Order");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPanel.setViewportView(mainPanel);

        getContentPane().add(jScrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 700, 410));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/vicspeedBG.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        searchingSO();
    }//GEN-LAST:event_searchBtnMouseClicked

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
            java.util.logging.Logger.getLogger(ListSO_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListSO_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListSO_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListSO_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListSO_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JComboBox searchBox;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
