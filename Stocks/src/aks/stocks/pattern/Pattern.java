/** * 
 * @author Akshay
 * This class will hold days for which pattern will be calculated and days after which stock will be sold.
 *  PatternDays : number of days for which pattern will be calculated
 *  SellDays : Number of days after which stock will be sold. 
 */

package aks.stocks.pattern;

public class Pattern {

	private int intPatternDays;
	private int intSellDays;
	public int getPatternDays() {
		return intPatternDays;
	}
	public void setPatternDays(int intPatternDays) {
		this.intPatternDays = intPatternDays;
	}
	public int getSellDays() {
		return intSellDays;
	}
	public void setSellDays(int intSellDays) {
		this.intSellDays = intSellDays;
	}
	
	
	
}
