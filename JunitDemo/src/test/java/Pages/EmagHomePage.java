package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class EmagHomePage {

    public static WebElement agreeCookiePolicyBtn() {
        return getDriver.findElement(By.cssSelector(".cookie-banner-buttons .js-accept"));
    }

    public static WebElement cartBtn() {
        return getDriver.findElement(By.cssSelector("#my_cart"));
    }

    public static WebElement navbarCartDropdownMessage() {
        return getDriver.findElement(By.cssSelector(".navbar-cart-dropdown p"));
    }

}
