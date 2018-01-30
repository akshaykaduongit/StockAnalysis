/**
 * This class is a container to store stock values for a day
 *  
 */


package aks.stocks;

import java.util.Calendar;

public class StockValue {
	
	private double open;
	private double close;
	private double high;
	private double low;
	private double volume;
	private double adjclose;
	private Calendar dt;
	
	
	/*************************************************/
	// 				GETTERS AND SETTERS
	/*************************************************/
	public Calendar getDt() {
		return dt;
	}
	public void setDt(Calendar dt) {
		this.dt = dt;
	}
	
	public double getOpen() {
		return open;
	}
	public double getAdjclose() {
		return adjclose;
	}
	public void setAdjclose(double adjclose) {
		this.adjclose = adjclose;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}	
	
	public void print(){
		
	}
	
}
