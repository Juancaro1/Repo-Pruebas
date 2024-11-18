package com.juancaro.controladores;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorRecetas {

	private static String listaRecetas[] = {"Pizza", "Espagueti", "Lasaña"};
	private static HashMap<String, String []> recetasConIngredientes = new HashMap<String, String[]>();
	
	public ControladorRecetas() {
		String [] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
		recetasConIngredientes.put("Pizza", pizza);
		String [] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
		recetasConIngredientes.put("Espagueti", espagueti);
		String [] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
		recetasConIngredientes.put("Lasaña", lasaña);
	}

	public static String[] getListaRecetas() {
		return listaRecetas;
	}

	public static void setListaRecetas(String[] listaRecetas) {
		ControladorRecetas.listaRecetas = listaRecetas;
	}

	public static HashMap<String, String[]> getRecetasConIngredientes() {
		return recetasConIngredientes;
	}

	public static void setRecetasConIngredientes(HashMap<String, String[]> recetasConIngredientes) {
		ControladorRecetas.recetasConIngredientes = recetasConIngredientes;
	}
	
	@GetMapping("/recetas")
	public String obtenerTodasLasRecetas(Model modelo) {
		modelo.addAttribute("recetas", listaRecetas);
		return "recetas.jsp";
	}	
	
	@GetMapping("/recetas/{nombre}")
	public String obtenerRecetaPorNombre(@PathVariable (value = "nombre") String nombre, Model modelo) {
		if(recetasConIngredientes.containsKey(nombre)) {
			String[] ingredientes = recetasConIngredientes.get(nombre);
			modelo.addAttribute("nombreReceta", nombre);
			modelo.addAttribute("ingredientes", ingredientes);
		}else {
			modelo.addAttribute("mensajeError", "La receta no se encuentra en nuestra lista.");
		}
		return "detalleReceta.jsp";
	}

	@Override
	public String toString() {
		return "ControladorRecetas [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
