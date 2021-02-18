package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Dato;
import com.example.demo.modelo.Salida;
import com.example.demo.service.IDataService;

@RequestMapping("/datos")
@RestController
public class DataController {
	
	private IDataService service;
	
	@Autowired
	public DataController(IDataService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Dato>> listar()  {
		List<Dato> lista = service.lista_elementos();
		return new ResponseEntity<List<Dato>>(lista,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Salida> reestructura() {
		List<Dato> datos = service.lista_elementos();
		Salida salida = service.reestructurar_elementos(datos);
		return new ResponseEntity<Salida>(salida, HttpStatus.CREATED);
		
	}
	

}
