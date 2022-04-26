package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class DashboardPage {

    public static WebElement dashboardButton() {

        return getDriver.findElement(By.cssSelector("a[href='/tpr/tpr/home']"));
    }

}