package com.inventarioparatienda;

import com.inventarioparatienda.clases.ComputadoraPortatil;
import com.inventarioparatienda.clases.ProductoElectrodomestico;
import com.inventarioparatienda.clases.Televisor;
import com.inventarioparatienda.clases.TiendaElectronica;

public class Aplicacion {
	public static void main(String[] args) {
		TiendaElectronica tienda = new TiendaElectronica();
		
		ProductoElectrodomestico notebook1 = new ComputadoraPortatil("Notebook Gamer", 2000.00, "Acer", 16);
		ProductoElectrodomestico notebook2 = new ComputadoraPortatil("Ultrabook", 5000.00, "Lenovo", 32);
		ProductoElectrodomestico televisor1 = new Televisor("Samsung", 1500.00, 20, 55.0f, "1920x1080");
		ProductoElectrodomestico televisor2 = new Televisor("LG", 1000.00, 5, 32.0f, "1920x1080");
		
		notebook1.setCantidadDisponible(4);
		notebook2.setCantidadDisponible(10);
		televisor1.setCantidadDisponible(20);
		televisor2.setCantidadDisponible(5);
		System.out.println();
		
		tienda.agregarProducto(notebook1);
		tienda.agregarProducto(notebook2);
		tienda.agregarProducto(televisor1);
		tienda.agregarProducto(televisor2);
		
		System.out.println();
		
		tienda.realizarVenta("Samsung");
		tienda.realizarVenta("LG");
		tienda.realizarVenta("Notebook Gamer");
		tienda.realizarVenta("Ultrabook");
		
		System.out.println();
		notebook1.mostrarInformacion();
		televisor1.mostrarInformacion();
		System.out.println();
		tienda.mostrarProductos();
		
	}
}
