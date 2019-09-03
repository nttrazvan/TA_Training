package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utils.DriverBuilder.getDriver;

public class EmptyTemplatePage {
    public static WebElement searchField = getDriver.findElement(By.cssSelector("input[title='Search']"));

    public static java.util.List<WebElement> results (){
        return getDriver.findElements(By.cssSelector("div.rc h3"));
    }
}