package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.*;
import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;

public class BenutzerverwaltungSteps {

    private LoginPage loginPage;
    private BenutzerverwaltungPage benutzerverwaltungPage;
    private DashboardPage dashboardPage;
    private BenutzerkontoAnlegenPage benutzerkontoAnlegenPage;
    private int initialValue = 0;
    private SoftAssertions softly = new SoftAssertions();


    @Step()
    public void navigate(String url){
        benutzerverwaltungPage.navigate(url);
    }

    @Step()
    public void inputUsername(String something) {
        loginPage.usernameInput.sendKeys(something);
    }

    @Step()
    public void inputPassword(String something){
        loginPage.passwordInput.sendKeys(something);
        loginPage.submitButton.submit();
    }
    @Step()
    public void openMenu(){
        dashboardPage.menuButton.click();
    }

    @Step()
    public void openUserOverview(){
        dashboardPage.userOverview.click();
    }

    @Step()
    public void openUserCreation(){
        benutzerverwaltungPage.createUserButton.click();
    }

    @Step()
    public void verifyTitleUserCreationPage(){
        softly.assertThat(getDriver().getTitle()).contains("Benutzerkonto anlegen").as("This message will be shown when the assertion fails");
    }

    @Step()
    public void searchForCreationButton(){

        benutzerverwaltungPage.createUserButton.submit();
    }
}