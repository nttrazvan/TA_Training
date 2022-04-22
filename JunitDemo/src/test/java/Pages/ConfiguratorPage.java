package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ConfiguratorPage {

    private By text = By.className("cmp-title__text");

    private WebDriver driver;

    public ConfiguratorPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitleText() {
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(text));
        return title.getText();
    }

}
