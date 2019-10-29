package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import views.AccountLoginView;

public class MainController {
    public ApplicationController applicationController;

    public MainController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void exit() {
        applicationController.loadView(AccountLoginView.class, applicationController.accountLoginController);
    }


}
