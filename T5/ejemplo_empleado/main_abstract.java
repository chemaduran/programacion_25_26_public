package U5_herencia_interfaces.teoria.ejemplo_empleado;

public class main_abstract {
  public static void main(String[] args) {
    //
    SerHumano s1;
    Persona p1 = new Persona();
    s1 = p1;
    s1.chillar();
    s1.nombre("Maria");
    s1.apellido();

    System.out.println();

    Empleado e1 = new Empleado();
    SerHumano s2;
    s2 = e1;
    s2.chillar();
    s2.nombre("Alicia");
    s2.apellido();
  }
}
