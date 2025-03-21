package com.demo.core.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.demo.actions.Actions;
import com.demo.core.allure.AllureLogger;
import com.demo.core.config.SelenideConfig;
import com.demo.utils.Constants;
import com.demo.utils.SelenideTools;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.URL;
import java.util.ArrayList;

@Listeners({TestListener.class})
public class BaseTest extends AllureLogger {

    @BeforeTest(alwaysRun = true, description = "Opening web browser...")
    public void setUp() throws Exception {
        logInfo("Creating web driver configuration..."); //test
        SelenideConfig.createBrowserConfig(System.getProperty("selenide.browser", "chrome"));
        Configuration.remote = "http://selenium:4444/wd/hub";
        configLog(this.getClass().getSimpleName());
        logInfo("Open browser...");
        Selenide.open();
        Configuration.timeout = 10000;
    }


    @AfterTest(alwaysRun = true, description = "Closing web browser...")
    public void tearDown() {
        Selenide.closeWebDriver();
        logInfo("Web driver closed!");
    }
}
