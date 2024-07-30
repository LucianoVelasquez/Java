package testFirst10;

import org.example.first10.Exa6;
import org.junit.jupiter.api.*;

import java.util.Random;

@DisplayName("Random Tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestExa6 {
    @Test
    @Order(1)
    @DisplayName("Strings with lower letters only")
    void testSomething1() {
        Assertions.assertEquals("uryyb", Exa6.encript("hello"), "For input: `hello`");
    }

    @Test
    @Order(2)
    @DisplayName("Strings with upper and lower case letters")
    void testSomething2() {
        Assertions.assertEquals("UryybJbeyq", Exa6.encript("HelloWorld"), "For input: `HelloWorld`");
    }

    @Test
    @Order(3)
    @DisplayName("Strings with spaces and special characters")
    void testSomething3() {
        Assertions.assertEquals("Uryyb Jbeyq!", Exa6.encript("Hello World!"), "For input: `Hello World!`");
    }

    @Test
    @Order(4)
    @DisplayName("Strings with only special characters, digits and spaces")
    void testSomething4() {
        Assertions.assertEquals("123@#!!#@  33", Exa6.encript("123@#!!#@  33"), "For input: `123@#!!#@  33`");
    }

    @Test
    @Order(5)
    @DisplayName("Strings with only special characters, digits, spaces and letters")
    void testSomething5() {
        Assertions.assertEquals("J3 ne3 va lr@e 2023$$$!äöü", Exa6.encript("W3 ar3 in ye@r 2023$$$!äöü"), "For input: `W3 ar3 in ye@r 2023$$$!äöü`");
    }

    @Test
    @Order(6)
    @DisplayName("Random tests with letters, digits, spaces and special characters")
    void testSomething6() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 !@#$%^&*()_+äöü";
        for (int test = 0; test < 100; test++) {
            StringBuilder sb = new StringBuilder();
            int length = random.nextInt(1, alphabet.length());
            for (int i = 0; i < length; i++) {
                sb.append(alphabet.charAt(random.nextInt(0, alphabet.length())));
            }
            Assertions.assertEquals(Exa6.encript(sb.toString()), Exa6.encript(sb.toString()), "For input: `" + sb.toString() + "`");
        }
    }
}

