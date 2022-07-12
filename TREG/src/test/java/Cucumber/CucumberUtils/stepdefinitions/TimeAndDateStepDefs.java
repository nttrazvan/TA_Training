package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.pages.TimeAndDatePage;
import Cucumber.CucumberUtils.steps.TimeAndDateSteps;
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

public class TimeAndDateStepDefs {/*ToDo - please add spaces after class declaration*/
    private TimeAndDatePage timeAndDatePage;

    @Steps
    private TimeAndDateSteps timeAndDateSteps;

    @Before("@Web")
    public void setUp() throws IOException {
        Serenity.initializeTestSession();
        getDriver();
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String property = variables.getProperty("webdriver.set.fullscreen");
        if (property.contains("true")) {
            timeAndDatePage.getDriver().manage().window().maximize();
        }
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }

    @Given("I open the browser to the page containing a date calculator {string}")
    public void openBrowser(String url) {
        getDriver().navigate().to(url);
    }

    @When("I accept the privacy policy")
    public void iAcceptThePrivacyPolicy() {
        timeAndDateSteps.agreePrivacyPolicy();
    }

    @When("I select a start date: {int} {string} {int}")
    public void iSelectStartDate(int startDay,String startMonth, int startYear) throws InterruptedException {
        timeAndDateSteps.setStartDate(startDay,startMonth,startYear);
    }

    @And("I select an end date: {int} {string} {int}")/*ToDo - interrupted exception not needed*/
    public void iSelectEndDate(int endDay,String endMonth, int endYear) throws InterruptedException {
        timeAndDateSteps.setEndDate(endDay,endMonth,endYear);
    }

    @And("I submit the form including the end date")
    public void submitIncludingEndDate() throws InterruptedException {
        timeAndDateSteps.includeEndDate();
        timeAndDateSteps.submit();
    }

    @And("I submit the form excluding the end date")
    public void submitExcludingEndDate() throws InterruptedException {
        timeAndDateSteps.submit();
    }

    @Then("I calculate difference between start date and end date {string} the end date")
    public void iCalculateDifference(String considerEndDate) throws InterruptedException {
        timeAndDateSteps.calculateDifference(considerEndDate);
    }

    @Then("I validate the result on the page {string} the end date")
    public void iValidate(String considerEndDate) throws InterruptedException {
        timeAndDateSteps.validateResult(considerEndDate);
    }

    @And("I exclude weekends")
    public void iExcludeTheWeekends() throws InterruptedException {
        timeAndDateSteps.clickCountWorkDays();
        timeAndDateSteps.excludeWeekends();
    }

    @And("I calculate difference between start date and end date {string} the end date and excluding the weekends")
    public void iCalculateDifferenceBetweenStartDateAndEndDateTheEndDateAndExcludingTheWeekends(String considerEndDate) {
        timeAndDateSteps.calculateDifferenceExcludingWeekends(considerEndDate);
    }

    @Then("I validate the result on the page {string} the end date and excluding the weekends")
    public void iValidateTheResultOnThePageTheEndDateAndExcludingTheWeekends(String considerEndDate) {
        timeAndDateSteps.validateResultExcludingWeekends(considerEndDate);
    }

    @And("I include the end date")
    public void iIncludeTheEndDate() {
        timeAndDateSteps.includeEndDate();
    }

    @And("I submit the dates form")
    public void iSubmitTheDatesForm() throws InterruptedException {
        timeAndDateSteps.submit();
    }

    @And("I include only Public Holidays")
    public void iIncludeOnlyPublicHolidays() {
        timeAndDateSteps.clickCountWorkDays();
        timeAndDateSteps.selectIncludeOnly();
        timeAndDateSteps.selectOnlyWeekends();
    }

    @Then("I validate the result on the page including the end date and the public holidays")
    public void iValidateTheResultOnThePageTheEndDateAndThePublicHolidays() {
        timeAndDateSteps.validatePublicHolidaysOnly();
    }

    @And("I include only Weekends")
    public void iIncludeOnlyWeekends() {
        timeAndDateSteps.clickCountWorkDays();
        timeAndDateSteps.selectIncludeOnly();
        timeAndDateSteps.selectOnlyWeekends();
    }

    @And("I calculate difference between start date and end date {string} the end date and the weekends only")
    public void iCalculateDifferenceBetweenStartDateAndEndDateTheEndDateAndTheWeekendsOnly(String considerEndDate) {
        timeAndDateSteps.calculateDifferenceIncludingWeekendsOnly(considerEndDate);
    }

    @Then("I validate the result on the page {string} the end date and only the weekends")
    public void iValidateTheResultOnThePageIncludingTheEndDateAndOnlyTheWeekends(String considerEndDate) throws InterruptedException {
        timeAndDateSteps.validateResultIncludingWeekendsOnly(considerEndDate);
    }
}
