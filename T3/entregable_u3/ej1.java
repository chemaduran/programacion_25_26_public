package entregable_u2;


// Implementa la función aleatorioDeArray con la cabecera que se muestra a continuación:
//
//public static int aleatorioDeArray(int[] a)
//Esta función debe devolver un número del array escogido al azar entre todos los disponibles.
//
//Por ejemplo, si a = {111, 222, 333, 444}, aleatorioDeArray(a) podría devolver el 111, el 222, el 333 o el 444.
// Si b = {52, 37}, aleatorioDeArray(b) podría devolver el 52 o el 37.
//
//Utiliza la función en un programa de prueba.
public class ej1 {
	public static void main(String[] args) {
		int[] array = {123, 12345, 2363, 326378, 8};
		System.out.println(aleatoriodearray(array));
	}

	public static int aleatoriodearray(int[] array) {
		int indice = (int) (Math.random() * array.length);
		return array[indice];
	}
}
