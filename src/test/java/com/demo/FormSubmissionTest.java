package com.demo;

import com.codeborne.selenide.SelenideElement;
import com.demo.actions.Actions;
import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import com.demo.utils.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;

@Epic("Test Epic")
@Feature("Test feature")
@Owner("QA Fedorov Anton")
public class FormSubmissionTest extends BaseTest {

    @Test(description = "firstTest")
    public void formSubmissionTest() {
        String name = System.getProperty("myArg", "Щnton");
        String email = System.getProperty("myArg", " anton@example.com");
        String message = System.getProperty("myArg", "Test Message");

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
