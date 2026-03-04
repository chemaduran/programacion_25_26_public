package U6_ficheros.teoria.ficheros;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class _04_ficheros_binarios_entrada { // entrada = leer = read
  public static void main(String[] args) {
    // Para leer ficheros binarios, vamos a utilizar el ObjectInputStream, que se lo
    // pasaremos al FileInputStream para crear un flujo de entrada.
    // Como siempre, es necesario rodear el código con el try-catch correspondiente.
    // Al igual que en el _03_ficheros_binarios_salida, vamos a utilizar el try con recursos
    // (try-with-resources) que nos permite un autocierre de los ficheros y un mejor control
    // de las excepciones.

    // Leemos el objeto que habíamos escrito en el fichero datos.dat con el _03.
    // Como lo que escribimos fue un objeto de tipo ClaseAFichero, al leerlo con readObject()
    // nos devuelve un Object, por lo que tenemos que hacer un casting al tipo correspondiente.

    try (ObjectInputStream flujo_entrada =
        new ObjectInputStream(new FileInputStream("datos.dat"))) {
      ClaseAFichero objClaseA = (ClaseAFichero) flujo_entrada.readObject();
      System.out.println(objClaseA);
    } catch (ClassNotFoundException e) {
      System.out.println("¡Error: clase no encontrada! " + e.getMessage());
    } catch (IOException e) {
      System.out.println("¡Error al leer el fichero! " + e.getMessage());
    }

    // Tenemos los siguientes métodos para leer los diferentes tipos:
    // boolean readBoolean()     ---- lee un valor boolean del flujo
    // char readChar()           ---- lee un valor char del flujo
    // int readInt()             ---- lee un entero
    // long readLong()           ---- lee un entero largo
    // double readDouble()       ---- lee un double
    // Object readObject()       ---- lee un objeto Serializable

    // IMPORTANTE: hay que leer los datos en el mismo orden en el que se escribieron.
    // Si escribimos un int y luego un String, hay que leer primero un int y luego un String.

    // Al igual que en la escritura, para leer objetos de clases propias, la clase tiene que
    // implementar la interfaz Serializable. Véase la clase ClaseAFichero.
  }
}
