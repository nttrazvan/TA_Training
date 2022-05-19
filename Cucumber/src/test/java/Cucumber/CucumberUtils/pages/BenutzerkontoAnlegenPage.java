package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BenutzerkontoAnlegenPage extends PageObject {

    public BenutzerkontoAnlegenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "button-2")
    public WebElement createUserButton;


    public void navigate(String url){
        getDriver().navigate().to(url);
    }

}



