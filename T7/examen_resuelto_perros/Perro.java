package U7_collections.en_clase.concurso_canino;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Perro implements Comparable<Perro>, Serializable {


	private String nombre;
	private int edad;
	private double peso;
	private boolean vacunas;
	private Propietario propietario;
	private String raza;

	public Perro(String nombre, String raza) {
		this.nombre = nombre;
		this.raza = raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isVacunas() {
		return vacunas;
	}

	public void setVacunas(boolean vacunas) {
		this.vacunas = vacunas;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Perro perro = (Perro) o;
		return Objects.equals(nombre, perro.nombre) && Objects.equals(propietario, perro.propietario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, propietario);
	}

	@Override
	public String toString() {
		return "Perro{" +
						"nombre='" + nombre + '\'' +
						", raza='" + raza + '\'' +
						'}';
	}

	@Override
	public int compareTo(@NotNull Perro o) {
//		return this.peso.compareTo(o.getPeso());
		return -Double.compare(this.peso, o.getPeso());
	}
}
