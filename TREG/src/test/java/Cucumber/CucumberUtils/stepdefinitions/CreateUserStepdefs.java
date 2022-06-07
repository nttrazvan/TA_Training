package Cucumber.CucumberUtils.stepdefinitions;

import Cucumber.CucumberUtils.steps.CreateUserSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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


    @And("I enter: first name {string}, last name {string}, email {string}, phone number {string}, extension {string}, role {string}, {string} and {string}")
    public void iEnterFirstNameLastNameEmailPhoneNumberExtensionDurchwahlRoleAnd(String firstName, String lastName, String email, String phoneNumber, String extension, String role, String referat, String team) {
        createUserSteps.enterUserData(firstName, lastName, email, phoneNumber, extension, role, referat, team);

    }
}
