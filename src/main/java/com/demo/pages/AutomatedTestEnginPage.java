package com.demo.pages;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class AutomatedTestEnginPage extends PageTools {
    private final By sectionLocator = By.xpath("//div[contains(@class, \"et_pb_text_2\")]/div");
    private final By nameFieldLocator = By.xpath("//input[@data-original_id=\"name\"]");
    private final By emailFieldLocator = By.xpath("//input[@data-original_id=\"email\"]");
    private final By messageFieldLocator = By.xpath("//textarea[@data-original_id=\"message\"]");
    private final By phoneFieldLocator = By.xpath("//input[@data-original_id=\"phone\"]");
    private final By captchaLocator = By.xpath("//input[@name=\"et_pb_contact_captcha_0\"]");
    private final By questionCaptchaLocator = By.xpath("//span[contains(@class,\"et_pb_contact_captcha_question\")]");
    private final By successMessageLocator = By.xpath("//div[@id=\"et_pb_contact_form_0\"]");
    private final By submitLocator = By.xpath("//button[@name=\"et_builder_submit_button\"]");
    private final By uploadFileLocator = By.xpath("//input[@type=\"file\"]");
    private final By proofUploadLocator = By.xpath("//span[contains(@class, \"et_pb_file_chosen_desc\")]");

    public void selectSection() {
        click(sectionLocator);
    }

    public boolean isVisible() {
        return isElementVisible(sectionLocator);
    }

    public void enterName(String name) {
        type(name, nameFieldLocator);
    }

    public void enterEmail(String email) {
        type(email, emailFieldLocator);
    }

    public void enterMessage(String message) {
        type(message, messageFieldLocator);
    }

    public void enterPhone(String company) {
        type(company, phoneFieldLocator);
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

    public String getPhone() { return getElementAttributeValue("value", phoneFieldLocator);}

    public void uploadFile (String path) {
        uploadFile(path, uploadFileLocator);
    }

    public boolean verifySuccesText() {
        return getElementText(proofUploadLocator).contains("selected");
    }

    public Boolean getSuccessMessage() {
        waitForElementVisibility(successMessageLocator);
        return isElementVisible(successMessageLocator);
    }

    public String getCaptcha() {
        waitForElementVisibility(captchaLocator);
        return getElementAttributeValue("value", captchaLocator);
    }

    public String getQuestionCaptcha() {
        return getElementText(questionCaptchaLocator);
    }
}
