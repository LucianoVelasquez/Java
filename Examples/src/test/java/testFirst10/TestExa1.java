package testFirst10;

import org.example.first10.Exa1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExa1 {

    @Test
    public void testSomething() {
        assertEquals(15, Exa1.sum(new Integer[]{1,2,3,4,5}));
        assertEquals(13, Exa1.sum(new Integer[]{1,-2,3,4,5}));
        assertEquals(0, Exa1.sum(new Integer[]{}));
        assertEquals(0, Exa1.sum(new Integer[]{-1,-2,-3,-4,-5}));
        assertEquals(9, Exa1.sum(new Integer[]{-1,2,3,4,-5}));
    }

}
