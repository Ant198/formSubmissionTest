package com.demo;

import com.demo.actions.Actions;
import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import com.demo.utils.Constants;
import com.demo.utils.CsvReader;
import com.demo.utils.SelenideTools;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AutomatedTestEnginPageTest extends BaseTest {
    @Test
    public void formSubmissionTest() throws CsvException {
        List<String[]> data = CsvReader.readCSV(Constants.CSVPATH);
        for(String[]row : data) {
            System.setProperty(row[0], row[1]);
        }

        String name = System.getProperty("name");
        String email = System.getProperty("email");
        String message = System.getProperty("message");
        String phone = System.getProperty("phone");
        String pathToCV = System.getProperty("pathToCV");

        logInfo("name is " + name);
        logInfo("email is " + email);
        logInfo("message is " + message);
/*
        SelenideTools.switchTo().newWindow(WindowType.TAB);
        SelenideTools.getDriver().navigate().to(Constants.AUTOMATEDTESTENGINURL);
        Assert.assertEquals(Actions.mainActions().getCurrentUrl(), Constants.AUTOMATEDTESTENGINURL, "page not found");
*/
        Actions.mainActions().openNewTab();
        Pages.automatedTestEnginPage().selectSection();
        Pages.automatedTestEnginPage().enterName(name);
        Pages.automatedTestEnginPage().enterEmail(email);
        Pages.automatedTestEnginPage().enterMessage(message);
        Pages.automatedTestEnginPage().enterPhone(phone);
        Pages.automatedTestEnginPage().uploadFile(pathToCV);
        Pages.automatedTestEnginPage().enterCaptcha(Actions.automatedTestEnginActions().getCaptchaResult());
        Pages.automatedTestEnginPage().submitForm();
        Assert.assertTrue(Pages.automatedTestEnginPage().isVisible(), "problems with section selection");
        Assert.assertEquals(Pages.automatedTestEnginPage().getName(), name, "problems entering name");
        Assert.assertEquals(Pages.automatedTestEnginPage().getEmail(), email, "problems entering email");
        Assert.assertEquals(Pages.automatedTestEnginPage().getMessage(), message, "problems entering message");
        Assert.assertEquals(Pages.automatedTestEnginPage().getPhone(), phone, "problems entering phone number");
        Assert.assertTrue(Pages.automatedTestEnginPage().verifySuccesText(), "problems with update files");
        Assert.assertEquals(Pages.automatedTestEnginPage().getCaptcha(), Actions.automatedTestEnginActions().getCaptchaResult(), "problems entering captcha");
        Assert.assertTrue(Pages.automatedTestEnginPage().getSuccessMessage(), "problems sending the form");
    }
}
