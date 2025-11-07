package U3_strings_arrays_funciones.teoria;

import java.util.Arrays;

public class paso_por_referencia_por_valor {
  public static void main(String[] args) {
    // 1. Paso por valor (primitivos e inmutables (String, Integer, etc.))
    int numero = 5;

    funcion_por_valor(numero);
    System.out.println(numero);

    // 2. Paso por referencia (Arrays y objetos no mutables (personalizados))
    int[] numeros = new int[2];

    numeros[0] = 10;
    numeros[1] = 20;

	  System.out.println(Arrays.toString(numeros));
	  funcion_por_referencia(numeros);
    System.out.println(Arrays.toString(numeros));
  }

  public static void funcion_por_valor(int numero) {
    numero = 7;
    System.out.println(numero);
  }

  public static void funcion_por_referencia(int[] numeros) {
    numeros[0] = 11;
    numeros[1] = 21;
    System.out.println(Arrays.toString(numeros));
  }
}
