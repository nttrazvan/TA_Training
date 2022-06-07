package Cucumber.CucumberUtils.stepsdefinitions;
import Cucumber.CucumberUtils.pages.EmptyTemplatePage;
import Cucumber.CucumberUtils.steps.EmptyTemplateSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.AfterClass;
import java.io.IOException;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class EmptyTemplateStepDefs {
    private EmptyTemplatePage emptyTemplatePage;
    @Steps
    private EmptyTemplateSteps emptyTemplateSteps;

    //Do not delete
    @Before("@Web")
    public void setUp() throws IOException {
        Serenity.initializeTestSession();
        getDriver();
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String property = variables.getProperty("webdriver.set.fullscreen");
        if (property.contains("true")) {
            emptyTemplatePage.getDriver().manage().window().maximize();
        }
    }

    @AfterClass
    public void tearDown(){
        getDriver().quit();
    }

    @Given("I open the browser to the page {string}")
    public void openBrowser(String url) {
        emptyTemplateSteps.navigate(url);
    }

    @When("This is an empty template without parameters")
    public void emptyTemplateNoParameter() {
        //I link the Gherkin(cucumber narrative) to java
    }

    @Given("This is an empty template with one parameter {int}")
    public void emptyTemplateOneParameter(int initialValueParameter) {
        emptyTemplateSteps.stepWithOneParameter(initialValueParameter);
    }

    @Then("This is an empty template with 2 parameters {int} and {int}")
    public void emptyTemplateMultipleParameters(int firstParameter, int secondParameter) {
        emptyTemplateSteps.stepWithTwoParameters(firstParameter, secondParameter);
    }



    @And("I search for the string {string}")
    public void searchForString(String something){
        emptyTemplateSteps.inputString(something);
    }

    @When("I dismiss the privacy policy")
    public void dismissPrivacyPolicy(){
        emptyTemplateSteps.dismissPrivacyPolicy();
    }

    @Then("The results contain {string}")
    public void verifySearchResultsTitles(String something){
        emptyTemplateSteps.verifySearchResultsTitles(something);
    }

    @When("And the Header contains {string}")
    public void checkHeader(String headers){
        emptyTemplateSteps.checkHeader(headers);
    }

    @Then("The table content should be {string} {string} {string} {string} {string} {string} {string} {string}")
    public void tableContains(String index, String col1, String col2, String col3, String col4,String col5,String col6,String col7) throws InterruptedException {
        emptyTemplateSteps.tableContains(index, col1,col2,col3,col4,col5,col6,col7);
    }

    @Given("The title is {string}")
    public void checkTitle(String title){
        emptyTemplateSteps.checkTitle(title);
    }

    @And("The content matches")
    public void theContentMatches(){
        emptyTemplateSteps.theContentMatches();
    }

    @When("I click the {string} button and verify it has text")
    public void iClickTheShomethingButtonAndVerifyItHasText(String button){
        emptyTemplateSteps.clickAndVerifyButton(button);
    }

    @When("I verify the canvas has a number")
    public void iVerifyCanvasHasNumbers(){
        emptyTemplateSteps.iVerifyCanvasHasNumbers();
    }

    @Then("I verify the top redirect")
    public void checkTopRedirect(){
        emptyTemplateSteps.checkTopRedirect();
    }

    @Then("I navigate back")
    public void iNavigateBack(){
        emptyTemplateSteps.navigateBack();
    }

    @And("I verify the bottom redirect")
    public void checkBottomRedirect() throws InterruptedException {
        emptyTemplateSteps.checkBottomRedirect();
    }

    @Then("I close the opened tab")
    public void closeOpenedTab(){
        emptyTemplateSteps.closeTab();
    }
}
