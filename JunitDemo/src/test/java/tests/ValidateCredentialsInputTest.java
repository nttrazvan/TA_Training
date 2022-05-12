package tests;

import Pages.LoginPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testData.testDataTREG;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;
//Todo - Please remove the declaration of soft assertions if not used and the additional empty lines
public class ValidateCredentialsInputTest {
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
//Todo - The name of the test is inconsistent, validateLoginInputsFunctionality
    @Test
    @Tag(value = "validateCredentialsEntered")
    public void enterCredentialsTest() {
        LoginPage.usernameInput().sendKeys(testDataTREG.username);
        LoginPage.passwordInput().sendKeys(testDataTREG.password);
        Assert.assertTrue(LoginPage.usernameInput().getAttribute("value").contains(testDataTREG.username));
        Assert.assertTrue(LoginPage.passwordInput().getAttribute("value").contains(testDataTREG.password));
    }


    @AfterEach
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
