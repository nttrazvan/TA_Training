package serenity_demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class AboutYouPage extends PageObject {

    @FindBy(css = "This is for CSS Selector")
    WebElementFacade aboutYouTemplate;

    @FindBy(css = "button[data-test-id='SearchButton']")
    public WebElementFacade clickSearchButton;

    @FindBy(css = "input[value placeholder='Caută după branduri, articole & multe altele...']")
    public WebElementFacade searchField;

    @FindBy(xpath = "//div //ul/a")
    public List<WebElementFacade> resultsTitles;

    @FindBy(xpath = "//*[contains(text(),'Continuă cumpărăturile în aboutyou.ro')]")
    public WebElementFacade acceptLngButton;

    @FindBy(xpath = "//*[contains(text(),'Ok')]")
    public WebElementFacade acceptPrivacyButton;
}
