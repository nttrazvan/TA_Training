package serenity_demo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import serenity_demo.steps.AboutYouSteps;
import serenity_demo.steps.EmptyTemplateSteps;

@Story(AboutYouStory.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WithTag("SmokeTest")
public class AboutYouStory {

    @Managed(uniqueSession = false)
    public WebDriver webDriver;

    @Steps
    private AboutYouSteps aboutYouSteps;

    @Before
    public void init() {
        aboutYouSteps.open("https://www.aboutyou.ro/");
        aboutYouSteps.clickButtons();
    }

    @Test
    @WithTag("Tag1")
    @Title("01 Test for search rochii")
    public void test1() {
        aboutYouSteps.inputString("rochii");
        aboutYouSteps.verifySearchResultsTitles("rochii");
    }
}
