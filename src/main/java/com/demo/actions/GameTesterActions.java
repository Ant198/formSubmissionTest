package com.demo.actions;

import com.demo.pages.Pages;
import com.demo.utils.Constants;
import com.demo.utils.SelenideTools;

public class GameTesterActions {
    public String getCaptchaResult() {
        String[] expression = Pages.gameTesterPage().getQuestionCaptcha().trim().split(" ");
        return (Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])) + "";
    }

    public void openTab() {
        Actions.mainActions().openNewTab();
        Actions.mainActions().switchToTab(2);
        SelenideTools.openUrl(Constants.GAMETESTERURL);

    }
}
