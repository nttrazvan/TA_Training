package Cucumber.CucumberUtils.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ValueListsOverviewPage extends PageObject {

    //Table title
    @FindBy(css = "span.isy-panel-title")
    public WebElementFacade tableTitle;
    // Table Header
    @FindBy(xpath = "//span[text()=' Bezeichnung Werteliste']")
    public WebElementFacade tableHeaderFirstColumn;
    @FindBy(xpath = "//span[text()=' Typ']")
    public WebElementFacade tableHeaderSecondColumn;
    @FindBy(xpath = "//span[contains(text(),' Aktionen')]")
    public WebElementFacade tableHeaderActions;
    //Table Data
    @FindBy(xpath = "//span[text()='Adressmuster und -hinweise']")
    public WebElementFacade addressList;
    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/view/26']")
    public WebElementFacade viewAddressButton;
    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/edit/26']")
    public WebElementFacade editAddressButton;
    @FindBy(xpath = "//span[text()='Faxnummer']")
    public WebElementFacade faxnummerList;
    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/view/2']")
    public WebElementFacade viewFaxnummerButton;
    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/edit/2']")
    public WebElementFacade editFaxnummerButton;
    // Table standard design
    @FindBy(xpath = "//div[text()='Treffer pro Seite']")
    public WebElementFacade paginator;

    @FindBy(xpath = "//span[text()=' Bezeichnung Werteliste']")
    public WebElementFacade sortingButton;

    @FindBy(css = "div.table-buttons")
    public WebElementFacade filteringButton;

    @FindBy(css = "tpr-table-filter-cell")
    public WebElementFacade filterLine;

    @FindBy(css = "input")
    public WebElementFacade inputFilterLine;

}


