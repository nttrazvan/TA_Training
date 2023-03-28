package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.steps.EmptyTemplateSteps;
import Cucumber.CucumberUtils.steps.TimetrackingSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class TimetrackingStepDefs {
    @Steps
    private TimetrackingSteps timetrackingSteps;
    @Given("I select the dates as {string} and {string}")
    public void setDates(String day, String month) {
        timetrackingSteps.setDates(day, month);
    }

    @Then("I log in with {string} and {string}")
    public void login(String user, String pass) {
        timetrackingSteps.login(user, pass);
    }

    @Then("I fill in the unallocated days")
    public void fillDays() throws InterruptedException {
        timetrackingSteps.fillDays();
    }
}
