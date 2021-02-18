package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modelo.Dato;
import com.example.demo.modelo.Salida;
import com.example.demo.service.IDataService;

@Service
public class DataServiceImpl implements IDataService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Dato> lista_elementos() {
		// TODO Auto-generated method stub

		String url = "https://jsonplaceholder.typicode.com/comments";
		ResponseEntity<List<Dato>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Dato>>() {
				});

		List<Dato> datos = response.getBody();

		return datos;
	}

		@Override
	public Salida reestructurar_elementos(List<Dato> datos) {
		// TODO Auto-generated method stub
		List<String> reestructura = new ArrayList<String>();
		String cadena_reestructura;
		for (int i = 0; i < datos.size(); i++) {
			cadena_reestructura = datos.get(i).getPostId() + "|" + datos.get(i).getId() + "|" + datos.get(i).getEmail();
			reestructura.add(cadena_reestructura);
		}
		Salida salida = new Salida();
		salida.setData(reestructura);

		return salida;
	}

}
