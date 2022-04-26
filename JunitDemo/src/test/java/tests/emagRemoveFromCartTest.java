package tests;

import Pages.EmagHomePage;
import Pages.EmagSearchResultsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testData.testDataEmag;
import utils.DriverBuilder;
import utils.Helpers;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static utils.DriverBuilder.getDriver;

public class emagRemoveFromCartTest {

    @BeforeEach
    public void beforeMethod() throws IOException, InterruptedException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(5);
        getDriver.get(System.getProperty("emag.url"));
        getDriver.manage().window().maximize();
        EmagHomePage.searchField().sendKeys(testDataEmag.tvString);
        EmagHomePage.searchField().submit();
        EmagSearchResultsPage.addToCartBtn().click();
        Thread.sleep(2000);
        EmagSearchResultsPage.productPurchasedModalCloseBtn().click();
    }

    @Test
    @Tag(value = "removeFromCart")
    public void removeFromCartTest() throws InterruptedException {
        Actions action = new Actions(getDriver);
        action.moveToElement(EmagHomePage.cartBtn()).build().perform();
        Thread.sleep(1000);
        action.moveToElement(EmagSearchResultsPage.cartProductItem()).build().perform();
        EmagSearchResultsPage.cartProductRemoveItemBtn().click();
        Thread.sleep(1000);
        assertEquals(EmagHomePage.navbarCartDropdownMessage().getAttribute("textContent"), "Nu ai niciun produs în coș", "This message will be thrown if the assertion fails");

    }

    @AfterEach
    public void afterMethod() {
        System.out.println("This method is called after each test executes");
        DriverBuilder.kill();
    }
}
