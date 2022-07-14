package serenity_demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class EmptyTemplatePage extends PageObject {
    @FindBy(css = "CSS Selector goes here")
    public WebElementFacade emptyElementTemplate;

    @FindBy(css = "input[title='Search']")
    public WebElementFacade searchField;

    @FindBy(xpath = "//div //a/h3")
    public List<WebElementFacade> resultsTitles;

    @FindBy(xpath = "//*[contains(text(),'Accept all')]")
    public WebElementFacade acceptPrivacyBtn;
}