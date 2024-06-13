package org.example.first10;




import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Exa2 {
//    Convert number to reversed array of digits
//    Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
//   Example: 35231 => [1,3,2,5,3]
//              0 => [0]
// 1 Pasar el parametro a string
// 2 Separar los caracteres del string en un array
// 3 transformar cada elemento del array en entero

    public static int[] digitize(long n) {
        // Code here

        Long nParam = (Long) n;
        List<Integer> result = new ArrayList<>(Arrays.stream(nParam.toString().split("")).map(Integer::parseInt).toList());
        Collections.reverse(result);

        //Diferentes formas de hacerlo:
        int[] a = Arrays.stream(new StringBuilder().append(n).reverse().toString().split("")).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
        int[] b = new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();

        return result.stream().mapToInt(Integer::intValue).toArray();


    }
}

