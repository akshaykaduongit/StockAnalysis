package aks.database;
import java.sql.*;
import aks.propmanager.*;
import sun.security.provider.ParameterCache;

public class Database {
	
	private String jdbc_driver;
	private String db_url;
	private String user;
	private String pass;
	private Connection con;
	
	public Database() throws ClassNotFoundException, SQLException {
		
		PropertyFile pfConfig;
		
		pfConfig = new PropertyFile("config.properties");
		
		
	//	super();		
		this.jdbc_driver = pfConfig.getPropertyValue("mysql.driver");
		this.db_url = pfConfig.getPropertyValue("mysql.dburl");
		this.user = pfConfig.getPropertyValue("mysql.user");
		this.pass = pfConfig.getPropertyValue("mysql.password");
		
		this.con = null;
		
		
		//STEP 2: Register JDBC driver
	//	System.out.println("setting formname: "+this.jdbc_driver);
		Class.forName(this.jdbc_driver);
		// "com.mysql.jdbc.Driver"		      

		//STEP 3: Open a connection	      
		con = DriverManager.getConnection(this.db_url,this.user,this.pass);	
		
		//System.out.println("connected successfully.");
	}
	
	public ResultSet executeSQL(String sql) throws SQLException{
		ResultSet rs = null;
		Statement stmt = null;
		stmt = this.con.createStatement();	
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		
		return rs;
		}
	
	
	
	public Integer executeSP_AddRow(StoredProcedure sp) throws SQLException{
		
		ResultSet rs=null;
		String params = "";
		String sql = "{call #SP_NAME#(#PARAMS#)}";
		StoredProcedureParameter spp = null;
		
		Integer paramCount = 0;
		paramCount = paramCount + sp.getInParamsList().size();
		paramCount = paramCount + sp.getOutParamsList().size();
		
		for(int i =0;i< paramCount;++i){
			if(i==0){params = params + "?";}
			else{params = params + ",?";}
			}		
		
		sql = sql.replace("#SP_NAME#", sp.getName());
		sql = sql.replace("#PARAMS#", params);
		
		//System.out.println(sql);
		//CallableStatement cs = this.con.prepareCall("{call stocks_sp_add_stock_data(?,?,?,?,?,?,?,?)}");
		CallableStatement cs = this.con.prepareCall(sql);
		
		//Add In Parameters
		for(int i=0; i<sp.getInParamsList().size();++i){
			spp = (StoredProcedureParameter) sp.getInParamsList().get(i);
			if(spp.getType() == StoredProcedureParameter.TYPE_STRING){
				cs.setString(spp.getName(), spp.getValue());
				}
			
			if(spp.getType() == StoredProcedureParameter.TYPE_INTEGER){
				cs.setInt(spp.getName(), Integer.parseInt(spp.getValue()) );
			}
			
			if(spp.getType() == StoredProcedureParameter.TYPE_DOUBLE){
				cs.setDouble(spp.getName(), Double.parseDouble(spp.getValue()) );
			}			
		}
		
		//Add Out parameters
		
		spp = (StoredProcedureParameter) sp.getOutParamsList().get(0);
		cs.registerOutParameter(spp.getName(), spp.getType());
		
				
		cs.executeQuery();		
	    Integer rowid = cs.getInt(spp.getName());
		
		return rowid;		
		}
	
	
public ResultSet executeSP2(String sql) throws SQLException{
	ResultSet rs=null;
	
	CallableStatement cs = this.con.prepareCall("{call stocks_sp_add_stock_data(?,?,?,?,?,?,?,?)}");
	DatabaseMetaData dbmd = this.con.getMetaData();
			 
	ParameterMetaData pm = cs.getParameterMetaData();
	System.out.println("Parameter count :" + Integer.toString(pm.getParameterCount()));
	System.out.println("Parameter Mode:"+pm.getParameterMode(7));
	System.out.println("Parameter Mode:"+pm.getParameterMode(8));
	
	
	cs.setString("p_stockname", "Larsen and Toubro");
	cs.setString("p_date", "2015-08-17");
	cs.setDouble("p_open", 10);
	cs.setDouble("p_close", 20);
	cs.setDouble("p_high", 30);
	cs.setDouble("p_low", 40);
	cs.setDouble("p_volume", 50);
	//cs.registerOutParameter(8, Types.INTEGER);
	cs.registerOutParameter("o_rowid", java.sql.Types.INTEGER);
	
	cs.executeQuery();		
	rs = (ResultSet) cs.getObject(8);
	
//System.out.println("rowid:"+cs.getInt(8));
	
	return rs;		
		}
	

	
	
}
