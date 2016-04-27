package database;
import java.util.ArrayList;
import java.util.HashMap;

public class ListSo extends ConnectDB{
        
        public ListSo() {
            super();
        }

        public ArrayList<HashMap> getAllInvoice(int soid) {
            String sql = "SELECT PRODUCTID, AMOUNT "
                    + "FROM VICSPEED_INVOICE, VICSPEED_PRODUCTINV "
                    + "WHERE VICSPEED_INVOICE.INVOICEID = VICSPEED_PRODUCTINV.INVOICEID "
                    + "AND SOID = " + soid;
            ArrayList<HashMap> allInvoice = db.queryRows(sql);
            return allInvoice;
        }
        
	public ArrayList<HashMap> getNormalSoIDs() {
		String sql = "SELECT SOID FROM SALEORDER WHERE ";
                return null;
	}

	public ArrayList<HashMap> getProblemSoIDs() {
		return null;
	}
}

class TestList {
    public static void main(String[] args) {
        ListSo l = new ListSo();
        ArrayList<HashMap> a = l.getAllInvoice(40001);
        //System.out.println(l.getAllInvoice(40001));
        for(HashMap h : a) {
            System.out.println(h.get("PRODUCTID"));
        }
    }
}