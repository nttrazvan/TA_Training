package tests;

import Pages.HomePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class launchBrowserTest {

    SoftAssertions softly = new SoftAssertions();

    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println ("This method is called before each tests executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
        HomePage.agreeCookieBtn().click();
    }

    @Test
    @Tag(value = "launchBrowser")
    public void launchBrowserTest(){
        softly.assertThat(getDriver.getTitle()).contains("DECRA").as("This message wil be shown when the assertion fails");
        softly.assertAll();
    }


    @AfterEach
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }
}
