package U4_poo.resolucion_clase.pizzeria;

import java.util.Arrays;

public class Pizzeria {
	private Pedido[] pedidos;

	public Pizzeria(int capacidad_inicial) {
		this.pedidos = new Pedido[capacidad_inicial];

	}

	public Pizzeria() {
		this(5);
	}


	public void addPedido(Pedido pedido) {
		int posicion = encontrarPrimerNullArray();
		if (posicion == -1) {
			pedidos = Arrays.copyOf(pedidos, pedidos.length + 1);
			pedidos[pedidos.length - 1] = pedido;
		} else {
			pedidos[posicion] = pedido;
		}
	}

	public int encontrarPrimerNullArray() {
		int resultado = -1;

		for (int i = 0; i < pedidos.length; i++) {
			if (pedidos[i] == null) {
				resultado = i;
				break;
			}
		}

		return resultado;
	}

	public int pedidosProcesados() {
		return Pedido.getCantidad_de_pedidos();
	}

	@Override
	public String toString() {
		return "Pizzeria{" +
						"pedidos=" + Arrays.toString(pedidos) +
						'}';
	}
}
