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
public class SoftwareTesterPageTest extends BaseTest {

    @Test(description = "softwareTesterFormSubmissionTests")
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

        Actions.softwearTesterActions().openTab();

        Pages.softwareTesterPage().selectSection();
        Pages.softwareTesterPage().enterName(name);
        Pages.softwareTesterPage().enterEmail(email);
        Pages.softwareTesterPage().enterMessage(message);
        Pages.softwareTesterPage().enterPhone(phone);
        Pages.softwareTesterPage().uploadFile(pathToCV);
        Pages.pilotProjectPage().enterCaptcha(Actions.softwearTesterActions().getCaptchaResult());
        Pages.pilotProjectPage().submitForm();
        Assert.assertTrue(Pages.softwareTesterPage().isVisible(), "problems with section selection");
        Assert.assertEquals(Pages.softwareTesterPage().getName(), name, "problems entering name");
        Assert.assertEquals(Pages.softwareTesterPage().getEmail(), email, "problems entering email");
        Assert.assertEquals(Pages.softwareTesterPage().getMessage(), message, "problems entering message");
        Assert.assertEquals(Pages.softwareTesterPage().getPhone(),phone, "problems entering phone number");
        Assert.assertTrue(Pages.softwareTesterPage().verifySuccesText(), "problems with update files");
        Assert.assertEquals(Pages.softwareTesterPage().getCaptcha(), Actions.softwearTesterActions().getCaptchaResult(), "problems entering captcha");
        Assert.assertTrue(Pages.softwareTesterPage().getSuccessMessage(), "problems sending the form");
    }

}