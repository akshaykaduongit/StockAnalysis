package aks.database;

import java.util.ArrayList;
import java.util.List;

public class StoredProcedure {

	private String name;
	private List<StoredProcedureParameter> inParamsList;
	private List<StoredProcedureParameter> outParamsList;	
	
	
	public StoredProcedure(String name) {
		super();
		this.name = name;
		this.inParamsList = new ArrayList<StoredProcedureParameter>();
		this.outParamsList = new ArrayList<StoredProcedureParameter>();
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getInParamsList() {
		return inParamsList;
	}
	public void setInParamsList(List inParamsList) {
		this.inParamsList = inParamsList;
	}
	public List getOutParamsList() {
		return outParamsList;
	}
	public void setOutParamsList(List outParamsList) {
		this.outParamsList = outParamsList;
	}
		
	public void addInParameter(StoredProcedureParameter spp){		
		this.inParamsList.add(spp);
	}
	
	public void addOutParameter(StoredProcedureParameter spp){
		this.outParamsList.add(spp);
	}
	
	
	
}
