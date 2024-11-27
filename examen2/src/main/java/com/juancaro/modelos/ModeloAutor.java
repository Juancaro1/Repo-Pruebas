package com.juancaro.modelos;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "autores")
public class ModeloAutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Este campo es obligatorio.")
    private String nombre;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private List<Poema> poemas;

    public ModeloAutor(String nombre) {
        this.nombre = nombre;
    }

    public ModeloAutor() {
        
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


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

}
