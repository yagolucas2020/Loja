package br.com.Store40.enums;

import java.util.HashMap;
import java.util.Map;



public enum TypeSaleEnum {
	
	DINHEIRO(1),
	PIX(2);
	
	private Integer code;
	private static final Map<Integer, TypeSaleEnum>getTypeSale = new HashMap<>();
	
	TypeSaleEnum(Integer code){
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	
	static {
		for(TypeSaleEnum typeOfSale : TypeSaleEnum.values()) {
			getTypeSale.put(typeOfSale.getCode(), typeOfSale);
		}
	}
	
	public static TypeSaleEnum getTypeSaleEnum(Integer code) {
		return getTypeSale.get(code);
	}
}

