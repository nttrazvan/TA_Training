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

public class ValidateLoginTest {
    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(20);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }

    @Test
    @Tag(value = "login")
    public void validateLoginTest() {
        LoginPage.usernameInput().sendKeys(testDataTREG.username);
        LoginPage.passwordInput().sendKeys(testDataTREG.password);
        LoginPage.submitButton().click();
        Helpers.waitForElement(10, DashboardPage.dashboardButton());
        DashboardPage.dashboardButton().isDisplayed();
    }

    @AfterEach
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
