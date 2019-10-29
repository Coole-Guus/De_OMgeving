package controllers;

import views.AccountLoginView;

public class MainController {
    private ApplicationController applicationController;
    public MainController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void exit() {
        applicationController.loadView(AccountLoginView.class, applicationController.accountLoginController);
    }
}
