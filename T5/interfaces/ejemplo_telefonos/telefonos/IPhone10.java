package U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos.telefonos;

import U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos.Persona;

public class IPhone10 extends IPhone8 {

  private String patronRostro;

  public IPhone10(String marca, Persona persona) {
    super(marca, persona);
  }

  @Override
  public boolean validar(Persona persona) {
    if (persona.getPatronRostro() != null) {
      return persona.getPatronRostro().equals(patronRostro);
    }
    return super.validar(persona);
  }

  public String getPatronRostro() {
    return patronRostro;
  }

  public void setPatronRostro(String patronRostro) {
    this.patronRostro = patronRostro;
  }
}
