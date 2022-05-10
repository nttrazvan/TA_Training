package serenity_demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DashboardPage extends PageObject {
    @FindBy(css = "span.menu-button")
    public WebElementFacade menuButton;

    @FindBy(css = "body > tpr-root > tpr-header > div.header.background-white > div > div.d-flex.align-items-center > p-menu > div > ul > li:nth-child(6) > a > span")
    public WebElementFacade valueLists;
    
}