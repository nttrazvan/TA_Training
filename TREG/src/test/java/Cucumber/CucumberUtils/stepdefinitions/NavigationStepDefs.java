package Cucumber.CucumberUtils.stepdefinitions;
import Cucumber.CucumberUtils.pages.NavigationPage;
import Cucumber.CucumberUtils.steps.NavigationSteps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;


public class NavigationStepDefs {

    private NavigationPage navigationPage;

    @Steps
    private NavigationSteps dashboardSteps;

    @Given("I navigate to the Value Lists Overview")
    public void navigateToValueListsOverview() {
        dashboardSteps.navigateToValueListsOverview();
    }
    @Given("Wait for the Dashboard to load")
    public void dashboardButtonIsDisplayed() {
        dashboardSteps.dashboardButtonIsDisplayed();
    }
}