package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;
public class OwiPage {
    //ToDo - the vbOverview element is not used, remove if not necessary
    public static WebElement owiNav() {
        return getDriver.findElement(By.cssSelector("a[href='/tpr/tpr/']"));
    }
    public static WebElement vbOverview() {
        return getDriver.findElement(By.cssSelector("a[href='/tpr/tpr/third-parties-management/overview']"));
    }
}