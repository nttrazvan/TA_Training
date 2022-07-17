package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmagHomePage extends PageObject {

    public EmagHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cookie-banner-buttons .js-accept")
    public WebElement agreeCookiePolicyBtn;

    @FindBy(id = "my_cart")
    public WebElement cartBtn;

    @FindBy(css = ".navbar-cart-dropdown p")
    public WebElement navbarCartDropdownMessage;

    @FindBy(id = "searchboxTrigger")
    public WebElement searchField;

}



