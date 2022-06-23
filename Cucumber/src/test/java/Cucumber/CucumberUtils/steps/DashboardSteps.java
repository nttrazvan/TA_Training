package Cucumber.CucumberUtils.steps;
import Cucumber.CucumberUtils.pages.DashboardPage;
import net.thucydides.core.annotations.Step;
//ToDo - add empty between package and imports
public class DashboardSteps {
    private DashboardPage dashboardPage;

    @Step()
    public void navigateToValueListsOverview() {
        dashboardPage.menuButton.click();
        dashboardPage.valueListsOverview.click();
    }
//ToDo - this method only validates if the btn is displayed, it does not wait for it :)
    @Step()
    public void dashboardButtonIsDisplayed() {
        dashboardPage.dashboardButton.isDisplayed();
    }
}