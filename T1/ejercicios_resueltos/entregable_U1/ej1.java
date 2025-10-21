package resolucion.entregable_U1;

// Escribe un programa que pida dos números por teclado y que luego mezcle en dos números diferentes los dígitos pares y
//los impares. Se van comprobando los dígitos de la siguiente manera: primer dígito del primer número, primer dígito del
//segundo número, segundo dígito del primer número, segundo dígito del segundo número, tercer dígito del primer número...
//Para facilitar el ejercicio, podemos suponer que el usuario introducirá dos números de la misma longitud y que siempre
//habrá al menos un dígito par y uno impar. Usa `long` en lugar de `int` donde sea necesario para admitir números largos.
//
//Ejemplo 1:
//
//```
//Por favor, introduzca un número: 9402
//Introduzca otro número: 6782
//El número formado por los dígitos pares es 640822
//El número formado por los dígitos impares es 97
//```
//
//Ejemplo 2:
//
//```
//Por favor, introduzca un número: 137
//Introduzca otro número: 909
//El número formado por los dígitos pares es 0
//El número formado por los dígitos impares es 19379
//```


public class ej1 {
    public static void main(String[] args) {
        long n1 = 9402;
        long n2 = 6782;

        long n1Invertido = 0;
        long ultimoDigito1;

        while (n1 > 0) {
            ultimoDigito1 = n1 % 10;
            n1Invertido = n1Invertido * 10 + ultimoDigito1;
            n1 = n1 / 10;
        }

        long n2Invertido = 0;
        long ultimoDigito2;

        while (n2 > 0) {
            ultimoDigito2 = n2 % 10;
            n2Invertido = n2Invertido * 10 + ultimoDigito2;
            n2 = n2 / 10;
        }

        long resultadoPar = 0;
        long resultadoImpar = 0;

        while (n1Invertido > 0 && n2Invertido > 0) {
            ultimoDigito1 = n1Invertido % 10;
            ultimoDigito2 = n2Invertido % 10;

            if (ultimoDigito1 % 2 == 0) {
                resultadoPar = resultadoPar * 10 + ultimoDigito1;
            }

            if (ultimoDigito2 % 2 == 0) {
                resultadoPar = resultadoPar * 10 + ultimoDigito2;
            }

            if (ultimoDigito1 % 2 != 0) {
                resultadoImpar = resultadoImpar * 10 + ultimoDigito1;
            }

            if (ultimoDigito2 % 2 != 0) {
                resultadoImpar = resultadoImpar * 10 + ultimoDigito2;
            }

            n1Invertido /= 10;
            n2Invertido /= 10;
        }

        System.out.println(resultadoPar);
        System.out.println(resultadoImpar);
    }
}
