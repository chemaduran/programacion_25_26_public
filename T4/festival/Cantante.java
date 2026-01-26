package U4_poo.resolucion_clase.festival;

import java.util.Arrays;

public class Cantante {
	private String nombre;
	private String nombre_artistico;
	private int edad;
	private String ciudad_origen;
	private Cancion[] canciones;


	public void addCancion(Cancion cancionNueva) {
		if (!estaCancionInsertada(cancionNueva)) {
			canciones = Arrays.copyOf(canciones, canciones.length + 1);
			canciones[canciones.length - 1] = cancionNueva;
		}
	}

	public boolean estaCancionInsertada(Cancion cancionAComprobar) {
		boolean resultado = false;
		for (Cancion cancion : canciones) {
			if (cancion.getTitulo().equals(cancionAComprobar.getTitulo())) {
				resultado = true;
				break;
			}
		}
		return resultado;
	}

	public void deleteCancion(String titulo) {
		Cancion[] canciones_nuevas = new Cancion[0];
		for (Cancion cancion : canciones) {
			if (!cancion.getTitulo().equals(titulo)) {
				canciones_nuevas = Arrays.copyOf(canciones_nuevas, canciones_nuevas.length+1);
				canciones_nuevas[canciones_nuevas.length-1] = cancion;
			}
		}

		this.canciones = canciones_nuevas;
	}

	public void mostrarCanciones() {
		for (Cancion cancion : canciones) {
			System.out.println(cancion);
		}
	}



}
