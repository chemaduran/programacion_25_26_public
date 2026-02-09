package U5_herencia_interfaces.teoria.interfaces.ejemplo_sonidos_animales;

public class Gato implements SonidoNuevo {

    private String nombre;
    private int peso;

    @Override
    public void voz() {
        System.out.println("miaaauuuu!!");
    }

    @Override
    public void vozDurmiendo() {
        System.out.println("miaaauuuZZZZZ");
    }
}
