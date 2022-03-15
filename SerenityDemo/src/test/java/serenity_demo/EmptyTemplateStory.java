package serenity_demo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import serenity_demo.steps.EmptyTemplateSteps;

@Story(EmptyTemplateStory.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WithTag("Smoke")
public class EmptyTemplateStory {

    @Managed(uniqueSession = false)
    public WebDriver webDriver;

    @Steps
    private EmptyTemplateSteps emptyTemplateSteps;

    @Before
    public void init() {
        emptyTemplateSteps.open("http://www.google.com/en");
        emptyTemplateSteps.dismissPrivacyPolicy();
    }

    @Test
    @WithTag("SomeTag1")
    @Title("01 Some test that tests something")
    public void T01someEmptyTest1() {
        emptyTemplateSteps.inputString("summer");
        emptyTemplateSteps.verifySearchResultsTitles("summer");
    }

    @Test
    @WithTag("SomeTag2")
    @Title("02 Some test that tests something")
    public void T02someEmptyTest2() {
        emptyTemplateSteps.inputString("Winter");
        emptyTemplateSteps.verifySearchResultsTitles("winter");
    }

    @Test
    @WithTag("SomeTag3")
    @Title("03 Some test that tests something")
    public void T03someEmptyTest3() {
        emptyTemplateSteps.inputString("summer");
        emptyTemplateSteps.verifySearchResultsTitles("test will fail here");
    }
}