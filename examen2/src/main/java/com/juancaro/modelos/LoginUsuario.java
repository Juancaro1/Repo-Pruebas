package com.juancaro.modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUsuario {

    @NotBlank(message =  "Este campo es obligatorio.")
    @Email(message = "Debe ser un correo valido.")
    private String email;

    @NotBlank(message = "El campo es requerido.")
	@Size(min = 8, message = "Debe contener al menos 8 caracteres.")
    private String password;


    public LoginUsuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginUsuario() {
        this.email = "";
        this.password = "";
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

}
