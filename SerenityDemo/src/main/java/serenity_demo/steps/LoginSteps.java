package serenity_demo.steps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import serenity_demo.Helpers;
import serenity_demo.pages.LoginPage;

import java.time.Duration;

public class LoginSteps extends ScenarioSteps {

    private LoginPage loginPage;

    @Step("Open page")
    public void open(String url) {
        getDriver().navigate().to(url);
        getDriver().manage().window().maximize();
    }

    @Step("STEP: I input the username")
    public void inputUsername(String something) {
        loginPage.usernameInput.sendKeys(something);
    }

    @Step("STEP: I input the password and submit")
    public void inputPassword(String something){
         loginPage.passwordInput.sendKeys(something);
         loginPage.submitButton.click();
    }
}