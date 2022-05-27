package Cucumber.CucumberUtils.steps;
import Cucumber.CucumberUtils.pages.DashboardPage;
import net.thucydides.core.annotations.Step;

public class DashboardSteps {
    private DashboardPage dashboardPage;

    @Step()
    public void navigateToValueListsOverview() {
        dashboardPage.menuButton.click();
        dashboardPage.valueListsOverview.click();
    }

    @Step()
    public void dashboardButtonIsDisplayed() {
        dashboardPage.dashboardButton.isDisplayed();
    }
}