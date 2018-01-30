package aks.stocks.yahoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import aks.constants.Constants;
import aks.stocks.Stock;
import aks.stocks.StockValue;

public class StockAPI {
	
 	public ArrayList<StockValue> FetchValuesFromWeb(Stock s, Calendar d1, Calendar d2, Integer Market) throws IOException{
		StockValue sv = null;
		ArrayList<StockValue> arrStocsValue = new ArrayList<StockValue>(); 
		//Construct url to fetch stock data
		String qstring = "http://real-chart.finance.yahoo.com/table.csv?";
		
		if(Market == Constants.MARKET_BSE){
			qstring = qstring + "s="+s.getYahoocode()+".BO";}
		else{
			qstring = qstring + "s="+s.getYahoocode()+".NS";}
		
		qstring = qstring + "&a="+Integer.toString(d1.get(Calendar.MONTH));
		qstring = qstring + "&b="+Integer.toString(d1.get(Calendar.DAY_OF_MONTH));
		qstring = qstring + "&c="+Integer.toString(d1.get(Calendar.YEAR));
		
		qstring = qstring + "&d="+Integer.toString(d2.get(Calendar.MONTH));
		qstring = qstring + "&e="+Integer.toString(d2.get(Calendar.DAY_OF_MONTH));
		qstring = qstring + "&f="+Integer.toString(d2.get(Calendar.YEAR));
		
		qstring = qstring + "&g=d&ignore=.csv";
		
		//System.out.println(qstring);
		
		
		//Fetch csv file		
		URL url = new URL(qstring );
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		
		try{
			Integer linenumber =1;	
			String strTemp;
			while(null != (strTemp = br.readLine())){				
				if(linenumber != 1){				
					sv = this.getStockValudFromCSVLine(strTemp);
					arrStocsValue.add(sv);
					}
				linenumber = linenumber + 1; 
				//System.out.println(strTemp);
				}
			}catch(Exception e){
				System.out.println("error occured" + e.getLocalizedMessage());
			}		
		
		return arrStocsValue;
	}
 	
 	private StockValue getStockValudFromCSVLine(String s) throws ParseException{
		StockValue sv = null;
		String[] vals;
		sv = new StockValue();
		
		vals = s.split(",");	
		//get date
		String dateStr = vals[0]; 
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		Date dtStock = (Date)formatter.parse(dateStr); 
		Calendar calStock = Calendar.getInstance();
		calStock.setTime(dtStock);
		sv.setDt(calStock);
		
		sv.setOpen(Double.parseDouble(vals[1]));
		sv.setHigh(Double.parseDouble(vals[2]));
		sv.setLow(Double.parseDouble(vals[3]));
		sv.setClose(Double.parseDouble(vals[4]));
		sv.setVolume(Double.parseDouble(vals[5]));	
		sv.setAdjclose(Double.parseDouble(vals[6]));		
		return sv;		
		}

}
