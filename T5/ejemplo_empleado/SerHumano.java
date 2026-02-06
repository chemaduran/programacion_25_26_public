package U5_herencia_interfaces.teoria.ejemplo_empleado;

public abstract class SerHumano {
  public int edad = 8;

  public void chillar() {
    System.out.println("AAAARGGGHHHH!");
  }

  public abstract void nombre(String nombre);

  public abstract void apellido();
}
