/**
 * This class is a container to store stock information
 */

package aks.stocks;


public class Stock {

	private String stockname;
	private String sector;
	private String sectorCategory;
	private String bsecode;
	private String nsecode;
	private String yahoocode;
	private Integer unid;
	
	/*************************************************/
	//				CONSTRUCTOR
	/*************************************************/
	public Stock(String stockname, String sector, String sectorCategory, String bsecode, String nsecode,
			String yahoocode, Integer unid) {
		super();
		this.stockname = stockname;
		this.sector = sector;
		this.sectorCategory = sectorCategory;
		this.bsecode = bsecode;
		this.nsecode = nsecode;
		this.yahoocode = yahoocode;
		this.unid = unid;
	}
	
	public Stock(){}
	
	//constructor that takes symbol and unid values
	public Stock(String symbol, String unid){
		this.yahoocode = symbol;
		this.unid= Integer.parseInt(unid);
		this.nsecode = symbol;
	}
	
	/*************************************************/
	// 				GETTERS AND SETTERS
	/*************************************************/
	public String getStockname() {
		return stockname;
	}
	
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getSectorCategory() {
		return sectorCategory;
	}
	public void setSectorCategory(String sectorCategory) {
		this.sectorCategory = sectorCategory;
	}
	public String getBsecode() {
		return bsecode;
	}
	public void setBsecode(String bsecode) {
		this.bsecode = bsecode;
	}
	public String getNsecode() {
		return nsecode;
	}
	public void setNsecode(String nsecode) {
		this.nsecode = nsecode;
	}
	public String getYahoocode() {
		return yahoocode;
	}
	public void setYahoocode(String yahoocode) {
		this.yahoocode = yahoocode;
	}
	public Integer getUnid() {
		return unid;
	}
	public void setUnid(Integer unid) {
		this.unid = unid;
	}	
	
	
}
