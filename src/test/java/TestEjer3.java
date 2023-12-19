import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.example.Ejercicios.Ejer3;

public class TestEjer3 {
    
    

    @Test()
    public void test1(){
        String[] gifts = {"tren", "oso", "pelota"};
        String materials = "tronesa";

        ArrayList<String> giftsAsser = new ArrayList<String>();
        giftsAsser.add("tren");
        giftsAsser.add("oso");

        /* String[] res = (Stirng[]) ; */

        assertEquals(giftsAsser, Ejer3.manugacture(gifts, materials)); 
    }
}
