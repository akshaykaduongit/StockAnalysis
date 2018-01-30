package aks.test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import com.aks.textfiles.TextFileList;

import aks.constants.Constants;
import aks.stocks.Stock;
import aks.stocks.StockManager;
import aks.stocks.StockValue;
import aks.stocks.pattern.Pattern;
import aks.stocks.pattern.PatternManager;
import aks.stocks.pattern.PatternStats;
import aks.stocks.pattern.PatternStatsManager;
import aks.stocks.pattern.StockPatternInfo;

public class testStockPatternToCSV {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException, IOException {
		
		// TODO Auto-generated method stub
				System.out.println("WebServiceTest2");
				StockManager 			sm = new StockManager();
				StockValue 				sv;
				ArrayList<StockValue> 	arrStockValue = null;
				ArrayList<Stock> 		arrStocks = null;
				Integer 				Market = Constants.MARKET_BSE;
				Double 					addcount = (double) 0;		
				Calendar 				startDate;
				Calendar 				endDate;			
				DateFormat 				formatter = new SimpleDateFormat("yyyy-MM-dd");
				Pattern 				pt = new Pattern();
				Stock 					s;			
				//Set start date
				Date dtStock = (Date)formatter.parse("1990-1-1"); 
				startDate = Calendar.getInstance();
				startDate.setTime(dtStock);
							
				//Set end date
				dtStock = (Date)formatter.parse("2016-07-25"); 
				endDate = Calendar.getInstance();
				endDate.setTime(dtStock);

				//Set pattern
				pt.setPatternDays(5);
				pt.setSellDays(5);
				
				System.out.println("START----------------------");
				//Initiate stat csv file				
				TextFileList csvStockPatternConsolidated = new TextFileList("C:\\StockData\\StockPattern\\Consolidated", "Consolidated_Patterns.csv");
				PatternStatsManager psm = new PatternStatsManager();
				
				//Get all stock list
				arrStocks = sm.getAllstocksManually();
								
				for(int cnt =0; cnt<arrStocks.size();cnt++){
					
					s= arrStocks.get(cnt);
					TextFileList csvStock = new TextFileList("C:\\StockData\\StockValue", s.getYahoocode()  +"_Data.csv");
					TextFileList csvStockPattern = new TextFileList("C:\\StockData\\StockPattern", s.getYahoocode()+"_Pattern.csv");
					
					//Loop through dates to populate data	
					try{
						//Wait for some time
						try {
							Thread.sleep(50);                 //1000 milliseconds is one second.
						} catch(InterruptedException ex){
							Thread.currentThread().interrupt();
						}
						
						arrStockValue = sm.FetchValuesFromWeb(s,startDate,endDate, Market);					
						
						PatternManager pm = new PatternManager(pt);
						StockPatternInfo spInfo;
											
						int counter = arrStockValue.size();
						
						System.out.println(s.getYahoocode() + counter);
						for(int i1 =0; i1< counter; ++i1){
							sv=arrStockValue.get(i1);
							if(sv.getVolume() != 0){												
								spInfo = pm.addDay(sv);
								csvStock.addLine(s.getYahoocode()+","+ formatter.format(sv.getDt().getTime())+","+sv.getOpen() + "," + sv.getClose());
								if(spInfo != null){
									csvStockPattern.addLine(spInfo.getStrPatternString()+","+spInfo.getGain()+","+formatter.format(spInfo.getBuyDate().getTime())+","+formatter.format(spInfo.getSellDate().getTime()));
									psm.addPatternStat(spInfo);
									}
								}
							}						
						csvStockPattern.closefile();	
						csvStock.closefile();
					}catch(Exception e){
						System.out.println("Error occured");
						e.printStackTrace();
						}									
					}
				
				//Print consolidated pattern data 
				ArrayList<PatternStats> arrPS = psm.getPatternStats();
				for(int i=0;i<arrPS.size();++i){
					PatternStats ps = arrPS.get(i);
					csvStockPatternConsolidated.addLine(ps.getStrPattern()+","+ps.getWin()+","+ps.getLoss()+","+ps.getTotal());
				}					
				csvStockPatternConsolidated.closefile();
				
				System.out.println("END----------------------");
				System.out.println("Completed. Total Added:"+Double.toString(addcount));

	}

}
