package serenity_demo;

import io.cucumber.java.sl.In;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import serenity_demo.steps.EmagHomeSteps;

@Story(EmptyTemplateStory.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WithTag("EmagHome")
public class EmagTemplateStory {

    @Managed(uniqueSession = false)
    public WebDriver webDriver;

    @Steps
    private EmagHomeSteps emagHomeSteps;

    @Before
    public void init() throws InterruptedException {
        emagHomeSteps.open("https://www.emag.ro");
        emagHomeSteps.agreePrivacyPolicy();
    }

    @Test
    @WithTag("EmagHome CheckCart")
    @Title("Verify cart is empty")
    public void VerifyCartIsEmpty() throws InterruptedException {
        emagHomeSteps.hoverCartButton();
        emagHomeSteps.verifyCart("nu ai niciun produs în coș");
    }
}