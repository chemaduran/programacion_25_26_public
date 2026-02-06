package U5_herencia_interfaces.teoria.ejemplo_empleado;

public class Empleado extends SerHumano {

  @Override
  public void nombre(String nombre) {
    System.out.println("Ahora soy un empleado con nombre" + nombre);
  }

  @Override
  public void apellido() {
    System.out.println("Ahora soy un empleado con apellido");
  }
}
