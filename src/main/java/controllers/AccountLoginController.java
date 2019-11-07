package controllers;

import javafx.scene.control.Alert;
import models.Account;
import models.AccountLogin;
import views.FilterView;
import views.MainView;
import views.ViewUtilities;
import services.HttpClientBuilder;

public class AccountLoginController  {
    private ApplicationController applicationController;
    public AccountLogin accountLogin;

    public String username;

    public AccountLoginController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void login(String username, String password) {
        if(username.length() != 0 && password.length() != 0) {
            this.username = username;
            applicationController.httpClientBuilder.httpGet ("accounts", username, password);
            applicationController.httpClientBuilder.httpGet ("accounts", username);
        }

        if(applicationController.httpClientBuilder.getIsValidLogin ()) {
            applicationController.loadView (MainView.class, applicationController.mainController);
            accountLogin = new AccountLogin (username, applicationController.httpClientBuilder.getRol ());
        }

//        System.out.println (applicationController.httpClientBuilder.getRol ());
    }

    public String getRol() { return accountLogin.getAccountRol (); }

    public String getUsername() { return username; }

}

