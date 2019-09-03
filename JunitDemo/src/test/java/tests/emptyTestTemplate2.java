package tests;

import Pages.EmptyTemplatePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebElement;
import testData.testDataContainer;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

@RunWith(JUnit4.class)
public class emptyTestTemplate2 {

    @Before
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.killDriverProcess();
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(7);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }

    @Test
    public void verifySearchResultTest01() throws InterruptedException {
        EmptyTemplatePage.searchField.sendKeys(testDataContainer.summerString);
        EmptyTemplatePage.searchField.submit();
        System.out.println("The number of search results titles is: " + EmptyTemplatePage.results().size());
        boolean exitResult = false;
        int index = 0;
        for (WebElement element : EmptyTemplatePage.results()) {
            int i = EmptyTemplatePage.results().indexOf(element);
            if (element.getAttribute("textContent").toLowerCase().contains(testDataContainer.summerString)) {
                System.out.println("The title numbered: " + i + " contains the string: " + testDataContainer.summerString);
                exitResult = true;
            } else {
                System.out.println("The title numbered: " + i + " does not contain the string: " + testDataContainer.summerString);
            }
        }
        Assert.assertTrue("This message will be thrown when the test does not pass in the console", exitResult);
    }

    @Test
    public void verifySearchResultTest02() {
        EmptyTemplatePage.searchField.sendKeys(testDataContainer.summerString);
        EmptyTemplatePage.searchField.submit();
        System.out.println("The number of search results titles is: " + EmptyTemplatePage.results().size());
        boolean exitResult = false;
        int index = 0;
        for (WebElement element : EmptyTemplatePage.results()) {
            int i = EmptyTemplatePage.results().indexOf(element);
            // Intentionally set value to winterString to fail
            if (element.getAttribute("textContent").toLowerCase().contains(testDataContainer.winterString)) {
                System.out.println("The title numbered: " + i + " contains the string: " + testDataContainer.summerString);
                exitResult = true;
            } else {
                System.out.println("The title numbered: " + i + " does not contain the string: " + testDataContainer.summerString);
            }
        }
        Assert.assertTrue("This message will be thrown when the test does not pass in the console",
                exitResult);
    }

    @After
    public void afterMethod() throws IOException {
        getDriver.close();
    }
}
