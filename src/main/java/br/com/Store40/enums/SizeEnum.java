package br.com.Store40.enums;

import java.util.HashMap;
import java.util.Map;



public enum SizeEnum {
	P("P"),
	M("M"),
	G("G"),
	GG("X");

private String cod;


 private static final Map<String, SizeEnum> getSize = new HashMap<>();

	static {
		for(SizeEnum size : SizeEnum.values()) {
			getSize.put(size.getCod(), size);
		}
	}
	
	public static SizeEnum getSizeEnum(String cod) {
		return getSize.get(cod);
	}
	

SizeEnum(String cod) {
		this.cod = cod;
	}

public String getCod() {
	return cod;
}
}
