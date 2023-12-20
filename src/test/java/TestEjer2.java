import com.example.Ejercicios.Ejer2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEjer2 {
    Ejer2 praEjer2 = new Ejer2();

    private int[] giftIds = {2, 1, 3, 5, 3, 2} ;
    private int[] giftIds2 = {1, 2, 3, 4};
    private int[] giftIds3 = {5, 1, 5, 1};

    @Test
    public void test1(){
        assertEquals(3,praEjer2.findFirstRepeated(giftIds));
    }
    @Test
    public void test2(){
        assertEquals(-1,praEjer2.findFirstRepeated(giftIds2));
    }
    @Test
    public void test3(){
        assertEquals(5,praEjer2.findFirstRepeated(giftIds3));

    }


}
