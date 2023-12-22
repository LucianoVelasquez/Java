import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.Ejercicios.Ejer5;

public class TestEjer5 {
    Ejer5 ejer5 = new Ejer5();

    @Test
    public void testSomething() {
    assertEquals("Jim", ejer5.generatorNickName("Jimmy"));
    assertEquals("Sam", ejer5.generatorNickName("Samantha"));
    assertEquals("Error: Nombre demasiado corto.", ejer5.generatorNickName("Sam"));
    assertEquals("Kay", ejer5.generatorNickName("Kayne"));
    assertEquals("Mel", ejer5.generatorNickName("Melissa"));
    assertEquals("Jam", ejer5.generatorNickName("James"));
    }
}
