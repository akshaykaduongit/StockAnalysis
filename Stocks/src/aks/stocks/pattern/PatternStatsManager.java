package aks.stocks.pattern;

import java.util.ArrayList;

import com.mysql.jdbc.UpdatableResultSet;

public class PatternStatsManager {

	
	ArrayList<PatternStats> arrPS_0;
	ArrayList<PatternStats> arrPS_1;
	ArrayList<PatternStats> arrPS_2;
	ArrayList<PatternStats> arrPS_3;
	ArrayList<PatternStats> arrPS_4;
	ArrayList<PatternStats> arrPS_5;
	
	public PatternStatsManager(){
		this.arrPS_0 = new ArrayList<PatternStats>();
		this.arrPS_1 = new ArrayList<PatternStats>();
		this.arrPS_2 = new ArrayList<PatternStats>();
		this.arrPS_3 = new ArrayList<PatternStats>();
		this.arrPS_4 = new ArrayList<PatternStats>();
		this.arrPS_5 = new ArrayList<PatternStats>();
	}
		
	public ArrayList<PatternStats> getPatternStats(){
		ArrayList<PatternStats> psTemp = new ArrayList<PatternStats>();
		psTemp.addAll(this.arrPS_0);
		psTemp.addAll(this.arrPS_1);
		psTemp.addAll(this.arrPS_2);
		psTemp.addAll(this.arrPS_3);
		psTemp.addAll(this.arrPS_4);
		psTemp.addAll(this.arrPS_5);		
		
		return psTemp;
	}
	
