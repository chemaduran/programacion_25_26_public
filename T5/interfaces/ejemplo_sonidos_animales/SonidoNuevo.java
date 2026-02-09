package U5_herencia_interfaces.teoria.interfaces.ejemplo_sonidos_animales;

public interface SonidoNuevo {
    int variable1 = 0;

    static void bostezo() {
        System.out.println("¡Aaaauuuuhhh!");
    }

    void voz();

    default void vozDurmiendo() {
        System.out.println("Zzz");

    }

    private void hacer_la_digestion() {
        System.out.println("Haciendo la digestión");
    }

}
