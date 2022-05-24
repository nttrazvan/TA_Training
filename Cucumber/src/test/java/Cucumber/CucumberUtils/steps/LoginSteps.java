package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginSteps {
    private LoginPage loginPage;

    @Step()
    public void openLoginPage(String url) {
        getDriver().navigate().to(url);
    }

    @Step()
    public void inputUsername(String something) {
        loginPage.usernameInput.sendKeys(something);
    }

    @Step()
    public void inputPassword(String something) {
        loginPage.passwordInput.sendKeys(something);
        loginPage.submitButton.submit();
    }
}