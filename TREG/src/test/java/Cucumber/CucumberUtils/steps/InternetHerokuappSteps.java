package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.InternetHerokuappItem;
import Cucumber.CucumberUtils.pages.InternetHerokuappPage;
import Cucumber.TestDataContainer.InternetDataContainer;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class InternetHerokuappSteps {/*ToDo - please add spaces after class declaration*/
    private InternetHerokuappPage internetHerokuappPage;
    private InternetDataContainer internetDataContainer;
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private SoftAssertions softly = new SoftAssertions();

    @Step()
    public void navigate(String url) {
        getDriver().navigate().to(url);
    }

    @Step()
    public void checkHeader(String headers) {
        for (WebElement element : internetHerokuappPage.tableHeader) {
            softly.assertThat(element.getAttribute("textContent")).contains((headers));
            System.out.println("The header is: " + element.getAttribute("textContent"));
        }
        softly.assertAll();
    }

    @Step()
    public void tableContains(String col1, String col2, String col3, String col4, String col5, String col6) throws InterruptedException {
        boolean elementIsPresent = false;
        List<InternetHerokuappItem> elementsFromPage = internetHerokuappPage.tableRetrieveValues();
        for (InternetHerokuappItem element : elementsFromPage) {
            if (element.Lorem.contains(col1) || element.Ipsum.contains(col2) || element.Dolor.contains(col3) || element.Sit.contains(col4) || element.Amet.contains(col5) || element.Diceret.contains(col6)) {
                elementIsPresent = true;
            }
        }
        softly.assertThat(elementIsPresent).isEqualTo(true);
        softly.assertAll();
    }
//Todo- remove empty line

    @Step()
    public void checkTitle(String expectedTitle) {
        String actualTitle = internetHerokuappPage.getDriver().getTitle();
        logger.info(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Step()
    public void theContentMatches() {
        Assert.assertEquals(internetHerokuappPage.contentParagraph.getTextContent(), internetDataContainer.content);
        logger.info(internetHerokuappPage.contentParagraph.getTextContent());
    }
//ToDo - for string comparison pleae use x.equals("asd")
    @Step()
    public void clickAndVerifyButton(String button) {
        if (button == "Blue") {
            Assert.assertFalse(internetHerokuappPage.blueButton.getTextContent().length() == 0);
            System.out.println("Text before click: " + internetHerokuappPage.blueButton.getTextContent());
            internetHerokuappPage.blueButton.click();
            System.out.println("Text after click: " + internetHerokuappPage.blueButton.getTextContent());
        } else if (button == "Red") {
            Assert.assertNotEquals(internetHerokuappPage.redButton.getTextContent().length(), 0);
            System.out.println("Text before click: " + internetHerokuappPage.redButton.getTextContent());
            internetHerokuappPage.redButton.click();
            System.out.println("Text after click: " + internetHerokuappPage.redButton.getTextContent());
        } else {
            Assert.assertNotEquals(internetHerokuappPage.greenButton.getTextContent().length(), 0);
            System.out.println("Text before click: " + internetHerokuappPage.greenButton.getTextContent());
            internetHerokuappPage.greenButton.click();
            System.out.println("Text after click: " + internetHerokuappPage.greenButton.getTextContent());
        }
    }
//ToDo - nicely done :D
    @Step()
    public void iVerifyCanvasHasNumbers() {
        String answer = new String();
        ArrayList<WebElement> scripts = new ArrayList<WebElement>((ArrayList<WebElement>) getDriver().findElements(By.tagName("script")));
        for (int i = 0; i < scripts.size(); i++) {
            String focusText = scripts.get(i).getAttribute("innerHTML");
            if (focusText.contains("canvas.strokeText")) {
                answer = focusText.substring(focusText.indexOf("Answer"), focusText.indexOf("',"));
                break;
            }
        }
        System.out.println(answer.substring(8));
    }
//ToDo - you can create a separate helper method to switch between window handles in a parameterized way, not mandatory
    @Step()
    public void checkBottomRedirect(String pageTitle) throws InterruptedException {
        String originalWindow = getDriver().getWindowHandle();
        assert getDriver().getWindowHandles().size() == 1;
        internetHerokuappPage.bottomRedirect.click();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(3000);
        String newTabTitle = getDriver().getTitle();
        System.out.println(newTabTitle);
        System.out.println("The first part of the title is: " + newTabTitle.substring(0, 18));
        Assert.assertTrue(newTabTitle.contains(pageTitle));
        getDriver().close();
    }

    @Step()
    public void checkTopRedirect(String pageTitle) throws InterruptedException {
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        System.out.println(tabs.size());
        getDriver().switchTo().window(String.valueOf(tabs.get(0)));
        internetHerokuappPage.topRedirect.click();
        String newPageTitle = getDriver().getTitle();
        System.out.println(newPageTitle);
        System.out.println("The first part of the title is: " + newPageTitle.substring(0, 6));
        Assert.assertTrue(newPageTitle.substring(0, 6).equals(pageTitle));
    }
//ToDo - this can be a generic step
    @Step()
    public void navigateBack() {
        getDriver().navigate().back();
    }
}