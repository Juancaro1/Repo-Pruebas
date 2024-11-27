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

import com.juancaro.modelos.ModeloAutor;
import com.juancaro.modelos.Poema;
import com.juancaro.repositorios.RepositorioAutores;
import com.juancaro.servicios.ServicioPoemas;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorPoema {

    @Autowired
    private ServicioPoemas servicioPoemas;

    @Autowired
    private RepositorioAutores repositorioAutores;

    @GetMapping("/poemas")
    public String obtenerPoemas(HttpSession sesion, Model modelo){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }
        List<Poema> poemas = this.servicioPoemas.obtenerTodos();

        modelo.addAttribute("poemas", poemas);
        modelo.addAttribute("idUsuario", idUsuario);
        return "poemas.jsp";
    }

    @GetMapping("/poemas/autor/{id}")
    public String obtenerPoemasPorAutor(HttpSession sesion, Model modelo, @PathVariable ("id") Long id){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }

        
        List<Poema> poemas = this.servicioPoemas.obtenerPoemasPorAutor(id);
        if(poemas.isEmpty()){
            modelo.addAttribute("mensaje", "No se encontraron poemas para este autor.");
        }

        modelo.addAttribute("poemas", poemas);
        modelo.addAttribute("idUsuario", idUsuario);
        return "poemasAutor.jsp";
    }


    @GetMapping("/form/agregar")
    public String agregarPoema(HttpSession sesion, Model modelo){
        if(sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
    }
    modelo.addAttribute("poema", new Poema());
    return "agregarPoema.jsp";
    }

    @GetMapping("/form/editar/{id}")
    public String editarPoema(HttpSession sesion, Model modelo, @PathVariable ("id") Long id){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }
        Poema poema = this.servicioPoemas.obtenerPorId(id);

        modelo.addAttribute("poema", poema);
        return "editarPoema.jsp";
    }

    @PostMapping("/guardar")
    public String guardar(HttpSession sesion, @Valid @ModelAttribute("poema") Poema poema, BindingResult validaciones) {
    Long idUsuario = (Long) sesion.getAttribute("idUsuario");
    if (sesion.getAttribute("nombreCompleto") == null) {
        return "redirect:/";
    }
    if (validaciones.hasErrors()) {
        return "agregarPoema.jsp"; 
    }
    ModeloAutor autor = this.servicioPoemas.findByNombre(poema.getAutor().getNombre());
    
    if (autor == null) {
        autor = new ModeloAutor();
        autor.setNombre(poema.getAutor().getNombre());
        this.repositorioAutores.save(autor);
    }

    poema.setAutor(autor);
    this.servicioPoemas.crear(poema, idUsuario);
    return "redirect:/poemas";
}


    @PutMapping("/actualizar/{id}")
    public String actualizar(HttpSession sesion, @PathVariable ("id") Long id, @Valid @ModelAttribute ("poema") Poema poema, BindingResult validaciones){
        if(sesion.getAttribute("nombreCompleto") == null){
            return "redirect:/";
        }
        if(validaciones.hasErrors()){
            return "editarPoema.jsp";
        }
        Poema poema1 = this.servicioPoemas.obtenerPorId(id);

        poema1.setTitulo(poema.getTitulo());
        poema1.setCreacion(poema.getCreacion());
        poema1.setAutor(poema.getAutor());

        this.servicioPoemas.actualizar(poema1);
        return "redirect:/poemas";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPoema(@PathVariable ("id") Long id, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }

        Poema poema = this.servicioPoemas.obtenerPorId(id);
        
        if(poema.getAutor() != null && poema.getCreador().getId().equals(idUsuario)){
            this.servicioPoemas.eliminar(id);
            return "redirect:/poemas";
        }else{
            return "";
        }
    }

    @GetMapping("/detalle/{id}")
    public String detallePoema(HttpSession sesion, @PathVariable ("id") Long id, Model modelo){
        if (sesion.getAttribute("nombreCompleto") == null) {
            return "redirect:/";
        }
        Poema poema = this.servicioPoemas.obtenerPorId(id);
        if(poema == null){
            return "redirect:/poemas";
        }
        modelo.addAttribute("poema", poema);
        return "detallePoema.jsp";
    }
}
