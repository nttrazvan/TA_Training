package serenity_demo.steps;
import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import serenity_demo.pages.ValueListsOverviewPage;
import serenity_demo.testData.TregTestData;

public class ValueListOverviewSteps extends ScenarioSteps {
    private ValueListsOverviewPage valueListsOverviewPage;


    @Step("STEP: I validate the title of the table")
    public void validateTitle(){
        Assert.assrt(valueListsOverviewPage.tableTitle.getAttribute("textContent").contains(TregTestData.valueListsOverviewTableTitle));
        System.out.println(valueListsOverviewPage.tableTitle.getAttribute("textContent"));
    }

    @Step("STEP: I validate the header of the table")
    public void validateHeader(){
        Assert.assrt(valueListsOverviewPage.tableHeader.getAttribute("textContent").contains(TregTestData.valueListsOverviewTableHeader));
        System.out.println(valueListsOverviewPage.tableHeader.getAttribute("textContent"));
    }
}