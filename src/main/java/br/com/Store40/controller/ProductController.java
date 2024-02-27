package br.com.Store40.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Store40.model.Product;
import br.com.Store40.service.ProductService;


@RestController
@RequestMapping(value="/estoque")
public class ProductController {
		
	@Autowired
	ProductService service;
	
	@PostMapping("/produto")
	public String registrarProduto(@RequestBody Product product) {
		
		return service.registerProduct(product);
	}
	
	@GetMapping("/buscar/{sku}")
	public Product buscarProduto(@PathVariable(value="sku") String sku) {
		return service.searchProductBySku(sku);
	}
	
	@GetMapping("/produtos")
	public List<Product> ProductList(){
		return service.productList();
	}
	
	@DeleteMapping("/produto/{sku}")
	public String deletarProduto(@PathVariable(value="sku") String sku) {
		return service.deleteProduct(sku);
	}
	
	@PutMapping("/produto/{sku}")
	public Product editarProduto(@PathVariable(value = "sku") String sku, @RequestBody Product product) {
		Integer quantity = 0;
		Double price = 0.0;
		return service.editProduct(product, sku, quantity, price);
	}
	
}
