package testFirst10;


import org.example.first10.Exa2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestExa2 {
    @Test
    public void tests() {
        assertArrayEquals(new int[] {1, 3, 2, 5, 3}, Exa2.digitize(35231l));
        assertArrayEquals(new int[] {0}, Exa2.digitize(0l));
    }
}

