package Cucumber.CucumberUtils.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends PageObject {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.menu-button")
    public WebElementFacade menuButton;

    @FindBy(xpath = "//span[contains(text(),'Wertelistenverwaltung')]")
    public WebElementFacade valueListsOverview;

    @FindBy(css = " a[href='/tpr/tpr/home']")
    public WebElementFacade dashboardButton;


}



