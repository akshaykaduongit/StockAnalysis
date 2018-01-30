package com.aks.textfiles;

import java.io.IOException;


public class TestTextFiles {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Double PTBindex = 2.0;
		
		//Test PTBindex
		PTBindex pbi = new PTBindex("c:\\WebCrawler", "ptbindex.txt");
		pbi.upcateIndex(PTBindex);
		pbi.closefile();		
		System.out.println(pbi.getIndex());
		
		
		//Test for Pages To Be visited 
		PagesToBeVisited ptb = new PagesToBeVisited("c:\\WebCrawler", "ptb.txt");
		PTBindex = ptb.addValue("Akshay",pbi);
		pbi.upcateIndex(PTBindex);
		PTBindex = ptb.addValue("Amit",pbi);
		pbi.upcateIndex(PTBindex);
		ptb.closefile();
		ptb = new PagesToBeVisited("c:\\WebCrawler", "ptb.txt");
		PTBindex = ptb.addValue("Amit2",pbi);
		pbi.upcateIndex(PTBindex);
		
		
		
		
	}

}
