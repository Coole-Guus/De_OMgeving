package controllers;

import models.AccountLogin;
import views.MainView;

public class AccountLoginController  {
    private ApplicationController applicationController;
    public AccountLogin accountLogin;

    public String username;

    /**
     * @author Guus Kleinlein
     * Constructor of the application controller.
     * @param applicationController
     */
    public AccountLoginController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    /**
     * @author Guus Kleinlein
     * This method asks the backend if the login attributes were falid and loads the main view if correct.
     * @param username
     * @param password
     */
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
    }

    public String getRol() { return accountLogin.getAccountRol (); }

    public String getUsername() { return username; }

}

