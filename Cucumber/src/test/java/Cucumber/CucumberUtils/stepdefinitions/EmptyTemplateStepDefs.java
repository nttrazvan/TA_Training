package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.pages.EmptyTemplatePage;
import Cucumber.CucumberUtils.steps.EmptyTemplateSteps;
import Cucumber.Utils.DriverUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import java.io.IOException;
import static Cucumber.Utils.DriverUtils.setEnvironment;

public class EmptyTemplateStepDefs {
    private DriverUtils pages;
    private EmptyTemplatePage emptyTemplatePage;

    //Do not delete
    @cucumber.api.java.Before
    public void setUp() throws IOException {
        Serenity.initializeTestSession();
        setEnvironment();
        pages.getCurrentDriver();
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String property = variables.getProperty("webdriver.set.fullscreen");
        if (property.contains("true")) {
            emptyTemplatePage.getDriver().manage().window().maximize();
        }
    }

    @Steps
    private EmptyTemplateSteps emptyTemplateSteps;

    @When("^This is an empty template without parameters$")
    public void emptyTemplateNoParameter() {
        //I link the Gherkin(cucumber narrative) to java
    }

    @Given("^This is an empty template with one parameter \"([^\"]*)\"$")
    public void emptyTemplateOneParameter(int initialValueParameter) {
        emptyTemplateSteps.stepWithOneParameter(initialValueParameter);
    }

    @Then("^This is an empty template with 2 parameters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void emptyTemplateMultipleParameters(int firstParameter, int secondParameter) {
        emptyTemplateSteps.stepWithTwoParameters(firstParameter, secondParameter);
    }

    @Given("^I open the browser to \"([^\"]*)\"$")
    public void navigate(String url){
        emptyTemplateSteps.navigate(url);
    }

    @When("^I search for the string \"([^\"]*)\"$")
    public void searchForString(String something){
        emptyTemplateSteps.inputString(something);
    }

    @Then("^The results contain \"([^\"]*)\" at least once$")
    public void verifySearchResultsTitles(String something){
        emptyTemplateSteps.verifySearchResultsTitles(something);
    }
}
