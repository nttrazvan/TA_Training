package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.EmagHomePage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.interactions.Actions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class EmagHomeSteps {
    private EmagHomePage emagHomePage;
    private SoftAssertions softly = new SoftAssertions();

    @Step()
    public void agreePrivacyPolicy() throws InterruptedException {
        Thread.sleep(2000);
        emagHomePage.agreeCookiePolicyBtn.click();
    }

    @Step()
    public void hoverCartButton() throws InterruptedException {
        Actions action = new Actions(getDriver());
        action.moveToElement(emagHomePage.cartBtn).build().perform();
        Thread.sleep(500);
    }

    @Step()
    public void verifyCart(String message) {
        softly.assertThat(emagHomePage.navbarCartDropdownMessage.getAttribute("textContent").toLowerCase()).contains(message);
        softly.assertAll();
    }
}