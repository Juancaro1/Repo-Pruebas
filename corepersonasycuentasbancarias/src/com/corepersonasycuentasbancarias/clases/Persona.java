package com.corepersonasycuentasbancarias.clases;

public class Persona {
	    private String nombre;
	    private int edad;

	    public Persona(String nombre, int edad){
	        this.nombre = nombre;
	        this.edad = edad;
	    }

	    //Metodos Getters
	    public String getNombre() {
	        return nombre;
	    }
	    public int getEdad() {
	        return edad;
	    }

	    //Metodos Setters
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    @Override
	    public String toString() {
	        return "Nombre: " + getNombre() + ", Edad: " + getEdad();
	    }
}
