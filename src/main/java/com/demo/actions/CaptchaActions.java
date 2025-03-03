package com.demo.actions;

import com.demo.pages.Pages;

public class CaptchaActions {
    public String getCaptchaResult() {
        String[] expression = Pages.contactPage().getQuestionCaptcha().trim().split(" ");
        return (Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])) + "";
    }
}
