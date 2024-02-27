package br.com.Store40.enums;

import java.util.HashMap;
import java.util.Map;



public enum TypeEnum {
	NACIONAL("N", "nacional"),
	IMPORTADO("I", "importado"),
	OUTROS("O", "outros");
	
	private static final Map<String, TypeEnum> getType = new HashMap<>();

	static {
		for(TypeEnum type : TypeEnum.values()) {
			getType.put(type.getTypeCod(), type);
		}
	}
	
	public static TypeEnum getTypeEnum(String cod) {
		return getType.get(cod);
	}

	public static TypeEnum getDesc(String desc) {
		for (TypeEnum getType :TypeEnum.values()) {
			if (getType.getTypeDesc().equals(desc))
				return getType;
		}
		return null;
	}
	
	
	private String TypeCod;
	private String typeDesc;
	
	
	
	public String getTypeDesc() {
		return typeDesc;
	}

	TypeEnum(String TypeCod, String typeDesc) {
		this.TypeCod = TypeCod;
		this.typeDesc = typeDesc;
	}
	
	public String getTypeCod() {
		return TypeCod;
	}
}
