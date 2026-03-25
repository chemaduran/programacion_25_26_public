package U7_collections.teoria;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class _06c_referencias_metodos {
  public static void main(String[] args) {
    // ¿Qué es una referencia a método?
    // Es una forma aún más compacta que una lambda para hacer referencia a un método existente.
    // Se usa el operador :: (doble dos puntos).
    //
    // Solo se puede usar cuando la lambda se limita a llamar a un método ya existente,
    // sin lógica adicional.
    //
    // Hay 4 tipos de referencias a métodos:
    //   1. Referencia a método estático:         Clase::metodoEstatico
    //   2. Referencia a método de instancia
    //      de un objeto concreto:                objeto::metodoInstancia
    //   3. Referencia a método de instancia
    //      de un objeto arbitrario del tipo:     Clase::metodoInstancia
    //   4. Referencia a constructor:             Clase::new

    Cliente c1 = new Cliente("29745987Y", "Chiquito", 8);
    Cliente c2 = new Cliente("23478237L", "Grandito", 45);
    Cliente c3 = new Cliente("75758989Y", "Medianita", 7);
    Cliente c4 = new Cliente("83630305X", "Equisele", 32);
    Cliente c5 = new Cliente("12327845W", "Moi", 47);

    List<Cliente> clientes = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5));

    // =========================================================================
    // 1. REFERENCIA A MÉTODO ESTÁTICO: Clase::metodoEstatico
    //    Equivale a: (args) -> Clase.metodoEstatico(args)
    // =========================================================================
    System.out.println("=== 1. Referencia a método estático ===");

    // Lambda:
    List<String> numerosStr = Arrays.asList("3", "1", "4", "1", "5", "9");
    List<Integer> numerosInt1 = numerosStr.stream()
        .map(s -> Integer.parseInt(s))   // Lambda
        .collect(Collectors.toList());
    System.out.println("Con lambda: " + numerosInt1);

    // Referencia a método estático (equivalente):
    List<Integer> numerosInt2 = numerosStr.stream()
        .map(Integer::parseInt)          // Referencia a método estático
        .collect(Collectors.toList());
    System.out.println("Con ref. método: " + numerosInt2);

    // Otros ejemplos de referencias a métodos estáticos:
    // Math::abs       equivale a   x -> Math.abs(x)
    // String::valueOf equivale a   x -> String.valueOf(x)
    // Integer::compare equivale a  (a, b) -> Integer.compare(a, b)

    List<Integer> numeros = Arrays.asList(-3, 1, -4, 1, 5, -9);
    System.out.println("Valor absoluto: " +
        numeros.stream().map(Math::abs).collect(Collectors.toList()));

    // Con nuestros propios métodos estáticos también funciona
    List<Integer> edades = clientes.stream()
        .map(Cliente::getEdad)   // Esto es tipo 3, lo vemos más abajo
        .collect(Collectors.toList());
    System.out.println("Edades: " + edades);

    System.out.println("¿Es mayor de edad?");
    clientes.forEach(c ->
        System.out.println("  " + c + ": " + esMayorDeEdad(c)));

    // También con filter:
    // clientes.stream().filter(MiClase::esMayorDeEdad) si fuera un método estático de esta clase

    // =========================================================================
    // 2. REFERENCIA A MÉTODO DE INSTANCIA DE UN OBJETO CONCRETO:
    //    objeto::metodoInstancia
    //    Equivale a: (args) -> objeto.metodoInstancia(args)
    // =========================================================================
    System.out.println("\n=== 2. Referencia a método de objeto concreto ===");

    // El ejemplo más clásico: System.out::println
    // System.out es un OBJETO concreto, println es su método de instancia
    System.out.println("Todos los clientes:");

    // Lambda:
    clientes.forEach(c -> System.out.println("  " + c));

    // Referencia a método (System.out es el objeto concreto):
    System.out.println("Con referencia a método:");
    clientes.forEach(System.out::println);
    // Equivale a: c -> System.out.println(c)

    // Otro ejemplo: usar un método de un objeto concreto que tengamos
    Formateador fmt = new Formateador(">>> ");
    System.out.println("\nCon formateador personalizado:");
    clientes.forEach(fmt::imprimir);
    // Equivale a: c -> fmt.imprimir(c)

    // =========================================================================
    // 3. REFERENCIA A MÉTODO DE INSTANCIA DE UN TIPO ARBITRARIO:
    //    Clase::metodoInstancia
    //    Equivale a: (obj, args) -> obj.metodoInstancia(args)
    //    o bien:     obj -> obj.metodoInstancia()
    // =========================================================================
    System.out.println("\n=== 3. Referencia a método de tipo arbitrario ===");

    // Cuando el primer parámetro de la lambda es el objeto sobre el que se llama al método.

    // Lambda:
    List<String> nombres1 = clientes.stream()
        .map(c -> c.toString())   // Lambda: c es el objeto, toString() el método
        .collect(Collectors.toList());
    System.out.println("Con lambda: " + nombres1);

    // Referencia a método (equivalente):
    List<String> nombres2 = clientes.stream()
        .map(Cliente::toString)   // Cliente es la CLASE, toString es el método de instancia
        .collect(Collectors.toList());
    System.out.println("Con ref. método: " + nombres2);

    // Más ejemplos:
    // String::length       equivale a   s -> s.length()
    // String::toUpperCase  equivale a   s -> s.toUpperCase()
    // String::trim         equivale a   s -> s.trim()
    // Cliente::getEdad     equivale a   c -> c.getEdad()
    // Cliente::getDni      equivale a   c -> c.getDni()

    List<String> palabras = Arrays.asList("  hola  ", " mundo ", "  java ");
    List<String> limpiadas = palabras.stream()
        .map(String::trim)            // s -> s.trim()
        .map(String::toUpperCase)     // s -> s.toUpperCase()
        .collect(Collectors.toList());
    System.out.println("Trim + Upper: " + limpiadas);

    // Con Comparator:
    // Lambda:           clientes.sort((a, b) -> a.compareTo(b))
    // Ref. a método:    clientes.sort(Cliente::compareTo)

    // ¿Cómo distinguir el tipo 1 del tipo 3?
    // Tipo 1 (estático):  Integer::parseInt -> solo un arg, el String que se parsea
    // Tipo 3 (instancia): String::length    -> el String es el OBJETO sobre el que se llama length
    // Java lo deduce automáticamente según el contexto (la interfaz funcional esperada)

    // =========================================================================
    // 4. REFERENCIA A CONSTRUCTOR: Clase::new
    //    Equivale a: (args) -> new Clase(args)
    // =========================================================================
    System.out.println("\n=== 4. Referencia a constructor ===");

    // Lambda:
    Supplier<ArrayList<String>> crearLista1 = () -> new ArrayList<>();

    // Referencia a constructor (equivalente):
    Supplier<ArrayList<String>> crearLista2 = ArrayList::new;

    ArrayList<String> lista1 = crearLista1.get();
    ArrayList<String> lista2 = crearLista2.get();
    System.out.println("Lista creada con lambda: " + lista1);
    System.out.println("Lista creada con ref. constructor: " + lista2);

    // Uso con Function (constructor con un argumento):
    // Ejemplo: crear un ArrayList a partir de una colección
    Function<List<String>, ArrayList<String>> copiarLista1 = lista -> new ArrayList<>(lista);
    Function<List<String>, ArrayList<String>> copiarLista2 = ArrayList::new; // Ref. a constructor con argumento
    List<String> original = Arrays.asList("A", "B", "C");
    System.out.println("Copia con ref. constructor: " + copiarLista2.apply(original));

    // Uso práctico: toArray con referencia a constructor
    String[] arrayNombres = clientes.stream()
        .map(Cliente::toString)
        .toArray(String[]::new);   // Equivale a: size -> new String[size]
    System.out.println("Array: " + Arrays.toString(arrayNombres));

    // collect con toCollection y referencia a constructor
    TreeSet<Cliente> arbol = clientes.stream()
        .collect(Collectors.toCollection(TreeSet::new)); // () -> new TreeSet<>()
    System.out.println("TreeSet: " + arbol);

    // =========================================================================
    // 5. CUÁNDO USAR LAMBDA vs REFERENCIA A MÉTODO
    // =========================================================================
    System.out.println("\n=== Lambda vs Referencia a método ===");

    // REGLA: si la lambda solo llama a un método existente sin lógica adicional,
    // se puede sustituir por una referencia a método. Es más legible.

    // ✅ Se puede usar referencia a método:
    //   c -> c.getEdad()                →  Cliente::getEdad
    //   c -> System.out.println(c)      →  System.out::println
    //   s -> Integer.parseInt(s)        →  Integer::parseInt
    //   () -> new ArrayList<>()         →  ArrayList::new

    // ❌ NO se puede usar referencia a método (hay lógica adicional):
    //   c -> c.getEdad() >= 18          →  No es posible, hay una comparación
    //   c -> c.toString().toUpperCase() →  No es posible, hay encadenamiento
    //   (a, b) -> a + b                 →  No es posible, hay una operación

    // Ejemplo lado a lado:
    System.out.println("Lambda vs Referencia a método:");

    // Lambda                                           Referencia a método
    clientes.stream().map(c -> c.toString())            // →
        .forEach(n -> System.out.println("  L: " + n));
    clientes.stream().map(Cliente::toString)             // →
        .forEach(System.out::println);                   // (imprime sin "  L: ")

    // =========================================================================
    // RESUMEN
    // =========================================================================
    // TIPO                          SINTAXIS               LAMBDA EQUIVALENTE
    // ---------------------------   --------------------   ----------------------------------
    // Método estático               Clase::metodo          (args) -> Clase.metodo(args)
    // Método instancia (concreto)   objeto::metodo         (args) -> objeto.metodo(args)
    // Método instancia (arbitrario) Clase::metodo          (obj, args) -> obj.metodo(args)
    // Constructor                   Clase::new             (args) -> new Clase(args)
  }

  // Método estático auxiliar
  static boolean esMayorDeEdad(Cliente c) {
    return c.getEdad() >= 18;
  }

  // Clase auxiliar para ejemplo de referencia a método de instancia de un objeto concreto
  static class Formateador {
    private final String prefijo;

    Formateador(String prefijo) {
      this.prefijo = prefijo;
    }

    void imprimir(Cliente c) {
      System.out.println("  " + prefijo + c + " (edad: " + c.getEdad() + ")");
    }
  }
}



