
package view;
import database.SaleOrder;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

public class SaleOrder_view extends javax.swing.JFrame {
    
    private SaleOrder saleOrder;
    private int soID;
    /**
     * Creates new form Refund_view
     */
    public SaleOrder_view(int soID) {
        saleOrder = new SaleOrder();
        this.soID = soID;
        
        saleOrder.connect();
        initComponents();
        addInfo();
        addProducts();
        summary();
        saleOrder.disconnect();
    }
    
    private void addInfo() {
        saleOrder.setSoID(soID);
        
        cusID.setText(""+saleOrder.getCustomerID());
        date.setText(saleOrder.getDateSo());
        cusName.setText(saleOrder.getCustomerName());
        companyName.setText(saleOrder.getCustomerCompany());
        deadline.setText(saleOrder.getDeadline());
        saleOrderID.setText(""+saleOrder.getSoID());
        credit.setText(""+saleOrder.getCredit());
        saleName.setText(saleOrder.getSaleName());
        
        ArrayList<HashMap> invIDs = saleOrder.getInvoiceIDs();
        for(HashMap invID : invIDs) {
            invCombo.addItem(invID.get("INVOICEID"));
        }
    }
    
    private void addProducts() {
        ArrayList<HashMap> products = saleOrder.getProducts();
        DefaultTableModel model = (DefaultTableModel) soTable.getModel();
        int line = 0;
        for (HashMap product : products) {
            model.addRow(new Object[0]);
            model.setValueAt(line+1, line, 0);
            model.setValueAt(product.get("PRODUCTID"), line, 1); // just for test
            model.setValueAt(product.get("PRODUCTID"), line, 1);
            model.setValueAt(product.get("PRODUCTNAME"), line, 2);
            model.setValueAt(product.get("AMOUNT"), line, 3);
            model.setValueAt(product.get("TYPEOFPRODUCT"), line, 4);
            model.setValueAt(String.format("%,.2f", product.get("PRICE")), line, 5);
            model.setValueAt(String.format("%,.2f", product.get("TOTALPRICE")), line, 6);
            line++;
            //String.format("%.2f", sumTotalPrice)
        }
    }
    
    private void summary() {
        double sumTotalPrice = saleOrder.getSumTotalPriceSO();
        double discount = saleOrder.getDiscount();
        //double finalPrice = (100-discount)*price/100;
        double tax = saleOrder.getTax();
        
        totalPrice.setText(String.format("%,.2f", sumTotalPrice));
        totalDiscount.setText(String.format("%.2f", discount));
        totalTax.setText(String.format("%.2f", tax));
        //total.setText(finalPrice);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        totalDiscount = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalTax = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        saleOrderID = new javax.swing.JLabel();
        credit = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        cusName = new javax.swing.JLabel();
        cusID = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        amountInvoice1 = new javax.swing.JLabel();
        deadline = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        companyName = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        saleName = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        invCombo = new javax.swing.JComboBox();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        soTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jButton1.setText("เสร็จสิ้น");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, 25));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel6.setText("รวมทั้งสิ้น");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel7.setText("จำนวนเงินรวม");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel8.setText("ส่วนลดการค้า");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        totalPrice.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        totalPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalPrice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 110, 25));

        totalDiscount.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        totalDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalDiscount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(totalDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 110, 25));

        total.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 110, 25));

        jLabel14.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel14.setText("อัตราภาษี(%)");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        totalTax.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        totalTax.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalTax.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(totalTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 110, 25));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 700, 140));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel1.setText("เลขที่เอกสาร");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel3.setText("ชื่อผู้ติดต่อ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel5.setText("พนักงานขาย");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jLabel11.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel11.setText("รหัสลูกค้า");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        saleOrderID.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        jPanel1.add(saleOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 120, 20));

        credit.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        jPanel1.add(credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 120, 20));

        date.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 90, 20));

        cusName.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        jPanel1.add(cusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 20));

        cusID.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        jPanel1.add(cusID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 20));

        jLabel13.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel13.setText("วันที่เอกสาร");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel16.setText("สั่งสินค้าภายใน (วัน)");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        amountInvoice1.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jPanel1.add(amountInvoice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 110, 20));

        deadline.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        jPanel1.add(deadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 90, 20));

        jLabel15.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel15.setText("ชื่อบริษัท");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        companyName.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        jPanel1.add(companyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 100, 20));

        jLabel12.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel12.setText("เครดิต (วัน)");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        saleName.setFont(new java.awt.Font("Angsana New", 1, 20)); // NOI18N
        jPanel1.add(saleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 120, 20));

        jLabel17.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        jLabel17.setText("เลขที่ใบกำกับ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        jPanel1.add(invCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 90, -1));

        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 68, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 700, 120));

        soTable.setFont(new java.awt.Font("Angsana New", 0, 20)); // NOI18N
        soTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " No.", "รหัสสินค้า", "ชื่อสินค้า", "จำนวน", "หน่วย", "ราคา/หน่วย", "จำนวนเงิน"
            }
        ));
        soTable.setRowHeight(20);
        jScrollPane1.setViewportView(soTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 700, 140));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sale Order");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/vicspeedBG.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        saleOrder.connect();
        
        int invID = Integer.parseInt(String.valueOf(invCombo.getSelectedItem()));
        new Invoice_view(invID).setVisible(true);
        
        saleOrder.disconnect();
    }//GEN-LAST:event_searchBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountInvoice1;
    private javax.swing.JLabel companyName;
    private javax.swing.JLabel credit;
    private javax.swing.JLabel cusID;
    private javax.swing.JLabel cusName;
    private javax.swing.JLabel date;
    private javax.swing.JLabel deadline;
    private javax.swing.JComboBox invCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel saleName;
    private javax.swing.JLabel saleOrderID;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable soTable;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalDiscount;
    private javax.swing.JLabel totalPrice;
    private javax.swing.JLabel totalTax;
    // End of variables declaration//GEN-END:variables
}
