package U5_herencia_interfaces.teoria.interfaces.comparable;

import java.util.Arrays;

public class main_comparator {
  public static void main(String[] args) {
    //
    Persona[] array = new Persona[3];
    Persona p1 = new Persona("Pepe", 12, 188);
    Persona p2 = new Persona("Juan", 78, 167);
    Persona p3 = new Persona("Maria", 23, 170);

    array[0] = p1;
    array[1] = p2;
    array[2] = p3;

    imprimir(array);
    Arrays.sort(array);
    imprimir(array);

    Arrays.sort(array, new comparaEdadPersona());
    imprimir(array);
  }

  public static void imprimir(Persona[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
    System.out.println("-----------------");
  }
}
