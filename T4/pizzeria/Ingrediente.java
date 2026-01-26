package U4_poo.resolucion_clase.pizzeria;

public class Ingrediente {
		private tiposIngredientes nombre;
		private int calorias_por_100;


	public Ingrediente() {
		this.nombre = tiposIngredientes.QUESO;
		this.calorias_por_100 = 250;
	}

	public Ingrediente(tiposIngredientes ingrediente, int calorias_por_100) {
		this.nombre = ingrediente;
		this.calorias_por_100 = calorias_por_100;
	}
}
