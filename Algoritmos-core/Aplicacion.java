import Clases.Algoritmos;

public class Aplicacion {
    public static void main(String[] args) {
        //Ejemplos esPar
        System.out.println(Algoritmos.esPar(45));
        System.out.println(Algoritmos.esPar(40));

        //Ejemplos esPrimo
        System.out.println(Algoritmos.esPrimo(33));
        System.out.println(Algoritmos.esPrimo(37));


        //Ejemplo esPalindromo
        System.out.println(Algoritmos.esPalindromo("seres"));
        System.out.println(Algoritmos.esPalindromo("Nadar"));



        //Ejemplo stringEnReversa
        System.out.println(Algoritmos.stringEnReversa("Sal"));
        System.out.println(Algoritmos.stringEnReversa("Amor"));

        //Ejemplo FizzBuzz
        Algoritmos.secuenciaFizzBuzz(5);
        Algoritmos.secuenciaFizzBuzz(3);
        Algoritmos.secuenciaFizzBuzz(15);
    }
}