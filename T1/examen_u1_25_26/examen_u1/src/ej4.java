// Realiza un programa que solicite al usuario un número entero positivo con una cantidad de cifras pares.
// Si el número que le pasamos no tiene una cantidad de cifras par deberá volver a pedir un número.
//
//Una vez tengamos el número deberemos decir qué mitades son números primos o no.
//
//Ejemplo1:
//
//Introduce un número:
//1213
//12 no es número primo
//13 es número primo
//Ejemplo2:
//
//Introduce un número:
//34567
//Introduce un número:
//1105
//11- Es número primo
//05 - Es número primo.

public class ej4 {
	public static void main(String[] args) {
		int num =1112;
		int aux = num;
		int cont = 0;
		do {
			aux /= 10;
			cont++;
		} while (aux > 0);
		int mitad = cont / 2;
		int parte1 = num / (int) Math.pow(10, mitad);
		int parte2 = num % (int) Math.pow(10, mitad);
		boolean primo1=true;
		for (int i = 2; i < parte1; i++) {
			if (parte1%i==0){
				primo1=false;
				break;
			}
		}
		boolean primo2=true;
		for (int i = 2; i < parte1; i++) {
			if (parte2%i==0){
				primo2=false;
				break;
			}
		}
		if (primo1){
			System.out.println(parte1+"-> primo");
		} else {
			System.out.println(parte1+"-> no primo");
		}
		if (primo2){
			System.out.println(parte2+"-> primo");
		} else {
			System.out.println(parte2+"-> no primo");
		}
	}
}
