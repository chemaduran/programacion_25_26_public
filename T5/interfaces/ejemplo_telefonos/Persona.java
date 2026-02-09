package U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos;

public class Persona {

  private String nombre;
  private int codigo;
  private String patron;
  private String patronRostro;
  private String huella;

  public String getHuella() {
    return huella;
  }

  public void setHuella(String huella) {
    this.huella = huella;
  }

  public String getPatronRostro() {
    return patronRostro;
  }

  public void setPatronRostro(String patronRostro) {
    this.patronRostro = patronRostro;
  }

  public String getPatron() {
    return patron;
  }

  public void setPatron(String patron) {
    this.patron = patron;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
