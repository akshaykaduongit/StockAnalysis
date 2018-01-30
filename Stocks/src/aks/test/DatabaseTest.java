package aks.test;
import java.sql.ResultSet;
import java.sql.SQLException;

import aks.database.*;


public class DatabaseTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Database db;		
		db = new Database();
		
		String sql;		
		StoredProcedure sp = new StoredProcedure("stocks_sp_add_stock_data");
		
		//In parameters
		sp.addInParameter(new StoredProcedureParameter("p_stockname", "Larsen and Toubro",StoredProcedureParameter.TYPE_STRING ));
		sp.addInParameter(new StoredProcedureParameter("p_date", "2015-08-16",StoredProcedureParameter.TYPE_STRING ));
		sp.addInParameter(new StoredProcedureParameter("p_open", "10",StoredProcedureParameter.TYPE_DOUBLE ));
		sp.addInParameter(new StoredProcedureParameter("p_close", "20",StoredProcedureParameter.TYPE_DOUBLE ));
		sp.addInParameter(new StoredProcedureParameter("p_high", "30",StoredProcedureParameter.TYPE_DOUBLE ));
		sp.addInParameter(new StoredProcedureParameter("p_low", "40",StoredProcedureParameter.TYPE_DOUBLE ));
		sp.addInParameter(new StoredProcedureParameter("p_volume", "50",StoredProcedureParameter.TYPE_DOUBLE ));
		
		//OUT parameter
		sp.addOutParameter(new StoredProcedureParameter("o_rowid", "",java.sql.Types.INTEGER));
		
		Integer rowid = db.executeSP_AddRow(sp);
		System.out.println("rowid: "+ Integer.toString(rowid));
		
		
	}

}
