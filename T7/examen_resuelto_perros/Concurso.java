package U7_collections.en_clase.concurso_canino;

import java.io.*;
import java.util.*;

public class Concurso {
	private String nombre;
	private String localidad;
	Map<String, Set<Perro>> mapa_razas;


	public Concurso() {
		mapa_razas = new HashMap<>();
	}


	@Override
	public String toString() {
		return "Concurso{" +
						"mapa_razas=" + mapa_razas +
						'}';
	}

	// Un método addDog() que recibe como parámetros la raza y un perro y que añadirá a
	//  la estructura de datos ese perro en la raza determinada o mostrará un mensaje de
	//  error en caso de que estemos intentando introducir en la raza un perro que no sea
	//  de dicha raza
	public void addDog(String raza, Perro perro) {
		if (!perro.getRaza().equals(raza)) {
			System.out.println("Error en addDog. La raza del perro es diferente a la recibida");
			return;
		}

		Set<Perro> conjunto_perros = mapa_razas.get(raza);
		if (conjunto_perros == null) {
			conjunto_perros = new HashSet<>();
			conjunto_perros.add(perro);
			mapa_razas.put(raza, conjunto_perros);
		} else {
			conjunto_perros.add(perro);
		}
	}

	// El método disqualifyDog() que recibe como parámetro un perro y lo elimina del concurso borrándolo de la
	//  estructura de datos que contienen los datos de los perros participantes organizados por razas. En caso de ese
	//  perro no esté inscrito deberá mostrar el siguiente mensaje "Perro no inscrito".
	public void disqualifyDog(Perro perro) {
		Set<Perro> conjunto_perros = mapa_razas.get(perro.getRaza());

		Iterator<Perro> it = conjunto_perros.iterator();
		boolean perro_encontrado = false;
		while (it.hasNext()) {
			Perro p = it.next();
			if (p.equals(perro)) {
				perro_encontrado = true;
				it.remove();
				System.out.println("Perro eliminado");
				break;
			}
		}

		if (perro_encontrado) {
			if (conjunto_perros.isEmpty()) {
				mapa_razas.remove(perro.getRaza());
			}
		} else {
			System.out.println("No se ha encontrado el perro");
		}

	}

	// El método ownerDogs() que mostrará por pantalla todos los perros de un dueño determinado (sea de la raza que sean).
	//  Este método recibe como parámetro el número de socio de la Sociedad Canina y mostrará el mensaje "Este socio no
	//   tiene perros inscritos" en caso de que el socio no tenga ningún perro en este concurso.
	public void ownerDogs(long num_socio) {
		List<Perro> lista_perros_socio = new ArrayList<>();
		boolean perro_encontrado = false;
		for (Set<Perro> conjunto_perro : mapa_razas.values()) {
			if (conjunto_perro != null && !conjunto_perro.isEmpty()) {
				for (Perro p : conjunto_perro) {
					if (p.getPropietario().getNumero_socio() == num_socio) {
						lista_perros_socio.add(p);
						perro_encontrado = true;
					}
				}
			}
		}

		if (!perro_encontrado) {
			System.out.println("Este socio no tiene perros inscritos");
		} else {
			System.out.println(lista_perros_socio);
		}
	}

	// El método perrosporPeso() que mostrará la lista de perros de una raza, que se recibe como parámetro,
	//  ordenados por peso de manera decreciente.
	public void perrosporPeso(String raza) {
		Set<Perro> perros_ordenados = new TreeSet<>(mapa_razas.get(raza));
		System.out.println(perros_ordenados);
	}


	public void perrosporEdad(String raza) {
		// Dos maneras de hacer lo mismo, y arriba, en el del peso, podemos hacer lo equivalente también.
//		Set<Perro> perros_ordenados = new TreeSet<>( (p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad())   );
		Set<Perro> perros_ordenados = new TreeSet<>(Comparator.comparingInt(Perro::getEdad).reversed());
		perros_ordenados.addAll(mapa_razas.get(raza));

		System.out.println(perros_ordenados);
	}

	// guardarPerros() que escribirá todos los perros cargados en el fichero "perros.dat". Estos perros serán guardados
	// de manera individual sin tener que estar, en esa estructura, organizados por raza.
	public void guardarPerros() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("perros.dat"))) {
			for (Set<Perro> conjunto_perro : mapa_razas.values()) {
				if (conjunto_perro != null && !conjunto_perro.isEmpty()) {
					for (Perro p : conjunto_perro) {
						out.writeObject(p);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero perros.dat no encontrado");
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
		}
	}

	// cargarPerros() que leerá todos los perros desde el fichero binario "perros.dat" y los colocará en el
	// conjunto de perros de su raza.
	public void cargarPerros() {
		mapa_razas.clear();
		try (ObjectInputStream out = new ObjectInputStream(new FileInputStream("perros.dat"))) {
			while (true) {
				Perro p = (Perro) out.readObject();
				addDog(p.getRaza(), p);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero perros.dat no encontrado");
		} catch (EOFException e) {
			System.out.println("Fin de fichero");
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		}
	}


}
