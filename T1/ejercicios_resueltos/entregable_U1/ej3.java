package resolucion.entregable_U1;

// Realiza un programa que pinte un reloj de arena relleno hecho de asteriscos. El programa debe pedir la altura. Se debe
//comprobar que la altura sea un número impar mayor o igual a 3, en caso contrario se debe mostrar un mensaje de error.
//
//Ejemplo 1:
//
//```
//Por favor, introduzca la altura del reloj de arena: 5
//
//*****
// ***
//  *
// ***
//*****
//```
//
//Ejemplo 2:
//
//```
//Por favor, introduzca la altura del reloj de arena: 3
//
//***
// *
//***
//```
//
//Ejemplo 3:
//
//```
//Por favor, introduzca la altura del reloj de arena: 7
//
//*******
// *****
//  ***
//   *
//  ***
// *****
//*******
//```

public class ej3 {
    public static void main(String[] args) {
        int altura = 5;

//        System.out.println("---Primera parte---");
        for (int i = 0; i < altura / 2; i++) {
            for (int j = 0; j < altura; j++) {
                if (i - j >= 1 || i + j >= altura) {
                    System.out.print("-");
                }
                else {
                    System.out.print("*");
                }
            }

            System.out.println();
        }

//        System.out.println("---Segunda parte---");
        for (int i = 0; i < (altura+1) / 2; i++) {
            for (int j = 0; j < altura; j++) {
                if (i + j >= altura / 2 && (j - i) <= (altura / 2)) {
                    System.out.print("*");
                }
                else {
                    System.out.print("-");
                }
            }

            System.out.println();
        }
    }
}
