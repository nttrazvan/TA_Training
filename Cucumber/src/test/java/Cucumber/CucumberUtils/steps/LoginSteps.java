package Cucumber.CucumberUtils.steps;
import Cucumber.CucumberUtils.pages.DashboardPage;
import Cucumber.CucumberUtils.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
//ToDo - add empty line between package and imports and between imports and static imports

public class LoginSteps {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Step()
    public void openLoginPage(String url) {
        getDriver().navigate().to(url);
    }

    @Step()
    public void inputUsername(String something) {
        if(!dashboardPage.dashboardButton.isVisible()) {
            loginPage.usernameInput.sendKeys(something);
        }
    }

    @Step()
    public void inputPassword(String something) {
        if(!dashboardPage.dashboardButton.isVisible()) {
            loginPage.passwordInput.sendKeys(something);
            loginPage.submitButton.submit();
        }
    }
}