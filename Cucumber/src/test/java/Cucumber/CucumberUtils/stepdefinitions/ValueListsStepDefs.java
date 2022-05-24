package Cucumber.CucumberUtils.stepdefinitions;
import Cucumber.CucumberUtils.pages.ValueListsOverviewPage;
import Cucumber.CucumberUtils.steps.ValueListsOverviewSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ValueListsStepDefs { ;
    @Steps
    private ValueListsOverviewSteps valueListsOverviewSteps;


    @Then("The page title is {string}")
    public void validatePageTitle(String title) {
        valueListsOverviewSteps.checkTitle(title);
    }

    @And("The table title is {string}")
    public void validateTableTitle(String tableTitle) {
        valueListsOverviewSteps.checkTableTitle(tableTitle);
    }

    @Then("The table header contains {string}, {string} and {string}")
    public void validateTableHeader(String col1,String col2, String col3) {
        valueListsOverviewSteps.verifyTableHeader(col1, col2, col3);
    }

    @And("I verify the table content {string}, {string} and the buttons")
    public void verifyTableContent(String list1, String list2) {
        valueListsOverviewSteps.verifyTableContent(list1,list2);
    }
}
