package com.example.Ejercicios;

public class Ejer5 {

    private String[] vocales = { "a", "e", "i", "o", "u" };

    public String generatorNickName(String name) {
        
        //name : luciano
        String[] letras = name.split("");
        // Objetivo: Generar un apodo apartir del nombre.
        // Datos de entrada: un string con el nombre.
        // Datos de salida: 
            //1) si la tercera letra en consonante debe devolver las
            // primeras 3 letras.
            // 2) si la tercer letra es una vocal, debe devolver las primeras 4 letras.
            // 3) si la cadena tiene menos de 4 caracteres, devuelve error.

        if (name.length() < 4) {
            return "Error: Nombre demasiado corto.";
        }

        for (String vocal : vocales) {
            if (letras[2].equals(vocal)) {
                return name.substring(0, 4);
            }
        }

        return name.substring(0, 3);
    }
}
