import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.Ejercicios.Ejer4;
public class TestEjer4 {

    @Test
    public void seEsperaUnaCadenaVacia(){

        Ejer4 ejer4 = new Ejer4();
        String original = "abcde";
        String modified = "abcde";
        String expet = "";

        assertEquals(expet, ejer4.findNaughtyStep(original, modified));
    }
}
