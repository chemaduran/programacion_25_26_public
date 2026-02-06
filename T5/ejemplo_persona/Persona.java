package U5_herencia_interfaces.teoria.ejemplo_persona;

public class Persona {
    protected int dni;
    protected String nombre;
    protected int edad;
    protected double estatura;

    public Persona(String nombre, int edad, double estatura, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.dni = dni;
    }



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{"
                + "nombre='"
                + nombre
                + '\''
                + ", edad="
                + edad
                + ", estatura="
                + estatura
                + ", dni="
                + dni
                + '}';
    }


    @Override
    public boolean equals(Object otra_persona) {
        if (this == otra_persona) return true;
        if (otra_persona == null || getClass() != otra_persona.getClass()) return false;
        Persona persona = (Persona) otra_persona;
        return dni == persona.dni && nombre.equals(persona.nombre);
    }
}
