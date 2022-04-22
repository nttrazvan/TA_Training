package tests;

import Pages.ConfiguratorPage;
import Pages.EmptyTemplatePage;
import Pages.IndexBMWPage;
import Pages.ModelPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class checkNavigationTest {

    protected IndexBMWPage indexBMWPage;

    SoftAssertions softly = new SoftAssertions();

    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes!");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
        //EmptyTemplatePage.agreeCookiePolicyBtn().click();

        indexBMWPage = new IndexBMWPage(getDriver);
    }

    @Test
    @Tag(value = "testNavigation")
    public void goToBMWConfiguratorTest(){
        softly.assertThat(getDriver.getTitle()).contains("BMW").as("This message will be shown when the assertion fails");
        softly.assertAll();
        ConfiguratorPage configuratorPage = indexBMWPage.clickConfigurator();
        //System.out.println(configuratorPage.getTitleText());
        softly.assertThat(configuratorPage.getTitleText()).contains("BMW.").as("This message will be shown when the assertion fails");
    }

    @Test
    @Tag(value = "testChooseModel")
    public void chooseModelTest(){
        softly.assertThat(getDriver.getTitle()).contains("BMW").as("This message will be shown when the assertion fails");
        softly.assertAll();
        ModelPage modelPage = indexBMWPage.clickModel();
        //System.out.println(modelPage.getTitleText().contains("modelele"));
        softly.assertThat(modelPage.getTitleText()).contains("modelele").as("This message will be shown when the assertion fails");
        //modelPage.clickI3Model();
    }

    @AfterEach
    public void afterMethod() {
        System.out.println("This method is called after each test executes!");
        DriverBuilder.kill();
    }
}
