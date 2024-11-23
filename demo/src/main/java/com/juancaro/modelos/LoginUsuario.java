package com.juancaro.modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUsuario {
	
	@NotBlank(message = "El campo es requerido.")
	@Email(message = "El correo debe ser valido.")
	private String email;
	
	@NotBlank(message = "El campo es requerido.")
	@Size(min = 8, message = "Debe contener al menos 8 caracteres.")
	private String password;

	public LoginUsuario(
			@NotBlank(message = "El campo es requerido.") @Email(message = "El correo debe ser valido.") String email,
			@NotBlank(message = "El campo es requerido.") @Size(min = 8, message = "Debe contener al menos 8 caracteres.") String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public LoginUsuario() {
		super();
		this.email = "";
		this.password = "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUsuario [email=" + email + ", password=" + password + "]";
	}
	
	
	
}
