package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverBuilder.getDriver;

public class EmptyTemplatePage {

    public static WebElement agreeCookiePolicyBtn() {
        WebElement title = new WebDriverWait(getDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("reject-button")));
        return getDriver.findElement(By.className("accept-button"));}

    public static WebElement searchField() {
        return getDriver.findElement(By.cssSelector("input[title='Search']"));
    }

    public static java.util.List<WebElement> results (){
        return getDriver.findElements(By.xpath("//div //a/h3"));
    }
}