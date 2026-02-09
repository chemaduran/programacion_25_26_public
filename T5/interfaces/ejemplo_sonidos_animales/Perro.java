package U5_herencia_interfaces.teoria.interfaces.ejemplo_sonidos_animales;

// Para implementar la interfaz, ponemos lo siguiente. Con eso estamos diciendo que la clase está
// OBLIGADA a implementar los métodos abstractos de la interfaz
public class Perro implements SonidoNuevo {

    @Override
    public void voz() {
        System.out.println("¡Guau!");
    }
}