package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utils.DriverBuilder.getDriver;

public class LoginPage {

    public static WebElement enterUserName(){
        return getDriver.findElement(By.cssSelector("input[name='username']"));
    }

    public static WebElement enterPassword(){
        return getDriver.findElement(By.cssSelector("input[name='password']"));
    }
}
