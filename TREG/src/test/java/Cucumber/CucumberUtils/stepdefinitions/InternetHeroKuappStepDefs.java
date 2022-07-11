package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.pages.InternetHerokuappPage;
import Cucumber.CucumberUtils.steps.InternetHerokuappSteps;
import io.cucumber.datatable.DataTable;
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
import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class InternetHeroKuappStepDefs {
    private InternetHerokuappPage internetHerokuappPage;

    @Steps
    private InternetHerokuappSteps internetHerokuappSteps;


    @Before("@Web")
    public void setUp() throws IOException {
        Serenity.initializeTestSession();
        getDriver();
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String property = variables.getProperty("webdriver.set.fullscreen");
        if (property.contains("true")) {
            internetHerokuappPage.getDriver().manage().window().maximize();
        }
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }

    @Given("I open the browser to the page {string}")
    public void openBrowser(String url) {
        internetHerokuappSteps.navigate(url);
    }

    @When("And the Header contains")
    public void checkHeader(DataTable table) {
        List<String> headers = new ArrayList<>();
        headers.addAll(table.asList());
        internetHerokuappSteps.checkHeader(headers);
    }

    @Then("The table content should be {string} {string} {string} {string} {string} {string}")
    public void tableContains(String col1, String col2, String col3, String col4, String col5, String col6) throws InterruptedException {
        internetHerokuappSteps.tableContains(col1, col2, col3, col4, col5, col6);
    }

    @Given("The title is {string}")
    public void checkTitle(String expectedTitle) {
        internetHerokuappSteps.checkTitle(expectedTitle);
    }

    @And("The content matches")
    public void theContentMatches() {
        internetHerokuappSteps.theContentMatches();
    }

    @When("I click the {string} button and verify it has text")
    public void iClickTheShomethingButtonAndVerifyItHasText(String button) {
        internetHerokuappSteps.clickAndVerifyButton(button);
    }

    @When("I verify the canvas has a number")
    public void iVerifyCanvasHasNumbers() {
        internetHerokuappSteps.iVerifyCanvasHasNumbers();
    }

    @And("I validate {string} bottom link and close the tab")
    public void checkBottomRedirect(String pageTitle) throws InterruptedException {
        internetHerokuappSteps.checkBottomRedirect(pageTitle);
    }

    @And("I validate {string} top link and navigate back")
    public void checkTopRedirect(String pageTitle) throws InterruptedException {
        internetHerokuappSteps.checkTopRedirect(pageTitle);
        internetHerokuappSteps.navigateBack();
    }

}
