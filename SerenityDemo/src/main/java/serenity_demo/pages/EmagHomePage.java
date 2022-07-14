package serenity_demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class EmagHomePage extends PageObject {
    @FindBy(css = ".cookie-banner-buttons .js-accept")
    public WebElementFacade agreeCookiePolicyBtn;

    @FindBy(id = "my_cart")
    public WebElementFacade cartBtn;

    @FindBy(css = ".navbar-cart-dropdown p")
    public WebElementFacade navbarCartDropdownMessage;

    @FindBy(id = "searchboxTrigger")
    public WebElementFacade searchField;
}