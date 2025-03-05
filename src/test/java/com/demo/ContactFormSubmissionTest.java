package com.demo;

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
public class ContactFormSubmissionTest extends BaseTest {

    @Test(description = "firstTest")
    public void formSubmissionTest() throws CsvException {
        List<String[]> data = CsvReader.readCSV(Constants.CSVPATH);
        for(String[]row : data) {
            System.setProperty(row[0], row[1]);
        }
        String name = System.getProperty("name");
        String email = System.getProperty("email");
        String message = System.getProperty("message");

        logInfo("name is " + name);
        logInfo("email is " + email);
        logInfo("message is " + message);

        Assert.assertEquals(Actions.mainActions().getCurrentUrl(), Constants.URL, "page not found");
        Pages.contactPage().enterName(name);
        Pages.contactPage().enterEmail(email);
        Pages.contactPage().enterMessage(message);
        Pages.contactPage().enterCaptcha(Actions.captchaActions().getCaptchaResult());
        Pages.contactPage().submitForm();
        Assert.assertEquals(Pages.contactPage().getName(), name, "problems entering name");
        Assert.assertEquals(Pages.contactPage().getEmail(), email, "problems entering email");
        Assert.assertEquals(Pages.contactPage().getMessage(), message, "problems entering message");
        Assert.assertEquals(Pages.contactPage().getCaptcha(), Actions.captchaActions().getCaptchaResult(), "problems entering captcha");
        Assert.assertTrue(Pages.contactPage().getSuccessMessage(), "problems sending the form");

    }
}