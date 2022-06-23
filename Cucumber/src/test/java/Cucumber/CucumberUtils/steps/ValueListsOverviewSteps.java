package Cucumber.CucumberUtils.steps;
import Cucumber.CucumberUtils.pages.ValueListsOverviewPage;
import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
//ToDo - add empty line between package and imports and between imports and static imports
//  Normal assert should be from junit
public class ValueListsOverviewSteps {
    private ValueListsOverviewPage valueListsOverviewPage;
    private SoftAssertions softly = new SoftAssertions();

//ToDo - the fail message is not correct, rename variable to not be 'something'
    @Step()
    public void checkTitle(String something){
        softly.assertThat(getDriver().getTitle()).contains(something).as("This message will be shown if the assertion fails");
    }

    @Step()
    public void checkTableTitle(String something){
        Assert.assrt(valueListsOverviewPage.tableTitle.getAttribute("textContent").contains(something));
    }
//ToDo - add soft assertions not java matchers :)
    @Step
    public void verifyTableHeader(String col1, String col2, String col3) {
        valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("textContent").contains(col1);
        valueListsOverviewPage.tableHeaderSecondColumn.getAttribute("textContent").contains(col2);
        valueListsOverviewPage.tableHeaderActions.getAttribute("textContent").contains(col3);
    }
//ToDo - add soft assertions to check all entries even if one fails
    @Step
    public void verifyTableContent() {
        valueListsOverviewPage.addressList.isDisplayed();
        valueListsOverviewPage.viewAddressButton.isClickable();
        valueListsOverviewPage.editAddressButton.isClickable();
        valueListsOverviewPage.faxnummerList.isDisplayed();
        valueListsOverviewPage.viewFaxnummerButton.isClickable();
        valueListsOverviewPage.editFaxnummerButton.isClickable();
    }
}