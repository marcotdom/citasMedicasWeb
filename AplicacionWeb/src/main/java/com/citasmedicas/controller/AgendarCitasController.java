package com.citasmedicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.citasmedicas.dto.CitaDTO;
import com.citasmedicas.service.CitasService;
import com.citasmedicas.util.FechaUtileria;

@Controller
public class AgendarCitasController {
	
	@PostMapping("/citasMedicas")
    public String guardarCita(@ModelAttribute("cita") CitaDTO cita,RedirectAttributes redirAttrs) {
        System.out.println(cita);

        
        
        
        boolean success = false;
		try {
			cita.setFecha(FechaUtileria.formatearFecha(cita.getFecha()));
			success = new CitasService().guardarCita(cita);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
            redirAttrs.addFlashAttribute("mensajeAgendarCitaError", "Error al agendar la cita");
		}
        if(success) {
            redirAttrs.addFlashAttribute("mensajeAgendarCitaExito", "Cita agendada correctamente");
        }else {
            redirAttrs.addFlashAttribute("mensajeAgendarCitaError", "Error al agendar la cita");

        }
        
        return "redirect:/medicos";
    }

}
