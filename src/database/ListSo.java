package database;
import java.util.ArrayList;

public class ListSo extends ConnectDB{

	public ArrayList getNormalSoIDs() {
		String sql = "SELECT SOID FROM SALEORDER WHERE ";
	}

	public ArrayList getProblemSoIDs() {
		return null;
	}

}
