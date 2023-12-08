package com.citasmedicas.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citasmedicas.dto.CitaDTO;
import com.citasmedicas.service.CitasService;
import com.citasmedicas.service.MedicosService;

@Controller
public class VerCitasController {
	
	 @RequestMapping(value="/citasAgendadas/{idMedico}/{fecha}", method=RequestMethod.GET)
	    public String citas(@PathVariable int idMedico, @PathVariable String fecha,Model model) {
		 	List<CitaDTO> lista = null;
		 	try {
		 		System.out.println("llamando a la API");
		 		lista = new CitasService().obtenerCitas(idMedico, fecha);
		 	}catch(Exception e) {
		 		e.printStackTrace();
		 		lista = new ArrayList<CitaDTO>();	
		 	}
		 	model.addAttribute("citasAgendadas", lista);
		 	return "/citas.html";
	    }
	
	 @GetMapping(value="/citasAgendadasRest/{idMedico}/{fecha}")
	 @ResponseBody
	    public Map<String, Object> citasRest(@PathVariable int idMedico, @PathVariable String fecha,Model model) {
		 	List<CitaDTO> lista = null;
		 	try {
		 		System.out.println("llamando a la API Rest");
		 		lista = new CitasService().obtenerCitas(idMedico, fecha);
		 	}catch(Exception e) {
		 		e.printStackTrace();
		 		lista = new ArrayList<CitaDTO>();	
		 	}
		 	model.addAttribute("citasAgendadas", lista);
		 	return Collections.singletonMap("citasAgendadas", lista);

	    }



}
