package serenity_demo;

import net.serenitybdd.core.exceptions.NoSuchElementException;
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

@Story(ValueListsNoPermissionsStory.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WithTag("Smoke")
public class ValueListsNoPermissionsStory {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    private TregSteps tregSteps;

    @Before
    public void init() {
        tregSteps.open("http://localhost:8080/tpr/tpr/dashboard");
        tregSteps.inputUsername(TregTestData.limitedRightsUsername);
        tregSteps.inputPassword(TregTestData.limitedRightsPassword);
    }

//    @Test
//    @WithTag("ValueListsOverview1")
//    @Title("01 Test of the overview of value lists")
//    public void T01valueListsOverviewTest1() {
//        try {
//            tregSteps.openMenu();
//        }
//        catch (NoSuchElementException) {
//            System.out.println("This test is supposed to fail");
//        }
//    }
}