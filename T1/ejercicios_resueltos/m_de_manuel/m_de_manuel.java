package U1_intro_bucles_condicionales.ejercicios.resolucion;

// *   *    *   *
// ** **     * *
// * * *      *
// *   *      *
// *   *      *

public class m_de_manuel {
	public static void main(String[] args) {
		int altura = 11;
		int espacios = 4;

		// Este bucle va de 0 a 4 (incluído el 4)
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < altura*2 +espacios; j++) {
				if (j == altura / 2 && i > altura / 2 ||
								(i + j == (altura - 1) && i < altura / 2) ||
								(i == j && i <= altura / 2) ||
								( j == altura + espacios) ||
								(j == (altura * 2 + espacios)-1) ||
								(i + espacios + altura == j && i <= altura / 2)

				) {
					System.out.print("*");
				} else {
					System.out.print(" ");

				}
			}
			System.out.println();
		}


	}
}
