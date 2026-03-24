package U7_collections.teoria;

import java.util.*;
import java.util.stream.Collectors;

public class _05c_streams_terminales {
  public static void main(String[] args) {
    // Las operaciones terminales consumen el Stream y producen un resultado.
    // Una vez ejecutada una operación terminal, el Stream queda cerrado.
    // Son las que "disparan" la ejecución de todas las operaciones intermedias (lazy evaluation).

    Cliente c1 = new Cliente("29745987Y", "Chiquito", 8);
    Cliente c2 = new Cliente("23478237L", "Grandito", 45);
    Cliente c3 = new Cliente("75758989Y", "Medianito", 7);
    Cliente c4 = new Cliente("83630305X", "Equisele", 32);
    Cliente c5 = new Cliente("12327845W", "Moi", 47);
    Cliente c6 = new Cliente("99999999Z", "Jovencito", 19);

    List<Cliente> clientes = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c6));

    // =========================================================================
    // 1. forEach: ejecuta una acción para cada elemento (Consumer)
    // =========================================================================
    System.out.println("=== forEach ===");
    clientes.stream()
        .forEach(c -> System.out.println("  " + c));
    // Equivalente con referencia a método:
    // clientes.stream().forEach(System.out::println);

    // NOTA: también existe forEachOrdered, que garantiza el orden en streams paralelos

    // =========================================================================
    // 2. collect: recoge los elementos en una colección u otra estructura
    //    Es la operación terminal más versátil y usada
    // =========================================================================

    // a) Recoger en una List
    System.out.println("\n=== collect -> toList ===");
    List<Cliente> adultos = clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .collect(Collectors.toList());
    System.out.println("  Adultos: " + adultos);

    // b) Recoger en un Set (sin duplicados)
    System.out.println("\n=== collect -> toSet ===");
    List<Integer> numerosConRepetidos = Arrays.asList(1, 2, 2, 3, 3, 3);
    Set<Integer> sinRepetidos = numerosConRepetidos.stream()
        .collect(Collectors.toSet());
    System.out.println("  Sin repetidos: " + sinRepetidos);

    // c) Recoger en un Map (clave/valor)
    //    toMap(función_clave, función_valor)
    System.out.println("\n=== collect -> toMap ===");
    Map<String, Integer> dniEdad = clientes.stream()
        .collect(Collectors.toMap(
            Cliente::getDni,    // función para la clave
            Cliente::getEdad    // función para el valor
        ));
    System.out.println("  Mapa DNI -> Edad: " + dniEdad);

    // d) Unir strings con joining
    System.out.println("\n=== collect -> joining ===");
    String nombresUnidos = clientes.stream()
        .map(Cliente::toString)
        .collect(Collectors.joining(", "));
    System.out.println("  Nombres: " + nombresUnidos);

    // joining con prefijo y sufijo
    String nombresConFormato = clientes.stream()
        .map(Cliente::toString)
        .collect(Collectors.joining(" | ", "[", "]"));
    System.out.println("  Con formato: " + nombresConFormato);

    // e) Recoger en una colección concreta (ArrayList, LinkedList, TreeSet...)
    System.out.println("\n=== collect -> toCollection ===");
    TreeSet<Cliente> arbol = clientes.stream()
        .collect(Collectors.toCollection(TreeSet::new));
    System.out.println("  TreeSet: " + arbol);

    // =========================================================================
    // 3. count: cuenta los elementos del Stream
    // =========================================================================
    System.out.println("\n=== count ===");
    long numAdultos = clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .count();
    System.out.println("  Número de adultos: " + numAdultos);

    // =========================================================================
    // 4. min y max: devuelven el mínimo/máximo según un Comparator
    //    Devuelven Optional porque el Stream podría estar vacío
    // =========================================================================
    System.out.println("\n=== min / max ===");
    Optional<Cliente> masJoven = clientes.stream()
        .min(Comparator.comparingInt(Cliente::getEdad));
    // Para extraer el valor de un Optional:
    masJoven.ifPresent(c -> System.out.println("  Más joven: " + c + " (edad: " + c.getEdad() + ")"));

    Optional<Cliente> masViejo = clientes.stream()
        .max(Comparator.comparingInt(Cliente::getEdad));
    masViejo.ifPresent(c -> System.out.println("  Más mayor: " + c + " (edad: " + c.getEdad() + ")"));

    // =========================================================================
    // 5. findFirst y findAny: buscan un elemento
    //    Devuelven Optional
    // =========================================================================
    System.out.println("\n=== findFirst ===");
    Optional<Cliente> primerAdulto = clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .findFirst(); // Devuelve el primero que cumple la condición
    primerAdulto.ifPresent(c -> System.out.println("  Primer adulto: " + c));

    // findAny es similar, pero no garantiza cuál devuelve (útil en streams paralelos)
