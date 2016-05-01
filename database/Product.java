package database;

import static database.ConnectDB.db;
import java.util.ArrayList;
import java.util.HashMap;

public class Product extends ConnectDB {

    private int productID, docID;

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        String sql = "SELECT PRODUCTNAME FROM VICSPEED_STOCK WHERE PRODUCTID = " + productID;
        HashMap pname = db.queryRow(sql);
        return String.valueOf(pname.get("PRODUCTNAME"));
    }

    public String getProductType() {
        String sql = "SELECT TYPEOFPRODUCT FROM VICSPEED_STOCK WHERE PRODUCTID = " + productID;
        HashMap ptype = db.queryRow(sql);
        return String.valueOf(ptype.get("TYPEOFPRODUCT"));
    }

    public String getProductAmountSO() {
        String sql = "SELECT AMOUNT FROM VICSPEED_SALEORDER AS SO, VICSPEED_PRODUCTSO AS P_SO"
                + " WHERE PRODUCTID = " + productID
                + " AND SO.SOID = P_SO.SOID";
        HashMap pamount = db.queryRow(sql);
        return String.valueOf(pamount.get("AMOUNT"));
    }

    public String getProductAmountInvoice() {
        String sql = "SELECT AMOUNT FROM VICSPEED_INVOICE AS INV, VICSPEED_PRODUCTINV AS P_INV"
                + " WHERE PRODUCTID = " + productID
                + " AND INV.INVOICEID = P_INV.INVOICEID";
        HashMap pamount = db.queryRow(sql);
        return String.valueOf(pamount.get("AMOUNT"));
    }

    public Double getProductPrice() {
        String sql = "SELECT PRICE FROM VICSPEED_STOCK WHERE PRODUCTID = " + productID;
        HashMap pprice = db.queryRow(sql);
        return Double.parseDouble(String.valueOf(pprice.get("PRICE")));
    }

    public Double getTotalPriceInvoice() {
        String sql = "SELECT SUM(P_INV.AMOUNT * ST.PRICE) AS TOTALPRICE"
                + " FROM VICSPEED_STOCK AS ST JOIN VICSPEED_PRODUCTINV AS P_INV"
                + " ON P_INV.PRODUCTID = ST.PRODUCTID"
                + " JOIN VICSPEED_INVOICE AS INV ON INV.INVOICEID = P_INV.INVOICEID"
                + " WHERE ST.PRODUCTID = " + productID + " AND P_INV.INVOICEID = " + docID
                + " GROUP BY ST.PRODUCTID";
        HashMap totalp = db.queryRow(sql);
        return Double.parseDouble(String.valueOf(totalp.get("TOTALPRICE")));
    }

    public Double getTotalPriceSO() {
        String sql = "SELECT SUM(P_SO.AMOUNT * ST.PRICE) AS TOTALPRICE"
                + " FROM VICSPEED_STOCK AS ST JOIN VICSPEED_PRODUCTSO AS P_SO"
                + " ON P_SO.PRODUCTID = ST.PRODUCTID"
                + " JOIN VICSPEED_SALEORDER AS SO ON SO.SOID = P_SO.SOID"
                + " WHERE ST.PRODUCTID = " + productID + " AND P_SO.SOID = " + docID
                + " GROUP BY ST.PRODUCTID";
        HashMap totalp = db.queryRow(sql);
        return Double.parseDouble(String.valueOf(totalp.get("TOTALPRICE")));
    }

    public ArrayList<HashMap> getAllInvioceProducts(int soID) {
        String sql = "SELECT P_INV.PRODUCTID, SUM(AMOUNT) AS AMOUNT, (SUM(AMOUNT)*PRICE) AS TOTALPRICE"
                + " FROM VICSPEED_SALEORDER AS SO, VICSPEED_INVOICE AS INV, VICSPEED_PRODUCTINV AS P_INV, VICSPEED_STOCK AS ST"
                + " WHERE SO.SOID = " + soID
                + " AND SO.SOID = INV.SOID AND INV.INVOICEID = P_INV.INVOICEID AND P_INV.PRODUCTID = ST.PRODUCTID"
                + " GROUP BY PRODUCTID";
        return db.queryRows(sql);
    }
}

//class TestPro {
//    public static void main(String[] args) {
//        Product p = new Product();
//        p.connect();
//        p.setProductID(5001);
//        System.out.println(p.getProductID());
//        System.out.println(p.getProductType());
//        p.disconnect();
//    }
//}
