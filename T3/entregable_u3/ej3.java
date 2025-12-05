package entregable_u2;

// Utilizando vectores bidimensionales en la función, realizar la siguiente función para un juego de ajedrez:
//
//public static boolean jaque(String posRey,String posReina)
//Y nos devuelva si reina está en posición de jaque al rey.
//
//La posiciones que recibe la función son posiciones de ajedrez: a5, h4, c8
//
//Para recordar una imagen de un tablero con las posiciones:
//
//       8  r n b q k b n r
//       7  p p p p p p p p
//       6  . . . . . . . .
//       5  . . . . . . . .
//       4  . . . . . . . .
//       3  . . . . . . . .
//       2  P P P P P P P P
//       1  R N B Q K B N R
//          a b c d e f g h
//
//
//
//NOTA: Podéis crear los vectores adiciones que consideréis.
public class ej3 {
	public static void main(String[] args) {
		String posreina = "c4";
		String posrey = "c3";
		System.out.println(esjaque(posreina, posrey));
	}

	public static boolean esjaque(String posreina, String posrey) {
		boolean esjaque = false;

		int[][] direcciones = {{1, 1}, {1, -1}, {-1, 1}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}};

		int colreina = posreina.charAt(0) - 'a';
		int filareina = posreina.charAt(1) - '0';

		int colrey = posrey.charAt(0) - 'a';
		int filarey = posrey.charAt(1) - '0';

		for (int[] dir : direcciones) {
			int nuevafila = filareina + dir[0];
			int nuevacol = colreina + dir[1];

			while (nuevacol <= 8 && nuevacol >= 0 && nuevafila <= 8 && nuevafila >= 0) {
				if (colrey == nuevacol && filarey == nuevafila) {
					esjaque = true;
					break;
				}
				nuevafila += dir[0];
				nuevacol += dir[1];
			}
			if (esjaque){
				break;
			}
		}
		return esjaque;
	}
}
