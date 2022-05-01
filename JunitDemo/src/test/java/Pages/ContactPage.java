package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class ContactPage {

    public static WebElement enterName(){
        return getDriver.findElement(By.cssSelector("input[id='form-field-name']"));
    }

    public static WebElement enterEmail(){
        return getDriver.findElement(By.cssSelector("input[id='form-field-email']"));
    }

    public static WebElement enterTelephone(){
        return getDriver.findElement(By.cssSelector("input[id='form-field-04fbb9f']"));
    }

    public static WebElement enterSubject(){
        return getDriver.findElement(By.cssSelector("input[id='form-field-b9cd3c3']"));
    }

    public static WebElement enterMessage(){
        return getDriver.findElement(By.cssSelector("textarea[id='form-field-6ed25c0']"));
    }

    public static WebElement submitBtn(){
        return getDriver.findElement(By.tagName("button"));
    }
}
