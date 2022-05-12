package tests;

import Pages.LoginPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;
//Todo - the Tags used for all the tests should not reflect the names of the tests themselves, not useful for grouping
public class findSubmitButtonTest {
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
//Todo - Please declare the element in the proper Page and call it in the tests
    @Test
    @Tag(value = "login")
    public void findSubmitButtonTest(){
        softly.assertThat(LoginPage.submitButton()).as("This message will be shown when the assertion fails");
        softly.assertAll();
    }

    @AfterEach
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }
}
