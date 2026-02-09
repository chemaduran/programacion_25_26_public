package U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos;

public abstract class Telefono implements Activar {

  private String marca;
  private Persona persona;

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  public Telefono(String marca, Persona persona) {
    super();
    this.marca = marca;
    this.persona = persona;
  }

  @Override
  public void on() {
    System.out.println("telefono encendido");
  }

  @Override
  public void off() {

    System.out.println("telefono apagado");
  }
}
