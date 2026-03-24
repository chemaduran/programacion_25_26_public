package U7_collections.teoria;

import java.util.*;
import java.util.stream.Collectors;

public class _05b_streams_intermedias {
  public static void main(String[] args) {
    // Las operaciones intermedias devuelven un nuevo Stream y son "lazy":
    // no se ejecutan hasta que se invoca una operación terminal.
    // Se pueden encadenar varias operaciones intermedias en un pipeline.

    Cliente c1 = new Cliente("29745987Y", "Chiquito", 8);
    Cliente c2 = new Cliente("23478237L", "Grandito", 45);
    Cliente c3 = new Cliente("75758989Y", "Medianito", 7);
    Cliente c4 = new Cliente("83630305X", "Equisele", 32);
    Cliente c5 = new Cliente("12327845W", "Moi", 47);
    Cliente c6 = new Cliente("99999999Z", "Jovencito", 19);

    List<Cliente> clientes = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c6));

    // =========================================================================
    // 1. FILTER: filtra elementos según un predicado (condición booleana)
    // =========================================================================
    System.out.println("=== FILTER: Clientes mayores de 18 ===");
    clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .forEach(c -> System.out.println("  " + c + " (edad: " + c.getEdad() + ")"));

    // Se pueden encadenar varios filter
    System.out.println("\n=== FILTER encadenados: adultos con edad < 40 ===");
    clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .filter(c -> c.getEdad() < 40)
        .forEach(c -> System.out.println("  " + c + " (edad: " + c.getEdad() + ")"));

    // =========================================================================
    // 2. MAP: transforma cada elemento en otro (puede cambiar el tipo)
    // =========================================================================
    // map recibe una función que se aplica a cada elemento del Stream

    // Ejemplo 1: Obtener solo los nombres (String) a partir de los clientes
    System.out.println("\n=== MAP: Obtener solo nombres ===");
    clientes.stream()
        .map(c -> c.toString()) // Cliente -> String (su nombre, ya que toString devuelve nombre)
        .forEach(nombre -> System.out.println("  " + nombre));

    // Ejemplo 2: Obtener las edades (Integer) de cada cliente
    System.out.println("\n=== MAP: Obtener solo edades ===");
    clientes.stream()
        .map(Cliente::getEdad) // Referencia a método, equivale a: c -> c.getEdad()
        .forEach(edad -> System.out.println("  " + edad));

    // Ejemplo 3: Convertir nombres a mayúsculas
    System.out.println("\n=== MAP: Nombres en mayúsculas ===");
    clientes.stream()
        .map(c -> c.toString().toUpperCase())
        .forEach(nombre -> System.out.println("  " + nombre));

    // =========================================================================
    // 3. mapToInt, mapToDouble, mapToLong: versiones especializadas de map
    //    que devuelven IntStream, DoubleStream, LongStream (evitan autoboxing)
    // =========================================================================
    System.out.println("\n=== mapToInt: suma de edades ===");
    int sumaEdades = clientes.stream()
        .mapToInt(Cliente::getEdad) // Devuelve IntStream
        .sum();                     // Método exclusivo de IntStream
    System.out.println("  Suma de edades: " + sumaEdades);

    // IntStream tiene métodos útiles: sum(), average(), max(), min(), count()
    OptionalDouble mediaEdades = clientes.stream()
        .mapToInt(Cliente::getEdad)
        .average();
    System.out.println("  Media de edades: " + mediaEdades.orElse(0));

    // =========================================================================
    // 4. SORTED: ordena los elementos del Stream
    // =========================================================================

    // a) Orden natural (requiere que el objeto implemente Comparable)
    System.out.println("\n=== SORTED: orden natural (por DNI) ===");
    clientes.stream()
        .sorted()
        .forEach(c -> System.out.println("  " + c + " - DNI: " + c.getDni()));

    // b) Con un Comparator personalizado
    System.out.println("\n=== SORTED: por edad ascendente ===");
    clientes.stream()
        .sorted(Comparator.comparingInt(Cliente::getEdad))
        .forEach(c -> System.out.println("  " + c + " (edad: " + c.getEdad() + ")"));

    // c) Orden descendente con reversed()
    System.out.println("\n=== SORTED: por edad descendente ===");
    clientes.stream()
        .sorted(Comparator.comparingInt(Cliente::getEdad).reversed())
        .forEach(c -> System.out.println("  " + c + " (edad: " + c.getEdad() + ")"));

    // =========================================================================
    // 5. DISTINCT: elimina duplicados (usa equals y hashCode)
    // =========================================================================
    List<Integer> numeros = Arrays.asList(1, 3, 5, 3, 1, 7, 5, 9);
    System.out.println("\n=== DISTINCT: eliminar duplicados ===");
    System.out.print("  Original: " + numeros);
    System.out.print("\n  Sin duplicados: ");
    numeros.stream()
        .distinct()
        .forEach(n -> System.out.print(n + " "));
    System.out.println();

    // =========================================================================
    // 6. LIMIT y SKIP: controlan cuántos elementos procesar
    // =========================================================================

    // limit(n): se queda solo con los primeros n elementos
    System.out.println("\n=== LIMIT: primeros 3 clientes ===");
    clientes.stream()
        .limit(3)
        .forEach(c -> System.out.println("  " + c));

    // skip(n): se salta los primeros n elementos
    System.out.println("\n=== SKIP: saltamos los 2 primeros ===");
    clientes.stream()
        .skip(2)
        .forEach(c -> System.out.println("  " + c));

    // Combinación de skip y limit: simular paginación
    int pagina = 1;
    int elementosPorPagina = 2;
    System.out.println("\n=== Paginación: página " + pagina + " (2 elementos) ===");
    clientes.stream()
        .skip((long) (pagina - 1) * elementosPorPagina)
        .limit(elementosPorPagina)
        .forEach(c -> System.out.println("  " + c));

    // =========================================================================
    // 7. PEEK: permite "espiar" los elementos sin modificar el Stream
    //    Útil para depuración. Recibe un Consumer (no devuelve nada)
    // =========================================================================
    System.out.println("\n=== PEEK: depuración del pipeline ===");
    List<String> resultado = clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .peek(c -> System.out.println("  [peek después de filter] " + c))
        .map(Cliente::toString)
        .peek(nombre -> System.out.println("  [peek después de map] " + nombre))
        .collect(Collectors.toList());
    System.out.println("  Resultado final: " + resultado);

    // =========================================================================
    // 8. FLATMAP: "aplana" streams anidados en uno solo
    //    Útil cuando cada elemento genera múltiples elementos
    // =========================================================================
    List<List<Integer>> listaDeListas = Arrays.asList(
        Arrays.asList(1, 2, 3),
        Arrays.asList(4, 5),
        Arrays.asList(6, 7, 8, 9)
    );

    System.out.println("\n=== FLATMAP: aplanar lista de listas ===");
    System.out.println("  Original: " + listaDeListas);
    List<Integer> aplanada = listaDeListas.stream()
        .flatMap(lista -> lista.stream()) // Cada sublista se convierte en un stream
        .collect(Collectors.toList());
    System.out.println("  Aplanada: " + aplanada);

    // Ejemplo con strings: obtener todos los caracteres de una lista de palabras
    List<String> palabras = Arrays.asList("Hola", "Mundo");
    System.out.println("\n=== FLATMAP: caracteres de palabras ===");
    palabras.stream()
        .flatMap(p -> p.chars().mapToObj(ch -> (char) ch)) // cada palabra -> stream de caracteres
        .forEach(ch -> System.out.print(ch + " "));
    System.out.println();

    // =========================================================================
    // 9. ENCADENAR VARIAS OPERACIONES INTERMEDIAS (pipeline completo)
    // =========================================================================
    System.out.println("\n=== Pipeline completo ===");
    System.out.println("Nombres en mayúsculas de los 3 clientes más jóvenes mayores de edad:");
    clientes.stream()
        .filter(c -> c.getEdad() >= 18)           // solo adultos
        .sorted(Comparator.comparingInt(Cliente::getEdad)) // de menor a mayor edad
        .limit(3)                                   // los 3 más jóvenes
        .map(c -> c.toString().toUpperCase())       // nombre en mayúsculas
        .forEach(nombre -> System.out.println("  " + nombre));

    // Recordatorio: nada de esto modifica la lista original
    System.out.println("\nLista original intacta: " + clientes);
  }
}


