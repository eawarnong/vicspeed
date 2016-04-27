package database;
import java.util.ArrayList;
import java.util.HashMap;

public class ListSo extends ConnectDB{

        public ArrayList<HashMap> getAllInvoice(int soid) {
            String sql = "SELECT PRODUCTID, AMOUNT"
                    + "FROM VICSPEED_INVOICE, VICSPEED_PRODUCTINV"
                    + "WHERE VICSPEED_INVOICE.INVOICEID = VICSPEED_PRODUCTINV.INVOICEID "
                    + "AND SOID = " + soid;
            ArrayList<HashMap> 
            return null;
        }
        
	public ArrayList<HashMap> getNormalSoIDs() {
		String sql = "SELECT SOID FROM SALEORDER WHERE ";
                return null;
	}

	public ArrayList<HashMap> getProblemSoIDs() {
		return null;
	}

}
