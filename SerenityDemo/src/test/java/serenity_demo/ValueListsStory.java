package serenity_demo;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import serenity_demo.pages.DashboardPage;
import serenity_demo.steps.*;
import serenity_demo.testData.TregTestData;

@Story(ValueListsStory.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WithTag("Smoke")
public class ValueListsStory {

    @Managed(uniqueSession = true)
    public WebDriver webDriver = new ChromeDriver();

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private GenericSteps genericSteps;
    @Steps
    private ValueListAddressEditSteps valueListAddressEditSteps;
    @Steps
    private ValueListOverviewSteps valueListOverviewSteps;

    @Before
    public void init() {
        loginSteps.open("http://localhost:8080/tpr/tpr/dashboard");
        loginSteps.inputUsername(TregTestData.fullRightsUsername1);
        loginSteps.inputPassword(TregTestData.fullRightsPassword1);
    }

    @Test
    @WithTag("ValueListsOverview")
    @Title("01 Test of the overview of value lists")
    public void T01valueListsOverviewTest() {
        genericSteps.openMenu();
        dashboardSteps.openValueListsOverview();
        valueListOverviewSteps.validateTitle();
        valueListOverviewSteps.validateHeader();
    }

    @Test
    @WithTag("AddressNotes")
    @Title("02 Edit Page for the list Adressmuster und -hinweise")
    public void T02editPageAddresses() {
        genericSteps.openMenu();
        dashboardSteps.openValueListsOverview();
        valueListAddressEditSteps.openAddressListInEditMode();
    }
}