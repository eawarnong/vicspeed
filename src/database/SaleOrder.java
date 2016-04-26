package database;
import java.util.Date;
import java.util.SortedMap;
import java.util.HashMap;

public class SaleOrder extends ConnectDB{

	private int soID;

	public int getSoID() {
            return soID;
	}

	public String getDateSo() {
            String sql = "SELECT DATE FROM VICSPEED_SALEORDER WHERE SOID = " + soID;
            HashMap date = db.queryRow(sql);
            return String.valueOf(date.get("DATE"));
	}

	public String getDeadline() {
		return null;
	}

	public int getCredit() {
		return 0;
	}

	public double getDiscount() {
		return 0;
	}

	public double getTax() {
		return 0;
	}

	public int getCustomerID() {
		return 0;
	}

	public String getCustomerName() {
		return null;
	}

	public String getCustomerCompany() {
		return null;
	}

	public String getSaleName() {
		return null;
	}

	public SortedMap getProducts() {
		return null;
	}

}
