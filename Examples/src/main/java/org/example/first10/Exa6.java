package org.example.first10;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exa6 {

//    https://www.codewars.com/kata/52223df9e8f98c7aa7000062/java

    public static String encript(String cadena){

        Map<String, Character> newAlph = new TreeMap<>();
        StringBuilder newCadena = new StringBuilder();
        List<String> listCadena = new ArrayList<>(Arrays.stream(cadena.split("")).toList());

        String regex = ".*[\\s\\W\\d_].*"; // Expresión regular para espacios, caracteres especiales y números
        Pattern pattern = Pattern.compile(regex);

        loadingData(newAlph);

        listCadena.stream().forEach(t -> {

            Matcher matcher = pattern.matcher(t);

            for (Map.Entry<String, Character> a : newAlph.entrySet()){

                if(t.equals(a.getKey())){
                    newCadena.append(a.getValue());
                } else if (matcher.find()) {
                    newCadena.append(t);
                }

            }


        });

        return newCadena.toString();
    }

    private static void loadingData(Map<String,Character> map){

        for (int i = 97; i < 123; i++) {

            if(i <= 109){
                map.put(Character.valueOf((char) i).toString(),Character.valueOf((char) (i+13)));
            }else{
                map.put(Character.valueOf((char) i).toString(),Character.valueOf((char) (i-13)));
            }
        }

        for (int i = 65; i < 91 ; i++) {
            if(i <= 77){
               map.put(Character.valueOf((char) i).toString(),Character.valueOf((char) (i+13)));
            }else{
                map.put(Character.valueOf((char) i).toString(),Character.valueOf((char) (i-13)));
            }
        }
    }

}
