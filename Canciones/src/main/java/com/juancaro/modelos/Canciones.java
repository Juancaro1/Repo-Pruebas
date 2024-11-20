package com.juancaro.modelos;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Canciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, message = "Debe tener minimo 5 caracteres.")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;

    @Size(min = 3, message = "Debe tener minimo 3 caracteres.")
    private String album;

    @Size(min = 3, message = "Debe tener minimo 3 caracteres.")
    private String genero;
    
    @Size(min = 3, message = "Debe tener minimo 3 caracteres.")
    private String idioma;

    @Temporal(TemporalType.DATE)
    private LocalDate fecha_creacion;

    @Temporal(TemporalType.DATE)
    private LocalDate fecha_actualizacion;


    public Canciones(Long id, String titulo, Artista artista, String album, String genero, String idioma, LocalDate fecha_creacion, LocalDate fecha_actualizacion) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.idioma = idioma;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public Canciones() {
        this.id = 0l;
        this.titulo = "";
        this.artista = new Artista();
        this.album = "";
        this.genero = "";
        this.idioma = "";
        this.fecha_creacion = LocalDate.now();
        this.fecha_actualizacion = LocalDate.now();
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

    public Artista getArtista() {
        return this.artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDate getFecha_creacion() {
        return this.fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDate getFecha_actualizacion() {
        return this.fecha_actualizacion;
    }

    public void setFecha_actualizacion(LocalDate fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", artista='" + getArtista() + "'" +
            ", album='" + getAlbum() + "'" +
            ", genero='" + getGenero() + "'" +
            ", idioma='" + getIdioma() + "'" +
            ", fecha_creacion='" + getFecha_creacion() + "'" +
            ", fecha_actualizacion='" + getFecha_actualizacion() + "'" +
            "}";
    }


}
