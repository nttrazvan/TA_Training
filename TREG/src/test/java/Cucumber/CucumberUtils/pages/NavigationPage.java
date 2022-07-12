package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
public class NavigationPage extends PageObject {/*ToDo - please add spaces before and after class declaration*/
    //ToDo - please add empty lines between the elements
    @FindBy(css = "span.menu-button")
    public WebElementFacade menuButton;
    @FindBy(xpath = "//span[contains(text(),'Wertelistenverwaltung')]")
    public WebElementFacade valueListsOverview;
    @FindBy(css = " a[href='/tpr/tpr/home']")
    public WebElementFacade dashboardButton;
    @FindBy(xpath = "//span[text()='Benutzerverwaltung']")
    public WebElementFacade userOverview;
}
//ToDo - please remove redundant empty lines


