package Clases;

public class Algoritmos {
    public static boolean esPar(int numero){
        return numero % 2 == 0;
    }

    public static boolean esPrimo(int numero){
        if(numero <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if(numero % i == 0){
                return false;
            }
        }
        return true;
    }

    public static String stringEnReversa(String normal){
        String reversa = "";
        for(int i = normal.length() - 1; i >=0; i--){
            reversa += normal.charAt(i);
        }
        return reversa;
    }

    public static boolean esPalindromo(String palindromo){
        String reversa = stringEnReversa(palindromo);
        return palindromo.equals(reversa);
    }

    public static void secuenciaFizzBuzz(int numero){
        for(int i = 1; i <= numero ; i++ ){
            if(i % 3 == 0 && i % 5 == 0){
            System.out.println("FizzBuzz ");
            } else if(i % 3 == 0){
            System.out.println("Fizz ");
            } else if (i % 5 == 0) {
                System.out.println("Buzz ");
            }
        }
    }
}

