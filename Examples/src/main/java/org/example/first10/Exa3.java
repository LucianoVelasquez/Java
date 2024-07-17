package org.example.first10;

import java.util.Arrays;
import java.util.List;

public class Exa3 {

//    Escriba una función que elimine los espacios de la cadena y, a continuación, devuelva la cadena resultante.
//    Ejemplos:
//    Input -> Output
//        "8 j 8   mBliB8g  imjB8B8  jl  B" -> "8j8mBliB8gimjB8B8jlB"
//        "8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd" -> "88Bifk8hB8BB8BBBB888chl8BhBfd"
//        "8aaaaa dddd r     " -> "8aaaaaddddr"

    public static String noSpace(final String x){

        List<String> result = Arrays.stream(x.split("")).filter(v -> !v.equals(" ")).toList();

        StringBuilder pushResult = new StringBuilder();

        for (String s : result) {
            pushResult.append(s);
        }

        //Otra forma
        String pushResult2 = String.join("",x.split(" "));

        return pushResult.toString();
    }


}
