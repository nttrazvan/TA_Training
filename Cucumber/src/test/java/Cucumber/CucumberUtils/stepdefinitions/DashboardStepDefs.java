package Cucumber.CucumberUtils.stepdefinitions;
import Cucumber.CucumberUtils.pages.DashboardPage;
import Cucumber.CucumberUtils.steps.DashboardSteps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

//ToDo - add empty line between package and imports
public class DashboardStepDefs {

    private DashboardPage dashboardPage;

    @Steps
    private DashboardSteps dashboardSteps;
// ToDo - Add spacing between steps, keep code style consistency
    @Given("I navigate to the Value Lists Overview")
    public void navigateToValueListsOverview() {
        dashboardSteps.navigateToValueListsOverview();
    }
    @Given("Wait for the Dashboard to load")
    public void dashboardButtonIsDisplayed() {
        dashboardSteps.dashboardButtonIsDisplayed();
    }
}