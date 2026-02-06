package U5_herencia_interfaces.teoria.this_super;

public class Padre {
  String nombre;
  String dni;

  public Padre(String nombre, String dni) {
    this.nombre = nombre;
    this.dni = dni;
  }

  @Override
  public String toString() {
    return "padre{" + "nombre='" + nombre + '\'' + '}';
  }
}