package aks.stocks;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				try{
					File file = new File("config.properties");
					FileInputStream fileInput = new FileInputStream(file);
					Properties properties = new Properties();
					properties.load(fileInput);
					fileInput.close();
					
					System.out.println(properties.getProperty("mysql.user"));
					
				}catch(Exception e){
				System.out.println(e.getMessage());
				}

	}

}
