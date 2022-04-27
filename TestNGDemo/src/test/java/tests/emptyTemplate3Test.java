package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Helpers;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class emptyTemplate3Test {
    private final int var1 = 0;
    private final int var2 = 1;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before the test executes");
        Helpers.getPropValues();
    }

    @Test(groups = "test3")
    public void successTest(){
        assertNotEquals(var1, var2,"This message will be thrown if the assertion fails");
    }

    @Test(groups = "test3")
    public void failTest(){
        assertEquals(var1, var2, "This message will be thrown if the assertion fails");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is the method run after the test executes");
    }
}
