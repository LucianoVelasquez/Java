package org.example.first10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class testStream {

    public static void Implement(){

        List<String> listaDeNombres = Arrays.asList("Luciano","Macarena","Ledro");
        List<Integer> listaDeNumeros = Arrays.asList(8,5,4,3,11,20,19,11);

        List<String> newListaDeNombres = listaDeNombres.stream()
                .filter(name -> name.startsWith("L"))
                .map(String::toUpperCase)
                .toList();
        newListaDeNombres.forEach(System.out::println);

        System.out.println("\n-------------------------------------\n");

        List<Integer> newListaDeNumeros = listaDeNumeros.stream()
                .filter(n -> n%2 != 0)
                .sorted()
                .toList()
                .reversed();

       newListaDeNumeros.forEach(System.out::println);
    }

}
