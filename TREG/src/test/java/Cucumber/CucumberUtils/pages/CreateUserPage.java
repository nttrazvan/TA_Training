package Cucumber.CucumberUtils.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class CreateUserPage extends PageObject {

    @FindBy(xpath = "//isy-page-toolbar-functions//button")
    public WebElementFacade createUserButton;

    @FindBy(id = "vorname")
    public WebElementFacade inputFirstName;

    @FindBy(id = "name")
    public WebElementFacade inputLastName;

    @FindBy(id = "email")
    public WebElementFacade inputEmail;

    @FindBy(css = "isy-dropdown[formcontrolname='telefonNummer']")
    public WebElementFacade inputPhoneNumber;

    @FindBy(css = "li[role='menuitem']")
    public List<WebElementFacade> phoneNumberList;

    @FindBy(css = "input[inputid='durchwahl']")
    public WebElementFacade inputExtension;

    @FindBy(xpath = "//a//span[contains(text(),' Referats- und Rollenzuordnung ')]")
    public WebElementFacade navigateSecondTab;

    @FindBy(css = "p-dropdown[formcontrolname='rolleId']")
    public WebElementFacade inputRole;

    @FindBy(css = "li[role='option']")
    public List<WebElementFacade> roleList;

    @FindBy(css = "isy-dropdown[formcontrolname='referateId']")
    public WebElementFacade inputReferat;

    @FindBy(css = "li[role='menuitem']")
    public List<WebElementFacade> referatList;

    @FindBy(css = "p-multiselect[formcontrolname='team']")
    public WebElementFacade inputTeam;

    @FindBy(css = "li.p-multiselect-item")
    public List<WebElementFacade> teamList;

    @FindBy(xpath = "//input[@inputid='hasMentor']/..")
    public WebElementFacade checkHasMentor;

    @FindBy(css = "p-dropdown[formcontrolname='mentorId']")
    public WebElementFacade inputMentor;

    @FindBy(css = "li[role='option']")
    public List<WebElementFacade> mentorList;

    @FindBy(css = "button.btn-save")
    public WebElementFacade saveButton;

    public String locateCreatedUsersText (String name) {
        WebElementFacade nameText = find(By.xpath("//tr//span[contains(text(),'" + name + "')]"));
        return nameText.getText();
    }
}



