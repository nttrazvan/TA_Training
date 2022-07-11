package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.AktePage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AkteSteps {
    private AktePage aktePage;
    private SoftAssertions softly = new SoftAssertions();
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private String CounterBeforeCreation;

    //setter
    public void setCounterBeforeCreation() {
        this.CounterBeforeCreation = aktePage.counter.getTextContent();
    }

    @Step()
    public void openAktePage(String url) {
        getDriver().navigate().to(url);
    }

    @Step()
    public String getCounter() throws InterruptedException {
        Thread.sleep(1000);
        setCounterBeforeCreation();
        logger.info("The counter before creation is: " + CounterBeforeCreation);
        return CounterBeforeCreation;
    }

    @Step()
    public void clickCreationButton() {
        aktePage.createRBButton.click();
    }

    @Step()
    public void selectAnrede(String anrede) {
        aktePage.dropdown.click();
        aktePage.selectAnredeFrau(anrede).click();
    }

    @Step
    public void validateFirstAndLastName(String vorname, String name) {
        aktePage.inputVorname.clear();
        aktePage.inputVorname.typeAndTab(vorname);
        aktePage.inputName.clear();
        aktePage.inputName.typeAndTab(name);
    }

    @Step
    public void inputFirstAndLastName(String firstName, String lastName) {
        aktePage.inputVorname.typeAndTab(firstName);
        aktePage.inputName.typeAndTab(lastName);
    }

    @Step
    public void weiterIsEnabled(String weiterState) {
        if (weiterState.equals("disabled")) {
            Assert.assertTrue(aktePage.buttonWeiter.isDisabled());
        } else {
            Assert.assertTrue(aktePage.buttonWeiter.isEnabled());
        }
    }

    @Step
    public void checkboxKanzlei() {
        aktePage.checkboxKanzlei.click();
    }

    @Step
    public void checkboxAddress() {
        aktePage.checkboxAddress.click();
    }

    @Step
    public void iClickSubmit() {
        aktePage.buttonWeiter.click();
    }

    @Step
    public void iCheckTheName(String firstName) {
        Assert.assertEquals("Liana Chis", aktePage.locateNameSecondStep(firstName).getText());
    }

    @Step()
    public void selectRole() {
        aktePage.dropdown.click();
        aktePage.roleDropdownVerteidigung.click();
    }

    @Step()
    public void inputBeginDate(String beginDate) {
        aktePage.beginDate.typeAndTab(beginDate);
    }

    @Step()
    public void inputEndDate(String endDate) {
        aktePage.endDate.typeAndTab(endDate);
    }

    @Step()
    public void submitWizard() {
        aktePage.saveButton.click();
    }

    @Step()
    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    @Step()
    public void checkCounter() throws InterruptedException {
        Thread.sleep(1000);
        String counterAfterCreation = aktePage.counter.getTextContent();
        logger.info("The counter after creation is: " + counterAfterCreation);
        Assert.assertNotEquals(CounterBeforeCreation, counterAfterCreation,"The counter has not been updated.");
    }
}