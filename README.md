# Java-selenium-cucumber

Automation Framework POC using Java, Selenium and Cucumber for http://automationpractice.com/ 

Currently working on Google Chrome 79.0.3945.88

### Prerequisites

You need to have Java 8 JDK installed along with Gradle 4.5.0

### Installing
Configure the required settings for the test execution in gradle.propeties file. For example:

```
baseURL = http://automationpractice.com
browser = Chrome
featuresPath = src/test/resources/features/
tags = @ShoppingCart
```

To clean and install all dependencies, run:

```
$ gradle clean compileJava compileTestJava
```

## Reporting

The report for the test execution is created using the plugin Cucumber Reporting 3.1.0.
The report HTML file can be found inside the folder: build/cucumber/reports/ after the test execution. 
