package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.pages.LoginPage;
import Cucumber.CucumberUtils.steps.LoginSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.AfterClass;
import java.io.IOException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginStepDefs {
    private LoginPage loginPage;
    @Steps
    private LoginSteps loginSteps;

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
    public void tearDown() {
        getDriver().quit();
    }

    @Given("I open the browser to {string}")
    public void openLoginPage(String url) {
        loginSteps.openLoginPage(url);
    }

    @And("I first enter the username {string}")
    public void inputUsername(String something) {
        loginSteps.inputUsername(something);
    }

    @And("I then enter the password {string} and press submit")
    public void inputPasswordAndSubmit(String something) {
        loginSteps.inputPassword(something);
    }
}