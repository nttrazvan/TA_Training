package tests;

import Pages.EmagHomePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class emagHomePageTest {

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
    @Tag(value = "emagHome")
    public void launchBrowserTest(){
        softly.assertThat(getDriver.getTitle()).contains("eMAG.ro - Căutarea nu se oprește niciodată");
        softly.assertAll();
    }

    @Test
    @Tag(value = "emagHome")
    public void checkCart(){
        Actions action = new Actions(getDriver);
        action.moveToElement(EmagHomePage.cartBtn()).build().perform();
        softly.assertThat(EmagHomePage.navbarCartDropdownMessage().getAttribute("textContent")).contains("Nu ai niciun produs în coș");
        softly.assertAll();
    }

    @AfterEach
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }

}