//    Optional<Cliente> cualquierAdulto = clientes.stream()
//        .filter(c -> c.getEdad() >= 18)
//        .findAny();

    // =========================================================================
    // 6. anyMatch, allMatch, noneMatch: comprueban condiciones (devuelven boolean)
    // =========================================================================
    System.out.println("\n=== anyMatch / allMatch / noneMatch ===");

    // ¿Hay algún menor de edad?
    boolean hayMenores = clientes.stream()
        .anyMatch(c -> c.getEdad() < 18);
    System.out.println("  ¿Hay algún menor?: " + hayMenores);

    // ¿Son todos mayores de edad?
    boolean todosMayores = clientes.stream()
        .allMatch(c -> c.getEdad() >= 18);
    System.out.println("  ¿Son todos mayores?: " + todosMayores);

    // ¿Ninguno tiene más de 100 años?
    boolean ningunCentenario = clientes.stream()
        .noneMatch(c -> c.getEdad() > 100);
    System.out.println("  ¿Ninguno es centenario?: " + ningunCentenario);

    // =========================================================================
    // 7. reduce: combina todos los elementos en uno solo
    //    Es la operación terminal más "potente" y genérica
    // =========================================================================
    System.out.println("\n=== reduce ===");

    // Ejemplo 1: sumar una lista de números
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
    int suma = numeros.stream()
        .reduce(0, (acumulador, elemento) -> acumulador + elemento);
    // reduce(valorInicial, funcionAcumuladora)
    // Paso a paso: 0+1=1, 1+2=3, 3+3=6, 6+4=10, 10+5=15
    System.out.println("  Suma con reduce: " + suma);

    // Equivalente con referencia a método:
    int suma2 = numeros.stream().reduce(0, Integer::sum);
    System.out.println("  Suma con Integer::sum: " + suma2);

    // Ejemplo 2: concatenar strings
    List<String> palabras = Arrays.asList("Hola", "mundo", "desde", "Streams");
    String frase = palabras.stream()
        .reduce("", (acc, palabra) -> acc + " " + palabra)
        .trim();
    System.out.println("  Frase: " + frase);

    // Ejemplo 3: reduce sin valor inicial (devuelve Optional)
    Optional<Integer> maximo = numeros.stream()
        .reduce(Integer::max);
    maximo.ifPresent(m -> System.out.println("  Máximo con reduce: " + m));

    // Ejemplo 4: sumar todas las edades con reduce
    int sumaEdades = clientes.stream()
        .map(Cliente::getEdad)
        .reduce(0, Integer::sum);
    System.out.println("  Suma de edades: " + sumaEdades);

    // =========================================================================
    // 8. toArray: convierte el Stream en un array
    // =========================================================================
    System.out.println("\n=== toArray ===");
    Cliente[] arrayClientes = clientes.stream()
        .filter(c -> c.getEdad() >= 18)
        .toArray(Cliente[]::new);
    System.out.println("  Array de adultos: " + Arrays.toString(arrayClientes));

    // =========================================================================
    // 9. RESUMEN DE OPERACIONES TERMINALES
    // =========================================================================
    // forEach(Consumer)        -> ejecuta acción por cada elemento
    // collect(Collector)       -> recoge en colección/estructura
    // count()                  -> cuenta elementos
    // min(Comparator)          -> mínimo (Optional)
    // max(Comparator)          -> máximo (Optional)
    // findFirst()              -> primer elemento (Optional)
    // findAny()                -> cualquier elemento (Optional)
    // anyMatch(Predicate)      -> ¿alguno cumple? (boolean)
    // allMatch(Predicate)      -> ¿todos cumplen? (boolean)
    // noneMatch(Predicate)     -> ¿ninguno cumple? (boolean)
    // reduce(identity, op)     -> combina en un solo valor
    // toArray()                -> convierte a array
  }
}

