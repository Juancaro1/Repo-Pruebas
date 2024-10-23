package com.corepersonasycuentasbancarias.clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    private double saldoDisponible;
    private Persona titular;
    private int nroCuenta;
    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    public CuentaBancaria(double saldoDeLaCuenta, Persona titular){
        this.saldoDisponible = saldoDeLaCuenta;
        this.titular = titular;
        this.nroCuenta = generarNumeroDeCuenta();
        listaDeCuentasBancarias.add(this);
    }

    private int generarNumeroDeCuenta(){
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    //Metodos Getters
    public double getSaldoDisponible() {
        return saldoDisponible;
    }
    public Persona getTitular() {
        return titular;
    }
    public int getNroCuenta() {
        return nroCuenta;
    }
    public ArrayList<CuentaBancaria> getListaDeCuentasBancarias() {
        return listaDeCuentasBancarias;
    }
    

    //Metodos Setters
    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    public void setTitular(Persona titular) {
        this.titular = titular;
    }
    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
    public void setListaDeCuentasBancarias(ArrayList<CuentaBancaria> listaDeCuentasBancarias) {
        CuentaBancaria.listaDeCuentasBancarias = listaDeCuentasBancarias;
    }

    public void depositar(double monto){
        if(monto > 0){
            saldoDisponible += monto;
            System.out.println("Depositaste: " + monto + ", tu nuevo saldo es: " + saldoDisponible);
        }else{
            System.out.println("El monto debe ser mayor que 0.");
        }
    }

    public void retiro(double monto){
        if(monto > 0 && saldoDisponible >= monto){
            saldoDisponible -= monto;
            System.out.println("Retiraste: " + monto + ", tu nuevo saldo es: " + saldoDisponible);
        }else{
            System.out.println("No tienes fondos suficientes para retirar");
        }
    }
    
    public void despliegaInformacion() {
    	System.out.println("Numero de Cuenta: " + nroCuenta);
    	System.out.println("Titular: " + titular.getNombre());
    	System.out.println("Edad: " + titular.getEdad());
    	System.out.println("Saldo Disponible: " + saldoDisponible);
	}
    
    public static void imprimeInformacionDeTodasLasCuentas(){
        System.out.println("Informacion de las cuentas:");
        for(CuentaBancaria cuenta : listaDeCuentasBancarias){
            cuenta.despliegaInformacion();
            System.out.println();
        }
    }
}
