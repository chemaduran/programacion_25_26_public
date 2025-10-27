// Escribe un programa que solicite al usuario los siguientes números:
//
//Un número entero positivo
//Una cifra entre 0 y 9 (ambos inclusive)
//Una vez introducidos los dos números nos debe decir cuántas ocurrencias de la cifra hay en el primer número y cuáles son las posiciones (en orden en las que se han encontrado).
//
//Ejemplo 1:
//
//Introduzca un número:
//3456759
//Una cifra:
//5
//
//Resultado:
//
//2 ocurrencias
//Posiciones: 2 - 5
//Ejemplo 2:
//
//Introduzca un número:
//66554433
//Una cifra:
//9
//
//Resultado:
//
//0 ocurrencias
//Posiciones: Ninguna

import java.util.Scanner;

public class ej2 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce un número (entero y positivo): ");
		int num = entrada.nextInt();
		System.out.println("Introduce una cifra (0-9): ");
		int cifra = entrada.nextInt();

		int numInvertido = 0;
		int ultimaCifra = 0;

		while (num > 0) {
			ultimaCifra = num % 10;
			numInvertido = numInvertido * 10 + ultimaCifra;
			num /= 10;
		}

		int numOcurrencias = 0;
		String posOcurrencias = "";
		int contador = 0;

		while (numInvertido > 0) {
			contador++;
			ultimaCifra = numInvertido % 10;
			num = num * 10 + ultimaCifra;
			if (ultimaCifra == cifra) {
				numOcurrencias++;
				if (posOcurrencias.isEmpty()) {
					posOcurrencias += contador ;
				}else {
					posOcurrencias += " - " + contador;
				}
			}
			numInvertido /= 10;
		}

		System.out.println(numOcurrencias + " ocurrencias");
		System.out.println("Posiciones: " + posOcurrencias);

	}
}
