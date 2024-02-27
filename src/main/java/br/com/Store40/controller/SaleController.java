package br.com.Store40.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Store40.model.Product;
import br.com.Store40.service.ServiceSale;
@RestController
@RequestMapping("/venda")
public class SaleController {

	@Autowired
	ServiceSale service;
	
	@GetMapping("/carrinho")
	public List<Product>carrinho(){
		return service.getCart();
	}
	
	@GetMapping("/busca/{sku}")
	public Product procurarSku(@PathVariable(value="sku") String sku) {
		return service.searchProductBySkuCart(sku);
	}
	
	@PostMapping("/adicionar")
	public  String adicionarCarrinho(@RequestBody String sku, Integer quantity ) {
		
		if(service.addProductToCart(sku, quantity) != null) {
			return "\n Produto Adicionado com Sucesso! \n";
		}
		return "\n Este Produto nao pode ser adicionado! \n ";
	}
	
	@DeleteMapping("/cancelar/{sku}")
	public String cancelarCompra(@PathVariable(value="sku") String sku) {
		return service.removeProductFromCart(null, null);
	}
	
	
}
