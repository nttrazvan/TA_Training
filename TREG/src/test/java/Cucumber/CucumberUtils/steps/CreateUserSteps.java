package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.AktePage;
import Cucumber.CucumberUtils.pages.CreateUserPage;
import Cucumber.CucumberUtils.pages.NavigationPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CreateUserSteps {
    CreateUserPage createUserPage;
    NavigationPage navigationPage;
    private SoftAssertions softly = new SoftAssertions();

    public CreateUserSteps() {
    }

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
    public void enterUserData(String firstName, String lastName, String email, String phoneNumber, String extension, String role, String referat, String team) {
        createUserPage.inputFirstName.sendKeys(firstName);
        createUserPage.inputLastName.sendKeys(lastName);
        createUserPage.inputEmail.sendKeys(email);
        createUserPage.inputPhoneNumber.selectByValue(phoneNumber);
        createUserPage.inputExtension.sendKeys(extension);
        createUserPage.navigateSecondTab.click();

    }

}