package database;

import static database.ConnectDB.db;
import java.util.HashMap;

public class Product extends ConnectDB{
        
        private int productID;
    
	public int getProductID() {
		return productID;
	}

	public String getProductName() {
            String sql = "SELECT PRODUCTNAME FROM VICSPEED_STOCK WHERE PRODUCTID = " + productID;
            HashMap pname = db.queryRow(sql);
            return String.valueOf(pname.get("NAME"));
	}

	public String getProductType() {
            String sql = "SELECT TYPEOFPRODUCT FROM VICSPEED_STOCK WHERE PRODUCTID = " + productID;
            HashMap ptype = db.queryRow(sql);
            return String.valueOf(ptype.get("TYPE"));
	}

	public int getProductAmount() {
            String sql = "SELECT AMOUNT FROM VICSPEED_SALEORDER WHERE PRODUCTID = " + productID;
            HashMap pamount = db.queryRow(sql);
            return Integer.parseInt(String.valueOf(pamount.get("AMOUNT")));
	}

	public double getProductPrice() {
            String sql = "SELECT PRICE FROM VICSPEED_STOCK WHERE PRODUCTID = " + productID;
            HashMap pprice = db.queryRow(sql);
            return Integer.parseInt(String.valueOf(pprice.get("PRICE")));
	}

	public double getTotalPrice() {
            String sql = "SELECT ST.PRODUCTID, SUM(SO.AMOUNT * ST.PRICE) AS TOTAL_PRICE, FROM VICSPEED_STOCK AS ST "
                    + "JOIN VICSPEED_SALEORDER AS SO ON SO.PRODUCTID = ST.PRODUCTID WHERE ST.PRODUCTID = " + productID 
                    + "GROUP BY ST.PRODUCTID";
            HashMap totalp = db.queryRow(sql);
            return Double.parseDouble(String.valueOf(totalp.get("PRICE")));
	}
        
}
