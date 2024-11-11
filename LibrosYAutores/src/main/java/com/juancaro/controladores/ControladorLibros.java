package com.juancaro.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorLibros {
	
	private static HashMap<String, String> listaLibros = new HashMap<String, String>();
	
	public ControladorLibros() {
		listaLibros.put("Odisea", "Homero");	
		listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
		listaLibros.put("El Código Da Vinci", "Dan Brown");		
		listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
		listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
		listaLibros.put("El alquimista", "Paulo Coelho");	
	}

	public static HashMap<String, String> getListaLibros() {
		return listaLibros;
	}

	public static void setListaLibros(HashMap<String, String> listaLibros) {
		ControladorLibros.listaLibros = listaLibros;
	}
	
	@GetMapping("/libros")
	public String obtenerTodosLosLibros(Model modelo) {
		modelo.addAttribute("libros", listaLibros);
		return "libros.jsp";
	}
	
	@GetMapping("/libros/{nombre}")
	public String obtenerInformacionDeLibro(@PathVariable String nombre, Model modelo) {
		if(listaLibros.containsKey(nombre)) {
			String autor = listaLibros.get(nombre);
			modelo.addAttribute("nombre", nombre);
			modelo.addAttribute("autor", autor);
		}else {
			modelo.addAttribute("mensaje", "El libro no se encuentra en nuestra lista");
		}
		return "detalleLibro.jsp";
	}
	
	@GetMapping("/libros/formulario")
	public String formularioLibro() {
		return "formularioLibros.jsp";
	}
	
	@PostMapping("/procesa/libro")
	public String procesaLibro(@RequestParam String nombreLibro, @RequestParam String autorLibro, Model modelo) {
		listaLibros.put(nombreLibro, autorLibro);
		return "redirect:/libros";
	}
}
