package serenity_demo.steps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import serenity_demo.pages.DashboardPage;

public class DashboardSteps extends ScenarioSteps {
    private DashboardPage dashboardPage;

    @Step("STEP: I open the Value lists Overview")
    public void openValueListsOverview(){
        dashboardPage.valueLists.click();
    }
}