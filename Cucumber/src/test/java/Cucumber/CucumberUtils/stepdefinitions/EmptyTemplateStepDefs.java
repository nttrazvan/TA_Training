package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.pages.EmptyTemplatePage;
import Cucumber.CucumberUtils.steps.EmptyTemplateSteps;
import Cucumber.Utils.DriverUtils;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.AfterClass;

import java.io.IOException;
import static Cucumber.Utils.DriverUtils.setEnvironment;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

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
        getDriver().get("http://the-internet.herokuapp.com/challenging_dom");
    }

    @AfterClass
    public void tearDown(){
        getDriver().quit();
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

    @When("^And the Header contains \"([^\"]*)\"$")
    public void checkHeader(String headers){
        emptyTemplateSteps.checkHeader(headers);
    }

    @Then("^The table content should be \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void tableContains(String index, String col1, String col2, String col3, String col4,String col5,String col6,String col7) throws InterruptedException {
        emptyTemplateSteps.tableContains(index, col1,col2,col3,col4,col5,col6,col7);
    }

    @Given("^The title is \"([^\"]*)\"$")
    public void checkTitle(String title){
        emptyTemplateSteps.checkTitle(title);
    }

    @And("^The content matches$")
    public void theContentMatches(){
        emptyTemplateSteps.theContentMatches();
    }

    @When("^I click the \"([^\"]*)\" button and verify it has text$")
    public void iClickTheShomethingButtonAndVerifyItHasText(String button){
        emptyTemplateSteps.clickAndVerifyButton(button);
    }

    @When("^I verify the canvas has a number$")
    public void iVerifyCanvasHasNumbers(){
        emptyTemplateSteps.iVerifyCanvasHasNumbers();
    }

    @Then("^I verify the top redirect$")
    public void checkTopRedirect(){
        emptyTemplateSteps.checkTopRedirect();
    }

    @Then("^I navigate back$")
    public void iNavigateBack(){
        emptyTemplateSteps.navigateBack();
    }

    @And("^I verify the bottom redirect$")
    public void checkBottomRedirect() throws InterruptedException {
        emptyTemplateSteps.checkBottomRedirect();
    }

    @Then("^I close the opened tab$")
    public void closeOpenedTab(){
        emptyTemplateSteps.closeTab();
    }
}
