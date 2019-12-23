package Cucumber.Utils;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DriverUtils extends PageObject {
    public DriverUtils(WebDriver driver) {
        super(driver);
    }

    public static void setEnvironment() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String property = variables.getProperty("environment.settings");
        variables.setProperty("environment.settings", "web");
        if (property.contains("web")) {
            setWeb();
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Pages.class);

    private static boolean isWEB;

    //------------------------------------------------------------------------------------------------------------------
    //region Page Object Utils
    //------------------------------------------------------------------------------------------------------------------

    public static void sleep(int seconds) {
        int time = seconds * 1000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
    }


    //endregion

    //------------------------------------------------------------------------------------------------------------------
    //region Driver Utils
    //------------------------------------------------------------------------------------------------------------------

    private static WebDriver getWebDriver(WebDriver driver) {
        if (isWEB()) {
            try {
                WebDriverFacade webDriverFacade = (WebDriverFacade) driver;
                WebDriver webDriver = (WebDriver) webDriverFacade.getProxiedDriver();
                setWeb();
                return webDriver;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public void getCurrentDriver() {
        getWebDriver(getDriver());
    }

    private static boolean isWEB() {
        return isWEB;
    }

    private static void setWeb() {
        isWEB = true;
    }


    public void clickTroublesomeElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public int getYPositionOflement(WebElement element) {
        return element.getLocation().y;
    }

    public void assertButtonContainsText(WebElement element){
        boolean exitResult = false;
        if(element.getAttribute("textContent").replaceAll("[^A-Za-z]+", "").length() != 0){
            exitResult = true;
        }
        Assert.assertTrue("The button does not contain text", exitResult);
    }
}