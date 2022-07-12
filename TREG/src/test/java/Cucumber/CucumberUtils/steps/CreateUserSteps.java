package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.CreateUserPage;
import Cucumber.CucumberUtils.pages.NavigationPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class CreateUserSteps {

    CreateUserPage createUserPage;
    NavigationPage navigationPage;

    @Step()
    public void navigateToUserOverview() {
        navigationPage.menuButton.click();
        navigationPage.userOverview.click();
    }

    @Step()
    public void openCreateUserPage() {
        createUserPage.createUserButton.click();
    }

    @Step()
    public void enterUserData(String firstName, String lastName, String email, String phoneNumber, String extension, String role, String referat, String team, String mentor) {
        createUserPage.inputFirstName.sendKeys(firstName);
        createUserPage.inputLastName.sendKeys(lastName);
        createUserPage.inputEmail.sendKeys(email);
        createUserPage.inputPhoneNumber.click();
        boolean phoneFlag = false;
        for (WebElementFacade elm : createUserPage.phoneNumberList) {
            if (elm.getAttribute("innerText").equals(phoneNumber)) {
                elm.click();
                phoneFlag = true;
                break;
            }
        }
        if (phoneFlag == false) {
            Assert.fail("The phone number is not in the desired list.");
        }
        createUserPage.inputExtension.sendKeys(extension);
        createUserPage.navigateToRoleAssignment.click();
        createUserPage.inputRole.click();
        boolean roleFlag = false;
        for (WebElementFacade elm : createUserPage.roleList) {
            if (elm.getAttribute("innerText").equals(role)) {
                elm.click();
                roleFlag = true;
                break;
            }
        }
        if (roleFlag == false) {
            Assert.fail("The role is not in the desired list.");
        }
        createUserPage.inputReferat.click();
        boolean referatFlag = false;
        for (WebElementFacade elm : createUserPage.referatList) {
            if (elm.getAttribute("innerText").equals(referat)) {
                elm.click();
                referatFlag = true;
                break;
            }
        }
        if (referatFlag == false) {
            Assert.fail("The referat is not in the desired list.");
        }
        createUserPage.inputTeam.click();
        boolean teamFlag = false;
        for (WebElementFacade elm : createUserPage.teamList) {
            if (elm.getAttribute("innerText").equals(team)) {
                elm.click();
                teamFlag = true;
                createUserPage.inputTeam.click();
                break;
            }
        }
        if (teamFlag == false) {
            Assert.fail("The team is not in the desired list.");
        }
        if (mentor.equals("yes")) {
            createUserPage.checkHasMentor.click();
            createUserPage.inputMentor.click();
            createUserPage.mentorList.get(0).click();
        }
    }

    @Step()
    public void submitForm() {
        createUserPage.saveButton.click();
    }

    @Step()
    public void validateCreation(String lastName, String firstName) {
        assertEquals(createUserPage.locateCreatedUsersText(lastName), lastName);
        assertEquals(createUserPage.locateCreatedUsersText(firstName), firstName);
    }
}