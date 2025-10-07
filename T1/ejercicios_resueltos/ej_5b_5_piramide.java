package resolucion;

import java.util.Scanner;

public class piramide {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

//        System.out.println("Introduzca la altura de la pirámide: ");
//        int altura = teclado.nextInt();
//        teclado.nextLine();

//        System.out.println("Introduzca el carácter para pintar: ");
//        String c = teclado.nextLine();

        int altura = 3;
        String c = "*";

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < (2 * altura) - 1; j++) {
                if ((i + j >= altura - 1) && (j - i <= altura - 1) /*|| i == altura - 1*/) {
                    System.out.print(c);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}