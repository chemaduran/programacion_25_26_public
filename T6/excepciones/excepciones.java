package U6_ficheros.teoria.excepciones;

public class excepciones {
    public static void main(String[] args) {

        // 1
//        int a = 1;
//        int b = 0;
//        int c = a / b;
//        System.out.println("¿llega aquí?");













        // 2
//            int c;
//            int a = 1;
//            int b = 0;
//            try {
//              c = a / 0;
//            } catch (ArithmeticException e) {
//              System.out.println("División por cero!" + e.getMessage());
//            }
//            System.out.println("ahora sí llega aquí");

        // 3
//            int c;
//            int a = 1;
//            int b = 0;
//            try {
//              c = a / b;
//            } catch (ArithmeticException una_excepcion) {
//              System.out.println("Estoy en el primer catch");
//            } catch (Exception la_excepcion) {
//              System.out.println("Estoy en el segundo catch");
//            }
//            System.out.println("llega aquí");

        // 4
//            int c;
//            int a = 1;
//            int b = 1;
//            try {
//              c = a / b;
//              System.out.println("He llegado hasta aquí en el try");
//              return;
//            } catch (ArithmeticException e) {
//              System.out.println("¡Capturada la excepción!");
//            } finally {
//              System.out.println("Gracias por utilizar el programa");
//            }

        // 5.
      LanzadoraExcepcion l = new LanzadoraExcepcion();

      l.division_lanzadora(2, 0);

      l.division_capturadora(2, 0);




        try {
            l.division_lanzadora(2, 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
