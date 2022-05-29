package tests;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class availabilityOfTheSystemTest {
    SoftAssertions softly = new SoftAssertions();

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }

    @Test(groups = {"availability"})
    public void availabilityOfTheSystem(){
        softly.assertThat(getDriver.getTitle()).contains("Anmelden").as("This message will be shown when the assertion fails");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }
}
