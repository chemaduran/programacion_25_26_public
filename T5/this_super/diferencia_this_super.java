package U5_herencia_interfaces.teoria.this_super;

public class diferencia_this_super {
  public static void main(String[] args) {
    //
    Padre p1 = new Padre("Papito", "8383636D");
    Hijo h1 = new Hijo("Hijito", 142);
    Hijo h2 = new Hijo("Hijito", 87346);

    h1.set_nombre("Joaquín");

    System.out.println(p1);
    System.out.println(h1);

    h1.setDni(897);
    System.out.println(h1);
  }
}