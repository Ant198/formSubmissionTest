package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    public static ContactPage contactPage;

    public static ContactPage contactPage() {
        if (contactPage == null) {
            contactPage = new ContactPage();
        }
        return contactPage;
    }

}