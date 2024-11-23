package com.juancaro.controladores;


import java.util.List;

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

import com.juancaro.modelos.Articulo;
import com.juancaro.servicios.ServicioArticulos;
import com.juancaro.servicios.ServicioFavoritos;
import com.juancaro.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorArticulos {

	@Autowired
	private ServicioArticulos servicioArticulos;
	
	@Autowired
	private ServicioFavoritos servicioFavoritos;
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@GetMapping("/articulos")// Mostrar los articulos
	public String mostrarArticulos(HttpSession sesion, Model modelo) {
	Long idUsuario = (Long) sesion.getAttribute("idUsuario");
   	if (idUsuario == null) {
    return "redirect:/"; 
    }
    List<Articulo> articulos = this.servicioArticulos.obtenerTodas();
    
    List<Articulo> favUsuario = servicioFavoritos.obtenerFavoritosDeUsuario(idUsuario);

    modelo.addAttribute("articulos", articulos);
    modelo.addAttribute("favUsuario", favUsuario);
    modelo.addAttribute("idUsuario", idUsuario);
    return "articulos.jsp";
	}
	
	
	@GetMapping("/form/agregar")// visat form Agregar articulo
	public String agregarArticulo(HttpSession sesion, Model modelo) {
		if(sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("articulo", new Articulo());
		return "agregarArticulo.jsp";
	}
	
	
	
	@GetMapping("/form/editar/{id}")// vista form editar articulo
	public String editarArticulo(HttpSession sesion, Model modelo, @PathVariable("id") Long id) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
    if (idUsuario == null) {
        return "redirect:/";
    }
    Articulo articulo = servicioArticulos.obtenerArticuloPorId(id);
    if (articulo == null || !articulo.getCreador().getId().equals(idUsuario)) {
        return "redirect:/articulos";
    }
    modelo.addAttribute("articulo", articulo);
    return "editarArticulo.jsp";
	}
	
	
	
	@PostMapping("/guardar")// procesa form agregar articulo
	public String guardar(HttpSession sesion, @Valid @ModelAttribute("articulo") Articulo articulo, BindingResult validaciones) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if(sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		if(validaciones.hasErrors()) {
			return "agregarArticulo.jsp";
		}
		this.servicioArticulos.crear(articulo, idUsuario);
		return "redirect:/articulos";
	}
	
	@PutMapping("/actualizar/{id}") // procesa el form editar articulo
	public String actualizar(@PathVariable("id") Long id, HttpSession sesion, @Valid @ModelAttribute("articulo") Articulo articulo, BindingResult validaciones) {
    if (sesion.getAttribute("nombreCompleto") == null) {
        return "redirect:/";
    }

    Long idUsuario = (Long) sesion.getAttribute("idUsuario");

    Articulo articuloExistente = servicioArticulos.obtenerArticuloPorId(id);
    if (articuloExistente == null) {
        return "redirect:/articulos";
    }
    if (!articuloExistente.getCreador().getId().equals(idUsuario)) {
        return "redirect:/articulos"; 
    }
    if (validaciones.hasErrors()) {
        return "editarArticulo.jsp";
    }
    this.servicioArticulos.actualizar(articulo);
    return "redirect:/articulos";
}

	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarArticulo(@PathVariable("id") Long id, HttpSession sesion) {
    Long idUsuario = (Long) sesion.getAttribute("idUsuario");
    if (idUsuario == null) {
        return "redirect:/";
    }

    Articulo articulo = servicioArticulos.obtenerArticuloPorId(id);
    if (articulo != null && articulo.getCreador().getId().equals(idUsuario)) {
        servicioArticulos.eliminarPorId(id);
    } else {
        return "redirect:/articulos";
    }
    return "redirect:/articulos";
}

	
	@GetMapping("/detalle/{id}") // Detalle del artículo
public String detalleArticulo(HttpSession sesion, @PathVariable("id") Long id, Model modelo) {
    if (sesion.getAttribute("nombreCompleto") == null) {
        return "redirect:/";
    }
    Articulo articulo = this.servicioArticulos.obtenerArticuloPorId(id);
    if (articulo == null) {
        return "redirect:/articulos";
    }
    modelo.addAttribute("articulo", articulo);
    return "detalleArticulo.jsp";
}

	
	@GetMapping("/favoritos")// vista de favoritos
	public String vistaFavoritos(HttpSession sesion, Model modelo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if(idUsuario == null) {
			return "redirect:/";
		}
		modelo.addAttribute("favUsuario", this.servicioUsuarios.obtenerPorId(idUsuario).getArticulosFavoritos());
		return "favoritos.jsp";
	}
	
	@PostMapping("/agregarFav/{id}") // anadir favorito
	public String agregarFavorito(HttpSession sesion, @PathVariable ("id") Long idArticulo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if(idUsuario == null) {
			return "redirect:/";
		}
		this.servicioFavoritos.agregarfavorito(idUsuario, idArticulo);
		return "redirect:/articulos";
	}
	
	@DeleteMapping("/quitarFav/{id}") // eliminar favorito
	public String quitarFavorito(HttpSession sesion, @PathVariable ("id") Long idArticulo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if(idUsuario == null) {
			return "redirect:/";
		}
		this.servicioFavoritos.quitarFavorito(idUsuario, idArticulo);
		return "redirect:/articulos";
	}
}


