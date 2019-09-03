package suites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.emptyTestTemplate1;
import tests.emptyTestTemplate3;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        emptyTestTemplate1.class,
        emptyTestTemplate3.class
})
public class testSuite2 {
    @BeforeEach
    public static void setUp() throws IOException, InterruptedException {
        Thread.sleep(2500);
        System.out.println("This method is called before each test executes");
        Helpers.killDriverProcess();
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(7);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }

    @AfterEach
    public static void tearDown() {
        System.out.println("This method is called after the test executes");
        try {
            getDriver.close();
            getDriver.quit();
        }catch (Exception e) {}
    }
}
