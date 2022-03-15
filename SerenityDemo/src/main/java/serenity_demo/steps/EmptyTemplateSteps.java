package serenity_demo.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.SoftAssertions;
import serenity_demo.pages.EmptyTemplatePage;

public class EmptyTemplateSteps extends ScenarioSteps {
    private SoftAssertions softly = new SoftAssertions();
    private EmptyTemplatePage emptyTemplatePage;

    @Step("Empty verification Template")
    public void emptyVerificationTemplate() {
        softly.assertThat(getDriver().getCurrentUrl()).contains("/").as("This message will be displayed if the assert fails in the console");
    }

    @Step("Open page")
    public void open(String url) {
        getDriver().navigate().to(url);
    }

    @Step("Dismiss privacy policy")
    public void dismissPrivacyPolicy(){
        emptyTemplatePage.acceptPrivacyBtn.click();
    }

    @Step("STEP: I input the string")
    public void inputString(String something){
        emptyTemplatePage.searchField.sendKeys(something);
        emptyTemplatePage.searchField.submit();
    }

    @Step("STEP: I verify it the string is present in the results at least once")
    public void verifySearchResultsTitles(String something) {
        System.out.println("The number of search results titles is: " + emptyTemplatePage.resultsTitles.size());
        for (WebElementFacade element : emptyTemplatePage.resultsTitles) {
            softly.assertThat(element.getAttribute("textContent").toLowerCase()).contains(something);
            softly.assertAll();
        }
    }
}