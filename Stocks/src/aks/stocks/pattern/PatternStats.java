package aks.stocks.pattern;

public class PatternStats {
	private String strPattern;
	private int win;
	private int loss;
	
	public PatternStats(){
		this.win = 0;
		this.loss = 0;		
	}
	
	public String getStrPattern() {
		return strPattern;
	}
	public void setStrPattern(String strPattern) {
		this.strPattern = strPattern;
	}
	public int getWin() {
		return win;
	}
	public float getWinPercentage(){
		return this.win/(this.win+this.loss)*100;
	}	
	public void setWin(int win) {
		this.win = win;
	}	
	public void incrementWin(){
		this.win = this.win+1;
	}
	
	public int getLoss() {
		return loss;
	}
	public float getLossPercentage(){
		return this.loss/(this.win+this.loss)*100;
	}	
	public void setLoss(int loss) {
		this.loss = loss;
	}	
	public void incrementLoss(){
		this.loss = this.loss + 1;
	}
	
	public int getTotal(){
		return this.win + this.loss;
	}
}
