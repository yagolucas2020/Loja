package br.com.Store40.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;







@Service
public class DataInventory {
	
	
	List<Object> inventory = new ArrayList<Object>();

	
	
	
	public boolean save(Object object) {
		if(inventory.add(object)) {
			return true;
		}else {
			return false;
		}
	}

	
	public boolean delete(Object object) {
		if(inventory.remove(object)) {
			return true;
		}else {
			return false;
		}
	}


	public boolean edit(Integer index, Object object) {
		inventory.set(index, object);
		return true;
	}

	
	public List<Object> list(){
		return inventory;
	}
}
