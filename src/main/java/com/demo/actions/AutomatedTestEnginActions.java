package com.demo.actions;

import com.demo.pages.Pages;

public class AutomatedTestEnginActions {
    public String getCaptchaResult() {
        String[] expression = Pages.automatedTestEnginPage().getQuestionCaptcha().trim().split(" ");
        return (Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])) + "";
    }
}
