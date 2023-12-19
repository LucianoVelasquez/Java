package com.example.Ejercicios;

import java.util.ArrayList;

public class Ejer3 {
    private static int contador = 0;

    public static ArrayList<String> manugacture(String[] gifts, String materials) {
        // const gifts = ['tren', 'oso', 'pelota']
        // const materials = 'tronesa'
        // 'tren' SÍ porque sus letras están en 'tronesa'
        // 'oso' SÍ porque sus letras están en 'tronesa'
        // 'pelota' NO porque sus letras NO están en 'tronesa'
        ArrayList<String> res = new ArrayList<String>();
        


        for(int i = 0; i < gifts.length;i++){

            String[] letras = gifts[i].split("");

            for(int j =0; j < letras.length;j++){
                if(materials.contains(letras[j])){
                    contador++;
                }
            }

            if (contador == gifts[i].length()) {
                res.add(gifts[i]);
                contador = 0;
            }
        }

        return res;
    }
}