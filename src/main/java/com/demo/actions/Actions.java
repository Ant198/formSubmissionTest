package com.demo.actions;

import org.checkerframework.checker.units.qual.C;

public class Actions {
   private static MainActions mainActions;
   private static CaptchaActions captchaActions;

    public static MainActions mainActions() {
        if (mainActions == null) {
            mainActions = new MainActions();
        }
        return mainActions;
    }

    public static CaptchaActions captchaActions() {
        if (captchaActions == null) {
            captchaActions = new CaptchaActions();
        }
        return captchaActions;
    }
}