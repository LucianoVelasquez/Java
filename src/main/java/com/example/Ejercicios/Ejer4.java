package com.example.Ejercicios;

public class Ejer4 {
    
    
    public String findNaughtyStep(String original,String modifiqued){

        String[] letrasOirign = original.split("");
        String[] letrasModifequed = modifiqued.split("");

        //String original = "abcd";
        //String modified = "abcde";


        for (int i = 0; i < letrasOirign.length; i++) {

            if(!letrasModifequed[i].equals(letrasOirign[i])){
                if(!letrasOirign[i].equals(letrasModifequed[i])){
                    return  letrasOirign[i];
                }else{
                    return  letrasModifequed[i];
                }
            }

        }

        //Para ver si es el ultimo caracter.
        if(!letrasModifequed[letrasModifequed.length-1].equals(letrasOirign[letrasOirign.length-1])){
            return letrasModifequed[letrasModifequed.length-1];
        }

        return "";
    }
}
