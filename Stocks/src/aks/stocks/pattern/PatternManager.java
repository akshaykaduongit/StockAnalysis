package aks.stocks.pattern;

import java.util.ArrayList;

import aks.stocks.StockValue;

public class PatternManager {

	
	private ArrayList<PatternData> arrPatternData;	
	private Pattern pt;
		
	
	public PatternManager(Pattern pt) {		
		this.arrPatternData = new ArrayList<PatternData>();
		this.pt = pt;
	}

/** 
 * @param sv
 * @return return PatternInfo if applicable otherwise Null
 */
	public StockPatternInfo addDay(StockValue sv){
		PatternData pd = new PatternData(this.pt);
		PatternData pdTemp;
		StockPatternInfo patternInfo = null;
		int toberemoved = -1;
		this.arrPatternData.add(pd);		
		String status;
		
		for(int i=0;i<this.arrPatternData.size();++i){
			pdTemp = this.arrPatternData.get(i);
			status = pdTemp.addDay(sv);
			if(status.equals(PatternData.STATUS_COMPLETE)){
				patternInfo = pdTemp.getPatternInfo();
				toberemoved = i;				
			}
		}
		
		//remove completed pattern data
		if(toberemoved!=-1){
			this.arrPatternData.remove(toberemoved);
		}
		return patternInfo;
	}
	
	
}
