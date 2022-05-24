package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class AktePage extends PageObject {

    public AktePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "button-7")
    public WebElementFacade createRBButton;

    @FindBy( xpath= "//button[contains(text),'p-dropdown-trigger ng-tns-c87-1']")
    public WebElementFacade anredeDropdownButton;

    @FindBy( xpath= "//*[@id=\"wizard-tab-0\"]/div/tpr-dynamic-component-loader/tpr-form-rechtbeistande-personal-data/div/form/div[3]/isy-form-wrapper/div/div[2]/div/tpr-input/div/input")
    public WebElementFacade inputVorname;

    @FindBy( xpath= "//*[@id=\"wizard-tab-0\"]/div/tpr-dynamic-component-loader/tpr-form-rechtbeistande-personal-data/div/form/div[3]/isy-form-wrapper/div/div[2]/isy-error-tooltip-icon/span/isy-tooltip/span/span")
    public WebElementFacade tooltipVorname;

    @FindBy( xpath= "//*[@id=\"wizard-tab-0\"]/div/tpr-dynamic-component-loader/tpr-form-rechtbeistande-personal-data/div/form/div[4]/isy-form-wrapper/div/div[2]/div/tpr-input/div/input")
    public WebElementFacade inputName;

    @FindBy( xpath= "/html/body/modal-container/div/div/tpr-dynamic-modal-component/isy-modal/div[2]/div[2]/div/tpr-dynamic-component-loader/tpr-dynamic-wizard-rechtsbeistand-create/tpr-dynamic-wizard/isy-wizard/div/button[2]")
    public WebElementFacade buttonWeiter;
}



