package com.citasmedicas.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citasmedicas.dto.MedicoDTO;

@Service
public class MedicosService {
	public List<MedicoDTO> obtenerMedicos() throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<MedicoDTO>> response = restTemplate.exchange("http://localhost:8081/medicos",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<MedicoDTO>>() {
				});
		response.getBody().sort((h1, h2) -> h1.getApellido().compareTo(h2.getApellido()));
		return response.getBody();

	}

	public MedicosService() {
		super();
	}

}
