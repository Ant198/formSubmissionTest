package com.demo.actions;

import com.demo.pages.Pages;

public class GameTesterActions {
    public String getCaptchaResult() {
        String[] expression = Pages.gameTesterPage().getQuestionCaptcha().trim().split(" ");
        return (Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])) + "";
    }
}
