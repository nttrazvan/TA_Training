package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.steps.CreateUserSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CreateUserStepdefs {

    @Steps
    private CreateUserSteps createUserSteps;

    @Given("I navigate to the User Overview")
    public void iNavigateToTheUserOverview() {
        createUserSteps.navigateToUserOverview();
    }

    @And("I press the creation button")
    public void iPressTheCreationButton() {
        createUserSteps.openCreateUserPage();
    }


    @And("I enter: first name {string}, last name {string}, email {string}, phone number {string}, extension {string}, role {string}, {string},{string} and {string}")
    public void iEnterFirstNameLastNameEmailPhoneNumberExtensionDurchwahlRoleAnd(String firstName, String lastName, String email, String phoneNumber, String extension, String role, String referat, String mentor, String team) {
        createUserSteps.enterUserData(firstName, lastName, email, phoneNumber, extension, role, referat, mentor, team);

    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        createUserSteps.submitForm();
    }

    @Then("I check that the users {string} and {string} where created")
    public void iCheckThatTheUsersWhereCreated(String lastName, String firtName) {
        createUserSteps.validateCreation(lastName, firtName);
    }
}
