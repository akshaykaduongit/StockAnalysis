package aks.test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import aks.stocks.*;
import aks.constants.*;
public class WebServiceTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		StockManager sm = new StockManager();
		StockValue sv;
		Integer Market = Constants.MARKET_BSE;
		Double addcount = (double) 0;		
		Calendar startDate;
		Calendar endDate;
		Calendar dt;
				
		ArrayList<Stock> stocklist = sm.getAllStocks();
		System.out.println("Printing stock list");
		
		startDate = Calendar.getInstance();
		startDate.set(2000,1,1);
		
		endDate = Calendar.getInstance();
		endDate.set(2000,12,31);	
		dt = startDate;			
		
		
		while( !startDate.after(endDate)){
			System.out.println("START----------------------");
		    Date targetDay = startDate.getTime();
		    // Do Work Here
		    dt = Calendar.getInstance();
		    dt.setTime(targetDay);
		    System.out.println(dt.get(Calendar.YEAR)+"-"+dt.get(Calendar.MONTH)+"-"+dt.get(Calendar.DAY_OF_MONTH)+"("+dt.get(Calendar.DAY_OF_WEEK)+")");
		    
		    for(int i = 0; i< stocklist.size();++i){	
		    	Stock s = stocklist.get(i);			
				System.out.println(s.getStockname());				
				//Loop through dates to populate data	
				 try{
					 //Wait for some time
					 try {
						    Thread.sleep(500);                 //1000 milliseconds is one second.
						} catch(InterruptedException ex) {
						    Thread.currentThread().interrupt();
						}
					 sv = sm.FetchValueFromWeb(s,startDate, Market);
					 sm.addStockDataToDB(s, sv, dt, Market);
					 addcount = addcount + 1;
					 System.out.println(sv.getClose());
				 }catch(Exception e){
					 System.out.println("Error occured");
					 System.out.println(e.toString());
				 }
			}		
		   
		    System.out.println("END----------------------");
		    startDate.add(Calendar.DATE, 1);
		}
		
			
			
			
		
		
		//sv = sm.FetchValueFromWeb(s,startDate, Constants.MARKET_NSE);
		
		System.out.println("Completed. Total Added:"+Double.toString(addcount));
	}

	
	public void populateAllStocksDataForDay(){
		
		StockManager sm = new StockManager();
		StockValue sv;
		Integer Market = Constants.MARKET_BSE;
		Integer addcount = 0;
		String sql;		
		
	}
}
