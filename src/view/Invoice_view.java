/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Oriopun Jaja
 */
public class Invoice_view extends javax.swing.JFrame {

    /**
     * Creates new form Refund_view
     */
    public Invoice_view() {
        initComponents();
        super.setSize(800,600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalSO = new javax.swing.JLabel();
        totalInvoice = new javax.swing.JLabel();
        refund = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SOid = new javax.swing.JLabel();
        LastName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        FirstName = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Invoice.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 30));

        jButton2.setFont(new java.awt.Font("Angsana New", 0, 18)); // NOI18N
        jButton2.setText("เสร็จสิ้น");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, -1, 25));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel6.setText("จำนวนเงินทั้งหมด");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel7.setText("จำนวนเงินรวม");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel8.setText("ส่วนลดการค้า");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        totalSO.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel2.add(totalSO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 110, 20));

        totalInvoice.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel2.add(totalInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 110, 20));

        refund.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel2.add(refund, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 110, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 670, 110));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 110, 20));

        jLabel13.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel13.setText("วันที่ใบกำกับ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        jLabel18.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 110, 20));

        jLabel16.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 110, 20));

        jLabel12.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel12.setText("ชื่อบริษัท");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel1.setText("อ้างถึง SO No.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel3.setText("ชื่อผู้ติดต่อ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel5.setText("เลขที่ใบกำกับ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel11.setText("รหัสลูกค้า");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        SOid.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(SOid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, 20));

        LastName.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 110, 20));

        jLabel15.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, 20));

        FirstName.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 110, 20));

        jLabel17.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 670, 120));

        jTable2.setFont(new java.awt.Font("Angsana New", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "รหัสสินค้า", "ชื่อสินค้า", "จำนวน", "ราคา/หน่วย", "ส่วนลด", "จำนวนเงิน"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 670, 160));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Invoice");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/vicspeedBG.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Invoice_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */ //JAJANAJA
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FirstName;
    private javax.swing.JLabel LastName;
    private javax.swing.JLabel SOid;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel refund;
    private javax.swing.JLabel totalInvoice;
    private javax.swing.JLabel totalSO;
    // End of variables declaration//GEN-END:variables
}
