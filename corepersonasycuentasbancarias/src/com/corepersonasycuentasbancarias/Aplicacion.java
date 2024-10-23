package com.corepersonasycuentasbancarias;

import com.corepersonasycuentasbancarias.clases.CuentaBancaria;
import com.corepersonasycuentasbancarias.clases.Persona;

public class Aplicacion {
	public static void main(String[] args) {
        Persona persona1 = new Persona("Matias", 27);
        Persona persona2 = new Persona("Cinthya", 24);
        Persona persona3 = new Persona("Cristobal", 20);

        CuentaBancaria cuenta1 = new CuentaBancaria(7000.00, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(2050.00, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(10700.00, persona3);
        
        cuenta1.depositar(500.00);
        cuenta2.retiro(3000.00);
        cuenta3.retiro(700.00);
        
        
        System.out.println(persona2 + ", Saldo disponible: " + cuenta2.getSaldoDisponible());
        System.out.println(persona3 + ", Saldo disponible: " + cuenta3.getSaldoDisponible());
        System.out.println(persona1 + ", Saldo disponible: " + cuenta1.getSaldoDisponible());
        System.out.println();
        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
    }
}
