package com.demo.actions;

import com.demo.pages.Pages;
import com.demo.utils.Constants;
import com.demo.utils.SelenideTools;

public class ContactActions {
    public String getCaptchaResult() {
        String[] expression = Pages.contactPage().getQuestionCaptcha().trim().split(" ");
        return (Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])) + "";
    }

    public void openTab() {
        Actions.mainActions().switchToTab(0);
        SelenideTools.openUrl(Constants.CONTACTURL);
    }
}