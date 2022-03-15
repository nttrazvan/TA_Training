package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utils.DriverBuilder.getDriver;

public class EmptyTemplatePage {

    public static WebElement agreeCookiePolicyBtn() {return getDriver.findElement(By.xpath("//*[contains(text(),'I agree')]"));}

    public static WebElement searchField() {
        return getDriver.findElement(By.cssSelector("input[title='Search']"));
    }

    public static java.util.List<WebElement> results (){
        return getDriver.findElements(By.xpath("//div //a/h3"));
    }
}