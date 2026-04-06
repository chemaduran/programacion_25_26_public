package U7_collections.en_clase.concurso_canino;

import java.io.Serializable;
import java.util.Objects;

public class Propietario implements Serializable {
	private String nombre;
	private String apellidos;
	private long numero_socio;
	private String pais;

	public long getNumero_socio() {
		return numero_socio;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Propietario that = (Propietario) o;
		return numero_socio == that.numero_socio;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(numero_socio);
	}
}
