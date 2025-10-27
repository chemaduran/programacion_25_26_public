
// En homenaje al grupo de música ZZ Top escribe un programa que escriba por pantalla un par de Zs. La anchura de la Z deberá ser igual a la altura y la separación entre ambas Zs será de 3 espacios.
//
//Se solicitará al usuario una altura que deberá ser siempre impar y mayor que 3. En caso contrario se volverá a solicitar dicha altura.
//
//Ejemplo 1:
//
//Introduce la altura de la Z: 5
//*****   *****
//   *       *
//  *       *
// *       *
//*****   *****
//Ejemplo2:
//
//Introduce la altura de la Z: 7
//*******   *******
//     *         *
//    *         *
//   *         *
//  *         *
// *         *
//*******   *******

import java.sql.SQLOutput;
import java.util.Scanner;

public class ej1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce una altura para la letra Z(que sea impar y mayor que 3)");
		int altura = 7;

//		do {
//			System.out.println("Introduce una altura para la letra Z(que sea impar y mayor que 3)");
//			altura = sc.nextInt();
//		} while (altura < 3 || altura % 2 == 0);

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < (altura * 2) + 3; j++) {
				if ((i == 0 && j < altura) || (i == 0 && j > (altura + 3)) ||
								(i == altura - 1 && j < altura) || (i == altura - 1 && j > (altura + 3) ||
								(i + j) == (altura - 1)) || (i + j) == (altura * 2 + 2))
				{
					System.out.print("*");
				} else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}

