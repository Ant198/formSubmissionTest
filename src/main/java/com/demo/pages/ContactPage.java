package com.demo.pages;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class ContactPage extends PageTools {
    private final By nameFieldLocator = By.xpath("//input[@data-original_id=\"name\"]");
    private final By emailFieldLocator = By.xpath("//input[@data-original_id=\"email\"]");
    private final By messageFieldLocator = By.xpath("//textarea[@data-original_id=\"message\"]");
    private final By submitLocator = By.xpath("//button[@name=\"et_builder_submit_button\"]");
    private final By captchaLocator = By.xpath("//input[@name=\"et_pb_contact_captcha_0\"]");
    private final By questionCaptchaLocator = By.xpath("//span[contains(@class,\"et_pb_contact_captcha_question\")]");
    private final By successMessageLocator = By.xpath("//div[@id=\"form\"]//strong");

    public void enterName(String name) {
        type(name, nameFieldLocator);
    }

    public void enterEmail(String email) {
        type(email, emailFieldLocator);
    }

    public void enterMessage(String message) {
        type(message, messageFieldLocator);
    }

    public void enterCaptcha(String captcha) {
        type(captcha, captchaLocator);
    }

    public void submitForm() {
        click(submitLocator);
    }
    public String getName() {
        return getElementAttributeValue("value", nameFieldLocator);
    }

    public String getEmail() {
        return getElementAttributeValue("value", emailFieldLocator);
    }

    public String getMessage() {
        return  getElementAttributeValue("value", messageFieldLocator);
    }

    public Boolean getSuccessMessage() {
        return isElementVisible(successMessageLocator);
    }

    public String getCaptcha() {
        return getElementAttributeValue("value", captchaLocator);
    }

    public String getQuestionCaptcha() {
        return getElementText(questionCaptchaLocator);
    }

}
