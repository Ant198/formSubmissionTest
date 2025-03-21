package com.demo;

import com.codeborne.selenide.Selenide;
import com.demo.actions.Actions;
import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import com.demo.utils.Constants;
import com.demo.utils.CsvReader;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

@Epic("Test Epic")
@Feature("Test feature")
@Owner("QA Fedorov Anton")
public class AutomatedTestEnginPageTest extends BaseTest {
    @Test(description = "automatedTestEnginFormSubmissionTests")
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

        Actions.automatedTestEnginActions().openTab();

        Pages.automatedTestEnginPage().selectSection();
        Pages.automatedTestEnginPage().enterName(name);
        Pages.automatedTestEnginPage().enterEmail(email);
        Pages.automatedTestEnginPage().enterMessage(message);
        Pages.automatedTestEnginPage().enterPhone(phone);
        Pages.automatedTestEnginPage().uploadFile(pathToCV);
        Pages.automatedTestEnginPage().enterCaptcha(Actions.automatedTestEnginActions().getCaptchaResult());
        Pages.automatedTestEnginPage().submitForm();
        Selenide.sleep(10000);
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
