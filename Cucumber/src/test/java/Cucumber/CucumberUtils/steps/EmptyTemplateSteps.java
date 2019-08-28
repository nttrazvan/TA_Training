package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.EmptyTemplatePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class EmptyTemplateSteps {
    private EmptyTemplatePage emptyTemplatePage;
    private int initialValue = 0;

    @Step("I set the value of the int initialValue to the given parameter")
    public void stepWithOneParameter(int initialValueParameter) {
        initialValue = initialValueParameter;
    }

    @Step("I verify the initialParameter + firstParameter = secondParameter")
    public void stepWithTwoParameters(int firstParameter, int secondParameter) {
        assertTrue("This message will be thrown when the test does not pass in the console",
                initialValue + firstParameter == secondParameter);
    }

    @Step("STEP: I navigate to URL")
    public void navigate(String url){
        emptyTemplatePage.navigate(url);
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
        for(WebElement element : emptyTemplatePage.resultsTitles){
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
