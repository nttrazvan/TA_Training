package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.NavigationPage;
import net.thucydides.core.annotations.Step;/*ToDo - please add spaces before and after class declaration*/
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