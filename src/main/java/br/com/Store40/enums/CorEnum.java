package br.com.Store40.enums;

import java.util.HashMap;
import java.util.Map;



public enum CorEnum {
	VERMELHO("VEM", "vermelho vulcanico"),
	AZUL("AZL" , "azul marinho"),
	PRETO("PTO", "preto fosco"),
	BRANCO("BCO" , "branco gelo"),
	CINZA("CIN" , "cinza metalico"),
	AMARELO("AMA", "amarelo ovo"),
	VERDE("VER" , "verde agua"),
	CAMUFLADO("CAM", "camuflado"),
	DOURADO("DOR", "camuflado"),
	PRATA("PRT", "camuflado");

 
 
 
 
	private static final Map<String, CorEnum> getCor = new HashMap<>();

	static {
		for(CorEnum type : CorEnum.values()) {
			getCor.put(type.getCor(), type);
		}
	}
	
	public static CorEnum getCorEnum(String cod) {
		return getCor.get(cod);
	}

	public static CorEnum getDesc(String desc) {
		for (CorEnum getType :CorEnum.values()) {
			if (getType.getDescCor().equals(desc))
				return getType;
		}
		return null;
	}
	
	
	private   String cor;	
	private	String descCor;

	CorEnum(String cor, String descCor) {
		this.cor = cor;
		this.descCor = descCor;
	}

	public String getCor() {
		return cor;
	}

	public String getDescCor() {
		return descCor;
	}
	
	


	
}
