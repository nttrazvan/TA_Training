package Cucumber.CucumberUtils.stepdefinitions;
import Cucumber.CucumberUtils.pages.ValueListsOverviewPage;
import Cucumber.CucumberUtils.steps.AkteSteps;
import Cucumber.CucumberUtils.steps.ValueListsOverviewSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AkteStepDefs {
    @Steps
    private AkteSteps akteSteps;

    @Given("I open the Akte page to {string}")
    public void openAktePage(String url) {
        akteSteps.openAktePage(url);
    }

    @Then("I press the creation button of RB")
    public void pressCreationButton() {
        akteSteps.pressCreationButtonRB();
    }

    @Then("I open the dropdown Anrede")
    public void openDropwdownAnrede() {
        akteSteps.openDropdownAnrede();
    }

    @When("I validate the fields {string} and {string}")
    public void validateStandardInput(String Vorname, String Name) {
        akteSteps.validateStandardInput(Vorname, Name);
    }

}
