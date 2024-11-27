package com.juancaro.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "poemas")
public class Poema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message =  "Este campo es obligatorio.")
    @Size(min = 5, message = "Debe contener al menos 5 caracteres.")
    private String titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    @NotNull(message = "Debe seleccionar un autor.")
    private ModeloAutor autor;

    @Positive(message = "Debe ser un numero positivo.")
    private int creacion;

    
    @NotBlank(message =  "Este campo es obligatorio.")
    @Size(min = 15, message = "Debe contener al menos 15 caracteres.")
    private String letra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario creador;


    public Poema(Long id, String titulo, ModeloAutor autor, int creacion, String letra, Usuario creador) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.creacion = creacion;
        this.letra = letra;
        this.creador = creador;
    }

    public Poema() {
        this.id = 0l;
        this.titulo = "";
        this.autor = null;
        this.creacion = 0;
        this.letra = "";
        this.creador = new Usuario();
    }


    public Usuario getCreador() {
        return this.creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public ModeloAutor getAutor() {
        return this.autor;
    }

    public void setAutor(ModeloAutor autor) {
        this.autor = autor;
    }


    public int getCreacion() {
        return this.creacion;
    }

    public void setCreacion(int creacion) {
        this.creacion = creacion;
    }

    public String getLetra() {
        return this.letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", autor='" + getAutor() + "'" +
            ", creacion='" + getCreacion() + "'" +
            ", letra='" + getLetra() + "'" +
            ", creador='" + getCreador() + "'" +
            "}";
    }


}
