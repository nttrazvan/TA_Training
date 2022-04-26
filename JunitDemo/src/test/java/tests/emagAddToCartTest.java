package tests;

import Pages.EmagHomePage;
import Pages.EmagSearchResultsPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import testData.testDataEmag;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class emagAddToCartTest {

    SoftAssertions softly = new SoftAssertions();

    @BeforeEach
    public void beforeMethod() throws IOException, InterruptedException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(5);
        getDriver.get(System.getProperty("emag.url"));
        getDriver.manage().window().maximize();
        Thread.sleep(2000);
        EmagHomePage.agreeCookiePolicyBtn().click();
    }

    @Test
    @Tag(value = "addToCart")
    public void verifySearchResultTest() {
        EmagHomePage.searchField().sendKeys(testDataEmag.tvString);
        EmagHomePage.searchField().submit();
        for (WebElement element : EmagSearchResultsPage.results()) {
            int i = EmagSearchResultsPage.results().indexOf(element);
            softly.assertThat(element.getAttribute("textContent").toLowerCase()).contains(testDataEmag.tvString)
                    .as("The title numbered: " + i + " does not contain the string: " + testDataEmag.tvString);
        }
        softly.assertAll();
    }

    @Test
    @Tag(value = "addToCart")
    public void addToCartSuccessfulTest() throws InterruptedException {
        EmagHomePage.searchField().sendKeys(testDataEmag.tvString);
        EmagHomePage.searchField().submit();
        EmagSearchResultsPage.addToCartBtn().click();
        Thread.sleep(2000);
        softly.assertThat(EmagSearchResultsPage.productPurchasedModalTitle().getAttribute("textContent")).contains("Produsul a fost adaugat in cos");
        softly.assertAll();
    }

    @Test
    @Tag(value = "addToCart")
    public void addToCartFailedTest() throws InterruptedException {
        EmagHomePage.searchField().sendKeys(testDataEmag.tvString);
        EmagHomePage.searchField().submit();
        EmagSearchResultsPage.addToCartBtn().click();
        Thread.sleep(2000);
        softly.assertThat(EmagSearchResultsPage.productPurchasedModalTitle().getAttribute("textContent")).contains("Produsul nu a fost adaugat in cos");
        softly.assertAll();
    }

    @AfterEach
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }

}
