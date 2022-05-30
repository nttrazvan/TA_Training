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
         for(WebElement element : emptyTemplatePage.tableHeader) {
            softly.assertThat(element.getAttribute("textContent")).contains(header);
             System.out.println("The header is: " + element.getAttribute("textContent"));
        }
        softly.assertAll();
    }

    @Step()
    public void tableContains(String Index, String col1, String col2, String col3, String col4, String col5, String col6, String col7) throws InterruptedException {

    }

    @Step()
    public void checkTitle(String title){
        String actualTitle = emptyTemplatePage.getDriver().getTitle();
        Assert.assertEquals(actualTitle,title);
    }

    @Step()
    public void theContentMatches(){
        Assert.assertEquals(emptyTemplatePage.contentParagraph.getTextContent(),TestDataContainer.content);
    }

    @Step()
    public void clickAndVerifyButton(String button){
        if(button == "Blue") {
            Assert.assertFalse(emptyTemplatePage.blueButton.getTextContent().length() == 0);
        } else if (button == "Red") {
            Assert.assertNotEquals(emptyTemplatePage.redButton.getTextContent().length(),0);
        } else {
            Assert.assertNotEquals(emptyTemplatePage.greenButton.getTextContent().length(),0);
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