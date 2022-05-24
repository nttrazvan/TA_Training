package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.AktePage;
import Cucumber.CucumberUtils.pages.ValueListsOverviewPage;
import Cucumber.TestDataContainer.RBCreactionDataContainer;
import com.ibm.icu.impl.Assert;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AkteSteps {
    private AktePage aktePage;
    private SoftAssertions softly = new SoftAssertions();


    @Step()
    public void openAktePage(String url) {
        getDriver().navigate().to(url);
    }

    @Step()
    public void pressCreationButtonRB() {
        aktePage.createRBButton.click();
    }

    @Step()
    public void openDropdownAnrede() {
        aktePage.anredeDropdownButton.click();
    }

    @Step
    public void validateStandardInput(String hundredAndOneChar, String hundredChar) {
        aktePage.inputVorname.typeAndTab(Vorname);
        aktePage.inputName.typeAndTab(Name);
        aktePage.buttonWeiter.isDisabled();
    }
//    @Step()
//    public void validateStandardInput() {
//        //Invalid input
//        aktePage.inputVorname.typeAndTab(RBCreactionDataContainer.hundredAndOneChar);
//        aktePage.inputName.typeAndTab(RBCreactionDataContainer.hundredAndOneChar);
//        aktePage.buttonWeiter.isDisabled();
//        //Valid input
//        aktePage.inputVorname.typeAndTab(RBCreactionDataContainer.hundredChar);
//        aktePage.inputName.typeAndTab(RBCreactionDataContainer.hundredChar);
//        aktePage.buttonWeiter.click();
//        //Validate tootlip missing
//        System.out.println(aktePage.tooltipVorname.getAttribute("value"));
//    }

}