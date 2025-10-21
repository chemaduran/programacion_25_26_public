package resolucion.entregable_U1;

// Escribe un programa que genere la nómina (bien desglosada) de un empleado según las siguientes condiciones:
//
//* Se pregunta el cargo del empleado (1 - Prog. junior, 2 - Prog. senior, 3 - Jefe de proyecto), los días que ha estado
//  de viaje visitando clientes durante el mes y su estado civil (1 - Soltero, 2 - Casado).
//* El sueldo base según el cargo es de 950, 1200 y 1600 euros según si se trata de un prog. junior, un prog. senior o
//  un jefe de proyecto respectivamente.
//* Por cada día de viaje visitando clientes se pagan 30 euros extra en concepto de dietas. Al sueldo neto hay que
//  restarle el IRPF, que será de un 25% en caso de estar soltero y un 20% en caso de estar casado.
//
//```
//---------------------------------
//| Sueldo base           1200.00 |
//| Dietas ( 5 viajes)     150.00 |
//---------------------------------
//| Sueldo bruto          1350.00 |
//| Retención IRPF (20%)   270.00 |
//---------------------------------
//| Sueldo neto           1080.00 |
//---------------------------------
//```

import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce tu cargo de empleo");
        int empleo = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduce numero de viajes");
        int dietas = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduce tu estado civil");
        int estadoCivil = entrada.nextInt();
        entrada.nextLine();

        int sueldoBase;

        if (empleo == 1){
            sueldoBase = 950;
        } else if (empleo == 2) {
            sueldoBase = 1200;
        }else {
            sueldoBase = 1600;
        }

        int sueldoViajes = dietas * 30;

        double irpf;
        int sueldoTotal = sueldoBase + sueldoViajes;

        if (estadoCivil == 1){
            irpf = sueldoTotal * 0.75;
        }else {
            irpf = sueldoTotal * 0.80;
        }
        double dineroIrpf = sueldoTotal - irpf;
        System.out.println("Sueldo base: " + sueldoBase);
        System.out.println("Dietas" + "(" + dietas + "Viajes): " + sueldoViajes);
        System.out.println("Sueldo bruto: " + sueldoTotal);
        System.out.println("Retencion IRPF: " + dineroIrpf);
        System.out.println("Sueldo total con IRPF: " + irpf);

    }
}
