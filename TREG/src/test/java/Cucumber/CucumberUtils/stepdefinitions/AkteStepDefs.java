package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.steps.AkteSteps;
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

    @And("I save the counter before creation")
    public void saveCounter() throws InterruptedException {
        akteSteps.saveCounter();
    }

    @And("I click the creation button of RB")
    public void pressCreationButton() {
        akteSteps.clickCreationButton();
    }

    @And("I select the option {string} in the dropdown Anrede")
    public void inputAnrede(String anrede) {
        akteSteps.selectGender(anrede);
    }

    @When("I enter something in the fields {string} and {string}")
    public void validateStandardInput(String vorname, String name) {
        akteSteps.validateFirstAndLastName(vorname, name);
    }

    @Then("I check that the button {string} is:")
    public void icheckTheStateOfNext(String weiterState) {
        akteSteps.validateNextButtonState(weiterState);
    }

    @Given("I click Next")
    public void iClickNext() {
        akteSteps.iClickSubmit();
    }

    @Then("I check the name {string}")
    public void iCheckTheName(String firstName) {
        akteSteps.iCheckTheName(firstName);
    }

    @And("I enter the first name {string} and the last name {string}")
    public void iEnterTheFirstNameAndTheLastName(String firstName, String lastName) {
        akteSteps.validateFirstAndLastName(firstName, lastName);
    }

    @And("I select a role")
    public void iSelectARole() {
        akteSteps.selectRole();
    }

    @And("I enter a begin date {string}")
    public void iEnterABeginDate(String beginDate) {
        akteSteps.inputBeginDate(beginDate);
    }

    @And("I enter an end date {string}")
    public void iEnterAnEndDate(String endDate) {
        akteSteps.inputEndDate(endDate);
    }

    @And("I submit the wizard")
    public void iSubmitTheWizard() {
        akteSteps.submitWizard();
    }

    @And("I refresh the page")
    public void iRefreshThePage() {
        akteSteps.refreshPage();
    }

    @Then("I check the counter")
    public void iCheckTheCounter() throws InterruptedException {
        akteSteps.checkCounter();
    }

    @And("I uncheck Kanzlei and Known Address")
    public void iUncheckKnownAddressAndKanzlei() {
        akteSteps.checkboxKanzlei();
        akteSteps.checkboxAddress();
    }
}
