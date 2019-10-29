package controllers;

import javafx.scene.control.Alert;
import views.FilterView;
import views.MainView;
import views.ViewUtilities;

public class AccountLoginController  {
    private ApplicationController applicationController;
    public AccountLoginController(ApplicationController applicationController) {
        this.applicationController = applicationController;

    }

    public void login() {
        applicationController.loadView(MainView.class, applicationController.mainController);
    }
}

