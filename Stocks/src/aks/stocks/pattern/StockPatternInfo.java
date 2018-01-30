package aks.stocks.pattern;

import java.util.Calendar;

public class StockPatternInfo {
	private String strPatternString;
	private Calendar calBuyDate;
	private Calendar calSellDate;
	private Calendar firstDate;
	private Calendar lastDate;
	public Calendar getFirstDate() {
		return firstDate;
	}
	public void setFirstDate(Calendar firstDate) {
		this.firstDate = firstDate;
	}
	public Calendar getLastDate() {
		return lastDate;
	}
	public void setLastDate(Calendar lastDate) {
		this.lastDate = lastDate;
	}
	private float gain;
	public String getStrPatternString() {
		return strPatternString;
	}
	public void setStrPatternString(String strPatternString) {
		this.strPatternString = strPatternString;
	}
	public Calendar getBuyDate() {
		return calBuyDate;
	}
	public void setBuyDate(Calendar calBuyDate) {
		this.calBuyDate = calBuyDate;
	}
	public Calendar getSellDate() {
		return calSellDate;
	}
	public void setSellDate(Calendar calSellDate) {
		this.calSellDate = calSellDate;
	}
	public float getGain() {
		return gain;
	}
	public void setGain(float gain) {
		this.gain = gain;
	}	
	
}
