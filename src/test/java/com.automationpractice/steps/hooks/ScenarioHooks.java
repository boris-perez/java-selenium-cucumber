package com.automationpractice.steps.hooks;

import core.selenium.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScenarioHooks {
    public final String SCENARIO_FAILED = "failed";
    private Logger log = Logger.getLogger(getClass());

    /**
     * Takes the screenshot and embeds into the cucumber.json
     *
     * @param scenario
     */
    public void embedScreenshot(Scenario scenario) {
        log.info("Take Screenshot for scenario: " + scenario.getName());
        try {
            WebDriver driver = DriverManager.getInstance().getWebDriver();
            String parentWindowHandle = driver.getWindowHandle();

            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);

                // Take screenshot of each browser window open
                byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);

                // Embeds screenshot to cucumber.json
                scenario.embed(screenshot, "image/jpeg");
            }

            // To switch back to parent window
            driver.switchTo().window(parentWindowHandle);
        } catch (WebDriverException e) {
            log.info("Failed to take a browser screenshot.", e);
        }
    }

    @After(order = 10000)
    public void afterScenarioTakeScreenshot(Scenario scenario) {
        if (scenario.getStatus().equals(SCENARIO_FAILED)) {
            embedScreenshot(scenario);
        }
    }
}