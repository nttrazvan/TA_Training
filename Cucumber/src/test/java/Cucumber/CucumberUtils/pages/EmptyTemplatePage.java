package Cucumber.CucumberUtils.pages;

import Cucumber.Utils.DriverUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
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

    @FindBy(css = "th")
    public List<WebElement> headersList;

    @FindBy(css = "p")
    public WebElement contentHolder;

    @FindBy(css = "a.button:first-child")
    public WebElement blueButton;

    @FindBy(css = "a.button.alert")
    public WebElement redButton;

    @FindBy(css = "a.button.success")
    public WebElement greenButton;

    @FindBy(css = "img")
    public WebElement redirectTop;

    @FindBy(css = "div#page-footer a")
    public WebElement redirectBottom;

    @FindBy(css ="div>script")
    public WebElement canvasScript;

    public List<WebElement> cellList(String i){
        return getDriver().findElements(By.cssSelector("tr:nth-child("+i+")>td"));
    }
    public void navigate(String url){
        pages.getDriver().navigate().to(url);
    }

}



