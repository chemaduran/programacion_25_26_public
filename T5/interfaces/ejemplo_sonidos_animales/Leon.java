package U5_herencia_interfaces.teoria.interfaces.ejemplo_sonidos_animales;

public class Leon implements Sonido {
    @Override
    public void voz() {
        System.out.println("¡Grrrr!");
    }

    @Override
    public void vozDurmiendo() {
        System.out.println("¡ZrrZrr!");
    }
}
