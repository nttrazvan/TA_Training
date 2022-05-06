package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class LoginPage {



    public static WebElement usernameInput() {
        return getDriver.findElement(By.cssSelector("input[autocomplete='username']"));
    }
    public static WebElement passwordInput() {
        return getDriver.findElement(By.cssSelector("input[autocomplete='password']"));
    }

    public static WebElement submitButton() {
        return getDriver.findElement(By.tagName("button"));
    }

    public static java.util.List<WebElement> results (){
        return getDriver.findElements(By.xpath("//div //a/h3"));
    }
}