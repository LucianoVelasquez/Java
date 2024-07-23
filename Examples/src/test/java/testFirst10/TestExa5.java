package testFirst10;

import org.example.first10.Exa5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExa5 {

    @Test
    public void validPins() {
        assertEquals(true, Exa5.validatePin("1234"));
        assertEquals(true, Exa5.validatePin("0000"));
        assertEquals(true, Exa5.validatePin("1111"));
        assertEquals(true, Exa5.validatePin("123456"));
        assertEquals(true, Exa5.validatePin("098765"));
        assertEquals(true, Exa5.validatePin("000000"));
        assertEquals(true, Exa5.validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertEquals(false, Exa5.validatePin("a234"));
        assertEquals(false, Exa5.validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertEquals(false, Exa5.validatePin("1"));
        assertEquals(false, Exa5.validatePin("12"));
        assertEquals(false, Exa5.validatePin("123"));
        assertEquals(false, Exa5.validatePin("12345"));
        assertEquals(false, Exa5.validatePin("1234567"));
        assertEquals(false, Exa5.validatePin("-1234"));
        assertEquals(false, Exa5.validatePin("1.234"));
        assertEquals(false, Exa5.validatePin("00000000"));
    }

}
