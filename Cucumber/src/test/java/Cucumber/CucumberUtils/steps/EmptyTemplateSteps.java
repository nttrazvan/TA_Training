package Cucumber.CucumberUtils.steps;
import Cucumber.CucumberUtils.pages.EmptyTemplatePage;
import Cucumber.TestDataContainer.TestDataContainer;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;

public class EmptyTemplateSteps {
    private EmptyTemplatePage emptyTemplatePage;
    private int initialValue = 0;
    private SoftAssertions softly = new SoftAssertions();


    @Step()
    public void stepWithOneParameter(int initialValueParameter) {
        initialValue = initialValueParameter;
    }

    @Step()
    public void stepWithTwoParameters(int firstParameter, int secondParameter) {
        assertEquals("This message will be thrown when the test does not pass in the console", initialValue + firstParameter, secondParameter);
    }

    @Step()
    public void navigate(String url){
        getDriver().navigate().to(url);
    }

    @Step()
    public void inputString(String something){
        emptyTemplatePage.searchField.sendKeys(something);
        emptyTemplatePage.searchField.submit();
    }

    @Step()
    public void dismissPrivacyPolicy(){
        emptyTemplatePage.acceptPrivacyBtn.click();
    }

    @Step()
    public void verifySearchResultsTitles(String something){
        System.out.println("The number of search results titles is: " + emptyTemplatePage.resultsTitles.size());
        for(WebElement element : emptyTemplatePage.resultsTitles) {
            softly.assertThat(element.getAttribute("textContent").toLowerCase()).contains(something);
        }
        softly.assertAll();
    }

    @Step()
    public void checkHeader(String header){

    }

    @Step()
    public void tableContains(String Index, String col1, String col2, String col3, String col4, String col5, String col6, String col7) throws InterruptedException {
    }

    @Step()
    public void checkTitle(String title){
        softly.assertThat(emptyTemplatePage.getDriver().getTitle()).contains(title);
        System.out.println(getDriver().getTitle());
    }

    @Step()
    public void theContentMatches(){
        softly.assertThat(emptyTemplatePage.contentParagraph.getTextContent().matches(TestDataContainer.content));
        System.out.println(emptyTemplatePage.contentParagraph.getTextContent());
    }

    @Step()
    public void clickAndVerifyButton(String button){
        if(button == "Blue") {
        Assert.assertFalse(emptyTemplatePage.blueButton.getTextContent().isEmpty());
        } else if (button == "Red") {
            Assert.assertFalse(emptyTemplatePage.redButton.getTextContent().isEmpty());
        } else {
            Assert.assertFalse(emptyTemplatePage.greenButton.getTextContent().isEmpty());
        }
    }

        @Step()
    public void iVerifyCanvasHasNumbers(){
    }

    @Step()
    public void checkBottomRedirect() throws InterruptedException {
    }

    @Step()
    public void checkTopRedirect(){
    }

    @Step()
    public void navigateBack(){
    }

    @Step()
    public void closeTab(){
    }
}