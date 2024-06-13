package org.example.first10;

import java.util.Arrays;

public class Exa1 {

    public static Integer sum(Integer[] arr){

        return Arrays.stream(arr).filter(n -> n > 0).reduce(0,(a,b)-> a + b);
    }
}
