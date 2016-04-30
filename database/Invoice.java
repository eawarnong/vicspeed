package database;

import static database.ConnectDB.db;
import java.util.ArrayList;
import java.util.HashMap;

public class Invoice extends ConnectDB {

    private int invoiceID;

    public Invoice() {
        super();
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public String getDateInvoice() {
        String sql = "SELECT DATE FROM VICSPEED_INVOICE WHERE INVOICEID = " + invoiceID;
        HashMap dateinv = db.queryRow(sql);
        return String.valueOf(dateinv.get("DATE"));
    }

    public int getApproveID() {
        String sql = "SELECT APPROVEID FROM VICSPEED_INVOICE WHERE INVOICEID = " + invoiceID;
        HashMap appid = db.queryRow(sql);
        return Integer.parseInt(String.valueOf(appid.get("APPROVEID")));
    }

    public String getDateApprove() {
        String sql = "SELECT DATEAPPROVE FROM VICSPEED_INVOICE WHERE INVOICEID = " + invoiceID;
        HashMap dateapp = db.queryRow(sql);
        return String.valueOf(dateapp.get("DATEAPPROVE"));
    }

    public ArrayList<HashMap> getProductIDs() {
        String sql = "SELECT PRODUCTID FROM VICSPEED_PRODUCTINV"
                + " WHERE INVOICEID = " + invoiceID;
        ArrayList<HashMap> proid = db.queryRows(sql);
        return proid;
    }

    public ArrayList<HashMap> getProducts() {
        ArrayList<HashMap> proids = getProductIDs();
        ArrayList<HashMap> products = new ArrayList<HashMap>();
        for (HashMap proid : proids) {
            Product product = new Product();
            HashMap productHashMap = new HashMap();
            //product.setProductID(Integer.parseInt(String.valueOf(proid.get("PRODUCTID"))));
            productHashMap.put("PRODUCTID", product.getProductID());
            productHashMap.put("PRODUCTNAME", product.getProductName());
            productHashMap.put("TYPEOFPRODUCT", product.getProductType());
            productHashMap.put("AMOUNT", product.getProductAmount());
            productHashMap.put("PRICE", product.getProductPrice());
            productHashMap.put("TOTALPRICE", product.getTotalPrice());
            products.add(productHashMap);
        }
        return products;
    }

}

class testInv {

    public static void main(String[] args) {
        Invoice i = new Invoice();
        i.connect();
        i.setInvoiceID(80001);

        System.out.println(i.getInvoiceID());
        System.out.println(i.getDateInvoice());
        System.out.println(i.getApproveID());
        System.out.println(i.getDateApprove());
        System.out.println(i.getProductIDs());
        System.out.println("");

        i.disconnect();
    }
}
