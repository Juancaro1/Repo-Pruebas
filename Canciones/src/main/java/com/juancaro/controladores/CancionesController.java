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

import com.juancaro.modelos.Artista;
import com.juancaro.modelos.Canciones;
import com.juancaro.servicios.ServicioArtistas;
import com.juancaro.servicios.ServiciosCanciones;

import jakarta.validation.Valid;


@Controller
public class CancionesController {

    @Autowired
    private ServiciosCanciones servicioCanciones;

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        modelo.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{id}")
    public String desplegarDetalleCancion(@PathVariable ("id") Long id, Model modelo){
        Canciones cancion =  servicioCanciones.obtenerCancionPorId(id);
        if(cancion != null){
            modelo.addAttribute("cancion", cancion);
            return "detalleCancion.jsp";
        }
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model modelo){
        Canciones cancion = new Canciones();
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();

        modelo.addAttribute("artistas", artistas);
        modelo.addAttribute("cancion", cancion);
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Canciones cancion, BindingResult validaciones, Model modelo){
        if(validaciones.hasErrors()){
            return "agregarCancion.jsp";
        }
        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/editar/{id}")
    public String formularioEditarCancion(@PathVariable Long id, Model modelo){
        Canciones cancion = servicioCanciones.obtenerCancionPorId(id);
        if(cancion != null){
            modelo.addAttribute("cancion", cancion);
        return "editarCancion.jsp";
        }
        return "redirect:/canciones";
    }

    @PutMapping("/canciones/procesa/editar/{id}")
    public String procesarEditarCancion(@Valid @ModelAttribute ("cancion") Canciones cancion, BindingResult validaciones, @PathVariable ("id") Long id ){
        if(validaciones.hasErrors()){
            return "editarCancion.jsp";
        }   
        cancion.setId(id);
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    @DeleteMapping("/canciones/eliminar/{id}")
    public String procesarEliminarCancion(@PathVariable Long id){
        this.servicioCanciones.eliminaCancion(id);
        return "redirect:/canciones";
    }
}