	public void addPatternStat(StockPatternInfo pi){
		//System.out.println("Size:"+this.arrPS_0.size()+"-"+this.arrPS_1.size()+"-"+this.arrPS_2.size()+"-"+this.arrPS_3.size()+"-"+this.arrPS_4.size()+"-"+this.arrPS_5.size());
		
		//Set win flag
		 boolean win = false;
		 boolean upateFlag = false;
		 String strPattern;
		 PatternStats ps = new PatternStats();
		 
		 strPattern = pi.getStrPatternString();		 
		 if(pi.getGain()>= 5.0){win = true; }
		 
		 if(strPattern.startsWith("0-")){			 
			//Loop through array
			for(int i=0; i<arrPS_0.size();++i){					
				if(arrPS_0.get(i).getStrPattern().equals(strPattern)){
					if(win){ this.arrPS_0.get(i).incrementWin();} else{ this.arrPS_0.get(i).incrementLoss(); }
					upateFlag = true;
					break;
					}
				}	
			
			//Add element to array
			if(upateFlag == false){
				ps.setStrPattern(pi.getStrPatternString());
				if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
				this.arrPS_0.add(ps);			 			
			}
			 
		 }// End IF
		 
		 if(strPattern.startsWith("1-")){			 
				//Loop through array
				for(int i=0; i<arrPS_1.size();++i){					
					if(arrPS_1.get(i).getStrPattern().equals(strPattern)){
						if(win){ this.arrPS_1.get(i).incrementWin();} else{ this.arrPS_1.get(i).incrementLoss(); }
						upateFlag = true;
						break;
						}
					}	
				//Add element to array
				if(upateFlag == false){
					ps.setStrPattern(pi.getStrPatternString());
					if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
					this.arrPS_1.add(ps);			 			
				}
				 
			 }// End IF
		 
		 if(strPattern.startsWith("2-")){			 
				//Loop through array
				for(int i=0; i<arrPS_2.size();++i){					
					if(arrPS_2.get(i).getStrPattern().equals(strPattern)){
						if(win){ this.arrPS_2.get(i).incrementWin();} else{ this.arrPS_2.get(i).incrementLoss(); }
						upateFlag = true;
						break;
						}
					}	
				//Add element to array
				if(upateFlag == false){
					ps.setStrPattern(pi.getStrPatternString());
					if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
					this.arrPS_2.add(ps);			 			
				}
				 
			 }// End IF
		 
		 if(strPattern.startsWith("3-")){			 
				//Loop through array
				for(int i=0; i<arrPS_3.size();++i){					
					if(arrPS_3.get(i).getStrPattern().equals(strPattern)){
						if(win){ this.arrPS_3.get(i).incrementWin();} else{ this.arrPS_3.get(i).incrementLoss(); }
						upateFlag = true;
						break;
						}
					}	
				//Add element to array
				if(upateFlag == false){
					ps.setStrPattern(pi.getStrPatternString());
					if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
					this.arrPS_3.add(ps);			 			
				}
				 
			 }// End IF
		 
		 if(strPattern.startsWith("4-")){			 
				//Loop through array
				for(int i=0; i<arrPS_4.size();++i){					
					if(arrPS_4.get(i).getStrPattern().equals(strPattern)){
						if(win){ this.arrPS_4.get(i).incrementWin();} else{ this.arrPS_4.get(i).incrementLoss(); }
						upateFlag = true;
						break;
						}
					}	
				//Add element to array
				if(upateFlag == false){
					ps.setStrPattern(pi.getStrPatternString());
					if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
					this.arrPS_4.add(ps);			 			
				}
				 
			 }// End IF
		 
		 if(strPattern.startsWith("5-")){			 
				//Loop through array
				for(int i=0; i<arrPS_5.size();++i){					
					if(arrPS_5.get(i).getStrPattern().equals(strPattern)){
						if(win){ this.arrPS_5.get(i).incrementWin();} else{ this.arrPS_5.get(i).incrementLoss(); }
						upateFlag = true;
						break;
						}
					}	
				//Add element to array
				if(upateFlag == false){
					ps.setStrPattern(pi.getStrPatternString());
					if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
					this.arrPS_5.add(ps);			 			
				}				 
			 }// End IF		 
		 }	

public void addPatternStat(String strPattern, boolean win){
	
	//Set win flag	 
	 boolean upateFlag = false;	 
	 PatternStats ps = new PatternStats();
	 	 
	 if(strPattern.startsWith("0-")){			 
		//Loop through array
		for(int i=0; i<arrPS_0.size();++i){					
			if(arrPS_0.get(i).getStrPattern().equals(strPattern)){
				if(win){ this.arrPS_0.get(i).incrementWin();} else{ this.arrPS_0.get(i).incrementLoss(); }
				upateFlag = true;
				break;
				}
			}	
		
		//Add element to array
		if(upateFlag == false){
			ps.setStrPattern(strPattern);
			if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
			this.arrPS_0.add(ps);			 			
		}
		 
	 }// End IF
	 
	 if(strPattern.startsWith("1-")){			 
			//Loop through array
			for(int i=0; i<arrPS_1.size();++i){					
				if(arrPS_1.get(i).getStrPattern().equals(strPattern)){
					if(win){ this.arrPS_1.get(i).incrementWin();} else{ this.arrPS_1.get(i).incrementLoss(); }
					upateFlag = true;
					break;
					}
				}	
			//Add element to array
			if(upateFlag == false){
				ps.setStrPattern(strPattern);
				if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
				this.arrPS_1.add(ps);			 			
			}
			 
		 }// End IF
	 
	 if(strPattern.startsWith("2-")){			 
			//Loop through array
			for(int i=0; i<arrPS_2.size();++i){					
				if(arrPS_2.get(i).getStrPattern().equals(strPattern)){
					if(win){ this.arrPS_2.get(i).incrementWin();} else{ this.arrPS_2.get(i).incrementLoss(); }
					upateFlag = true;
					break;
					}
				}	
			//Add element to array
			if(upateFlag == false){
				ps.setStrPattern(strPattern);
				if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
				this.arrPS_2.add(ps);			 			
			}
			 
		 }// End IF
	 
	 if(strPattern.startsWith("3-")){			 
			//Loop through array
			for(int i=0; i<arrPS_3.size();++i){					
				if(arrPS_3.get(i).getStrPattern().equals(strPattern)){
					if(win){ this.arrPS_3.get(i).incrementWin();} else{ this.arrPS_3.get(i).incrementLoss(); }
					upateFlag = true;
					break;
					}
				}	
			//Add element to array
			if(upateFlag == false){
				ps.setStrPattern(strPattern);
				if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
				this.arrPS_3.add(ps);			 			
			}
			 
		 }// End IF
	 
	 if(strPattern.startsWith("4-")){			 
			//Loop through array
			for(int i=0; i<arrPS_4.size();++i){					
				if(arrPS_4.get(i).getStrPattern().equals(strPattern)){
					if(win){ this.arrPS_4.get(i).incrementWin();} else{ this.arrPS_4.get(i).incrementLoss(); }
					upateFlag = true;
					break;
					}
				}	
			//Add element to array
			if(upateFlag == false){
				ps.setStrPattern(strPattern);
				if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
				this.arrPS_4.add(ps);			 			
			}
			 
		 }// End IF
	 
	 if(strPattern.startsWith("5-")){			 
			//Loop through array
			for(int i=0; i<arrPS_5.size();++i){					
				if(arrPS_5.get(i).getStrPattern().equals(strPattern)){
					if(win){ this.arrPS_5.get(i).incrementWin();} else{ this.arrPS_5.get(i).incrementLoss(); }
					upateFlag = true;
					break;
					}
				}	
			//Add element to array
			if(upateFlag == false){
				ps.setStrPattern(strPattern);
				if(win){ ps.incrementWin();} else{ ps.incrementLoss(); }
				this.arrPS_5.add(ps);			 			
			}				 
		 }// End IF	
	
	
}

}
