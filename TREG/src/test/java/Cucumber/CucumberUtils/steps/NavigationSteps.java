package Cucumber.CucumberUtils.steps;
import Cucumber.CucumberUtils.pages.NavigationPage;
import net.thucydides.core.annotations.Step;

public class NavigationSteps {
    NavigationPage navigationPage;

    @Step()
    public void navigateToValueListsOverview() {
        navigationPage.menuButton.click();
        navigationPage.valueListsOverview.click();
    }

    @Step()
    public void dashboardButtonIsDisplayed() {
        navigationPage.dashboardButton.isDisplayed();
    }
}