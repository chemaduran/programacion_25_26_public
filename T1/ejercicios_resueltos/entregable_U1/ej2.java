package resolucion.entregable_U1;

// Escribe un programa que, dado un número entero positivo, diga cuáles
//son y cuánto suman los dígitos pares. Los dígitos pares se deben
//mostrar en orden, de izquierda a derecha. Usa `long` en lugar de `int`
//donde sea necesario para admitir números largos.
//
//Ejemplo 1:
//
//```
//Por favor, introduzca un número entero positivo: 94026782
//Dígitos pares: 4 0 2 6 8 2
//Suma de los dígitos pares: 22
//```
//
//Ejemplo 2:
//
//```
//Por favor, introduzca un número entero positivo: 31779
//Dígitos pares:
//Suma de los dígitos pares: 0
//```
//
//Ejemplo 3:
//
//```
//Por favor, introduzca un número entero positivo: 2404
//Dígitos pares: 2 4 0 4
//Suma de los dígitos pares: 10
//```

public class ej2 {
    public static void main(String[] args) {
        long n = 94026782;

        long ultimoDigito;
        long nInvertido = 0;

        while (n > 0) {
            ultimoDigito = n % 10;
            nInvertido = nInvertido * 10 + ultimoDigito;
            n = n / 10;
        }

        long sumaPares = 0;

        while (nInvertido > 0) {
            ultimoDigito = nInvertido % 10;

            if (ultimoDigito % 2 == 0) {
                System.out.print(ultimoDigito);
                sumaPares += ultimoDigito;
            }

            nInvertido = nInvertido / 10;
        }

        System.out.println("\nSuma pares: " + sumaPares);

    }
}
