package U5_herencia_interfaces.teoria.interfaces.ejemplo_sonidos_animales;

public class principal_inter {
    public static void main(String[] args) {
        //
        Perro perro = new Perro();
        Gato gato = new Gato();
        Leon leon = new Leon();
        perro.voz();
        gato.voz();
        leon.voz();
        perro.vozDurmiendo();
        gato.vozDurmiendo();
        leon.vozDurmiendo();

    SonidoNuevo sonido = new Perro();
    sonido.vozDurmiendo();
    sonido.voz();
    sonido = new Gato();
    sonido.voz();

        // Para una variable de interfaz, en este caso, de tipo Sonido, podemos asignarle una clase sin
        // nombre, que implementará la interfaz. Como no se tiene nombre, se usa un constructor con el
        // mismo nombre de la interfaz.
        Sonido son =
                new Sonido() {
                    public void voz() {
                        System.out.println("jajaja");
                    }
                };
        son.voz();
    }
}
