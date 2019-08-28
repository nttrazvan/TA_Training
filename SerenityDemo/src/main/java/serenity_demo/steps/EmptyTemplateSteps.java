package serenity_demo.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import serenity_demo.pages.EmptyTemplatePage;

import static junit.framework.TestCase.assertTrue;

public class EmptyTemplateSteps extends ScenarioSteps {

    private EmptyTemplatePage emptyTemplatePage;

    @Step("Empty verification Template")
    public void emptyVerificationTemplate() {
        assertTrue("This message will be displayed if the assert fails in the console",
                getDriver().getCurrentUrl().contains("/"));
    }

    @Step("Open page")
    public void open(String url) {
        getDriver().navigate().to(url);
    }

    @Step("STEP: I input the string")
    public void inputString(String something){
        emptyTemplatePage.searchField.sendKeys(something);
        emptyTemplatePage.searchField.submit();
    }

    @Step("STEP: I verify it the string is present in the results at least once")
    public void verifySearchResultsTitles(String something){
        System.out.println("The number of search results titles is: " + emptyTemplatePage.resultsTitles.size());
        boolean exitResult = false;
        int index = 0;
        for(WebElementFacade element : emptyTemplatePage.resultsTitles){
            int i = emptyTemplatePage.resultsTitles.indexOf(element) + 1;
            if (element.getAttribute("textContent").toLowerCase().contains(something)){
                System.out.println("The title numbered: " + i + " contains the string: " + something);
                exitResult = true;
            } else {
                System.out.println("The title numbered: " + i + " does not contain the string: " + something);}
        }
        assertTrue("This message will be thrown when the test does not pass in the console",
                exitResult);
    }
}