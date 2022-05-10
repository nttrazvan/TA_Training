package serenity_demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ValueListAddressEditPage extends PageObject {

    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/edit/26']")
    public WebElementFacade editButtonAddress;

    @FindBy(css = "span.isy-panel-title")
    public WebElementFacade tableTitle;
}