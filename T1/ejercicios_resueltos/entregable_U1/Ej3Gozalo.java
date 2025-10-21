package resolucion.entregable_U1;

public class Ej3Gozalo {
    public static void main(String[] args) {
        int altura = 5;
        int mitad = altura / 2;
        for (int i = 1; i < mitad + 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("_");
            }
            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= mitad + 1; i++) {
            for (int j = i; j <= mitad + 1; j++) {
                System.out.print("_");
            }
            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
