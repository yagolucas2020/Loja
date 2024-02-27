package br.com.Store40.model;

import java.util.List;

import br.com.Store40.enums.TypeSaleEnum;









public class Money extends Sale{
	public Money( String date, String time, Double total, TypeSaleEnum typeSale, List<Product> cart) {
		super();
		this.setDate(date);
		this.setTime(time);
		this.setTotal(total);
		this.setTypeSale(typeSale);
		this.setCart(cart);
	}

	public Money(Double total, TypeSaleEnum typeSaleEnum, List<Product> cart) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\n Data da compra "  +  getDate() +"\n" + getTime() 
		+ "\n Forma de pagamento dinheiro  " + "Total da compra" + getTotal();
	}
}
