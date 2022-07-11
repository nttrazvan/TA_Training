package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AktePage extends PageObject {

    @FindBy(css = "a[href='/tpr/tpr/akte/1/create-rechsbeistand']")
    public WebElementFacade createRBButton;
    @FindBy(css = "form>div:nth-child(1) isy-form-wrapper p-dropdown")
    public WebElementFacade dropdown;
    @FindBy(xpath = "//li/span[contains(text(),'Frau')]")
    public WebElementFacade anredeDropdownFrau;
    @FindBy(xpath = "//li/span[contains(text(),'Verteidigung')]")
    public WebElementFacade roleDropdownVerteidigung;
    @FindBy(xpath = "//tpr-input[@inputid='vorname']/div/input")
    public WebElementFacade inputVorname;
    @FindBy(xpath = "//tpr-input[@inputid='name']/div/input")
    public WebElementFacade inputName;
    @FindBy(xpath = "//input[@id='isy-wrapper-input-6']/..")
    public WebElementFacade checkboxKanzlei;
    @FindBy(xpath = "//input[@id='isy-wrapper-input-7']/..")
    public WebElementFacade checkboxAddress;
    @FindBy(xpath = "//button[contains(text(),'Weiter')]")
    public WebElementFacade buttonWeiter;
    @FindBy(id = "input-1")
    public WebElementFacade beginDate;
    @FindBy(id = "input-2")
    public WebElementFacade endDate;
    @FindBy(xpath = "//tpr-akte//p[contains(text(),'Rechtsbeist')]")
    public WebElementFacade counter;
    @FindBy(xpath = "//button[contains(text(),'Speichern')]")
    public WebElementFacade saveButton;
    public AktePage(WebDriver driver) {
        super(driver);
    }

    public WebElementFacade selectAnredeFrau(String anrede) {
        return find(By.xpath("//li/span[contains(text(),'" + anrede + "')]"));
    }

    public WebElementFacade locateNameSecondStep(String firstName) {
        return find(By.xpath("//div[contains(text(),'" + firstName + "')]"));
    }

}



