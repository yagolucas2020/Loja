package br.com.Store40.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.Store40.data.DataHistoric;


@Service
public class ServiceHistoric {
DataHistoric dataHistoric = new DataHistoric();
	
	public boolean saveHistoric(Object object) {
		if(dataHistoric.save(object)) {
			return true; 
		} else {
			return false; 
		}
	}
	
	public List<Object> historicList(){
		return dataHistoric.list();
	}
}
