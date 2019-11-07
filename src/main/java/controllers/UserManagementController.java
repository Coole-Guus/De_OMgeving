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
        Account newAccount = new Account (username,password,rol, 0);

        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");

        int i = 0;
        System.out.println ("oke nu hier");
        for(Account account : applicationController.httpClientBuilder.getAccounts()) {
            if (account.getAccountNaam ().contentEquals (username))
                i++;
            System.out.println ("+1");
            }
        if (i == 0) {
            applicationController.httpClientBuilder.httpPostAdd (newAccount, "accounts", "create");
            System.out.println ("success");
        }

        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");
        userManagement.createAccountList(applicationController.httpClientBuilder.getAccounts());

    }

    public void removeUser(String username) {
        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");

        for(Account account2 : applicationController.httpClientBuilder.getAccounts()) {
            if(account2.getAccountNaam ().contentEquals (username))
                applicationController.httpClientBuilder.httpGet ("accounts", "delete", String.valueOf (account2.getAccountId ()));
        }

        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");
        userManagement.createAccountList(applicationController.httpClientBuilder.getAccounts());
    }
}
