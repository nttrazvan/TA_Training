package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexBMWPage {

    private By configurator = By.linkText("Configurator");
    private By model = By.linkText("Modele");

    private WebDriver driver;

    public IndexBMWPage(WebDriver driver){
        this.driver = driver;
    }

    public ConfiguratorPage clickConfigurator() {
        driver.findElement(configurator).click();
        return new ConfiguratorPage(driver);
    }

    public ModelPage clickModel() {
        driver.findElement(model).click();
        return new ModelPage(driver);
    }
}
