package serenity_demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class LoginPage extends PageObject {
    @FindBy(css = "input[autocomplete='username']")
    public WebElementFacade usernameInput;
    @FindBy(css = "input[autocomplete='password']")
    public WebElementFacade passwordInput;
    @FindBy(css = "form.ng-valid button")
    public WebElementFacade submitButton;
}