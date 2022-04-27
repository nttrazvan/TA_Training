package tests;

import Pages.EmptyTemplatePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class emptyTemplate1Test {
    SoftAssert softly = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
        EmptyTemplatePage.agreeCookiePolicyBtn().click();
    }

  @Test(groups = {"test1"})
    public void launchBrowserTest(){
        softly.assertTrue(getDriver.getTitle().contains("Google"),"This message will be shown when the assertion fails");
        softly.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }
}
