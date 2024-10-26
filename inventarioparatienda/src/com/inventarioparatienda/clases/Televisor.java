package com.inventarioparatienda.clases;

public class Televisor extends ProductoElectrodomestico{
	private float tamanoPantalla;
	private String resolucion;
	
	public Televisor (String nombre, double precio, int cantidadDisponible ,float tamano, String resolucion) {
		super(nombre, precio);
		this.tamanoPantalla = tamano;
		this.resolucion = resolucion;
	}
	
	public void mostrarInformacion() {
		super.mostrarInformacion();
		System.out.println("Tamano de pantalla: " + tamanoPantalla + "pulgadas");
		System.out.println("Resolucion: " + resolucion);
	}
}
