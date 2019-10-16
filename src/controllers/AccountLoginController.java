package controllers;

import views.MainView;

public class AccountLoginController  {
    private ApplicationController applicationController;
    public AccountLoginController(ApplicationController applicationController) {
        this.applicationController = applicationController;

    }

    public void login() {
        System.out.println("hier niet null");
        applicationController.loadView(MainView.class, applicationController.mainController);
    }
}

