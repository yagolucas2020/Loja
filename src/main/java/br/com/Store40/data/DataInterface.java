package br.com.Store40.data;

import java.util.List;

import br.com.Store40.model.Product;

public interface DataInterface {
		
	public boolean save(Product product); //salvar
	
	public boolean delete(Product product); //deletar
	
	public boolean edit(Integer index, Product product);//editar
	
	public List<Product> list();
}
