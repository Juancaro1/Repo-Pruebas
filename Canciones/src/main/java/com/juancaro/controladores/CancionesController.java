package com.juancaro.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.juancaro.servicios.ServiciosCanciones;
import com.juancaro.modelos.*;



import jakarta.validation.Valid;

@Controller
public class CancionesController {
	
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
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(Model modelo) {
		modelo.addAttribute("cancion", new Canciones());
		return "agregarCancion.jsp";
	}


	@PostMapping("/canciones/procesa/agregar")
	private String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Canciones cancion, BindingResult validaciones) {
		if(validaciones.hasErrors()) {
			return "agregarCancion.jsp";
		}
		
		this.servicioCanciones.agregarCancion(cancion);
		return "redirect:/canciones";
	}


	@GetMapping("/canciones/formulario/editar/{id}")
	public String formularioEditarCancion(@PathVariable("id") Long id, Model modelo) {
		Canciones cancionActual = this.servicioCanciones.obtenerCancionPorId(id);
		modelo.addAttribute("cancion", cancionActual);
		return "editarCancion.jsp";
	}
	
	
	@PutMapping("/canciones/procesa/editar/{id}")
	public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Canciones cancion, BindingResult validaciones, @PathVariable("id") Long id) {
		if(validaciones.hasErrors()) {
			return "editarCancion.jsp";
		}
			cancion.setId(id);
			this.servicioCanciones.actualizaCancion(cancion);
			return "redirect:/canciones";
		}
	
	@DeleteMapping("/canciones/eliminar/{id}")
	public String procesarEliminarCancion (@PathVariable("id") Long id) {
		this.servicioCanciones.eliminarCancion(id);
		return "redirect:/canciones";
	}
}



