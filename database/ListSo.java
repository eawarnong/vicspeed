package database;
import java.util.ArrayList;
import java.util.HashMap;

public class ListSo extends ConnectDB{
        
        public ListSo() {
            super();
        }

        private ArrayList<HashMap> getAllInvoiceProducts(int soid) {
            String sql = "SELECT PRODUCTID, AMOUNT "
                    + "FROM VICSPEED_INVOICE, VICSPEED_PRODUCTINV "
                    + "WHERE VICSPEED_INVOICE.INVOICEID = VICSPEED_PRODUCTINV.INVOICEID "
                    + "AND SOID = " + soid;
            return db.queryRows(sql);
        }
        
        private ArrayList<HashMap> getSaleOrderProducts(int soid) {
            String sql = "SELECT PRODUCTID, AMOUNT "
                    + "FROM VICSPEED_PRODUCTSO "
                    + "WHERE SOID = " + soid;
            return db.queryRows(sql);
        }
        
        private ArrayList<HashMap> getAllSaleOrderIDs() {
            String sql = "SELECT SOID FROM VICSPEED_SALEORDER";
            return db.queryRows(sql);
        }
        
        public void mergeInvoiceProducts(int soid) {
            ArrayList<HashMap> invs = getAllInvoiceProducts(soid);
            ArrayList<HashMap> mergeInvs = new ArrayList();
            for(HashMap inv : invs) {
                if(mergeInvs.contains(inv.get("PRODUCTID"))) {
                    int index = mergeInvs.indexOf(inv.get("PRODUCTID"));
                    int invAmount = Integer.parseInt(String.valueOf(inv.get("AMOUNT")));
                    int oldMergeAmount = Integer.parseInt(String.valueOf(mergeInvs.get(index).get("AMOUNT")));
                    int newAmount = invAmount + oldMergeAmount;
                    HashMap newInv = new HashMap();
                    newInv.put(inv.get("PRODUCTID"), newAmount);
                    mergeInvs.set(index, newInv);
                } else {
                    mergeInvs.add(inv);
                }
            }
        }
        
	public ArrayList<HashMap> getNormalSoIDs() {
           // ArrayList<HashMap> soids = getAllSaleOrderIDs();
            /*for(HashMap soid : soids) {
                
            }*/
            
		//ArrayList<HashMap> invs = getAllInvoiceProducts(soid);
                return null;
	}

	public ArrayList<HashMap> getProblemSoIDs() {
		return null;
	}
}

class TestList {
    public static void main(String[] args) {
        ListSo l = new ListSo();
        
        /*
        ArrayList<HashMap> a = l.getAllInvoiceProducts(40001);
        System.out.println("Product id and amount of invoice");
        for(HashMap h : a) {
            System.out.println("PRODUCTID " + h.get("PRODUCTID") + " AMOUNT " + h.get("AMOUNT"));
        }
        
        System.out.println("");
        
        a = l.getSaleOrderProducts(40001);
        System.out.println("Product id and amount of sale order");
        for(HashMap h : a) {
            System.out.println("PRODUCTID " + h.get("PRODUCTID") + " AMOUNT " + h.get("AMOUNT"));
        }
        
        System.out.println("");
        
        a = l.getAllSaleOrderIDs();
        System.out.println("show all sale order id");
        for(HashMap h : a) {
            System.out.println(h.get("SOID"));
        }
        */
        
        //l.disconnect();
    }
}