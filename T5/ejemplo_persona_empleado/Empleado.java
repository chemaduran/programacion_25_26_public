package U5_herencia_interfaces.teoria.ejemplo_persona_empleado;

public class Empleado extends Persona {
    private int sueldo;

    public Empleado(String nombre, String direccion, String dni, int sueldo) {
        super(nombre, direccion, dni, "solo_persona_de_empleado");
        this.sueldo = sueldo;
    }

    public void mostrar_informacion() {
        super.setSolo_persona("otra_persona_empleado");
        super.mostrar_informacion();
        System.out.println("Sueldo: " + sueldo);
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "sueldo=" + sueldo +
                '}';
    }
}
