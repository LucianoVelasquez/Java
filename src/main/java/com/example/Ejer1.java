package com.example;
public class Ejer1 {

     /* Dados dos números enteros a y b, que pueden ser positivos o negativos, encuentra la suma de todos los números enteros entre ellos e incluyéndolos, y devuélvela. Si los dos números son iguales, devuelve a o b. */
     
    private int sumaTotal = 0;

    public int getSuma(int a, int b) {

        if (a == b) {
            return a;
        }

        if (b < a) {

            for (int i = b; i <= a; i++) {
                sumaTotal += i;
            }

        } else {

            for (int i = a; i <= b; i++) {
                sumaTotal += i;
            }

        }

        return sumaTotal;
    }
}
