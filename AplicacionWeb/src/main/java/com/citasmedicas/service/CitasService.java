package com.citasmedicas.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citasmedicas.dto.CitaDTO;
import com.citasmedicas.dto.MedicoDTO;
import org.springframework.http.HttpEntity;

@Service
public class CitasService {
	
	public List<CitaDTO> obtenerCitas(int idMedico,String fecha) throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<CitaDTO>> response = restTemplate.exchange("http://localhost:8082/citasApi/{idMedico}/{fecha}",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<CitaDTO>>() {
				},idMedico,fecha);
		response.getBody().sort((h1, h2) -> h1.getHora().compareTo(h2.getHora()));
		return response.getBody();

	}
	
	public boolean guardarCita(CitaDTO nuevaCita) throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<CitaDTO> request = new HttpEntity<>(nuevaCita);
		ResponseEntity<CitaDTO> response = restTemplate.exchange("http://localhost:8082/citasApi/",
				HttpMethod.POST, request, CitaDTO.class);
		return
				(response.getStatusCode().equals(HttpStatus.CREATED)) ? true : false;
		
		
	}
	
	

	public CitasService() {
		super();
	}

}
