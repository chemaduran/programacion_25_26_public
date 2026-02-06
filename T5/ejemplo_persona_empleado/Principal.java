package U5_herencia_interfaces.teoria.ejemplo_persona_empleado;

public class Principal {
    public static void main(String[] args) {
        Persona p1 = new Persona("Bellerín", "Estadio Benito Villamarín", "764728364", "solo_persona");
        Persona p2 = new Empleado("Iniesta", "Calle Arabia", "75874728", 10000);
        Empleado p3 = new Empleado("Villa", "Calle MLS", "975677", 10001);

        Persona[] personas = new Persona[3];

        personas[0] = p1;
        personas[1] = p2;
        personas[2] = p3;

        for (Persona p : personas) {
            p.mostrar_informacion();
        }


//        p1.mostrar_informacion();
//        System.out.println();
//        p2.mostrar_informacion();
//
//        System.out.println(p2.getClass().getName());


    }
}
