package U6_ficheros.teoria.excepciones;

public class LanzadoraExcepcion {

  void division_lanzadora(int a, int b) throws ArithmeticException {
    int c;
    c = a / b;
    System.out.println("a/b = " + c);
    throw new ArithmeticException();
  }

  void division_capturadora(int a, int b) {
    int c;

    try {
      c = a / b;
      System.out.println("a/b = " + c);
    } catch (ArithmeticException e) {
      System.out.println("División por cero");
    }
  }
}