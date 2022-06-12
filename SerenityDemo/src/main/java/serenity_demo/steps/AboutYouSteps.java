package serenity_demo.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.SoftAssertions;
import serenity_demo.pages.AboutYouPage;

public class AboutYouSteps extends ScenarioSteps {

    private SoftAssertions softly = new SoftAssertions();

    AboutYouPage aboutYouPage;

    @Step("Empty verification Template")
    public void emptyVerificationTemplate() {
        softly.assertThat(getDriver().getCurrentUrl()).contains("/").as("This message will be displayed if the assert fails in the console");
    }

    @Step("Open page")
    public void open(String url) {
        getDriver().get(url);
    }

    @Step("Click buttons")
    public void clickButtons(){
        aboutYouPage.acceptLngButton.click();
        aboutYouPage.acceptPrivacyButton.click();
        aboutYouPage.clickSearchButton.click();
    }

    @Step("STEP: I input the string rochii")
    public void inputString(String something){
        aboutYouPage.searchField.sendKeys(something);
        aboutYouPage.searchField.submit();
    }

    @Step("STEP: I verify it the string rochii is present in the results at least once")
    public void verifySearchResultsTitles(String something) {
        System.out.println("The number of search results titles is: " + aboutYouPage.resultsTitles.size());
        for (WebElementFacade element : aboutYouPage.resultsTitles) {
            softly.assertThat(element.getAttribute("textContent").toLowerCase()).contains(something);
            softly.assertAll();
        }
    }

}
