package br.com.Store40.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Store40.data.DataInventory;
import br.com.Store40.model.Product;
import br.com.Store40.repository.ProductRepository;


@Service
public class ProductService {
	
	
		@Autowired
		DataInventory dataInventory;
		
		@Autowired
		ProductRepository repository;
		
		public List<Product> productList(){ 
			return repository.findAll();
		}
		
		
		public Product searchProductBySku(String sku) { 
			for (int i = 0; i < productList().size(); i++) {
				Product product = (Product) productList().get(i);
				if(sku.equals(product.getSku())) {
					return product;
					
				}
			}
			return null;
		}
		
		public String registerProduct(Product product) { 
			if((product.getDepart() == null || product.getCor() == null || product.getCategory() == null | product.getSize() == null | product.getType() == null)) {
				return "Sku Invalido, ou Inexistente";
			} else {
				
					Product save = repository.save(product);
					
						return "Produto cadastrado com sucesso..."; 
					
						
				
			}
		
		
		}	
		
		public Product editProduct(Product product, String sku,Integer quantity, Double price) {
			for (int i = 0; i < productList().size(); i++) {
				Product productSku = (Product) productList().get(i);
				if(product.getSku().equals(productSku.getSku())) {
					
				product.setQuantity(product.getQuantity() + (quantity));
				product.setPrice(product.getPrice() + (price));
				}
			}
			return repository.save(product);
			
			}
		
		
		public String deleteProduct(String sku) { 
			Product product = searchProductBySku(sku);
			
			repository.delete(product);
			return sku;
		}
	}

