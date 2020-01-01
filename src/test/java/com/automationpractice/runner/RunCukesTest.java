package com.automationpractice.runner;

import core.selenium.DriverManager;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;

public class RunCukesTest extends AbstractTestNGCucumberTests {
    private static Logger log = Logger.getLogger("RunCukesTest");

    @AfterTest
    public void afterExecution() {
        log.info("After method executed after all features");
        DriverManager.getInstance().quitDriver();
    }
}
