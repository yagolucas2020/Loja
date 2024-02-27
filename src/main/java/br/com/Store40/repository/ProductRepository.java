package br.com.Store40.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Store40.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

		

		

		Product getBySku(String sku);

		
}
