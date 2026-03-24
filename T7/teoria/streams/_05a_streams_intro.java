package U7_collections.teoria;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _05a_streams_intro {
  public static void main(String[] args) {
    // ¿Qué es un Stream?
    // Un Stream es una secuencia de elementos que soporta operaciones secuenciales y paralelas
    // para procesar datos de forma declarativa (similar a SQL).
    // NO almacena datos (no es una colección), sino que opera sobre una fuente de datos.
    // Los Streams son de un solo uso: una vez consumidos, no se pueden reutilizar.

    // Hay dos tipos de operaciones:
    // - Operaciones intermedias: devuelven otro Stream (son "lazy", no se ejecutan hasta que
    //   hay una operación terminal). Ejemplos: filter, map, sorted, distinct, limit, skip...
    // - Operaciones terminales: producen un resultado o efecto secundario y consumen el Stream.
    //   Ejemplos: forEach, collect, count, reduce, min, max, anyMatch...

    // =========================================================================
    // 1. FORMAS DE CREAR UN STREAM
    // =========================================================================

    // a) A partir de una colección (la más habitual)
    List<String> nombres = Arrays.asList("Ana", "Luis", "Marta", "Pedro", "Pablo");
    Stream<String> streamDeNombres = nombres.stream();
    System.out.println("Stream creado a partir de lista:");
    streamDeNombres.forEach(n -> System.out.print(n + " "));
    System.out.println();
    // OJO: el stream ya está consumido, no se puede volver a usar

    // b) A partir de un array
    String[] arr = {"Rojo", "Verde", "Azul"};
    Stream<String> streamDeArray = Arrays.stream(arr);
    System.out.println("\nStream creado a partir de array:");
    streamDeArray.forEach(n -> System.out.print(n + " "));
    System.out.println();

    // c) Con Stream.of() para valores sueltos
    Stream<String> streamOf = Stream.of("Uno", "Dos", "Tres");
    System.out.println("\nStream creado con Stream.of():");
    streamOf.forEach(n -> System.out.print(n + " "));
    System.out.println();

    // d) Streams de tipos primitivos (IntStream, LongStream, DoubleStream)
    //    Evitan el autoboxing y son más eficientes para operaciones numéricas
    IntStream streamEnteros = IntStream.rangeClosed(1, 10); // del 1 al 10 (ambos incluidos)
    System.out.println("\nStream de enteros del 1 al 10:");
    streamEnteros.forEach(n -> System.out.print(n + " "));
    System.out.println();

//    IntStream.range(1, 10); // del 1 al 9 (el 10 NO se incluye)

    // e) Stream vacío
    Stream<String> streamVacio = Stream.empty();
    System.out.println("\nElementos en stream vacío: " + streamVacio.count()); // 0

    // f) Stream infinito con generate (necesita limit para no ser infinito)
    Stream<Double> aleatorios = Stream.generate(Math::random).limit(5);
    System.out.println("\n5 números aleatorios:");
    aleatorios.forEach(n -> System.out.printf("%.2f ", n));
    System.out.println();

    // g) Stream infinito con iterate (como un bucle)
    Stream<Integer> pares = Stream.iterate(0, n -> n + 2).limit(8);
    System.out.println("\n8 primeros números pares:");
    pares.forEach(n -> System.out.print(n + " "));
    System.out.println();

    // =========================================================================
    // 2. EJEMPLO BÁSICO: comparación estilo tradicional vs Stream
    // =========================================================================

    Cliente c1 = new Cliente("29745987Y", "Chiquito", 8);
    Cliente c2 = new Cliente("23478237L", "Grandito", 45);
    Cliente c3 = new Cliente("75758989Y", "Medianito", 7);
    Cliente c4 = new Cliente("83630305X", "Equisele", 32);
    Cliente c5 = new Cliente("12327845W", "Moi", 47);

    List<Cliente> clientes = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5));

    // FORMA CLÁSICA: contar cuántos clientes son mayores de edad
    int contadorClasico = 0;
    for (Cliente c : clientes) {
      if (c.getEdad() >= 18) {
        contadorClasico++;
      }
    }
    System.out.println("\n[Clásico] Clientes mayores de edad: " + contadorClasico);

    // CON STREAMS: misma operación en una sola línea
    long contadorStream = clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .count();
    System.out.println("[Stream]  Clientes mayores de edad: " + contadorStream);

    // =========================================================================
    // 3. PIPELINE (tubería): encadenar operaciones
    // =========================================================================

    // Un pipeline se compone de:
    //   1. Una fuente de datos (colección, array, etc.)
    //   2. Cero o más operaciones intermedias (devuelven Stream)
    //   3. Una operación terminal (produce resultado y cierra el Stream)

    // Ejemplo: obtener los nombres de los clientes mayores de 18 años, ordenados
    System.out.println("\nNombres de clientes adultos ordenados:");
    clientes.stream()                        // 1. Fuente
        .filter(c -> c.getEdad() >= 18)      // 2. Intermedia: filtrar
        .sorted()                            // 2. Intermedia: ordenar (usa compareTo)
        .forEach(c -> System.out.println("  - " + c)); // 3. Terminal: imprimir

    // =========================================================================
    // 4. LOS STREAMS NO MODIFICAN LA FUENTE ORIGINAL
    // =========================================================================
    System.out.println("\nLista original sin modificar:");
    System.out.println(clientes);

    // =========================================================================
    // 5. LOS STREAMS SON DE UN SOLO USO
    // =========================================================================
//    Stream<Cliente> miStream = clientes.stream();
//    miStream.forEach(System.out::println); // Primera vez: OK
//    miStream.forEach(System.out::println); // Segunda vez: IllegalStateException!
  }
}

