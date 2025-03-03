package com.demo.actions;

import com.demo.pages.Pages;

public class CaptchaActions {
    public String getCaptchaResult() {
        String[] exprasion = Pages.contactPage().getQuestionCaptcha().trim().split(" ");
        return (Integer.parseInt(exprasion[0]) + Integer.parseInt(exprasion[2])) + "";
    }
}
