package aks.database;

public class StoredProcedureParameter {

	private String name;	
	private String value;
	private int type;
	
	// Static varialbes for value type
	public static int TYPE_STRING = 1;
	public static int TYPE_INTEGER = 2;
	public static int TYPE_DOUBLE = 3;
	public static int TYPE_DATE = 4;
	
	public StoredProcedureParameter(String name, String value, int type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
