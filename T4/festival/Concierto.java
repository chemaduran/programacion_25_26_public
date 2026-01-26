package U4_poo.resolucion_clase.festival;

import java.time.LocalDate;
import java.util.Arrays;

public class Concierto {
	private String nombre;
	private LocalDate Fecha;
	private Escenario[] escenarios;
	private static String organizador;

	public static void setOrganizador(String organizador) {
		Concierto.organizador = organizador;
	}


	public void addEscenario(Escenario escenario) {
		escenarios = Arrays.copyOf(escenarios, escenarios.length + 1);
		escenarios[escenarios.length - 1] = escenario;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

	public void mostrarCartelera() {
		for (Escenario escenario : escenarios) {
			System.out.println(escenario);
		}
	}


}
