package Cucumber.CucumberUtils.pages;

import Cucumber.Utils.DriverUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EmptyTemplatePage extends DriverUtils {

    private DriverUtils pages;
    public EmptyTemplatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "css identifier goes here")
    public WebElement elementTemplate;

    @FindBy(css = "input[title='Search']")
    public WebElement searchField;

    @FindBy(css = "div.rc h3")
    public List<WebElement> resultsTitles;

    public void navigate(String url){
        pages.getDriver().navigate().to(url);
    }

}



