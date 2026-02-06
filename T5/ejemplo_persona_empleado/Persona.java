package U5_herencia_interfaces.teoria.ejemplo_persona_empleado;

public class Persona {
    protected String nombre;
    protected String direccion;
    protected String dni;
    private String solo_persona;

    public Persona(String nombre, String direccion, String dni, String solo_persona) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.solo_persona = solo_persona;
    }

    public String getSolo_persona() {
        return solo_persona;
    }

    public void setSolo_persona(String solo_persona) {
        this.solo_persona = solo_persona;
    }

    public void mostrar_informacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Direccion: " + direccion);
        System.out.println("Dni: " + dni);
        System.out.println("Solo persona: " + solo_persona);
    }


}
