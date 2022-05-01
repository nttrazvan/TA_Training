package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class HomePage {

    public static WebElement agreeCookieBtn () {
        return getDriver.findElement(By.xpath("//*[contains(text(),'Accept')]"));
    }
}
