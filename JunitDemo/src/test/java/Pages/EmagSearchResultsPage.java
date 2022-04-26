package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class EmagSearchResultsPage {

    public static java.util.List<WebElement> results() {
        return getDriver.findElements(By.cssSelector("#card_grid .card-item .card-v2-title"));
    }

    public static WebElement addToCartBtn() {
        return getDriver.findElement(By.cssSelector("#card_grid .card-item .yeahIWantThisProduct"));
    }

    public static WebElement productPurchasedModalTitle() {
        return getDriver.findElement(By.cssSelector(".product-purchased-modal .modal-header h4"));
    }

    public static WebElement productPurchasedModalCloseBtn() {
        return getDriver.findElement(By.cssSelector(".product-purchased-modal .modal-header .close"));
    }

    public static WebElement cartProductItem() {
        return getDriver.findElement(By.cssSelector(".navbar-cart-dropdown .nav-product-container"));
    }

    public static WebElement cartProductRemoveItemBtn() {
        return getDriver.findElement(By.cssSelector(".navbar-cart-dropdown .nav-product-line_remove"));
    }
}
