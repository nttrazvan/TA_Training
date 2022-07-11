package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject {

    @FindBy(css = "input[autocomplete='username']")
    public WebElementFacade usernameInput;
    @FindBy(css = "input[autocomplete='password']")
    public WebElementFacade passwordInput;
    @FindBy(tagName = "button")
    public WebElementFacade submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}



