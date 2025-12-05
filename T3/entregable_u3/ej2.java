package entregable_u2;

import java.util.Arrays;
import java.util.Scanner;

// Crear una función insertarValor que:
//
//Reciba como parámetros un vector de enteros, un valor y una posición
//Devuelva como resultado un vector en el que habremos insertado el valor que le hemos pasado en la posición indicada. De esta manera el vector resultado tendrá un elemento más.
//En caso de que la posición exceda los límites del vector deberá mostrar un error por pantalla y devolver el mismo vector recibido. Realizar una llamada a la función mostrando el vector resultado.
//Ejemplo:
//
//v = { 1 , 2 , 3 , 4 , 5 }
//v1 = insertarValor(v,8,3)
//Entonces v1 será {1,2,3,8,4,5}
public class ej2 {

	public static int [] insertarVector (int [] vector, int valor, int posicion){
		int [] resultado = new int[vector.length + 1];

		if (posicion < vector.length){
			int contador = 0;
			for (int i = 0; i < resultado.length; i++) {

					if (i == posicion) {
						resultado[i] = valor;
					} else {
						resultado[i] = vector[contador];
						contador++;
					}
				}
		} else {
			resultado = vector;
			System.out.println("Error, la posicion es mayor");
		}
		return resultado;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
int [] vector = {123, 4565, 8, 3454,124};
		System.out.println("Valor a introducir");
		int numeroIntroducido = entrada.nextInt();
		System.out.println("Posicion");
	int posicion = entrada.nextInt();

		System.out.println("El nuevo vector es: " + Arrays.toString(insertarVector(vector,numeroIntroducido, posicion)));


	}
}
