package U7_collections.teoria;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class _06b_lambdas {
  public static void main(String[] args) {
    // ¿Qué es una expresión lambda?
    // Es una forma abreviada de implementar una interfaz funcional (una interfaz con un
    // solo método abstracto). Permite escribir funciones anónimas de forma compacta.
    //
    // Sintaxis:
    //   (parámetros) -> { cuerpo }
    //
    // Si el cuerpo tiene una sola sentencia, las llaves y el return son opcionales.
    // Si hay un solo parámetro, los paréntesis son opcionales.

    Cliente c1 = new Cliente("29745987Y", "Chiquito", 8);
    Cliente c2 = new Cliente("23478237L", "Grandito", 45);
    Cliente c3 = new Cliente("75758989Y", "Medianita", 7);
    Cliente c4 = new Cliente("83630305X", "Equisele", 32);
    Cliente c5 = new Cliente("12327845W", "Moi", 47);

    List<Cliente> clientes = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5));

    // =========================================================================
    // 1. EVOLUCIÓN: de clase anónima a lambda
    // =========================================================================
    System.out.println("=== Evolución de clase anónima a lambda ===");

    // ANTES DE JAVA 8: Clase anónima para ordenar
    // Mucho código repetitivo (boilerplate)
    Comparator<Cliente> comparadorAnonimo = new Comparator<Cliente>() {
      @Override
      public int compare(Cliente a, Cliente b) {
        return Integer.compare(a.getEdad(), b.getEdad());
      }
    };

    // CON LAMBDA (Java 8+): mucho más compacto
    // La lambda "implementa" el único método abstracto de la interfaz
    Comparator<Cliente> comparadorLambda = (Cliente a, Cliente b) -> {
      return Integer.compare(a.getEdad(), b.getEdad());
    };

    // SIMPLIFICANDO: si el cuerpo es una sola expresión, quitamos llaves y return
    Comparator<Cliente> comparadorCorto = (Cliente a, Cliente b) -> Integer.compare(a.getEdad(), b.getEdad());

    // MÁS SIMPLE: los tipos se infieren automáticamente
    Comparator<Cliente> comparadorInferido = (a, b) -> Integer.compare(a.getEdad(), b.getEdad());

    clientes.sort(comparadorInferido);
    System.out.println("Ordenado por edad: " + clientes);

    // =========================================================================
    // 2. SINTAXIS DE LAMBDAS: todos los casos
    // =========================================================================
    System.out.println("\n=== Sintaxis de lambdas ===");

    // a) Sin parámetros: () -> expresión
    Runnable saludo = () -> System.out.println("  ¡Hola desde una lambda!");
    saludo.run();

    // b) Un parámetro (paréntesis opcionales): x -> expresión
    Consumer<String> imprimir = mensaje -> System.out.println("  " + mensaje);
    imprimir.accept("Un solo parámetro, sin paréntesis");

    // c) Varios parámetros: (x, y) -> expresión
    Comparator<Integer> compararNums = (a, b) -> a - b;
    System.out.println("  Comparar 5 y 3: " + compararNums.compare(5, 3));

    // d) Con cuerpo de varias líneas: (x) -> { sentencias; return valor; }
    Function<Cliente, String> descripcion = c -> {
      String nombre = c.toString();
      int edad = c.getEdad();
      String categoria = edad >= 18 ? "adulto" : "menor";
      return nombre + " es " + categoria + " (" + edad + " años)";
    };
    System.out.println("  " + descripcion.apply(c1));
    System.out.println("  " + descripcion.apply(c2));

    // =========================================================================
    // 3. LAMBDAS COMO ARGUMENTOS DE MÉTODOS
    // =========================================================================
    System.out.println("\n=== Lambdas como argumentos ===");

    // sort con lambda directa (sin variable intermedia)
    clientes.sort((a, b) -> a.toString().compareTo(b.toString()));
    System.out.println("Ordenado por nombre: " + clientes);

    // forEach con lambda
    System.out.println("Recorrido con forEach:");
    clientes.forEach(c -> System.out.println("  - " + c));

    // removeIf con lambda (Predicate)
    List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    numeros.removeIf(n -> n % 2 == 0); // Elimina los pares
    System.out.println("Impares: " + numeros);

    // replaceAll con lambda (UnaryOperator)
    List<String> palabras = new ArrayList<>(Arrays.asList("hola", "mundo", "java"));
    palabras.replaceAll(p -> p.toUpperCase());
    System.out.println("Mayúsculas: " + palabras);

    // =========================================================================
    // 4. LAMBDAS CON STREAMS (uso más habitual)
    // =========================================================================
    System.out.println("\n=== Lambdas con Streams ===");

    // filter recibe un Predicate (lambda que devuelve boolean)
    System.out.println("Adultos:");
    clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .forEach(c -> System.out.println("  " + c));

    // map recibe una Function (lambda que transforma)
    System.out.println("Nombres en mayúsculas:");
    clientes.stream()
        .map(c -> c.toString().toUpperCase())
        .forEach(nombre -> System.out.println("  " + nombre));

    // sorted recibe un Comparator (lambda con dos parámetros)
    System.out.println("Ordenados por edad descendente:");
    clientes.stream()
        .sorted((a, b) -> b.getEdad() - a.getEdad())
        .forEach(c -> System.out.println("  " + c + " (" + c.getEdad() + ")"));

    // reduce recibe un BinaryOperator
    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
    int suma = nums.stream().reduce(0, (acum, n) -> acum + n);
    System.out.println("Suma con reduce: " + suma);

    // =========================================================================
    // 5. ALMACENAR LAMBDAS EN VARIABLES (reutilización)
    // =========================================================================
    System.out.println("\n=== Lambdas en variables (reutilización) ===");

    // Definimos predicados reutilizables
    Predicate<Cliente> esMayor = c -> c.getEdad() >= 18;
    Predicate<Cliente> esJoven = c -> c.getEdad() < 30;

    // Usamos el mismo predicado en distintos sitios
    long totalMayores = clientes.stream().filter(esMayor).count();
    System.out.println("Total mayores: " + totalMayores);

    // Componemos predicados (ver _06a para más detalle)
    Predicate<Cliente> adultoJoven = esMayor.and(esJoven);
    long totalAdultosJovenes = clientes.stream().filter(adultoJoven).count();
    System.out.println("Total adultos jóvenes: " + totalAdultosJovenes);

    // =========================================================================
    // 6. LAMBDAS Y VARIABLES EXTERNAS (effectively final)
    // =========================================================================
    System.out.println("\n=== Lambdas y variables externas ===");

    // Las lambdas pueden acceder a variables locales del método,
    // PERO deben ser "effectively final" (no se modifican después de asignarse)

    int edadMinima = 18; // Esta variable NO se modifica -> effectively final
    clientes.stream()
        .filter(c -> c.getEdad() >= edadMinima) // OK: edadMinima es effectively final
        .forEach(c -> System.out.println("  " + c));

    // Esto NO compila:
    // int limite = 18;
    // limite = 20; // Se modifica -> ya no es effectively final
    // clientes.stream().filter(c -> c.getEdad() >= limite); // ERROR de compilación

    // =========================================================================
    // 7. PASAR LAMBDAS A MÉTODOS PROPIOS
    // =========================================================================
    System.out.println("\n=== Lambdas como argumentos de métodos propios ===");

    // Podemos crear métodos que reciban interfaces funcionales como parámetro
    // y pasarles lambdas cuando los invocamos

    System.out.println("Filtrados por predicado personalizado:");
    filtrarEImprimir(clientes, c -> c.getEdad() > 10);

    System.out.println("Filtrados por otro predicado:");
    filtrarEImprimir(clientes, c -> c.toString().startsWith("M"));

    // =========================================================================
    // RESUMEN DE SINTAXIS
    // =========================================================================
    // ()         -> expresión              // Sin parámetros
    // x          -> expresión              // Un parámetro (sin tipo)
    // (x)        -> expresión              // Un parámetro (con paréntesis)
    // (x, y)     -> expresión              // Múltiples parámetros
    // (T x, T y) -> expresión              // Con tipos explícitos
    // (x, y)     -> { sentencias; }        // Cuerpo con varias líneas
    // (x, y)     -> { return expresión; }  // Cuerpo con return explícito
  }

  // Método que recibe una lista y un Predicate para filtrar e imprimir
  static void filtrarEImprimir(List<Cliente> lista, Predicate<Cliente> condicion) {
    for (Cliente c : lista) {
      if (condicion.test(c)) {
        System.out.println("  " + c + " (edad: " + c.getEdad() + ")");
      }
    }
  }
}

