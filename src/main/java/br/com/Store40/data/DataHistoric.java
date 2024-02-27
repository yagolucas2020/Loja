package br.com.Store40.data;

import java.util.ArrayList;
import java.util.List;

import br.com.Store40.model.Product;



public class DataHistoric {

List<Object> historic = new ArrayList<Object>();
	
	
	public boolean save(Object object) {
		if(historic.add((Product) object)) {
			return true;
		}
		return false;
	}

	
	public boolean delete(Object object) {
		if(historic.remove(object)) {
			return true;
		}
		return false;
	}


	public boolean edit(Integer index, Object object) {
		historic.set(index, (Product) object);
		return false;
	}

	
	public List<Object> list() {
		return historic;
	}



}
