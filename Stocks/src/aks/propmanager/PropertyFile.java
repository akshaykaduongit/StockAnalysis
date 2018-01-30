package aks.propmanager;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {	
	private Properties properties;

	public PropertyFile(String p_filename){
		try{			
			File file = new File(p_filename);
			FileInputStream fileInput = new FileInputStream(file);
			this.properties = new Properties();
			this.properties.load(fileInput);
			fileInput.close();			
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}	
	}
	
	public String getPropertyValue(String p_key){		
		try{		
			return this.properties.getProperty(p_key);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return "ERROR_PROPERTY_NOT_FOUND";
		}
	}
	
}
