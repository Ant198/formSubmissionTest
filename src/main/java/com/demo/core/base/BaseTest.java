package com.demo.core.base;

import com.codeborne.selenide.Selenide;
import com.demo.actions.Actions;
import com.demo.core.allure.AllureLogger;
import com.demo.core.config.SelenideConfig;
import com.demo.utils.Constants;
import org.checkerframework.checker.units.qual.C;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest extends AllureLogger {

    @BeforeTest(alwaysRun = true, description = "Opening web browser...")
    public void setUp() throws Exception {

        logInfo("Creating web driver configuration..."); //test
        SelenideConfig.createBrowserConfig(System.getProperty("selenide.browser", "chrome"));
        configLog(this.getClass().getSimpleName());
        logInfo("Open browser...");
        Selenide.open();
    }


    @AfterTest(alwaysRun = true, description = "Closing web browser...")
    public void tearDown(ITestResult result) {
        Selenide.closeWebDriver();
        logInfo("Web driver closed!");
    }
}
