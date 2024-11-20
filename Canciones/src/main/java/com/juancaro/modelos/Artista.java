package com.juancaro.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name =  "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 150)
    private String biografia;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDate fecha_creacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fecha_actualizacion;

    @OneToMany(mappedBy = "artista", cascade  = CascadeType.ALL, orphanRemoval =  true)
    private List<Canciones> listaCanciones;

    public Artista(Long id, String nombre, String apellido, String biografia, LocalDate fecha_creacion, LocalDate fecha_actualizacion, List<Canciones> listaCanciones) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.biografia = biografia;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.listaCanciones = listaCanciones;
    }
    
    public Artista() {
        this.id = 0l;
        this.nombre = "";
        this.apellido = "";
        this.biografia = "";
        this.fecha_creacion = LocalDate.now();
        this.fecha_actualizacion = LocalDate.now();
        this.listaCanciones = new ArrayList<>();
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

    public String getBiografia() {
        return this.biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
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

    public List<Canciones> getListaCanciones() {
        return this.listaCanciones;
    }

    public void setListaCanciones(List<Canciones> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    @PrePersist
    public void PrePersist(){
        this.fecha_creacion = LocalDate.now();
        this.fecha_actualizacion = LocalDate.now();
    }

    @PreUpdate
    public void PreUpdate(){
        this.fecha_actualizacion = LocalDate.now();
    }
    
}

