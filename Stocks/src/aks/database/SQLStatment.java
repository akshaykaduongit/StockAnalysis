package aks.database;

public class SQLStatment {

	public static String SQL_ADD_STOCK_DATA = "SQL_ADD_STOCK_DATA";
	
	public static String getSQLStatement(String key){
		
		String stat = "";
		switch (key) {
		case "SQL_ADD_STOCK_DATA":
			stat = 			"set @o_rowid = 0;";
			stat = stat + 	"call stocks.`stocks.sp_add_stock_data`('#STOCK_NAME#', '#DATE#', #OPEN#, #CLOSE#, #HIGH#, #LOW#, #VOLUME#, @o_rowid);";
			stat = stat + 	"select @o_rowid as rowid;";
			break;
		default:			
			break;
		}
		
		return stat;
		
		
	}
	
}
