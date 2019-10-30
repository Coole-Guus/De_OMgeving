package controllers;

import javafx.scene.control.Alert;
import views.FilterView;
import views.MainView;
import views.ViewUtilities;
import services.HttpClientBuilder;

public class AccountLoginController  {
    private ApplicationController applicationController;
    private AccountLoginController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void login(String username, String password) {
        if(username.length() != 0 && password.length() != 0)
            applicationController.httpClientBuilder.httpGet ("accounts", username, password);

        if(applicationController.httpClientBuilder.getIsValidLogin ())
            applicationController.loadView(MainView.class, applicationController.mainController);
    }
}

