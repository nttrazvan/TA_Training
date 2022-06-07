package serenity_demo.steps;
import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import serenity_demo.Helpers;
import serenity_demo.pages.DashboardPage;

public class GenericSteps extends ScenarioSteps {
    private DashboardPage dashboardPage;
    private Helpers helpers;


    @Step("STEP: I open the menu")
    public void openMenu()  {
        helpers.wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.menuButton));
        dashboardPage.menuButton.click();
    }

    @Step("STEP: I test the permissions by checking that the Value lists Overview option is not present in the menu")
    public void checkValueListsOverview(){
        Assert.assrt(!dashboardPage.valueLists.isPresent());
        System.out.println(!dashboardPage.valueLists.isPresent());
    }
}