package U3_strings_arrays_funciones.teoria.arrays;

import java.util.Arrays;

public class prueba_impresion_arrays {
	public static void main(String[] args) {
		int[] t = {1, 2, 1, 6, 23};
		int[] a, b;
		a = Arrays.copyOf(t, t.length);
		System.out.println(Arrays.toString(a));


	}
}
