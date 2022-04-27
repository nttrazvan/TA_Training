package tests;

import Pages.EmptyTemplatePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testData.testDataContainer;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class emptyTemplate2Test {

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

    @Test(groups = "test2")
    public void verifySearchResultTest01() {
        EmptyTemplatePage.searchField().sendKeys(testDataContainer.summerString);
        EmptyTemplatePage.searchField().submit();
        System.out.println("The number of search results titles is: " + EmptyTemplatePage.results().size());
        for (WebElement element : EmptyTemplatePage.results()) {
            int i = EmptyTemplatePage.results().indexOf(element);
            softly.assertTrue(element.getAttribute("textContent").toLowerCase().contains(testDataContainer.summerString)
                    ,"The title numbered: " + i + " does not contain the string: " + testDataContainer.summerString);
        }
        softly.assertAll();
    }

    @Test(groups = "test2")
    public void verifySearchResultTest02() {
        EmptyTemplatePage.searchField().sendKeys(testDataContainer.summerString);
        EmptyTemplatePage.searchField().submit();
        System.out.println("The number of search results titles is: " + EmptyTemplatePage.results().size());
        for (WebElement cartodfElement : EmptyTemplatePage.results()) {
            int i = EmptyTemplatePage.results().indexOf(cartodfElement);
            // Intentionally set value to winterString to fail
            softly.assertTrue(cartodfElement.getAttribute("textContent").toLowerCase().contains(testDataContainer.winterString)
                    ,"The title numbered: " + i + " does not contain the string: " + testDataContainer.summerString);
        }
        softly.assertAll();
    }

    @AfterMethod
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
