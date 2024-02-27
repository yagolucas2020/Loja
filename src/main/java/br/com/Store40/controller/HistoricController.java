package br.com.Store40.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Store40.service.ServiceHistoric;

@RestController
@RequestMapping(value = "/historico")
public class HistoricController {

	@Autowired
	ServiceHistoric serviceH;
		
	
	@GetMapping("/lista")
	public List<Object> historico() {
		return serviceH.historicList();
	}
}
