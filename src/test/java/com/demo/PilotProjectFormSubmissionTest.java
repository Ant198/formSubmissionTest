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
public class PilotProjectFormSubmissionTest extends BaseTest {
    @Test(description = "pilotProjectFormSubmissionTests")
    public void formSubmissionTest() throws CsvException {

        List<String[]> data = CsvReader.readCSV(Constants.CSVPATH);
        for(String[]row : data) {
            System.setProperty(row[0], row[1]);
        }

        String name = System.getProperty("name");
        String email = System.getProperty("email");
        String message = System.getProperty("message");
        String company = System.getProperty("company");
        String country = System.getProperty("country");

        logInfo("name is " + name);
        logInfo("email is " + email);
        logInfo("message is " + message);

        Actions.pilotProjectActions().openTab();

        Pages.pilotProjectPage().enterName(name);
        Pages.pilotProjectPage().enterEmail(email);
        Pages.pilotProjectPage().enterCompanyName(company);
        Pages.pilotProjectPage().enterMessage(message);
        Pages.pilotProjectPage().selectCountry(country);
        Pages.pilotProjectPage().enterCaptcha(Actions.pilotProjectActions().getCaptchaResult());
        Pages.pilotProjectPage().submitForm();
        Assert.assertEquals(Pages.pilotProjectPage().getName(), name, "problems entering name");
        Assert.assertEquals(Pages.pilotProjectPage().getEmail(), email, "problems entering email");
        Assert.assertEquals(Pages.pilotProjectPage().getMessage(), message, "problems entering message");
        Assert.assertTrue(Pages.pilotProjectPage().isCountrySelected(country), "country did not select");
        Assert.assertEquals(Pages.pilotProjectPage().getCaptcha(), Actions.pilotProjectActions().getCaptchaResult(), "problems entering captcha");
        Assert.assertTrue(Pages.pilotProjectPage().getSuccessMessage(), "problems sending the form");

    }
}