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

    public ArrayList<HashMap> getProductIDs() {
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
            product.setProductID(Integer.parseInt(String.valueOf(proid.get("PRODUCTID"))));
            product.setDocID(soID);
            productHashMap.put("PRODUCTID", product.getProductID());
            productHashMap.put("PRODUCTNAME", product.getProductName());
            productHashMap.put("TYPEOFPRODUCT", product.getProductType());
            productHashMap.put("AMOUNT", product.getProductAmountSO());
            productHashMap.put("PRICE", product.getProductPrice());
            productHashMap.put("TOTALPRICE", product.getTotalPriceSO());
            products.add(productHashMap);
        }
        return products;
    }
    
    public ArrayList<HashMap> getAllInvioceProducts() {
        Product product = new Product();
        ArrayList<HashMap> pros = product.getAllInvioceProducts(soID);
        ArrayList<HashMap> products = new ArrayList<HashMap>();
        for(HashMap pro : pros) {
            HashMap productHashMap = new HashMap();
            int proid = Integer.parseInt(String.valueOf(pro.get("PRODUCTID")));
            product.setProductID(proid);
            product.setDocID(soID);
            productHashMap.put("PRODUCTID", proid);
            productHashMap.put("PRODUCTNAME", product.getProductName());
            productHashMap.put("TYPEOFPRODUCT", product.getProductType());
            productHashMap.put("AMOUNT", pro.get("AMOUNT"));
            productHashMap.put("PRICE", product.getProductPrice());
            productHashMap.put("TOTALPRICE", Double.parseDouble(String.valueOf(pro.get("TOTALPRICE"))));
            products.add(productHashMap);
        }
        return products;
    }

    public Double getSumTotalPriceSO() {
        ArrayList<HashMap> proids = getProductIDs();
        Double sumTotalPrice = 0.0;
        for(HashMap proid : proids) {
            Product product = new Product();
            product.setProductID(Integer.parseInt(String.valueOf(proid.get("PRODUCTID"))));
            product.setDocID(soID);
            sumTotalPrice += Double.parseDouble(String.valueOf(product.getTotalPriceSO()));
        }
        
        return sumTotalPrice;
    }
    
    public Double getSumTotalPriceInvoice() {
        ArrayList<HashMap> invids = getInvoiceIDs();
        Double sumTotalPrice = 0.0;
        for(HashMap invid : invids) {
            Invoice inv = new Invoice();
            inv.setInvoiceID(Integer.parseInt(String.valueOf(invid.get("INVOICEID"))));
            sumTotalPrice += inv.getSumTotalPrice();
        }
        return sumTotalPrice;
    }
    
    public Double getTotalSO() {
        return ((100-getDiscount())*getSumTotalPriceSO()/100) + (getSumTotalPriceSO()*getTax()/100); // price-discount+tax
    }
    
    public Double getSumDiscount() {
        ArrayList<HashMap> invids = getInvoiceIDs();
        Double sumDiscount = 0.0;
        for(HashMap invid : invids) {
            Invoice inv = new Invoice();
            inv.setInvoiceID(Integer.parseInt(String.valueOf(invid.get("INVOICEID"))));
            sumDiscount += inv.getDiscount();
        }
        return sumDiscount;
    }

}

class Test {

    public static void main(String[] args) {
        SaleOrder s = new SaleOrder();
        s.connect();
        s.setSoID(40004);

        System.out.println("Sale Order ID: " + s.getSoID());
        System.out.println("Sale Order Date: " + s.getDateSo());
        System.out.println("Sale Name: " + s.getSaleName());
        System.out.println("Deadline: " + s.getDeadline());
        System.out.println("Get All product ID: "  + s.getProductIDs());
        System.out.println("Information of Products: ");
        ArrayList<HashMap> ps = s.getProducts();
        for(HashMap p : ps) {
            System.out.println(p);
        }
        System.out.println("Total Price: " + s.getSumTotalPriceSO());
        System.out.println("Discount: " + s.getDiscount());
        System.out.println("Tax: " + s.getTax());
        System.out.println("Total SO Price (price-discount+tax): " + s.getTotalSO());
        System.out.println("Credit: " + s.getCredit());
        
        System.out.println("");
        System.out.println("Customer ID: " + s.getCustomerID());
        System.out.println("Customer Name: " + s.getCustomerName());
        System.out.println("Company Name: " + s.getCustomerCompany());
        
        System.out.println("");
        System.out.println("Get All invoice ID: " + s.getInvoiceIDs());
        System.out.println("Summary Information of All Products: " );
        ArrayList<HashMap> pi = s.getAllInvioceProducts();
        for(HashMap p : pi) {
            System.out.println(p);
        }
        System.out.println("Total Price of All Invoices: " + s.getSumTotalPriceInvoice());
        System.out.println("Sum Discount of All Invoices: " + s.getSumDiscount());
        s.disconnect();
    }
}
