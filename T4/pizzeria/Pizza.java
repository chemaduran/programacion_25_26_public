package U4_poo.resolucion_clase.pizzeria;

import java.util.Arrays;

public class Pizza {
	private TamanioPizza size;
	private Ingrediente[] ingredientes = new Ingrediente[0];

	public Pizza() {
		this.size = TamanioPizza.FAMILIAR;
	}


	public static void tamaniosDisponibles() {
		System.out.println(Arrays.toString(TamanioPizza.values()));
	}

	public int num_ingredientes() {
		return ingredientes.length;
	}

	public boolean addIngrediente(Ingrediente ingrediente) {
		boolean resultado = false;

		if (ingredientes.length < 3) {
			ingredientes = Arrays.copyOf(ingredientes, ingredientes.length + 1);
			ingredientes[ingredientes.length - 1] = ingrediente;
			resultado = true;
		}

		return resultado;
	}

	@Override
	public String toString() {
		return "Pizza{" +
						"size=" + size +
						", ingredientes=" + Arrays.toString(ingredientes) +
						'}';
	}
}
