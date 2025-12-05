package U3_strings_arrays_funciones.ejercicios.T4_arrays_adicionales;

import java.util.Scanner;

// Escribe un programa que, dada una posición en un tablero de ajedrez, nos diga a qué casillas
// podría saltar un alfil que se encuentra en esa posición. Como se indica en la figura, el alfil se
// mueve siempre en diagonal. El tablero cuenta con64 casillas. Las columnas se indican con las
// letras de la "a" a la "h" y las filas se indican del 1 al 8.
//
// Introduzca la posición del alfil: d5
//
// El alfil puede moverse a las siguientes posiciones:h1 a2 g2 b3 f3 c4 e4 c6 e6 b7 f7 a8 g8
public class ej4 {
  public static void main(String[] args) {
    //
    String letras = "abcdefgh";
    final int MAXIMO = 8;
    final int MINIMO = 1;
    String[][] tablero = new String[MAXIMO][MAXIMO];

    for (int i = MAXIMO - 1; i >= MINIMO - 1; i--) {
      for (int j = MINIMO - 1; j < MAXIMO; j++) {
        String posicion = letras.charAt(j) + Integer.toString(i + 1);
        tablero[j][i] = posicion;
        System.out.print(tablero[j][i] + " ");
      }
      System.out.println();
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Introduzca la posición del alfil:");
    String posicion = sc.nextLine();
    int x = columna(posicion);
    int y = Integer.parseInt(posicion.substring(1, 2)) - 1;

    System.out.print(tablero[x][y] + " ");

    System.out.println();

    // bucle 1:
    int tmp_x = x - 1;
    int tmp_y = y - 1;
    while (tmp_x >= 0 && tmp_y >= 0) {
      System.out.print(tablero[tmp_x][tmp_y] + " ");
      tmp_x--;
      tmp_y--;
    }

    System.out.println();

    // bucle 2:
    tmp_x = x + 1;
    tmp_y = y - 1;
    while (tmp_x < MAXIMO && tmp_y >= 0) {
      System.out.print(tablero[tmp_x][tmp_y] + " ");
      tmp_x++;
      tmp_y--;
    }

    System.out.println();

    // bucle 3:
    tmp_x = x - 1;
    tmp_y = y + 1;
    while (tmp_x >= 0 && tmp_y < MAXIMO) {
      System.out.print(tablero[tmp_x][tmp_y] + " ");
      tmp_x--;
      tmp_y++;
    }

    System.out.println();

    // bucle 4:
    tmp_x = x + 1;
    tmp_y = y + 1;
    while (tmp_x < MAXIMO && tmp_y < MAXIMO) {
      System.out.print(tablero[tmp_x][tmp_y] + " ");
      tmp_x++;
      tmp_y++;
    }
  }

  public static int columna(String posicion) {
    String letras = "abcdefgh";
    return letras.indexOf(posicion.charAt(0));
  }
}