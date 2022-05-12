package tests;

import Pages.DashboardPage;
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
public class ValidateLoginTest {
    SoftAssertions softly = new SoftAssertions();

    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(20);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }
//ToDo - the final assert is redundant as the login functionality is successful upon the appearance of the dashboardButton
    @Test
    @Tag(value = "validateLogin")
    public void validateLoginTest() {
        LoginPage.usernameInput().sendKeys(testDataTREG.username);
        LoginPage.passwordInput().sendKeys(testDataTREG.password);
        LoginPage.submitButton().click();
        Helpers.waitForElement(10, DashboardPage.dashboardButton());
        DashboardPage.dashboardButton().isDisplayed();
        Assert.assertEquals(getDriver.getTitle(), testDataTREG.expectedDashboardTitle);
    }


    @AfterEach
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
