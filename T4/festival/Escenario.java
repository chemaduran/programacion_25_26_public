package U4_poo.resolucion_clase.festival;

import java.util.Arrays;

public class Escenario {
	private String nombre;
  private String ubicacion;
	private int capacidad;
	private Cantante[] cantantes;

	public void addCantante(Cantante cantante) {
		cantantes = Arrays.copyOf(cantantes, cantantes.length + 1);
		cantantes[cantantes.length - 1] = cantante;
	}


	public void mostrarCantantes() {
		for (Cantante cantante : cantantes) {
			System.out.println(cantante);
		}
	}

	@Override
	public String toString() {
		return "Escenario{" +
						"capacidad=" + capacidad +
						", ubicacion='" + ubicacion + '\'' +
						", nombre='" + nombre + '\'' +
						'}';
	}
}
