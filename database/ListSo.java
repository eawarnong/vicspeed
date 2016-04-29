package database;

import java.util.ArrayList;
import java.util.HashMap;

public class ListSo extends ConnectDB {

    public ListSo() {
        super();
    }

    public ArrayList<HashMap> getNormalSoIDs() {
        ArrayList<HashMap> SOs = getAllSaleOrders();
        ArrayList<HashMap> problemSOs = getProblemSoIDs();
        ArrayList<HashMap> normalSOs = new ArrayList();
        for(HashMap SO : SOs) {
            if(problemSOs.contains(SO)) {
                continue;
            } else {
                normalSOs.add(SO);
            }
        }
        return normalSOs;
    }
    
    public ArrayList<HashMap> getAllSaleOrders() {
        String sql = "SELECT SOID FROM VICSPEED_SALEORDER";
        return db.queryRows(sql);
    }

    public ArrayList<HashMap> getProblemSoIDs() {
        String sql = "SELECT SO.SOID"
                + " FROM VICSPEED_SALEORDER AS SO, VICSPEED_PRODUCTSO AS P_SO"
                + " WHERE SO.SOID = P_SO.SOID"
                + " AND (PRODUCTID, AMOUNT) NOT IN (SELECT PRODUCTID, SUM(AMOUNT) AS AMOUNT"
                +                 " FROM VICSPEED_INVOICE AS INV, VICSPEED_PRODUCTINV AS P_INV"
                +                 " WHERE INV.INVOICEID = P_INV.INVOICEID"
                +                 " AND SOID = SO.SOID"
                +                 " GROUP BY PRODUCTID)"
                + " ORDER BY SO.SOID";
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
