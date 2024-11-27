package com.juancaro.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.juancaro.modelos.LoginUsuario;
import com.juancaro.modelos.Usuario;
import com.juancaro.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class ControladorUsuario {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/") //Mostrara el Login
    public String formLogin(Model modelo){
        modelo.addAttribute("loginUsuario", new LoginUsuario());
        return "login.jsp";
    }

    @GetMapping("/registro")//Mostrare el registro
    public String formRegistro(Model modelo){
        modelo.addAttribute("usuario", new Usuario());
        return "register.jsp";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession sesion){
        sesion.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")//Proceso el Login del usuario
    public String login(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario, BindingResult validaciones, Model modelo, HttpSession sesion){
        this.servicioUsuarios.validarLogin(validaciones, loginUsuario);
        if(validaciones.hasErrors()){
            return "login.jsp";
        }
        Usuario usuario = this.servicioUsuarios.obtenerPorEmail(loginUsuario.getEmail());
        sesion.setAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido());
        sesion.setAttribute("idUsuario", usuario.getId());
        return "redirect:/poemas";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones, Model modelo, HttpSession sesion){
        this.servicioUsuarios.validarRegistro(validaciones, usuario);
        if(validaciones.hasErrors()) {
			modelo.addAttribute("usuario", new Usuario());
			return "register.jsp";
        }
        Usuario usuario2 = this.servicioUsuarios.crear(usuario);
        sesion.setAttribute("nombreCompleto",  usuario2.getNombre() + " " + usuario2.getApellido());
        sesion.setAttribute("idUsuario", usuario2.getId());
		return "redirect:/poemas";
    }
}
