package U7_collections.teoria;

import java.util.ArrayList;
import java.util.Iterator;

public class array_list {
  public static void main(String[] args) {
    ArrayList<Integer> lista = new ArrayList<>();

    lista.add(0, 7);
    lista.add(1, 5);
    lista.add(2, 10);
    lista.add(3, 9);

    Iterator<Integer> it = lista.iterator();

//    while (it.hasNext()) {
//      Integer i = it.next();
//      if (i == 5) {
//        it.remove();
//      }
//    }

    for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i) == 7) {
        lista.remove(i);
      }
    }

//    while (it.hasNext()) {
//      Integer i = it.next();
//      if (i == 10) {
//        it.remove();
//      }
//    }

//    Object[] array_de_enteros = lista.toArray();
//    System.out.println(array_de_enteros[0]);

    System.out.println(lista);
  }
}
