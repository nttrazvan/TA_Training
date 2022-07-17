package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.pages.EmagHomePage;
import Cucumber.CucumberUtils.steps.EmagHomeSteps;
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

public class EmagHomeStepDefs {
    private EmagHomePage emagHomePage;

    //Do not delete
    @Before("@Web")
    public void setUp() throws IOException {
        Serenity.initializeTestSession();
        getDriver();
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String property = variables.getProperty("webdriver.set.fullscreen");
        if (property.contains("true")) {
            emagHomePage.getDriver().manage().window().maximize();
        }
    }

    @AfterClass
    public void tearDown(){
        getDriver().quit();
    }

    @Steps
    private EmagHomeSteps emagHomeSteps;

    @When("I agree with privacy policy")
    public void agreePrivacyPolicy() throws InterruptedException {
        emagHomeSteps.agreePrivacyPolicy();
    }

    @And("I hover the cart button")
    public void searchForString() throws InterruptedException {
        emagHomeSteps.hoverCartButton();
    }

    @Then("The cart should contain text {string}")
    public void verifyCart(String message){
        emagHomeSteps.verifyCart(message);
    }

}
