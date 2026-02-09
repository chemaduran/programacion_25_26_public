package U5_herencia_interfaces.teoria.interfaces.ejemplo_sonidos_animales;

// Las interfaces, como las clases abstractas, NO SON INSTANCIABLES. No podremos hacer algo como:
// Sonido s1 = new Sonido();
// Sin embargo, sí podemos crear una variable de tipo la interfaz, y asignarle un objeto que la
// implemente. Por ejemplo:
// Perro p1 = new Perro();
// Sonido s1 = p1;

public interface Sonido {
    // Las interfaces pueden tener atributos. Se convierte automáticamente en un atributo de la clase
    // que implemente la interfaz. Si no ponemos ningún modificador (como es este ejemplo), son 'static
    // final' por defecto.
    int variable1 = 0;

    // También se pueden implementar métodos 'static' en la interfaz. Por defecto son 'public'
    // también. Sería accesible directamente desde la interfaz, como todas lo 'static'.
    // Sonido.bostezo()
    static void bostezo() {
        System.out.println("¡Aaaauuuuhhh!");
    }

    // Este método se declara en la interfaz, pero no se define (como los métodos abstractos. De hecho
    // es un método abstracto)
    void voz();

    // Este es un método propio de la interfaz Sonido. Se les llama también por defecto, y tienen una
    // palabra reservada del lenguaje para ello. Son public sin necesidad de especificarlo. Estos
    // métodos por defecto, si se quiere, se pueden reimplementar en las clases que implementen la
    // interfaz Sonido, haciendo sobrecarga (overriding).
    default void vozDurmiendo() {
        System.out.println("Zzz");
    }

    // Para uso interno de la interfaz, se pueden declarar métodos 'private'. Pueden ser también
    // 'static' o no, pero en cualquier caso, únicamente servirán como ayuda al resto de métodos de la
    // interfaz
    private void hacer_la_digestion() {
        System.out.println("Haciendo la digestión");
    }
}
