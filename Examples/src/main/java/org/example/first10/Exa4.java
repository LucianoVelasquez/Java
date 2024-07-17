package org.example.first10;


import java.util.Arrays;
import java.util.Objects;

public class Exa4 {

    public static String encode(String word){

        String[] list = word.toLowerCase().split("");
        boolean flag = false;

        for (int i = 0; i < Arrays.stream(list).count(); i++) {

            flag = false;

            for (int j = 0; j < Arrays.stream(list).count(); j++) {

                if(list[i].equals(list[j]) && i!=j && (!Objects.equals(list[i], "(") || !Objects.equals(list[i], ")")) ){

                    list[j] = ")";
                    flag = true;
                }
            }

            if(flag){
                list[i] = ")";
            }else{
                list[i] = "(";
            }
        }

        return String.join("",list);
    }


}
