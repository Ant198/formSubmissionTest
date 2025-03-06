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

public class GameTesterFormSubmissionTest extends BaseTest {
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

        Pages.gameTesterPage().selectSection();
        Pages.gameTesterPage().enterName(name);
        Pages.gameTesterPage().enterEmail(email);
        Pages.gameTesterPage().enterMessage(message);
        Pages.gameTesterPage().enterPhone(phone);
        Pages.automatedTestEnginPage().uploadFile(pathToCV);
        Pages.gameTesterPage().enterCaptcha(Actions.gameTesterActions().getCaptchaResult());
        Pages.gameTesterPage().submitForm();
        Assert.assertTrue(Pages.gameTesterPage().isVisible(), "problems with section selection");
        Assert.assertEquals(Pages.gameTesterPage().getName(), name, "problems entering name");
        Assert.assertEquals(Pages.gameTesterPage().getEmail(), email, "problems entering email");
        Assert.assertEquals(Pages.gameTesterPage().getMessage(), message, "problems entering message");
        Assert.assertEquals(Pages.gameTesterPage().getPhone(),phone, "problems entering phone number");
        Assert.assertTrue(Pages.gameTesterPage().verifySuccesText(), "problems with update files");
        Assert.assertEquals(Pages.gameTesterPage().getCaptcha(), Actions.gameTesterActions().getCaptchaResult(), "problems entering captcha");
        Assert.assertTrue(Pages.gameTesterPage().getSuccessMessage(), "problems sending the form");
    }
}
