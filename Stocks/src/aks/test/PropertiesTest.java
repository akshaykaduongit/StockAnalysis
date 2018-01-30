package aks.test;
import aks.propmanager.*;

public class PropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PropertyFile pf = new PropertyFile("config.properties");
		System.out.println(pf.getPropertyValue("mysql.driver"));
	}

}
