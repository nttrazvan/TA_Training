package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.ValueListsOverviewPage;
import Cucumber.CucumberUtils.pages.ValueListItem;
import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ValueListsOverviewSteps {/*ToDo - please add spaces after class declaration*/
    private ValueListsOverviewPage valueListsOverviewPage;
    private SoftAssertions softly = new SoftAssertions();
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
//ToDo - remove if unused
    @Step
    public void verifyTableContent() {
        valueListsOverviewPage.addressList.isDisplayed();
        valueListsOverviewPage.viewAddressButton.isClickable();
        valueListsOverviewPage.editAddressButton.isClickable();
        valueListsOverviewPage.faxnummerList.isDisplayed();
        valueListsOverviewPage.viewFaxnummerButton.isClickable();
        valueListsOverviewPage.editFaxnummerButton.isClickable();
    }

    //Table defined standard design
    @Step
    public void checkPaginator() {
        valueListsOverviewPage.paginator.isDisplayed();
    }
//ToDo - please check the imports and use the Junit assertions
    @Step
    public void checkSortingWorks() {
        logger.info("The sorting type is: " + valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort"));
        valueListsOverviewPage.sortingButton.click();
        logger.info("The sorting type is: " + valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort"));
        Assert.assrt(valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort").equals("ascending"));
        valueListsOverviewPage.sortingButton.click();
        logger.info("The sorting type is: " + valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort"));
        Assert.assrt(valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort").equals("descending"));
    }

    @Step
    public void filterLine(String searchString) {
        logger.info("I press the filter button");
        valueListsOverviewPage.filteringButton.click();
        logger.info("I check the filter line appears");
//        ToDo - pelase check the assertuin, format should be sofly.assertThat(element).condition (hovering over it will tell you the assert is ignored)
        softly.assertThat(valueListsOverviewPage.filterLine.isPresent());
        valueListsOverviewPage.inputFilterLine.typeAndTab(searchString);
//ToDo-remove line here
    }

    @Step
    public void tableRetrieveValues(String firstList, String secondList) throws InterruptedException {
        boolean elementIsPresent = false;
        List<ValueListItem> elementsFromPage = valueListsOverviewPage.tableRetrieveValues();
        for (ValueListItem element : elementsFromPage) {
            if (element.BezeichnungWerteliste.contains(firstList) || element.BezeichnungWerteliste.contains(secondList)) {
                elementIsPresent = true;/*ToDo - please add break*/
            }
        }
        Assert.assrt(elementIsPresent);
    }

    @Step
    public void checkResetFilterButton() throws InterruptedException {
        List<ValueListItem> elementsFromPage = valueListsOverviewPage.tableRetrieveValues();
        Integer listSizeBeforeReset = elementsFromPage.size();/*ToDo - please declare as int*/
        valueListsOverviewPage.resetFilteringButton.click();
        valueListsOverviewPage.sortingButton.click();
        Thread.sleep(1000);
        List<ValueListItem> elementsFromPageAfterReset = valueListsOverviewPage.tableRetrieveValues();
        Integer listSizeAfterReset = elementsFromPageAfterReset.size();
        logger.info("The size before reset is: " + listSizeBeforeReset);
        logger.info("The size after reset is: " + listSizeAfterReset);
        Assert.assrt(!(listSizeBeforeReset == listSizeAfterReset));
    }
}