package aks.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.aks.textfiles.TextFileList;
import com.aks.textfiles.TextFileReader;

import aks.stocks.pattern.PatternStats;
import aks.stocks.pattern.PatternStatsManager;

public class ProcessPatternCSVFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PatternStatsManager psm = new PatternStatsManager();
		PatternStats ps;
		Double gainThreshold = 2.0;
		String csvInput;
		String pattern;
		String gain;
		boolean win;
		Double dbl_gain;		
		TextFileReader inputFile = new TextFileReader("C:\\StockData\\StockPattern\\Consolidated\\0_Consolidate.csv");
		TextFileList outputFile = new TextFileList("C:\\StockData\\StockPattern\\Consolidated\\", "PatternStats_2.csv");
		StringTokenizer st;
		Double counter = 0.0;
		//Update pattern Stats Manager
		try{
			while(!inputFile.isEndOfFile()){
				counter = counter +1.0;			
				win = false;
				csvInput = inputFile.getNextLine();
				if(csvInput != null){
					st = new StringTokenizer(csvInput, ",");
					pattern = st.nextToken();
					System.out.println(counter);
					gain = st.nextToken();			
					dbl_gain = Double.parseDouble(gain);
					if(dbl_gain > gainThreshold){
						win = true;
						}			
					psm.addPatternStat(pattern, win);
					}						
				}
		}catch(Exception e){
			
		}
				
		//Print consolidated pattern data 
		ArrayList<PatternStats> arrPS = psm.getPatternStats();
		for(int i=0;i<arrPS.size();++i){
			ps = arrPS.get(i);
			outputFile.addLine(ps.getStrPattern()+","+ps.getWin()+","+ps.getLoss()+","+ps.getTotal());
		}					
		outputFile.closefile();
		
		}

}
