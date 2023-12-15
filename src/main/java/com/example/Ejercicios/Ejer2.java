package com.example.Ejercicios;

import java.util.Arrays;

public class Ejer2 {
    /*
     * ¡Encuentra el primer número de identificación que se ha repetido, donde la
     * segunda ocurrencia tenga el índice más pequeño!
     * 
     * En otras palabras, si hay más de un número repetido, debes devolver el número
     * cuya segunda ocurrencia aparezca primero en la lista. Si no hay números
     * repetidos, devuelve -1.
     * https://adventjs.dev/es/challenges/2023/1
     */
    private int repeat = 0;
    private int index = 999;

    // giftIds = [2, 1, 3, 5, 3, 2]
    //            i     j
    // IN
    public int findFirstRepeated(int[] gifts) {

        for (int i = 0; i < gifts.length - 1; i++) {
            for (int j = i + 1; j < gifts.length; j++) {

                if (gifts[i] == gifts[j] && j < index) {
                    repeat = gifts[i];
                    index = j;
                }
            }
        }

        if(repeat == 0){
            return -1;
        }

        return repeat;
    }

}
