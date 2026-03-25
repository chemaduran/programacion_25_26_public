package U7_collections.teoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class _06a_interfaces_funcionales {
  public static void main(String[] args) {
    // ¿Qué es una interfaz funcional?
    // Es una interfaz que tiene UN SOLO método abstracto (puede tener métodos default y static).
    // Se anotan con @FunctionalInterface (opcional pero recomendable).
    // Son la base de las expresiones lambda y las referencias a métodos.

    // Java incluye muchas interfaces funcionales en el paquete java.util.function.
    // Las más importantes son: Predicate, Function, Consumer, Supplier, UnaryOperator,
    // BinaryOperator y BiFunction.

    Cliente c1 = new Cliente("29745987Y", "Chiquito", 8);
    Cliente c2 = new Cliente("23478237L", "Grandito", 45);
    Cliente c3 = new Cliente("75758989Y", "Medianita", 7);
    Cliente c4 = new Cliente("83630305X", "Equisele", 32);
    Cliente c5 = new Cliente("12327845W", "Moi", 47);

    List<Cliente> clientes = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5));

    // =========================================================================
    // 1. PREDICATE<T>: recibe un argumento T y devuelve boolean
    //    Método abstracto: boolean test(T t)
    //    Uso típico: condiciones de filtrado
    // =========================================================================
    System.out.println("=== Predicate<T> ===");

    // Definimos un predicado que comprueba si un cliente es mayor de edad
    Predicate<Cliente> esMayorDeEdad = c -> c.getEdad() >= 18;

    System.out.println("¿Chiquito es mayor de edad? " + esMayorDeEdad.test(c1));
    System.out.println("¿Grandito es mayor de edad? " + esMayorDeEdad.test(c2));

    // Los predicados se pueden componer con and(), or() y negate()
    Predicate<Cliente> esJoven = c -> c.getEdad() < 30;
    Predicate<Cliente> adultoJoven = esMayorDeEdad.and(esJoven); // >= 18 Y < 30
    Predicate<Cliente> menorOViejo = esMayorDeEdad.negate().or(c -> c.getEdad() > 40); // < 18 O > 40

    System.out.println("\n¿Equisele es adulto joven? " + adultoJoven.test(c4)); // false, tiene 32
    System.out.println("¿Chiquito es menor o mayor de 40? " + menorOViejo.test(c1)); // true, tiene 8

    // Uso práctico: pasar un Predicate a removeIf o a filter de un Stream
    // lista.removeIf(esMayorDeEdad);
    // lista.stream().filter(esMayorDeEdad).forEach(System.out::println);

    // =========================================================================
    // 2. FUNCTION<T, R>: recibe un argumento T y devuelve un resultado R
    //    Método abstracto: R apply(T t)
    //    Uso típico: transformaciones (map en Streams)
    // =========================================================================
    System.out.println("\n=== Function<T, R> ===");

    // Función que recibe un Cliente y devuelve su nombre en mayúsculas
    Function<Cliente, String> obtenerNombreMayusculas = c -> c.toString().toUpperCase();

    System.out.println(obtenerNombreMayusculas.apply(c1)); // CHIQUITO
    System.out.println(obtenerNombreMayusculas.apply(c2)); // GRANDITO

    // Función que recibe un String y devuelve su longitud
    Function<String, Integer> longitud = s -> s.length();
    System.out.println("Longitud de 'Hola': " + longitud.apply("Hola"));

    // Composición con andThen (primero aplica la primera, luego la segunda)
    Function<Cliente, Integer> longitudDelNombre = obtenerNombreMayusculas.andThen(longitud);
    System.out.println("Longitud del nombre de Chiquito: " + longitudDelNombre.apply(c1));

    // Composición con compose (primero aplica el argumento, luego la función)
    // longitud.compose(obtenerNombreMayusculas) --> equivale a lo anterior

    // =========================================================================
    // 3. CONSUMER<T>: recibe un argumento T y no devuelve nada (void)
    //    Método abstracto: void accept(T t)
    //    Uso típico: acciones (forEach en Streams)
    // =========================================================================
    System.out.println("\n=== Consumer<T> ===");

    Consumer<Cliente> imprimirCliente = c -> System.out.println("  -> " + c + " (edad: " + c.getEdad() + ")");
    imprimirCliente.accept(c1);
    imprimirCliente.accept(c2);

    // Encadenar consumers con andThen
    Consumer<Cliente> imprimirDni = c -> System.out.println("     DNI: " + c.getDni());
    Consumer<Cliente> imprimirCompleto = imprimirCliente.andThen(imprimirDni);
    System.out.println("\nConsumer encadenado:");
    imprimirCompleto.accept(c3);

    // Uso práctico: pasar un Consumer a forEach
    // clientes.forEach(imprimirCliente);

    // =========================================================================
    // 4. SUPPLIER<T>: no recibe nada y devuelve un resultado T
    //    Método abstracto: T get()
    //    Uso típico: fábricas de objetos, generadores de valores
    // =========================================================================
    System.out.println("\n=== Supplier<T> ===");

    Supplier<Cliente> clientePorDefecto = () -> new Cliente("00000000A", "Anónimo", 0);
    Cliente anonimo = clientePorDefecto.get();
    System.out.println("Cliente por defecto: " + anonimo + " - DNI: " + anonimo.getDni());

    Supplier<Double> aleatorio = () -> Math.random() * 100;
    System.out.println("Número aleatorio: " + aleatorio.get());
    System.out.println("Otro aleatorio: " + aleatorio.get());

    // Uso práctico: Optional.orElseGet(supplier)
    // optional.orElseGet(() -> new Cliente(...))

    // =========================================================================
    // 5. UNARYOPERATOR<T>: caso especial de Function<T, T>
    //    Recibe un argumento T y devuelve un resultado del mismo tipo T
    //    Método abstracto: T apply(T t) (heredado de Function)
    // =========================================================================
    System.out.println("\n=== UnaryOperator<T> ===");

    UnaryOperator<String> aMayusculas = s -> s.toUpperCase();
    System.out.println(aMayusculas.apply("hola mundo")); // HOLA MUNDO

    UnaryOperator<Integer> duplicar = n -> n * 2;
    System.out.println("Duplicar 5: " + duplicar.apply(5));

    // Uso práctico: replaceAll en listas
    List<String> palabras = new ArrayList<>(Arrays.asList("hola", "mundo", "java"));
    palabras.replaceAll(aMayusculas); // Convierte todos los elementos a mayúsculas
    System.out.println("Lista tras replaceAll: " + palabras);

    // =========================================================================
    // 6. BINARYOPERATOR<T>: caso especial de BiFunction<T, T, T>
    //    Recibe DOS argumentos del tipo T y devuelve un resultado del mismo tipo T
    //    Método abstracto: T apply(T t1, T t2)
    // =========================================================================
    System.out.println("\n=== BinaryOperator<T> ===");

    BinaryOperator<Integer> sumar = (a, b) -> a + b;
    System.out.println("Sumar 3 + 7: " + sumar.apply(3, 7));

    BinaryOperator<String> concatenar = (a, b) -> a + " " + b;
    System.out.println(concatenar.apply("Hola", "Mundo"));

    // Uso práctico: reduce en Streams
    // numeros.stream().reduce(0, sumar);

    // =========================================================================
    // 7. BIFUNCTION<T, U, R>: recibe dos argumentos (T y U) y devuelve R
    //    Método abstracto: R apply(T t, U u)
    // =========================================================================
    System.out.println("\n=== BiFunction<T, U, R> ===");

    BiFunction<String, Integer, Cliente> crearCliente =
        (nombre, edad) -> new Cliente("00000000X", nombre, edad);
    Cliente nuevo = crearCliente.apply("Nuevecito", 25);
    System.out.println("Cliente creado: " + nuevo + " (edad: " + nuevo.getEdad() + ")");

    // =========================================================================
    // 8. BIPREDICATE<T, U>: recibe dos argumentos y devuelve boolean
    //    Método abstracto: boolean test(T t, U u)
    // =========================================================================
    System.out.println("\n=== BiPredicate<T, U> ===");

    BiPredicate<Cliente, Integer> tieneMasDe = (c, edad) -> c.getEdad() > edad;
    System.out.println("¿Grandito tiene más de 30? " + tieneMasDe.test(c2, 30));
    System.out.println("¿Chiquito tiene más de 30? " + tieneMasDe.test(c1, 30));

    // =========================================================================
    // 9. COMPARATOR<T>: interfaz funcional clásica (ya existía antes de Java 8)
    //    Método abstracto: int compare(T o1, T o2)
    // =========================================================================
    System.out.println("\n=== Comparator<T> como interfaz funcional ===");

    // Antes de Java 8: clase aparte (como OrdenaDescendente.java)
    // Con lambdas: se puede definir inline
    Comparator<Cliente> porEdadAsc = (a, b) -> Integer.compare(a.getEdad(), b.getEdad());
    Comparator<Cliente> porEdadDesc = porEdadAsc.reversed();

    clientes.sort(porEdadAsc);
    System.out.println("Ordenados por edad (asc): " + clientes);

    clientes.sort(porEdadDesc);
    System.out.println("Ordenados por edad (desc): " + clientes);

    // Forma más compacta con Comparator.comparingInt
    clientes.sort(Comparator.comparingInt(Cliente::getEdad));
    System.out.println("Con comparingInt: " + clientes);

    // =========================================================================
    // 10. CREAR NUESTRA PROPIA INTERFAZ FUNCIONAL
    // =========================================================================
    System.out.println("\n=== Interfaz funcional personalizada ===");

    // Ver la interfaz Operacion definida más abajo en este mismo fichero
    Operacion suma = (a, b) -> a + b;
    Operacion resta = (a, b) -> a - b;
    Operacion multiplicacion = (a, b) -> a * b;

    System.out.println("Suma 10 + 3 = " + suma.calcular(10, 3));
    System.out.println("Resta 10 - 3 = " + resta.calcular(10, 3));
    System.out.println("Multiplicación 10 * 3 = " + multiplicacion.calcular(10, 3));

    // También podemos pasar la interfaz funcional como argumento de un método
    System.out.println("Resultado operando: " + ejecutarOperacion(10, 3, multiplicacion));

    // =========================================================================
    // RESUMEN DE INTERFACES FUNCIONALES PRINCIPALES
    // =========================================================================
    // Predicate<T>          T -> boolean         test(T)         Condiciones
    // Function<T, R>        T -> R               apply(T)        Transformaciones
    // Consumer<T>           T -> void            accept(T)       Acciones
    // Supplier<T>           () -> T              get()           Fábricas/generadores
    // UnaryOperator<T>      T -> T               apply(T)        Transformación mismo tipo
    // BinaryOperator<T>     (T, T) -> T          apply(T, T)     Combinaciones
    // BiFunction<T, U, R>   (T, U) -> R          apply(T, U)     Transformación 2 args
    // BiPredicate<T, U>     (T, U) -> boolean    test(T, U)      Condición 2 args
    // Comparator<T>         (T, T) -> int        compare(T, T)   Ordenación
  }

  // Método auxiliar que recibe una interfaz funcional como parámetro
  static double ejecutarOperacion(double a, double b, Operacion op) {
    return op.calcular(a, b);
  }

  // Interfaz funcional personalizada
  @FunctionalInterface
  interface Operacion {
    double calcular(double a, double b);
    // Solo puede tener UN método abstracto.
    // Puede tener métodos default y static:
    // default void metodoDefault() { ... }
    // static void metodoStatic() { ... }
  }
}

