/**
 * This class will actually hold data to be analyzed for each pattern
 * Instance of Pattern class is passed to this class 
 * which is used to calculates number of days it is supposed to hold data
 */
package aks.stocks.pattern;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import aks.stocks.StockValue;

public class PatternData {
	// Define possible status values of the class
	
	public static final String STATUS_EMPTY = "EMPTY";	
	public static final String STATUS_ADDING_PATTERN_DAYS = "ADDING_PAT_DAYS";
	public static final String STATUS_BUY_DATE_ADDED= "BUY_DATE_ADDED";
	public static final String STATUS_SELL_DATE_ADDED= "SELL_DATE_ADDED";
	public static final String STATUS_COMPLETE = "COMPLETE";
	
	private String status;
	private int intDayCounter;
	private ArrayList<StockValue> alStockValues;
	private StockValue svBuy;
	private StockValue svSell;
	private Pattern pt;
	
	public PatternData(Pattern pt){
		this.status = PatternData.STATUS_EMPTY;
		this.intDayCounter = 0;
		this.alStockValues = new ArrayList<StockValue>();
		this.pt = pt;
	}
	
	/**
	 * This function add day info to the object and returns status
	 * @return status
	 */
	public String addDay(StockValue sv){		
		//check status, if status is complete then return current status
		if(this.status.equals(PatternData.STATUS_COMPLETE) ){
			return this.status;
		}
		
		//add sell date
		if(this.intDayCounter ==0){
			this.svSell = sv;			
			this.status = PatternData.STATUS_SELL_DATE_ADDED;
			}
		else if(this.intDayCounter >0 && this.intDayCounter< this.pt.getSellDays()-1){			
		}		
		else if(this.intDayCounter == this.pt.getSellDays()-1){
			this.svBuy = sv;			
			this.status = PatternData.STATUS_BUY_DATE_ADDED;
			}
		else if(this.intDayCounter < this.pt.getSellDays() + this.pt.getPatternDays()){
			this.alStockValues.add(sv);			
			this.status = PatternData.STATUS_ADDING_PATTERN_DAYS;
			}
		else if(this.intDayCounter == this.pt.getSellDays() + this.pt.getPatternDays()){
			this.status = PatternData.STATUS_COMPLETE;			
		}
		this.intDayCounter = this.intDayCounter + 1;
		
		return this.status;
	}
	
	/**
	 * This function calculates the pattern
	 * @return pattern info object
	 */
	public StockPatternInfo getPatternInfo(){
		StockPatternInfo pinfo = new StockPatternInfo();
		double max = 0.0;
		double min = 10000000.0;
		double grad;
		int p1,p2,p3,p4,p5;
		if(this.svBuy == null){
			System.out.println("svBuy is null"+this.intDayCounter);
		}
		
		float gain = (float) ((this.svSell.getClose()-this.svBuy.getClose())*100/this.svBuy.getClose());		
				
		//calculate max value
		max = Math.max(this.alStockValues.get(0).getClose(),max);
		max = Math.max(this.alStockValues.get(1).getClose(),max);
		max = Math.max(this.alStockValues.get(2).getClose(),max);
		max = Math.max(this.alStockValues.get(3).getClose(),max);
		max = Math.max(this.alStockValues.get(4).getClose(),max);
		
		//calculate min value
		min = Math.min(this.alStockValues.get(0).getClose(),min);
		min = Math.min(this.alStockValues.get(1).getClose(),min);
		min = Math.min(this.alStockValues.get(2).getClose(),min);
		min = Math.min(this.alStockValues.get(3).getClose(),min);
		min = Math.min(this.alStockValues.get(4).getClose(),min);
		
		grad = (max-min)/5;
		
		p1= (int) Math.round((this.alStockValues.get(4).getClose()-min)/grad);
		p2=(int)Math.round((this.alStockValues.get(3).getClose()-min)/grad);
		p3=(int)Math.round((this.alStockValues.get(2).getClose()-min)/grad);
		p4=(int)Math.round((this.alStockValues.get(1).getClose()-min)/grad);
		p5=(int)Math.round((this.alStockValues.get(0).getClose()-min)/grad);
		
		String strPattern="";
		
		strPattern = strPattern + Integer.toString(p1)+"-";
		strPattern = strPattern + Integer.toString(p2)+"-";
		strPattern = strPattern + Integer.toString(p3)+"-";
		strPattern = strPattern + Integer.toString(p4)+"-";
		strPattern = strPattern + Integer.toString(p5);
		
		pinfo.setStrPatternString(strPattern);
		pinfo.setBuyDate(svBuy.getDt());
		pinfo.setSellDate(svSell.getDt());
		pinfo.setGain(gain);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		String temp =	strPattern + " | " ;
		temp = temp +formatter.format(this.alStockValues.get(4).getDt().getTime())+" | ";
		temp = temp +formatter.format(this.alStockValues.get(0).getDt().getTime())+ " | ";
		temp = temp +formatter.format(this.svBuy.getDt().getTime())+" | ";
		temp = temp +formatter.format(this.svSell.getDt().getTime());
		//System.out.println(temp);
	return pinfo;	
	}
	
	
	
}


