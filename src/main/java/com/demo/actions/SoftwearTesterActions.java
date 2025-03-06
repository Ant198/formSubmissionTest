package com.demo.actions;

import com.demo.pages.Pages;

public class SoftwearTesterActions {
    public String getCaptchaResult() {
        String[] expression = Pages.softwareTesterPage().getQuestionCaptcha().trim().split(" ");
        return (Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])) + "";
    }
}
