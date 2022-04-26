package tests;

import Pages.LoginPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testData.testDataTREG;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class no20EnterCredentialsTest {
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
    @Tag(value = "enterCredentials")
    public void enterCredentialsTest() {
        LoginPage.enterUsername().sendKeys(testDataTREG.username);
        LoginPage.enterPassword().sendKeys(testDataTREG.password);
    }


    @AfterEach
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
