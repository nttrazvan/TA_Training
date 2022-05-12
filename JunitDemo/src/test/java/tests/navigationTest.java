package tests;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.OwiPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testData.testDataTREG;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static utils.DriverBuilder.getDriver;
//Todo - please keep the constants in the test data files
public class navigationTest {
    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before the test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
        LoginPage.usernameInput().sendKeys(testDataTREG.username);
        LoginPage.passwordInput().sendKeys(testDataTREG.password);
        LoginPage.submitButton().click();
        Helpers.waitForElement(10, DashboardPage.dashboardButton());
        DashboardPage.dashboardButton().isDisplayed();
    }

//Todo - remove additional lines and hardcoded printed messages
    @Test
    @Tag(value = "smoke")
    public void checkNavTitles(){
        assertEquals(DashboardPage.dashboardButton().getAttribute("textContent"),testDataTREG.dashboardFirstNavigationElement);
        assertEquals(OwiPage.owiNav().getAttribute("textContent"),testDataTREG.dashboardSecondNavigationElement);
    }

    @AfterEach
    public void afterMethod(){
        System.out.println("This is the method run after the test executes");
        DriverBuilder.kill();
    }
}