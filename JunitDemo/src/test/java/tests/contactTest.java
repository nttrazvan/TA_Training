package tests;

import Pages.ContactPage;
import Pages.EmptyTemplatePage;
import Pages.HomePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testData.dataContainer;
import testData.testDataContainer;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class contactTest {

    SoftAssertions softly = new SoftAssertions();

    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
        getDriver.navigate().to("https://decrasystems.ro/contact/");
    }

    @Test
    @Tag(value = "enterContactData")
    public void fillContactDataTest1() {
        ContactPage.enterName().sendKeys(dataContainer.name);
        ContactPage.enterEmail().sendKeys(dataContainer.email);
        ContactPage.enterTelephone().sendKeys(dataContainer.telephone);
        ContactPage.enterSubject().sendKeys(dataContainer.subject);
        ContactPage.enterMessage().sendKeys(dataContainer.message);
    }

    @Test
    @Tag(value = "submitBtn")
    public void findSubmitBtn() {
        softly.assertThat(getDriver.findElement(By.tagName("button"))).as("This message will be thrown if the assertion fails");
        softly.assertAll();
    }


    @AfterEach
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
