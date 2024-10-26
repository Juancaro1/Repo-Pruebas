package com.inventarioparatienda.clases;


public class ProductoElectrodomestico {
	private String nombre;
	private double precio;
	private int cantidadDisponible;
	
	public ProductoElectrodomestico (String nombre, double precio, int cantidadDisponible) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}
	
	public ProductoElectrodomestico(String nombre, double precio) {
		this(nombre, precio, 0);
	}
	
	//Metodos GETTERS
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	
	//Metodos SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	
	public void mostrarInformacion() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
		System.out.println("Cantidad Disponible: " + cantidadDisponible);
	}
}
