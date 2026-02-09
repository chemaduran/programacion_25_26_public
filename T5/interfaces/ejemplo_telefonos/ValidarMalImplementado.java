package U5_herencia_interfaces.teoria.interfaces.ejemplo_telefonos;

public interface ValidarMalImplementado {

  public void on();

  public void off();

  public boolean validarCodigo(int numero);

  public boolean validarPatron(String patron);

  public boolean validarHuella(String patronHuella);

  public boolean validarRostro(String patronRostro);
}
