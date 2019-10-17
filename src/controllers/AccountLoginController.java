package controllers;

import javafx.scene.control.Alert;
import views.MainView;
import views.ViewUtilities;

public class AccountLoginController  {
    private ApplicationController applicationController;
    public AccountLoginController(ApplicationController applicationController) {
        this.applicationController = applicationController;

    }

    public void login() {
        System.out.println("hier niet null");
        applicationController.popUpVoorbeeldController.showPopUp();
    }
}

