package serenity_demo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import serenity_demo.steps.TregSteps;
import serenity_demo.testData.TregTestData;

@Story(ValueListsStory.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WithTag("Smoke")
public class ValueListsStory {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    private TregSteps tregSteps;

    @Before
    public void init() {
        tregSteps.open("http://localhost:8080/tpr/tpr/dashboard");
        tregSteps.inputUsername(TregTestData.fullRightsUsername1);
        tregSteps.inputPassword(TregTestData.fullRightsPassword1);
    }

    @Test
    @WithTag("ValueListsOverview")
    @Title("01 Test of the overview of value lists")
    public void T01valueListsOverviewTest() {
        tregSteps.openMenu();
        tregSteps.openValueListsOverview();
        tregSteps.validateTitle();
        tregSteps.validateHeader();
    }

    @Test
    @WithTag("AddressNotes")
    @Title("02 Edit Page for the list Adressmuster und -hinweise")
    public void T02editPageAddresses() {
        tregSteps.openMenu();
        tregSteps.openValueListsOverview();
        tregSteps.openAddressListInEditMode();
    }
}