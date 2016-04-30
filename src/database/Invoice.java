package database;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedMap;

public class Invoice extends SaleOrder {

	private int invoiceID;
        
        public Invoice(){
            super();
        }
        
        public void setInvoiceID(int invoiceID){
            this.invoiceID = invoiceID;
        }
        
        
        
	public int getInvoiceID() {
            String sql = "SELECT INVOICEID FROM VICSPEED_INVOICE WHERE INVOICEID = " + invoiceID;
            HashMap invid = db.queryRow(sql);
            return Integer.parseInt(String.valueOf(invid.get("INVOICEID")));
		
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

	public ArrayList<HashMap> getProductsID() {
            String sql = "SELECT PRODUCTID FROM VICSPEED_PRODUCTINV" 
                    + " WHERE INVOICEID = " + invoiceID;
            ArrayList<HashMap> proid = db.queryRows(sql);
            return proid;
	}

}
class test{
    public static void main(String[]args){
        Invoice i = new Invoice();
        i.setInvoiceID(80001);
        
        
        System.out.println(i.getInvoiceID());
        System.out.println(i.getDateInvoice());
        System.out.println(i.getApproveID());
        System.out.println(i.getDateApprove());
        System.out.println(i.getProductsID());
        System.out.println("");
        
        
        i.disconnect();
    }
}
