package com.aks.textfiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

	private BufferedReader br;
	private boolean EOF;
	public TextFileReader(String strPath) throws FileNotFoundException{		
		this.br = new BufferedReader(new FileReader(strPath));
		this.EOF = false; 
		}
	
	public String getNextLine(){
		try{
			String line;
			line = this.br.readLine();
			if(line == null){
				this.EOF = true;
				return "EOF";
				}
			return line;
			}catch(Exception e){
				e.printStackTrace();
				return "EOL";
			}		
		}	
	
	public void close() throws IOException{
		this.br.close();
	}
	
	public boolean isEndOfFile(){
		return this.EOF;
	}
}
