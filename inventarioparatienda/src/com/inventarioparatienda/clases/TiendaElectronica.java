package com.inventarioparatienda.clases;

import java.util.ArrayList;

public class TiendaElectronica {
	private ArrayList<ProductoElectrodomestico> listaDeProductos;
	
	public TiendaElectronica() {
		listaDeProductos = new ArrayList<>();
	}
	
	public void agregarProducto(ProductoElectrodomestico producto) {
		listaDeProductos.add(producto);
		System.out.println("Producto agregado: " + producto.getNombre());
	}
	
	public void mostrarProductos() {
        for (ProductoElectrodomestico producto : listaDeProductos) {
            producto.mostrarInformacion();
            System.out.println();
        	}
		}
	public ProductoElectrodomestico buscarProducto(String nombre){
		for(ProductoElectrodomestico producto : listaDeProductos) {
			if(producto.getNombre().equalsIgnoreCase(nombre)) {
				return producto;
			}
		} System.out.println("Producto no Disponible: " + nombre);
		return null;
	}
	
	public void realizarVenta(String nombre) {
		ProductoElectrodomestico producto = buscarProducto(nombre);
		if(producto != null) {
			int cantidadDisponible = producto.getCantidadDisponible();
			if(cantidadDisponible > 0) {
				producto.setCantidadDisponible(cantidadDisponible - 1);
				System.out.println("Se realizo la venta: " + producto.getNombre() + "\n Cantidad Disponible: " + producto.getCantidadDisponible());
				
				if(producto.getCantidadDisponible() == 0){
					System.out.println("Producto agotado: " + producto.getNombre());
				}else {
					System.out.println("Producto agotado: " + producto.getNombre());
				}
			}
		}
	}
}
