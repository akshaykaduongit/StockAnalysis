package com.aks.textfiles;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class TextFileList {
	
	private String dirPath;
	private String fileName;

	private FileWriter writer;
	public TextFileList(String dirPath, String fileName) throws IOException{
		this.dirPath = dirPath;
		this.fileName = fileName;		
		createDirectoryIfNeeded(this.dirPath);
		this.writer = new FileWriter(this.dirPath+"\\"+this.fileName, true);	
	}
	
	public void addLine(String line) throws IOException{
		this.writer.write(line+System.lineSeparator());
		//this.writer.println(line);
	}
	
	public void closefile() throws IOException{		
		this.writer.close();
	}
	
	private void createDirectoryIfNeeded(String directoryName)
	{
	File theDir = new File(directoryName); 
	if (!theDir.exists())
	    theDir.mkdirs();
	}
}
