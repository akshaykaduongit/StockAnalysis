package aks.test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import aks.stocks.*;
import aks.constants.*;
public class StockDataAddTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		StockManager sm = new StockManager();
		StockValue sv;
		Stock s = new Stock("Larsen and Toubro", "test","test", "bsecode", "nsecode", "LT", 2);
		Integer rowid;
		
		Calendar cl = Calendar.getInstance();
		cl.set(2015, 7, 13);		
		
		sv = sm.FetchValueFromWeb(s,cl, Constants.MARKET_NSE);		
		rowid = sm.addStockDataToDB(s, sv, cl, Constants.MARKET_NSE);
		System.out.println("Row ID:"+rowid.toString());
				
	}

}
