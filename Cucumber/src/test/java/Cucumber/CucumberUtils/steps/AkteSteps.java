package Cucumber.CucumberUtils.steps;
import Cucumber.CucumberUtils.pages.AktePage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AkteSteps {
    private AktePage aktePage;
    private SoftAssertions softly = new SoftAssertions();


    @Step()
    public void openAktePage(String url) {
        getDriver().navigate().to(url);
    }

    @Step()
    public String getCounter() {
      String counterBeforeCreation = aktePage.counter.getText();
      return counterBeforeCreation;
    }

    @Step()
    public void pressCreationButtonRB() {
        aktePage.createRBButton.click();
    }

    @Step()
    public void selectAnrede() {
        aktePage.dropdown.click();
        aktePage.anredeDropdownFrau.click();
    }

    @Step
    public void validateStandard(String vorname, String name) {
        aktePage.inputVorname.clear();
        aktePage.inputVorname.typeAndTab(vorname);
        aktePage.inputName.clear();
        aktePage.inputName.typeAndTab(name);
    }

    @Step
    public void inputName(String firstName, String lastName) {
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
    public void iPressSubmit() {
        aktePage.buttonWeiter.click();
    }

    @Step
    public void iCheckTheName(String firstName) {
        aktePage.locateNameSecondStep(firstName);
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
    public void checkCounter() {
       String counterAfterCreation = aktePage.counter.getText();
        Assert.assertNotEquals(getCounter(),counterAfterCreation);
        System.out.println(counterAfterCreation);
    }
}