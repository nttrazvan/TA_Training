package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.steps.ValueListsOverviewSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ValueListsStepDefs {
    @Steps
    private ValueListsOverviewSteps valueListsOverviewSteps;

    @And("I check that a paginator exists")
    public void checkPaginator() {
        valueListsOverviewSteps.checkPaginator();
    }


    @Then("I check that sorting works")
    public void iCheckThatSortingWorks() {
        valueListsOverviewSteps.checkSortingWorks();
    }

    @Then("I check that the filter for string {string} and returns following values: {string} and {string}")
    public void iCheckTheFilterWorks(String searchString, String firstList, String secondList) throws InterruptedException {
        valueListsOverviewSteps.filterLine(searchString);
        valueListsOverviewSteps.tableRetrieveValues(firstList, secondList);
    }

    @Then("I check that filtering and sorting can be reset through the reset button")
    public void iCheckThatFilteringAndSortingCanBeResetThroughTheResetButton() throws InterruptedException {
        valueListsOverviewSteps.checkResetFilterButton();
    }


}
