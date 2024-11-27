package com.juancaro.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message =  "Este campo es obligatorio.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String nombre;

    @NotBlank(message =  "Este campo es obligatorio.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String apellido;

    @Column(unique = true)
    @NotBlank(message =  "Este campo es obligatorio.")
    @Email(message = "Debe ser un correo valido.")
    private String email;

    @NotBlank(message =  "Este campo es obligatorio.")
    @Size(min =  8, message = "Debe contener al menos 8 caracteres.")
    private String password;

    @Transient
    private String confirmarPassword;

    @OneToMany(mappedBy = "creador")
    private List<Poema> poemas;




    public Usuario(Long id, String nombre, String apellido, String email, String password, String confirmarPassword, List<Poema> poemas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.confirmarPassword = confirmarPassword;
        this.poemas = poemas;
    }

    public Usuario() {
        this.id = 0l;
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.password = "";
        this.confirmarPassword = "";
        this.poemas = null;
    }



    public List<Poema> getPoemas() {
        return this.poemas;
    }

    public void setPoemas(List<Poema> poemas) {
        this.poemas = poemas;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getConfirmarPassword() {
        return this.confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", confirmarPassword='" + getConfirmarPassword() + "'" +
            ", poemas='" + getPoemas() + "'" +
            "}";
    }

}
