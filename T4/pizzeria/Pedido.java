package U4_poo.resolucion_clase.pizzeria;

import java.util.Calendar;

public class Pedido {
	private Pizza pizza;
	private Calendar fecha;
	private static int cantidad_de_pedidos = 0;

	public Pedido() {
		this.pizza = new Pizza();
		this.pizza.addIngrediente(new Ingrediente());
		this.pizza.addIngrediente(new Ingrediente(tiposIngredientes.JAMON_IBERICO, 100));
		fecha = Calendar.getInstance();
		cantidad_de_pedidos++;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public Calendar getFecha() {
		return fecha;
	}


	public static int getCantidad_de_pedidos() {
		return cantidad_de_pedidos;
	}
}
