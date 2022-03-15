package tests;

import org.junit.jupiter.api.*;
import utils.Helpers;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class emptyTestTemplate3 {
    private final int var1 = 0;
    private final int var2 = 1;

    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before the test executes");
        Helpers.getPropValues();
    }

    @Test
    @Tag("test3")
    public void successTest(){
        assertNotEquals(var1, var2,"This message will be thrown if the assertion fails");
    }

    @Test
    @Tag("test3")
    public void failTest(){
        assertEquals(var1, var2, "This message will be thrown if the assertion fails");
    }

    @AfterEach
    public void afterMethod(){
        System.out.println("This is the method run after the test executes");
    }
}