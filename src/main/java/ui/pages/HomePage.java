package ui.pages;

import core.selenium.UIMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.sections.BestSellersSection;

/**
 * This class contains the methods to interact with the HomePage.
 */
public class HomePage extends BasePageObject {
    public BestSellersSection bestSellersSection;

    @FindBy(xpath = "//a[@href='#blockbestsellers']")
    WebElement bestSellersTab;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement shoppingCartDropdown;

    private By checkoutButtonXpath = By.xpath("//span[contains(text(), 'Check out')]");

    /**
     * Constructor for HomePage.
     */
    public HomePage() {
        waitForPageLoaded();
    }

    @Override
    public void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(bestSellersTab));
    }

    /**
     * Clicks on best sellers tab.
     */
    public void clickBestSellersTab() {
        bestSellersTab.click();
        bestSellersSection = new BestSellersSection();
    }

    /**
     * Selects check out option from shopping cart dropdown.
     * @return ShoppingCartPage
     */
    public ShoppingCartPage selectCheckoutCartOption() {
        UIMethods.moveMouseToElement(shoppingCartDropdown);
        WebElement checkoutButton = UIMethods.getElement(checkoutButtonXpath);
        checkoutButton.click();
        return new ShoppingCartPage();
    }
}
