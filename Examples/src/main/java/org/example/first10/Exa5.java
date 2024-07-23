package org.example.first10;

public class Exa5 {


//    Los cajeros automáticos permiten códigos PIN de 4 o 6 dígitos y los códigos PIN no
//    pueden contener nada más que exactamente 4 dígitos o exactamente 6 dígitos.

    public static boolean validatePin(String pin){

        if(pin.length() < 4 || pin.length() > 6 || pin.length() == 5 || pin.contains("+") || pin.contains("-")){
            return false;
        }

        try {

            Integer num = Integer.parseInt(pin);

        }catch (NumberFormatException e){
            return false;
        }

        return true;
    }



}
