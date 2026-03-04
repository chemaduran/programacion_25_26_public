package U6_ficheros.teoria.ficheros;

import java.io.*;
import java.util.Arrays;

public class _03_ficheros_binarios_salida { // salida = escribir = write
	public static void main(String[] args) {
		// Para escribir ficheros binarios, esta vez vamos a utilizar el ObjectOutputStream, que se lo
		// pasaremos al FileOutputStream para crear un flujo de salida.
		// Como siempre, es necesario rodear el código con el try-catch correspondiente.

		int[] enteros = new int[10];
		for (int i = 0; i < enteros.length; i++) {
			enteros[i] = i;
		}

		// Si escribimos el array de enteros uno a uno...
		try {
			ObjectOutputStream flujo_salida;
			flujo_salida = new ObjectOutputStream(new FileOutputStream("numeros_enteros.dat"));
			for (int i = 0; i < enteros.length; i++) {
				flujo_salida.writeInt(enteros[i]);
			}
			flujo_salida.close();
		} catch (IOException e) {
			System.out.println("¡Error al escribir el fichero!");
		}

		// ... luego a la hora de leerlos, tenemos que hacer esta ñapa.
		// No sabemos cuántos enteros se guardaron, así que leemos en un bucle infinito
		// hasta que se lance EOFException, que indica que hemos llegado al final del fichero.
		// Como no conocemos el tamaño, empezamos con un array vacío y lo vamos redimensionando
		// con Arrays.copyOf cada vez que leemos un nuevo entero. Es ineficiente, pero usa
		// la memoria justa y necesaria.
		 try {
		 	ObjectInputStream flujo_entrada;
		 	flujo_entrada = new ObjectInputStream(new FileInputStream("numeros_enteros.dat"));
		 	int[] enteros_leidos = new int[0];
		 	try {
		 		while (true) {
		 			int num = flujo_entrada.readInt();
		 			enteros_leidos = Arrays.copyOf(enteros_leidos, enteros_leidos.length + 1);
		 			enteros_leidos[enteros_leidos.length - 1] = num;
		 		}
		 	} catch (EOFException e) {
		 		// Fin del fichero alcanzado, no es un error real
			  System.out.println("Fin de lectura de fichero");
		 	}
		 	flujo_entrada.close();
		 	System.out.println(Arrays.toString(enteros_leidos));
		 } catch (IOException e) {
		 	System.out.println("¡Error al leer el fichero!");
		 }

		// Sin embargo, esta vez vamos a ver una manera diferente de hacerlo, que nos permite un
		// autocierre de los ficheros y un mejor control de las excepciones.
		// Fíjate bien en cómo se hace el try.
		ClaseAFichero objClaseA = new ClaseAFichero();

		try (ObjectOutputStream flujo_salida = new ObjectOutputStream(new FileOutputStream("datos.dat"))) {
			flujo_salida.writeObject(objClaseA);
		} catch (IOException e) {
			System.out.println("¡Error al escribir el fichero!");
		}

		// Hay que tener en cuenta que el objeto que vamos a escribir en binario a fichero, tiene que pertenecer a una
		// clase que implemente la interfaz "Serializable" (mira el fichero ClaseAFichero.java). La interfaz Serializable
		// no obliga a implementar ningún método (es automático en este caso), pero tenemos que asegurarnos que TODAS
		// las propiedades de esa clase TAMBIÉN sean Serializables. Las típicas que nos ofrece Java (Integer, String, etc.)
		// lo son, pero si tenemos alguna clase nuestra, debe implementar la interfaz Serializable

		// Tenemos los siguientes métodos para escribir los diferentes tipos:
		// void writeBoolean (boolean b)   ---- escribe un valor boolean en el flujo
		// void writeChar(int c)           ---- escribe el valor char del valor entero que se pasa
		// void writeInt(int n)            ---- escribe un entero
		// void writeLong(long n)          ---- escribe un entero largo
		// void writeDouble(double d)      ---- escribe un
		// double void writeObject(Objeto) ---- escribe un objeto Serializable
	}
}