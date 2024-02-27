package br.com.Store40.model;

import java.util.List;

import br.com.Store40.enums.TypeSaleEnum;





public class Pix extends Sale{
	
	private String pixKey;
	
	public Pix(String date, String time, Double total, TypeSaleEnum typeSale, List<Product> cart, String pixKey) {
		super();
		
		this.setDate(date);
		this.setTime(time);
		this.setTotal(total);
		this.setTypeSale(typeSale);
		this.setCart(cart);
		this.pixKey = pixKey;
	}

	public Pix(Double total, TypeSaleEnum typeSaleEnum, List<Product> cart, String pixKey2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\n Data da compra "  +  getDate() +"\n" + getTime() 
		+ "\n Forma de pagamento dinheiro  " + "Total da compra" + getTotal() + "\n Chave Pix" + pixKey;
	}
}
