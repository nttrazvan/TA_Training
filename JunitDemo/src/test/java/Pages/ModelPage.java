package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModelPage {

    private By text = By.className("model-nav");

    private By i3 = By.linkText("BMW i3");

    private WebDriver driver;

    public ModelPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitleText() {
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(text));
        return title.getText();
    }

    public I3ModelPage clickI3Model() {
        driver.findElement(i3).click();
        return new I3ModelPage(driver);
    }
}
