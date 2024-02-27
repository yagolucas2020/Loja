package br.com.Store40.enums;

import java.util.HashMap;
import java.util.Map;



public enum DepartamentEnum {
	MASCULINO("MC", "Masculino" , "A1"),
	FEMININO("FM", "Feminino" , "B1"),
	INFANTIL("IN", "Infantil", "A2" );


private String cod;
private String descDep;
private String localInvent;


 private static final Map<String, DepartamentEnum> getDept = new HashMap<>();

	static {
		for(DepartamentEnum departament : DepartamentEnum.values()) {
			getDept.put(departament.getCod(), departament);
		}
	}
	
	public static DepartamentEnum getDept(String cod) {
		return getDept.get(cod);
	}
	
	
	DepartamentEnum(String cod, String descDep, String localInvent) {
		this.cod = cod;
		this.descDep = descDep;
	}

	public String getCod() {
		return cod;
	}

	public String getDescDep() {
		return descDep;
	}

	public String getLocalInvent() {
		return localInvent;
	}
}
