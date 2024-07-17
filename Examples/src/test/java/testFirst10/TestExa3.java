package testFirst10;

import org.example.first10.Exa3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExa3 {
    @Test
    public void testSomething() {
        assertEquals("8j8mBliB8gimjB8B8jlB", Exa3.noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"));
        assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd", Exa3.noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
        assertEquals("8aaaaaddddr", Exa3.noSpace("8aaaaa dddd r     "));
        assertEquals("jfBmgklf8hg88lbe8", Exa3.noSpace("jfBm  gk lf8hg  88lbe8 "));
        assertEquals("8jaam", Exa3.noSpace("8j aam"));
    }
}
