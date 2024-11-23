package com.juancaro.servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.juancaro.modelos.LoginUsuario;
import com.juancaro.modelos.Usuario;
import com.juancaro.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	//Crear nuevo usuario
	public Usuario crear(Usuario usuario) {
		String hashPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(hashPassword);
		return this.repositorioUsuarios.save(usuario);
	}
	
	public List<Usuario> obtenerTodos(){
		return (List<Usuario>) this.repositorioUsuarios.findAll();
	}
	
	public Usuario obtenerPorId(Long id) {
		return this.repositorioUsuarios.findById(id).orElse(null);
	}
	
	public Usuario obtenerPorEmail(String email) {
		return this.repositorioUsuarios.findByEmail(email).orElse(null);
	}
	
	// Actualiza el usuario
	public Usuario actualizar(Usuario usuario) {
		return this.repositorioUsuarios.save(usuario);
	}
	
	// Elimina el usuario
	public void eliminar(Long id) {
		this.repositorioUsuarios.deleteById(id);
	}
	
	//Validar el registro las contrasenas
	public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
		if(!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
			validaciones.rejectValue("confirmarPassword", "passwordNoCoincide", "Las contrasenas no coinciden.");
		}
		return validaciones;
	}
	
	//Validar el login
	public BindingResult validarLogin(BindingResult validaciones, LoginUsuario usuario) {
		Usuario usuarioDb = this.obtenerPorEmail(usuario.getEmail());
		if(usuarioDb == null) {
			validaciones.rejectValue("email", "emailNoRegistrado", "El correo ingresado no se encuentra en nuestra base de datos.");
		}else {
			if(!BCrypt.checkpw(usuario.getPassword(), usuarioDb.getPassword())) {
				validaciones.rejectValue("password", "passwordIncorrecto", "Contrasena incorrecta.");
			}
		}
		return validaciones;
	}
	
}
