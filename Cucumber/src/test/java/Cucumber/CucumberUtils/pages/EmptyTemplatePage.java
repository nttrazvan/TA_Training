package Cucumber.CucumberUtils.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EmptyTemplatePage extends PageObject {

    public EmptyTemplatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "css identifier goes here")
    public WebElement elementTemplate;

    @FindBy(xpath = "//*[contains(text(),'I agree')]")
    public WebElement acceptPrivacyBtn;

    @FindBy(css = "input[title='Search']")
    public WebElement searchField;

    @FindBy(xpath = "//div //a/h3")
    public List<WebElement> resultsTitles;

    @FindBy(xpath = "//div/p")
    public WebElementFacade contentParagraph;

    @FindBy(css = "a[class='button']")
    public WebElementFacade blueButton;

    @FindBy(css = "a[class='button alert']")
    public WebElementFacade redButton;

    @FindBy(css = "a[class='button success']")
    public WebElementFacade greenButton;

    @FindBy(id = "canvas")
    public WebElementFacade canvas;

}



