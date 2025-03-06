package com.demo.actions;

import com.demo.pages.Pages;

public class PilotProjectActions {
    public String getCaptchaResult() {
        String[] expression = Pages.pilotProjectPage().getQuestionCaptcha().trim().split(" ");
        return (Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])) + "";
    }
}
