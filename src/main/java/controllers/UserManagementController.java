package controllers;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import models.Account;
import models.Experiment;
import models.UserManagement;
import views.UserManagementView;
import views.ViewUtilities;

public class UserManagementController {
    private ApplicationController applicationController;
    private UserManagement userManagement = new UserManagement ();

    public UserManagementController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void Usermanagerment() {
        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");
        userManagement.createAccountList(applicationController.httpClientBuilder.getAccounts());
    }

    public void registerObserver(UserManagementView userManagementView) {
        userManagement.registerObserver (userManagementView);
    }

    public void addUser(String username, String password, String rol) {
        String id = "error";
        Account account = new Account (username,password,rol, id);
//        applicationController.httpClientBuilder.httpPostAdd ();
    }

    public void removeUser(String username) {

    }
}
