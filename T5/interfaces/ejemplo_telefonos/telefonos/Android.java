package U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos.telefonos;

import U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos.Persona;
import U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos.Telefono;
import U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos.Validar;

public class Android extends Telefono implements Validar {

  public Android(String marca, Persona persona) {
    super(marca, persona);
  }

  private String patron;

  public String getPatron() {
    return patron;
  }

  public void setPatron(String patron) {
    this.patron = patron;
  }

  @Override
  public boolean validar(Persona persona) {
    return persona.getPatron().equals(patron);
  }
}
