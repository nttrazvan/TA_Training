package serenity_demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ValueListsOverviewPage extends PageObject {

    @FindBy(css = "span.isy-panel-title")
    public WebElementFacade tableTitle;

    @FindBy(css = "tpr-table-header-cell")
    public WebElementFacade tableHeader;
}