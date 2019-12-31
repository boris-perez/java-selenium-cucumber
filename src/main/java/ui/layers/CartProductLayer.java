package ui.layers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.HomePage;

/**
 * This class contains the methods to interact with the CartProductLayer.
 */
public class CartProductLayer extends BasePageObject {
    @FindBy(id = "//span[@title='Continue shopping']")
    WebElement continueShoppingButton;

    /**
     * Constructor for CartProductLayer.
     */
    public CartProductLayer() {
        waitForPageLoaded();
    }

    @Override
    public void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
    }

    /**
     * Clicks on continue shopping button.
     * @return HomePage
     */
    public HomePage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new HomePage();
    }
}
