package Cucumber.CucumberUtils.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreateUserPage extends PageObject {

    @FindBy(xpath = "//isy-page-toolbar-functions//button")
    public WebElementFacade createUserButton;

    @FindBy(id = "vorname")
    public WebElementFacade inputFirstName;

    @FindBy(id = "name")
    public WebElementFacade inputLastName;

    @FindBy(id = "email")
    public WebElementFacade inputEmail;

    @FindBy(xpath = "//isy-dropdown-item")
    public WebElementFacade inputPhoneNumber;

    @FindBy(css = "input[inputid='durchwahl']")
    public WebElementFacade inputExtension;

    @FindBy(xpath = "//a//span[contains(text(),' Referats- und Rollenzuordnung ')]")
    public WebElementFacade navigateSecondTab;

}



