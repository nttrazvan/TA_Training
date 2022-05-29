package tests;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.OwiPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.tregDataContainer;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static utils.DriverBuilder.getDriver;

public class validateCredentialsInputTest {
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

    @Test(groups = {"validateCredentialsInput"})
    public void validateCredentialsInput(){
        LoginPage.usernameInput().sendKeys(tregDataContainer.username);
        LoginPage.passwordInput().sendKeys(tregDataContainer.password);
        Assert.assertTrue(LoginPage.usernameInput().getAttribute("value").contains(tregDataContainer.username));
        Assert.assertTrue(LoginPage.passwordInput().getAttribute("value").contains(tregDataContainer.password));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }
}
