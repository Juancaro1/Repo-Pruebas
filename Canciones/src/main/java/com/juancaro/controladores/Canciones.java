package com.juancaro.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.juancaro.servicios.ServiciosCanciones;

@Controller
public class Canciones {
	
	@Autowired
	private ServiciosCanciones servicioCanciones;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		modelo.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
		return "Canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{id}")
	public String desplegarDetallesCancion(@PathVariable("id") Long id, Model modelo) {
		modelo.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(id));
		return "detalleCancion.jsp";
	}
}
