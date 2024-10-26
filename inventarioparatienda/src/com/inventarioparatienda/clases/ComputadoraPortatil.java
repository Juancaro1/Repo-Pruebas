package com.inventarioparatienda.clases;

import java.util.Random;

public class ComputadoraPortatil extends ProductoElectrodomestico {
	private String marca;
	private int memoriaRam;
	private String numeroSerie;
	
	
	public ComputadoraPortatil (String nombre, double precio,String marca, int memoriaRam) {
		super(nombre, precio);
		this.marca = marca;
		this.memoriaRam = memoriaRam;
		this.numeroSerie = generarNumeroSerie();
	}
	
	private String generarNumeroSerie() {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder numeroSerie = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			int indice = random.nextInt(letras.length());
			numeroSerie.append(letras.charAt(indice));			
		}
		return numeroSerie.toString();
	}
	
	public void mostrarInformacion() {
		super.mostrarInformacion();
		System.out.println("Marca: " + marca);
		System.out.println("Memoria Ram: " + memoriaRam + "GB");
		System.out.println("Numero de serie: " + numeroSerie);
	}
}
