package database;

import java.util.ArrayList;
import java.util.HashMap;

public class ListSo extends ConnectDB {

    public ListSo() {
        super();
    }
    
    public ArrayList<HashMap> getAllSaleOrders() {
        String sql = "SELECT SOID FROM VICSPEED_SALEORDER ORDER BY SOID";
        return db.queryRows(sql);
    }

    public ArrayList<HashMap> getNormalSoIDs() {
        ArrayList<HashMap> SOs = getAllSaleOrders();
        ArrayList<HashMap> problemSOs = getProblemSoIDs();
        ArrayList<HashMap> normalSOs = new ArrayList();
        
        for(HashMap SO : SOs) {
            if(!problemSOs.contains(SO)) {
                normalSOs.add(SO);
            }
        }
        return normalSOs;
    }
    
    public ArrayList<HashMap> getProblemSoIDs() {
        String sql = "SELECT DISTINCT SO.SOID"
                + " FROM VICSPEED_SALEORDER AS SO, VICSPEED_PRODUCTSO AS P_SO"
                + " WHERE SO.SOID = P_SO.SOID AND DEADLINE < CURDATE()"
                + " AND (PRODUCTID, AMOUNT) NOT IN (SELECT PRODUCTID, SUM(AMOUNT) AS AMOUNT"
                +                 " FROM VICSPEED_INVOICE AS INV, VICSPEED_PRODUCTINV AS P_INV"
                +                 " WHERE INV.INVOICEID = P_INV.INVOICEID"
                +                 " AND SOID = SO.SOID"
                +                 " GROUP BY PRODUCTID)"
                + " ORDER BY SO.SOID";
        return db.queryRows(sql);
    }
    
    public ArrayList<HashMap> getSO(int soid) {
        String sql = "SELECT SOID FROM VICSPEED_SALEORDER WHERE SOID = " + soid;
        return db.queryRows(sql);
    }
    
    public ArrayList<HashMap> getDateSO(String date) {
        String sql = "SELECT SOID FROM VICSPEED_SALEORDER WHERE DATE = '" + date + "' ";
        return db.queryRows(sql);
    }
    
    public ArrayList<HashMap> getCusIdSO(int cusid) {
        String sql = "SELECT SOID FROM VICSPEED_SALEORDER WHERE CUSTOMERID = " + cusid;
        return db.queryRows(sql);
    }
    
    public ArrayList<HashMap> getCusNameSO(String cusName) {
        String sql = "SELECT SOID FROM VICSPEED_SALEORDER AS SO, VICSPEED_CUSTOMER AS CUS"
                + " WHERE (FIRSTNAME LIKE '%" + cusName + "%'"
                + " OR LASTNAME LIKE '%" + cusName + "%')"
                + " AND SO.CUSTOMERID = CUS.CUSTOMERID";
        return db.queryRows(sql);
    }
    
    public ArrayList<HashMap> getCompanySO(String companyName) {
        String sql = "SELECT SOID FROM VICSPEED_SALEORDER AS SO, VICSPEED_CUSTOMER AS CUS"
                + " WHERE COMPANYNAME LIKE '%" + companyName + "%'"
                + " AND SO.CUSTOMERID = CUS.CUSTOMERID";
        return db.queryRows(sql);
    }

}

class TestList {

    public static void main(String[] args) {
        ListSo l = new ListSo();
        ArrayList<HashMap> a = new ArrayList<>();
        
        System.out.println("Normal");
         a = l.getNormalSoIDs();
         System.out.println(a);

         
         System.out.println();
         
         System.out.println("Problem");
         a = l.getProblemSoIDs();
         System.out.println(a);
         
        l.disconnect();
    }
}
