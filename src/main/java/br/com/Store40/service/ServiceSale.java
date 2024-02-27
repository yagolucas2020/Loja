package br.com.Store40.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.Store40.model.Product;



@Service
public class ServiceSale {
	
	List<Product> cart = new ArrayList<Product>();
	ProductService service;
	
//	public void serviceProductMain(ProductService serviceProductMain) { 
	//	service = serviceProductMain;
//	}
	
	public List<Product>getCart(){ 
		return cart;
	}
	
	public Product searchProductBySkuCart(String sku) { 
		for (int i = 0; i < cart.size(); i++) {
			Product product = (Product) cart.get(i);
			if(sku.equals(product.getSku())) {
				return product;
			}
		}
		return null;
	}
	
	
	public String addProductToCart(String sku, Integer quantity) { 
		Product product = service.searchProductBySku(sku);
		
		if(product == null) {
			return "Sku nao existe";
		}else if(product.getQuantity() <= 0){
			return "Estoque insuficiente";
		}else {
			if(removeProductFromInventory(product, quantity, sku) == 2) {
				product.setQuantity(quantity);
				Product cartProduct = searchProductBySkuCart(sku);
				if(cartProduct == null) {
					cart.add(product);
					return "Produto adicionado com sucesso";
				}else {
					return "Falha para adicionar o produto";
				}
			}
			else {
				return "Quantidade do estoque insuficiente";
			}
		}
	}
	
	public String removeProductFromCart(String sku, Integer quantity) {
		Product product = searchProductBySkuCart(sku);
		
		if(product == null) {
			return " Nao Existe sku";
		}else if(product.getQuantity() < quantity) {
			return " Quantidade no carrinho insuficiente";
		}else {
			putProductInInventory(product.getSku(), quantity);
			product.setQuantity((product.getQuantity() - quantity));;
			if(editProductCart(product) == 0) {
				return "Produto retirado do carrinho";
			}else {
				return "falha ao retirar produto ";
			}
		}
	}
	
	private Integer editProductCart(Product product) {
		Integer index = -1;
		for (int i = 0; i < getCart().size(); i++) {
			Product productSku = getCart().get(i);
			if(product.getSku().equals(productSku.getSku())) {
				index = 0;
			}
			
		}
		
		switch (index) {
		case -1: 
			
			return 1;
		
		default:
			if(cart.set(index, product) != null) {
				checkZeroProducts();
				return 0; 
			}else {
				return 1; 
			}
			
		}
	}
		
	public int removeProductFromInventory(Product product, Integer quantity, String sku) { 
		if(product.getQuantity() < quantity) {
			return 1;
		}else {
			quantity = product.getQuantity() - quantity;
			Product updateProduct = new Product(product.getSku(), product.getDesc(), quantity, product.getPrice());
			service.editProduct(updateProduct, sku , 0 , 0.0);
				return 2;
			}
		
	}
	
	public void putProductInInventory(String sku, Integer qtd) {
		Product productInInventory = service.searchProductBySku(sku);
		if(productInInventory == null) {
			service.registerProduct(productInInventory);
		}else {
			qtd = productInInventory.getQuantity() + qtd;
			Product upadteProduct = new Product(productInInventory.getSku(), productInInventory.getDesc(), qtd,productInInventory.getPrice());
			service.editProduct(upadteProduct,sku, 0, 0.0);
		}
	}
	
	public String emptyCart() { 
		for (int i = 0; i < getCart().size(); i++) {
			Product product = getCart().get(i);
			removeProductFromCart(product.getSku(), product.getQuantity());
		}
		return "Compra cancelada.....Carrinho vazio";
	}
	
	
	public Double purchaseTotal() {
		Double total = 0.0;
		for (int i = 0; i < cart.size(); i++) {
			total = total + (cart.get(i).getPrice() * cart.get(i).getPrice());
		}
		return total;
	}
	
	private void checkZeroProducts() { 
		for (int i = 0; i < cart.size(); i++) {
			Product product = cart.get(i);
			if(product.getQuantity() <=0 ) {
				cart.remove(product);
			}
		}
	}
}
