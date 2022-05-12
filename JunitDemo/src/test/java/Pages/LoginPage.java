package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;
//Todo - remove additional empty lines, please keep the code arrangement consistent
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
//ToDo - if it is not used, please remove
    public static java.util.List<WebElement> results (){
        return getDriver.findElements(By.xpath("//div //a/h3"));
    }
}