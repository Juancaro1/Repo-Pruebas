package com.juancaro.modelos;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@NotBlank(message = "El campo es obligatorio.")
	@Size(min = 3, message = "Debe tener minimo 3 caracteres.")
	private String nombre;
	
	@NotBlank(message = "El campo es obligatorio.")
	@Size(min = 3, message = "Debe tener minimo 3 caracteres.")
	private String apellido;
	
	@Column(unique = true)
	@NotBlank(message = "El campo es obligatorio.")
	@Email(message = "Debe ser un correo electronico valido.")
	private String email;
	
	@NotBlank(message = "El campo es obligatorio.")
	@Size(min = 8, message = "Debe contener al menos 8 caracteres.")
	private String password;
	
	@Transient
	private String confirmarPassword;
	
	@OneToMany(mappedBy = "creador")
	private List<Articulo> articulos;
	
	@ManyToMany
	@JoinTable(name = "favoritos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_articulo"))
	private List<Articulo> articulosFavoritos;

	public Usuario(Long id,
			@NotBlank(message = "El campo es obligatorio.") @Size(min = 3, message = "Debe tener minimo 3 caracteres.") String nombre,
			@NotBlank(message = "El campo es obligatorio.") @Size(min = 3, message = "Debe tener minimo 3 caracteres.") String apellido,
			@NotBlank(message = "El campo es obligatorio.") @Email(message = "Debe ser un correo electronico valido.") String email,
			@NotBlank(message = "El campo es obligatorio.") @Size(min = 8, message = "Debe contener al menos 8 caracteres.") String password,
			String confirmarPassword, List<Articulo> articulos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.confirmarPassword = confirmarPassword;
		this.articulos = articulos;
	}
	
	public Usuario() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.apellido = "";
		this.email = "";
		this.password = "";
		this.confirmarPassword = "";
		this.articulos = null;
	}

	
	
	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Articulo> getArticulosFavoritos() {
		return articulosFavoritos;
	}

	public void setArticulosFavoritos(List<Articulo> articulosFavoritos) {
		this.articulosFavoritos = articulosFavoritos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", confirmarPassword=" + confirmarPassword + "]";
	}
	
	
	
	
	
	
}
