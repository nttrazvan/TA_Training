package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.pages.BenutzerverwaltungPage;
import Cucumber.CucumberUtils.pages.DashboardPage;
import Cucumber.CucumberUtils.pages.EmptyTemplatePage;
import Cucumber.CucumberUtils.pages.LoginPage;
import Cucumber.CucumberUtils.steps.BenutzerverwaltungSteps;
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

public class BenutzerverwaltungStepDefs {
    private LoginPage loginPage;
    private BenutzerverwaltungPage benutzerverwaltungPage;
    private DashboardPage dashboardPage;

    //Do not delete
    @Before("@Web")
    public void setUp() throws IOException {
        Serenity.initializeTestSession();
        getDriver();
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String property = variables.getProperty("webdriver.set.fullscreen");
        if (property.contains("true")) {
            loginPage.getDriver().manage().window().maximize();
        }
    }

    @AfterClass
    public void tearDown(){
        getDriver().quit();
    }

    @Steps
    private BenutzerverwaltungSteps benutzerverwaltungSteps;

    @Given("I open the browser to {string}")
    public void navigate(String url){
        benutzerverwaltungSteps.navigate(url);
    }

    @Given("I first enter the {string}")
    public void inputUsername(String something) {
        benutzerverwaltungSteps.inputUsername(something);
    }

    @Given("I then enter the {string} and press submit")
    public void inputPassword(String something) {
        benutzerverwaltungSteps.inputPassword(something);
    }

    @Given("I navigate to the user overview")
    public void navigateUserOverview(){
        benutzerverwaltungSteps.openMenu();
        benutzerverwaltungSteps.openUserOverview();
    }

    @And("I click the button to create a user")
    public void openUserCreation(){
        benutzerverwaltungSteps.openUserCreation();
    }

    @Then("I verify the title of the creation user page")
    public void verifyCreationUserTitle(){
        benutzerverwaltungSteps.verifyTitleUserCreationPage();
    }
}
