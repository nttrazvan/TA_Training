package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utils.DriverBuilder;
import utils.Helpers;
import java.io.IOException;

@RunWith(JUnit4.class)
public class emptyTestTemplate3 {
    private int var1 = 0;
    private int var2 = 1;

    @Before
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before the test executes");
        Helpers.getPropValues();
    }

    @Test
    public void successTest(){
        Assert.assertTrue("This message will be thrown if the assertion fails", var1 != var2);
    }

    @Test
    public void failTest(){
        Assert.assertEquals("This message will be thrown if the assertion fails", var1, var2);
    }

    @After
    public void afterMethod(){
        System.out.println("This is the method run after the test executes");
    }
}