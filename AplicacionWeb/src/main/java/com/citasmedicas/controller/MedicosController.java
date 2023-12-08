package com.citasmedicas.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citasmedicas.dto.MedicoDTO;
import com.citasmedicas.dto.CitaDTO;
import com.citasmedicas.service.MedicosService;

@Controller
public class MedicosController {

	@RequestMapping("medicos")
	public String login(Model model) {
		// BORRAR ESTA LINEA
		model.addAttribute("msg", "dr jimenez");
		List<MedicoDTO> medicos;
		try {
			medicos = new MedicosService().obtenerMedicos();
		} catch (Exception e) {
			medicos = new ArrayList<MedicoDTO>();
		}
		model.addAttribute("medicos", medicos);
		return "/medicos.html";
	}

	@RequestMapping("citasMedicas")
	public String citasMedicas(Model model) {
		return "/citas.html";
	}

	@RequestMapping("agendarCitaMedica")
	public String agendarCitasMedicas(Model model) {
		CitaDTO cita = new CitaDTO();
		model.addAttribute("cita", cita);
		return "/agendarCita.html";
	}

}
