package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Dato;
import com.example.demo.modelo.Salida;


public interface IDataService {
	
	List<Dato> lista_elementos() ;
	Salida reestructurar_elementos(List<Dato> datos);
	
	

}
