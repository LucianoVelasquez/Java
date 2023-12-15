import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.Ejercicios.Ejer1;

public class TestEjer1 {
    Ejer1 s = new Ejer1();

    @Test
    public void testSumPositiveNumbersLarge() {
      assertEquals(14, s.getSuma(5, -1));
    }
    
    @Test
    public void testSumPositiveNumbersNearZero() {
      assertEquals(127759, s.getSuma(505, 4));
    }
    
    @Test
    public void testSumPositiveNumbersMidRange() {
      assertEquals(44178, s.getSuma(321, 123));
    }

    @Test
    public void TestZero()
    {
      assertEquals(0, s.getSuma(0, 0));
    }
    
    @Test
    public void TestSwitchMinMax()
    {
      assertEquals(-15, s.getSuma(-5, -1));
    }
    
}
