package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.pages.AmazonTemplatePage;
import Cucumber.CucumberUtils.steps.AmazonTemplateSteps;
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

public class AmazonStepDefs {

    private AmazonTemplatePage amazonTemplatePage;

    @Before("@Web")
    public void setUp() throws IOException {
        Serenity.initializeTestSession();
        getDriver();
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String property = variables.getProperty("webdriver.set.fullscreen");
        if (property.contains("true")) {
            amazonTemplatePage.getDriver().manage().window().maximize();
        }
    }

    @AfterClass
    public void tearDown(){
        getDriver().quit();
    }

    @Steps
    private AmazonTemplateSteps amazonTemplateSteps;

    @Given("I navigate to the Amazon DE {string} URL")
    public void navigate(String url){
        amazonTemplateSteps.navigate(url);
    }

    @And("I search for the string {string}")
    public void searchForString(String something){
        amazonTemplateSteps.inputString(something);
    }

    @When("I dismiss the privacy policy")
    public void dismissPrivacyPolicy(){
        amazonTemplateSteps.dismissPrivacyPolicy();
    }

    @Then("The results contain {string}")
    public void verifySearchResultsTitles(String something){
        amazonTemplateSteps.verifySearchResultsTitles(something);
    }
}
