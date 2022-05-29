package serenity_demo.steps;
import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import serenity_demo.pages.DashboardPage;

public class GenericSteps extends ScenarioSteps {
    private DashboardPage dashboardPage;

    @Step("STEP: I open the menu")
    public void openMenu(){
        dashboardPage.menuButton.click();
    }

    @Step("STEP: I test the permissions by checking that the Value lists Overview option is not present in the menu")
    public void checkValueListsOverview(){
        Assert.assrt(!dashboardPage.valueLists.isPresent());
        System.out.println(!dashboardPage.valueLists.isPresent());
    }
}