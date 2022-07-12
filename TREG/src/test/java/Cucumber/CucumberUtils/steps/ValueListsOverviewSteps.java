package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.ValueListsOverviewPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ValueListsOverviewSteps {

    private ValueListsOverviewPage valueListsOverviewPage;
    private SoftAssertions softly = new SoftAssertions();
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    //Table defined standard design
    @Step
    public void checkPaginator() {
        valueListsOverviewPage.paginator.isDisplayed();
    }

    @Step
    public void checkSortingWorks() {
        logger.info("The sorting type is: " + valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort"));
        valueListsOverviewPage.sortingButton.click();
        logger.info("The sorting type is: " + valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort"));
        Assert.assertEquals("ascending", valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort"));
        valueListsOverviewPage.sortingButton.click();
        logger.info("The sorting type is: " + valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort"));
        Assert.assertEquals(valueListsOverviewPage.tableHeaderFirstColumn.getAttribute("aria-sort"), "descending");
    }

    @Step
    public void filterLine(String searchString) {
        logger.info("I press the filter button");
        valueListsOverviewPage.filteringButton.click();
        logger.info("I check the filter line appears");
        valueListsOverviewPage.filterLine.isPresent();
        valueListsOverviewPage.inputFilterLine.typeAndTab(searchString);
    }

    @Step
    public void tableRetrieveValues(String firstList, String secondList) throws InterruptedException {
        boolean elementIsPresent = false;
        List<List> elementsFromPage = valueListsOverviewPage.tableRetrieveValues();
        String firstListElement = String.valueOf(elementsFromPage.get(0).get(0));
        String secondListElement = String.valueOf(elementsFromPage.get(1).get(0));
        if (firstListElement.equals(firstList) && secondListElement.equals(secondList)) {
            elementIsPresent = true;
        }
        Assert.assertTrue(elementIsPresent);
    }

    @Step
    public void checkResetFilterButton() throws InterruptedException {
        List<List> elementsFromPage = valueListsOverviewPage.tableRetrieveValues();
        int listSizeBeforeReset = elementsFromPage.size();
        valueListsOverviewPage.resetFilteringButton.click();
        valueListsOverviewPage.sortingButton.click();
        Thread.sleep(1000);
        List<List> elementsFromPageAfterReset = valueListsOverviewPage.tableRetrieveValues();
        int listSizeAfterReset = elementsFromPageAfterReset.size();
        logger.info("The size before reset is: " + listSizeBeforeReset);
        logger.info("The size after reset is: " + listSizeAfterReset);
        Assert.assertNotEquals(listSizeBeforeReset, listSizeAfterReset);
    }
}