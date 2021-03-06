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
        //System.out.println("Set invoiceID = " + invoiceID + " Successfully");
    }

    public int getInvoiceID() {
        return invoiceID;
    }
    
    public int getSOID() {
        String sql = "SELECT SOID FROM VICSPEED_INVOICE WHERE INVOICEID = " + invoiceID;
        HashMap soid = db.queryRow(sql);
        return Integer.parseInt(String.valueOf(soid.get("SOID")));
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
    
    public String getCustomerID() {
        String sql = "SELECT CUSTOMERID FROM VICSPEED_INVOICE AS INV, VICSPEED_SALEORDER AS SO"
                + " WHERE INV.SOID = SO.SOID AND INVOICEID = " + invoiceID;
        HashMap cusid = db.queryRow(sql);
        return String.valueOf(cusid.get("CUSTOMERID"));
    }
    
    public String getCustomerName() {
        String sql = "SELECT FIRSTNAME, LASTNAME"
                + " FROM VICSPEED_INVOICE AS INV, VICSPEED_CUSTOMER AS CUS, VICSPEED_SALEORDER AS SO"
                + " WHERE INVOICEID = " + invoiceID
                + " AND INV.SOID = SO.SOID AND SO.CUSTOMERID = CUS.CUSTOMERID";
        HashMap cusName = db.queryRow(sql);
        return String.valueOf(cusName.get("FIRSTNAME")) + " " + String.valueOf(cusName.get("LASTNAME"));
    }
    
    public String getCompanyName() {
        String sql = "SELECT COMPANYNAME"
                + " FROM VICSPEED_INVOICE AS INV, VICSPEED_CUSTOMER AS CUS, VICSPEED_SALEORDER AS SO"
                + " WHERE INV.INVOICEID = " + invoiceID
                + " AND INV.SOID = SO.SOID AND SO.CUSTOMERID = CUS.CUSTOMERID";
        HashMap comName = db.queryRow(sql);
        return String.valueOf(comName.get("COMPANYNAME"));
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
            product.setProductID(Integer.parseInt(String.valueOf(proid.get("PRODUCTID"))));
            product.setDocID(invoiceID);
            productHashMap.put("PRODUCTID", product.getProductID());
            productHashMap.put("PRODUCTNAME", product.getProductName());
            productHashMap.put("TYPEOFPRODUCT", product.getProductType());
            productHashMap.put("AMOUNT", product.getProductAmountInvoice());
            productHashMap.put("PRICE", product.getProductPrice());
            productHashMap.put("TOTALPRICE", product.getTotalPriceInvoice());
            products.add(productHashMap);
        }
        return products;
    }

    public Double getSumTotalPrice() {
        ArrayList<HashMap> proids = getProductIDs();
        Double sumTotalPrice = 0.0;
        for(HashMap proid : proids) {
            Product product = new Product();
            product.setProductID(Integer.parseInt(String.valueOf(proid.get("PRODUCTID"))));
            product.setDocID(invoiceID);
            sumTotalPrice += Double.parseDouble(String.valueOf(product.getTotalPriceInvoice()));
        }
        return sumTotalPrice;
    }
    
    public double getDiscount() {
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setSoID(getSOID());
        double discount = saleOrder.getDiscount();
        double totalPrice = getSumTotalPrice();
        return discount*totalPrice/100;
    }

}

class testInv {

    public static void main(String[] args) {
        Invoice i = new Invoice();
        i.connect();
        i.setInvoiceID(80019);
        
        System.out.println("Sale Order ID: " + i.getSOID());
        System.out.println("Invoice ID: " + i.getInvoiceID());
        System.out.println("Invoice Date: " + i.getDateInvoice());
        System.out.println("Approve ID: " + i.getApproveID());
        System.out.println("Approve Date: " + i.getDateApprove());
        
        System.out.println("");
        System.out.println("Customer ID: " + i.getCustomerID());
        System.out.println("Customer Name: " + i.getCustomerName());
        System.out.println("Company Name: " + i.getCompanyName());
        
        System.out.println("");
        System.out.println("Products ID: " + i.getProductIDs());
        System.out.println("Infomation of Products: ");
        ArrayList<HashMap> ps = i.getProducts();
        for(HashMap p : ps) {
            System.out.println(p);
        }
        System.out.println("Total Price: " + i.getSumTotalPrice());
        System.out.println("Discount: " + i.getDiscount());

        i.disconnect();
    }
}
