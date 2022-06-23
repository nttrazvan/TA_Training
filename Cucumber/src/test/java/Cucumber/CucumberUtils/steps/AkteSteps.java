package Cucumber.CucumberUtils.steps;
import Cucumber.CucumberUtils.pages.AktePage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
//ToDo - remove soft assertions if not used, add empty line between package and imports and between imports and static imports
public class AkteSteps {
    private AktePage aktePage;
    private SoftAssertions softly = new SoftAssertions();


    @Step()
    public void openAktePage(String url) {
        getDriver().navigate().to(url);
    }
//Todo - return actePage.counter.getText(); / String declaration is redundant
    @Step()
    public String getCounter() {
      String counterBeforeCreation = aktePage.counter.getText();
      return counterBeforeCreation;
    }
//ToDo - press is on real devices(tablet/phone/touch laptop), else it is click:)
    @Step()
    public void pressCreationButtonRB() {
        aktePage.createRBButton.click();
    }

    @Step()
    public void selectAnrede() {
        aktePage.dropdown.click();
        aktePage.anredeDropdownFrau.click();
    }
//ToDo - there is no standard for validation since they are business dependent
//    change method name to validate name fields
    @Step
    public void validateStandard(String vorname, String name) {
        aktePage.inputVorname.clear();
        aktePage.inputVorname.typeAndTab(vorname);
        aktePage.inputName.clear();
        aktePage.inputName.typeAndTab(name);
    }
//ToDo - If you enter name and surname, change method name to full name input
    @Step
    public void inputName(String firstName, String lastName) {
        aktePage.inputVorname.typeAndTab(firstName);
        aktePage.inputName.typeAndTab(lastName);
    }
//ToDo - if you use 'weiter' in the feature file, this method will never reach the else if statement, only the else
//    this method type should be used when you call it in the feature in two states specific for the Weiter btn, ex:
//    I should see the Weiter btn "Disabled"
//    I should see the Weiter btn "Enabled"
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
//ToDo - bring element and assertion
    @Step
    public void iCheckTheName(String firstName) {
        aktePage.locateNameSecondStep(firstName);
    }

    @Step()
    public void selectRole() {
        aktePage.dropdown.click();
        aktePage.roleDropdownVerteidigung.click();
    }
//ToDo - remove empty line
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
//ToDo - this is a generic step that can be used on all pages, move accordingly
    @Step()
    public void refreshPage() {
        getDriver().navigate().refresh();
    }
//ToDo - alignment / add message to assertion in case step fails
    @Step()
    public void checkCounter() {
       String counterAfterCreation = aktePage.counter.getText();
        Assert.assertNotEquals(getCounter(),counterAfterCreation);
        System.out.println(counterAfterCreation);
    }
//ToDo - remove redundant method
    public void setAktePage(AktePage aktePage) {
        this.aktePage = aktePage;
    }
}