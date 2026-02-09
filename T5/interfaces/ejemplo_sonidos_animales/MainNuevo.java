package U5_herencia_interfaces.teoria.interfaces.ejemplo_sonidos_animales;

public class MainNuevo {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Leon leon = new Leon();
        perro.voz();
        gato.voz();
        leon.voz();
        perro.vozDurmiendo();
        gato.vozDurmiendo();
        leon.vozDurmiendo();

        SonidoNuevo sonido = new Gato();
        sonido.vozDurmiendo();
        sonido.voz();

        sonido = perro;
        sonido.vozDurmiendo();
        sonido.voz();

    }
}
