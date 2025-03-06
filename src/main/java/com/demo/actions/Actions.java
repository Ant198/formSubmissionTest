package com.demo.actions;

import org.checkerframework.checker.units.qual.C;

public class Actions {
   private static MainActions mainActions;
   private static ContactActions contactActions;
   private static AutomatedTestEnginActions automatedTestEnginActions;
   private static GameTesterActions gameTesterActions;
   private static PilotProjectActions pilotProjectActions;
   private static SoftwearTesterActions softwearTesterActions;

    public static MainActions mainActions() {
        if (mainActions == null) {
            mainActions = new MainActions();
        }
        return mainActions;
    }

    public static ContactActions contactActions() {
        if (contactActions == null) {
            contactActions = new ContactActions();
        }
        return contactActions;
    }

    public static AutomatedTestEnginActions automatedTestEnginActions() {
        if (automatedTestEnginActions == null) {
            automatedTestEnginActions = new AutomatedTestEnginActions();
        }
        return automatedTestEnginActions;
    }

    public static GameTesterActions gameTesterActions() {
        if (gameTesterActions == null) {
            gameTesterActions = new GameTesterActions();
        }
        return gameTesterActions;
    }

    public static SoftwearTesterActions softwearTesterActions() {
        if (softwearTesterActions == null) {
            softwearTesterActions = new SoftwearTesterActions();
        }
        return softwearTesterActions;
    }

    public static PilotProjectActions pilotProjectActions() {
        if (pilotProjectActions == null) {
            pilotProjectActions = new PilotProjectActions();
        }
        return pilotProjectActions;
    }
}