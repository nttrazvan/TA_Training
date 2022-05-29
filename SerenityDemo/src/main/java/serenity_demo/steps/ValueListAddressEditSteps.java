package serenity_demo.steps;
import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import serenity_demo.pages.ValueListAddressEditPage;
import serenity_demo.testData.TregTestData;

public class ValueListAddressEditSteps extends ScenarioSteps {
    private ValueListAddressEditPage valueListAddressEditPage;

    @Step("STEP: I open the list of Addresses in the edit mode")
    public void openAddressListInEditMode(){
        valueListAddressEditPage.editButtonAddress.click();
        Assert.assrt(valueListAddressEditPage.tableTitle.getAttribute("textContent").contains(TregTestData.valueListAddressEditTableTitle));
        System.out.println(valueListAddressEditPage.tableTitle.getAttribute("textContent"));
    }

    public void setValueListAddressEditPage(ValueListAddressEditPage valueListAddressEditPage) {
        this.valueListAddressEditPage = valueListAddressEditPage;
    }
}