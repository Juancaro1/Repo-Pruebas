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

import com.juancaro.modelos.Artista;
import com.juancaro.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ArtistasController {

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo){
        modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "artistas.jsp";
    }

    @GetMapping("/artistas/detalle/{id}")
    public String desplegarDetalleArtista(@PathVariable Long id, Model modelo){
        Artista artista = servicioArtistas.obtenerArtistaPorId(id);
        modelo.addAttribute("artista", artista);
        return "detalleArtista.jsp";
    }

    @GetMapping("/artistas/formulario/agregar/")
    public String formularioAgregar(Model modelo){
        modelo.addAttribute("nuevoArtista", new Artista());
        return "agregarArtista.jsp";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute ("artista") Artista artista, Model modelo, BindingResult validaciones){
        if(validaciones.hasErrors()){
            return "agregarArtista.jsp";
        }
        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
    
    @DeleteMapping("/artistas/eliminar/{id}")
    public String procesarEliminarArtista(@PathVariable Long id){
        this.servicioArtistas.eliminaCancion(id);
        return "redirect:/canciones";
    }
}
