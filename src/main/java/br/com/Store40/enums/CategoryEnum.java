package br.com.Store40.enums;

import java.util.HashMap;
import java.util.Map;



public enum CategoryEnum {
	CALCADOS("C", "Calcados" ),
	ROUPAS("R", "Roupas"),
	INTIMO("I", "Intimo"),
	ACESSORIOS("A", "Acessorios");

	private String ref;
	private String desc;
	
	private static final Map<String, CategoryEnum> getCategory = new HashMap<>();

	static {
		for(CategoryEnum category : CategoryEnum.values()) {
			getCategory.put(category.getRef(), category);
		}
	}
	
	public static CategoryEnum getCategory(String ref) {
		return getCategory.get(ref);
	}
	
	public static CategoryEnum getDesc(String desc) {
		for (CategoryEnum getCategory :CategoryEnum.values()) {
			if (getCategory.getDesc().equals(desc))
				return getCategory;
		}
		return null;
	}
	
	CategoryEnum(String ref, String desc) {
		this.ref = ref;
		this.desc = desc;
	}


	public String getRef() {
		return ref;
	}

	public String getDesc() {
		return desc;
	}
}
