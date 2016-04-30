package database;

import static database.ConnectDB.db;
import java.util.ArrayList;
import java.util.HashMap;

public class SaleOrder extends ConnectDB {

    private int soID;
    
    public SaleOrder() {
        super();
    }

    public void setSoID(int soID) {
        this.soID = soID;
    }

    public int getSoID() {
        return soID;
    }

    public String getDateSo() {
        String sql = "SELECT DATE FROM VICSPEED_SALEORDER WHERE SOID = " + soID;
        HashMap date = db.queryRow(sql);
        return String.valueOf(date.get("DATE"));
    }

    public String getDeadline() {
        String sql = "SELECT DEADLINE FROM VICSPEED_SALEORDER WHERE SOID = " + soID;
        HashMap dead = db.queryRow(sql);
        return String.valueOf(dead.get("DEADLINE"));
    }

    public int getCredit() {
        String sql = "SELECT CREDIT FROM VICSPEED_SALEORDER WHERE SOID = " + soID;
        HashMap credit = db.queryRow(sql);
        return Integer.parseInt(String.valueOf(credit.get("CREDIT")));
    }

    public double getDiscount() {
        String sql = "SELECT DISCOUNT FROM VICSPEED_SALEORDER WHERE SOID = " + soID;
        HashMap dis = db.queryRow(sql);
        return Double.parseDouble(String.valueOf(dis.get("DISCOUNT")));
    }

    public double getTax() {
        String sql = "SELECT TAX FROM VICSPEED_SALEORDER WHERE SOID = " + soID;
        HashMap taxs = db.queryRow(sql);
        return Double.parseDouble(String.valueOf(taxs.get("TAX")));
    }

    public int getCustomerID() {
        String sql = "SELECT CUSTOMERID FROM VICSPEED_SALEORDER WHERE SOID = " + soID;
        HashMap custid = db.queryRow(sql);
        return Integer.parseInt(String.valueOf(custid.get("CUSTOMERID")));

    }

    public String getCustomerName() {
        String sql = "SELECT FIRSTNAME, LASTNAME FROM VICSPEED_CUSTOMER, VICSPEED_SALEORDER "
                + "WHERE VICSPEED_SALEORDER.CUSTOMERID = VICSPEED_CUSTOMER.CUSTOMERID AND SOID = " + soID;
        HashMap custname = db.queryRow(sql);
        return String.valueOf(custname.get("FIRSTNAME")) + " " + String.valueOf(custname.get("LASTNAME"));
    }

    public String getCustomerCompany() {
        String sql = "SELECT COMPANYNAME"
                + " FROM VICSPEED_CUSTOMER AS CUS, VICSPEED_SALEORDER AS SO"
                + " WHERE SOID = " + soID
                + " AND CUS.CUSTOMERID = SO.CUSTOMERID";
        HashMap custcomp = db.queryRow(sql);
        return String.valueOf(custcomp.get("COMPANYNAME"));
    }

    public String getSaleName() {
        String sql = "SELECT FIRSTNAME, LASTNAME FROM VICSPEED_SALEORDER , VICSPEED_EMPLOYEE WHERE VICSPEED_SALEORDER.EMPID = VICSPEED_EMPLOYEE.EMPID AND SOID = " + soID;
        HashMap sname = db.queryRow(sql);
        return String.valueOf(sname.get("FIRSTNAME")) + " " + String.valueOf(sname.get("LASTNAME"));
    }
    
    public ArrayList<HashMap> getInvoiceIDs() {
        String sql = "SELECT INVOICEID FROM VICSPEED_INVOICE WHERE SOID = " + soID;
        return db.queryRows(sql);
    }

    private ArrayList<HashMap> getProductIDs() {
        String sql = "SELECT PRODUCTID FROM VICSPEED_PRODUCTSO WHERE SOID = " + soID;
        ArrayList<HashMap> proid = db.queryRows(sql);
        return db.queryRows(sql);
    }
    
    public ArrayList<HashMap> getProducts() {
        ArrayList<HashMap> proids = getProductIDs();
        ArrayList<HashMap> products = new ArrayList<HashMap>();
        for(HashMap proid : proids) {
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

class Test {

    public static void main(String[] args) {
        SaleOrder s = new SaleOrder();
        s.connect();
        s.setSoID(40001);

        System.out.println(s.getSoID());
        System.out.println(s.getDateSo());
        System.out.println(s.getDeadline());
        System.out.println(s.getCustomerID());
        System.out.println(s.getCustomerName());
        System.out.println(s.getCustomerCompany());
        System.out.println(s.getDiscount());
        System.out.println(s.getTax());
        System.out.println(s.getSaleName());
        System.out.println(s.getInvoiceIDs());
        s.disconnect();
    }
}
