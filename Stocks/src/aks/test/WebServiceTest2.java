package aks.test;

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

public class WebServiceTest2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		// TODO Auto-generated method stub
				System.out.println("WebServiceTest2");
				StockManager sm = new StockManager();
				StockValue sv;
				ArrayList<StockValue> arrStockValue = null;
				Integer Market = Constants.MARKET_BSE;
				Double addcount = (double) 0;		
				Calendar startDate;
				Calendar endDate;
				ArrayList<Stock> stocklist = sm.getAllStocks();
				System.out.println("Printing stock list");
				
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
				Date dtStock = (Date)formatter.parse("2005-1-1"); 
				startDate = Calendar.getInstance();
				startDate.setTime(dtStock);
							
				dtStock = (Date)formatter.parse("2005-12-31"); 
				endDate = Calendar.getInstance();
				endDate.setTime(dtStock);
				System.out.println("START----------------------");
				  
				    for(int i = 0; i< stocklist.size();++i){	
				   // for(int i = 0; i< 2;++i){
				    	Stock s = stocklist.get(i);			
									
						//Loop through dates to populate data	
						 try{
							 //Wait for some time
							 try {
								    Thread.sleep(500);                 //1000 milliseconds is one second.
								} catch(InterruptedException ex) {
								    Thread.currentThread().interrupt();
								}
							 arrStockValue = sm.FetchValuesFromWeb(s,startDate,endDate, Market);
							 
							 int counter = arrStockValue.size();
							 System.out.println(s.getStockname() + counter);
							 for(int i1 =0; i1< counter; ++i1){
								 sv=arrStockValue.get(i1);
								 System.out.println(sv.getDt().toString()+"-"+sv.getOpen() + "-" + sv.getClose());
								 System.out.println(sv.toString());
								 //sm.addStockDataToDB(s, sv, sv.getDt(), Market);
								 //Thread.sleep(500);                 //1000 milliseconds is one second.
							 }
							 
							 addcount = addcount + 1;
							
						 }catch(Exception e){
							 System.out.println("Error occured");
							 System.out.println(e.toString());
						 }
					}		
				   
				    System.out.println("END----------------------");				
					
				
				
				//sv = sm.FetchValueFromWeb(s,startDate, Constants.MARKET_NSE);
				
				System.out.println("Completed. Total Added:"+Double.toString(addcount));

	}

}
