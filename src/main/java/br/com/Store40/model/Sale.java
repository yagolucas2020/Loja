package br.com.Store40.model;

import java.util.ArrayList;
import java.util.List;

import br.com.Store40.enums.TypeSaleEnum;





public class Sale {
	
	
	private String date;
	private String time;
	private Double total;
	private TypeSaleEnum typeSale;
	private List<Product> cart = new ArrayList<Product>();
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public TypeSaleEnum getTypeOfSale() {
		return typeSale;
	}
	public void setTypeSale(TypeSaleEnum typeOfSale) {
		this.typeSale = typeSale;
	}
	public List<Product> getCart() {
		return cart;
	}
	public void setCart(List<Product> cart) {
		this.cart = cart;
	}
}
