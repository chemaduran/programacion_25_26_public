package U7_collections.teoria;

import java.util.ArrayList;

public class _01b_array_list_iterators {
  public static void main(String[] args) {
    ArrayList<Integer> lista = new ArrayList<>();

    lista.add(7);
    lista.add(5);
    lista.add(5);
    lista.add(10);
    lista.add(9);

    System.out.println(lista);

    // MAL HECHO
//    for (int i = 0; i < lista.size(); i++) {
//      if (lista.get(i) == 5) {
//        lista.remove(i);
//      }
//    }

    // BIEN HECHO
//    Iterator<Integer> it = lista.iterator();
//
//    while (it.hasNext()) {
//      Integer i = it.next();
//      if (i == 5) {
//        it.remove();
//      }
//    }

    // MEJOR HECHO
//    lista.removeIf(i -> i == 5); // Programación funcional con Streams

    System.out.println(lista);
  }
}
