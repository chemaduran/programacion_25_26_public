package U5_herencia_interfaces.teoria.this_super;

public class Hijo extends Padre {
  private int dni;

  public Hijo(String nombre, int dni) {
    super(nombre, String.valueOf(dni));
    this.dni = dni;
  }

  public void set_nombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  @Override
  public String toString() {
    return "Hijo{"
        + "this.nombre='"
        + this.nombre
        + ' '
        + "super.nombre='"
        + super.nombre
        + ' '
        + "this.dni='"
        + this.dni
        + ' '
        + "super.dni='"
        + super.dni
        + ' '
        + '}';
  }
}