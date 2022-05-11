package serenity_demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DashboardPage extends PageObject {
    @FindBy(css = "span.menu-button")
    public WebElementFacade menuButton;

    @FindBy(xpath = "//span[contains(text(),'Wertelistenverwaltung')]")
    public WebElementFacade valueLists;
    
}