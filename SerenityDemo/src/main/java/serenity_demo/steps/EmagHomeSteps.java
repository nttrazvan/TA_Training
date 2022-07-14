package serenity_demo.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.interactions.Actions;
import serenity_demo.pages.EmagHomePage;

public class EmagHomeSteps extends ScenarioSteps {
    private SoftAssertions softly = new SoftAssertions();

    private EmagHomePage emagHomePage;

    @Step("Empty verification Template")
    public void emptyVerificationTemplate() {
        softly.assertThat(getDriver().getCurrentUrl()).contains("/").as("This message will be displayed if the assert fails in the console");
    }

    @Step("Open page")
    public void open(String url) {
        getDriver().navigate().to(url);
    }

    @Step("Agree privacy policy")
    public void agreePrivacyPolicy() throws InterruptedException {
        Thread.sleep(2000);
        emagHomePage.agreeCookiePolicyBtn.click();
    }

    @Step("Hover cart button")
    public void hoverCartButton() throws InterruptedException {
        Actions action = new Actions(getDriver());
        action.moveToElement(emagHomePage.cartBtn).build().perform();
        Thread.sleep(500);
    }

    @Step("STEP: I verify the cart")
    public void verifyCart(String message){
        softly.assertThat(emagHomePage.navbarCartDropdownMessage.getAttribute("textContent").toLowerCase()).contains(message);
        softly.assertAll();
    }
}