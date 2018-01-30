package aks.test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import aks.constants.Constants;
import aks.stocks.Stock;
import aks.stocks.StockManager;
import aks.stocks.StockValue;

public class testStockPattern {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException, IOException {
		
		// TODO Auto-generated method stub
				System.out.println("WebServiceTest2");
				StockManager sm = new StockManager();
				StockValue sv;
				ArrayList<StockValue> arrStockValue = null;
				Integer Market = Constants.MARKET_BSE;
				Double addcount = (double) 0;		
				Calendar startDate;
				Calendar endDate;
			//	ArrayList<Stock> stocklist = sm.getAllStocks();
				System.out.println("Printing stock list");
				
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
				Date dtStock = (Date)formatter.parse("2016-07-13"); 
				startDate = Calendar.getInstance();
				startDate.setTime(dtStock);	
				
				System.out.println("START----------------------");
				Stock s = new Stock();
				s.setUnid(1);
				s.setYahoocode("POWERGRID");							
				String t = sm.getPattern(s, startDate, Market);
				System.out.println(t);
				System.out.println("END----------------------");							
				
				//sv = sm.FetchValueFromWeb(s,startDate, Constants.MARKET_NSE);
				
				System.out.println("Completed. Total Added:"+Double.toString(addcount));

	}

}
