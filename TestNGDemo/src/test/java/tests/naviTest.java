package tests;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.OwiPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.tregDataContainer;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static utils.DriverBuilder.getDriver;

public class naviTest {
    SoftAssertions softly = new SoftAssertions();

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
        LoginPage.usernameInput().sendKeys(tregDataContainer.username);
        LoginPage.passwordInput().sendKeys(tregDataContainer.password);
        LoginPage.submitButton().click();
        Helpers.waitForElement(10, DashboardPage.dashboardButton());
        DashboardPage.dashboardButton().isDisplayed();
    }

    @Test(groups = {"navi"})
    public void navigation(){
        assertEquals(DashboardPage.dashboardButton().getAttribute("textContent"),tregDataContainer.dashboardFirstNavigationElement);
        assertEquals(OwiPage.owiNav().getAttribute("textContent"),tregDataContainer.dashboardSecondNavigationElement);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }
}
