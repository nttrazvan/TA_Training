package serenity_demo.steps;


import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.SoftAssertions;
import serenity_demo.pages.DashboardPage;
import serenity_demo.pages.LoginPage;
import serenity_demo.pages.ValueListAddressEditPage;
import serenity_demo.pages.ValueListsOverviewPage;

public class TregSteps extends ScenarioSteps {
    private SoftAssertions softly = new SoftAssertions();

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ValueListsOverviewPage valueListsOverviewPage;
    private final String valueListsOverviewTableTitle = "Wertelisten Übersicht";
    private final String valueListsOverviewTableHeader = " Bezeichnung Werteliste";
    private ValueListAddressEditPage valueListAddressEditPage;
    private final String valueListAddressEditTableTitle = "Adressmuster und -hinweise";

    @Step("Empty verification Template")
    public void emptyVerificationTemplate() {
        softly.assertThat(getDriver().getCurrentUrl()).contains("/").as("This message will be displayed if the assert fails in the console");
    }

    @Step("Open page")
    public void open(String url) {
        getDriver().navigate().to(url);
        getDriver().manage().window().maximize();
    }

    @Step("STEP: I input the username")
    public void inputUsername(String something) {
        loginPage.usernameInput.sendKeys(something);
    }

    @Step("STEP: I input the password and submit")
    public void inputPassword(String something){
         loginPage.passwordInput.sendKeys(something);
         loginPage.submitButton.submit();
    }

    @Step("STEP: I open the menu")
    public void openMenu(){
        dashboardPage.menuButton.click();
        dashboardPage.valueLists.click();
    }

    @Step("STEP: I validate the title of the table")
    public void validateTitle(){
        Assert.assrt(valueListsOverviewPage.tableTitle.getAttribute("textContent").contains(valueListsOverviewTableTitle));
        System.out.println(valueListsOverviewPage.tableTitle.getAttribute("textContent"));
    }

    @Step("STEP: I validate the header of the table")
    public void validateHeader(){
        Assert.assrt(valueListsOverviewPage.tableHeader.getAttribute("textContent").contains(valueListsOverviewTableHeader));
        System.out.println(valueListsOverviewPage.tableHeader.getAttribute("textContent"));
    }

    @Step("STEP: I open the list of Addresses in the edit mode")
    public void openAddressListInEditMode(){
        valueListAddressEditPage.editButtonAddress.click();
        Assert.assrt(valueListAddressEditPage.tableTitle.getAttribute("textContent").contains(valueListAddressEditTableTitle));
        System.out.println(valueListAddressEditPage.tableTitle.getAttribute("textContent"));
    }
}