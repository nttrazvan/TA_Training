package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class validateSystemAvailabilityTest {
    SoftAssertions softly = new SoftAssertions();

    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }

    @Test
    @Tag(value = "validateTitle")
    public void launchBrowserTest(){
        softly.assertThat(getDriver.getTitle()).contains("Anmelden").as("This message will be shown when the assertion fails");
        softly.assertAll();
    }

    @AfterEach
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }
}
