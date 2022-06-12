package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonTemplatePage extends PageObject {

    public AmazonTemplatePage(WebDriver driver) {
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

    public void navigate(String url){
        getDriver().navigate().to(url);
    }

}



