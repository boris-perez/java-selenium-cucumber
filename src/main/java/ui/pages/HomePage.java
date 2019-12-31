package ui.pages;

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
}
