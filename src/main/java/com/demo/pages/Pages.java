package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    public static ContactPage contactPage;
    public static PilotProjectPage pilotProjectPage;
    public static SoftwareTesterPage softwareTesterPage;
    public static GameTesterPage gameTesterPage;
    public static AutomatedTestEnginPage automatedTestEnginPage;


    public static PilotProjectPage pilotProjectPage() {
        if (pilotProjectPage == null) {
            pilotProjectPage = new PilotProjectPage();
        }
        return pilotProjectPage;
    }

    public static ContactPage contactPage() {
        if (contactPage == null) {
            contactPage = new ContactPage();
        }
        return contactPage;
    }

    public static SoftwareTesterPage softwareTesterPage() {
        if (softwareTesterPage == null) {
            softwareTesterPage = new SoftwareTesterPage();
        }
        return softwareTesterPage;
    }

    public static GameTesterPage gameTesterPage() {
        if (gameTesterPage == null) {
            gameTesterPage = new GameTesterPage();
        }
        return gameTesterPage;
    }

    public static AutomatedTestEnginPage automatedTestEnginPage() {
        if (automatedTestEnginPage == null) {
            automatedTestEnginPage = new AutomatedTestEnginPage();
        }
        return automatedTestEnginPage;
    }

}