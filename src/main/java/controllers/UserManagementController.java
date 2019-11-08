package controllers;

import models.Account;
import models.UserManagement;
import views.UserManagementView;

public class UserManagementController {
    private ApplicationController applicationController;
    private UserManagement userManagement = new UserManagement ();

    /**
     * @author Guus Kleinlein
     * Constructor of the usermanagement controller.
     * @param applicationController
     */
    public UserManagementController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    /**
     * @author Guus Kleinlein
     * Initializes the accountlists on first showing.
     */
    public void Usermanagerment() {
        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");
        userManagement.createAccountList(applicationController.httpClientBuilder.getAccounts());
    }

    public void registerObserver(UserManagementView userManagementView) {
        userManagement.registerObserver (userManagementView);
    }

    /**
     * @author Guus Kleinlein
     * Checks if the username is not already taken, sets it in the backend accordingly and updates the model to show it.
     * @param username
     * @param password
     * @param rol
     */
    public void addUser(String username, String password, String rol) {
        Account newAccount = new Account (username,password,rol, 0);

        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");

        int i = 0;
        for(Account account : applicationController.httpClientBuilder.getAccounts()) {
            if (account.getAccountNaam ().contentEquals (username))
                i++;
            }
        if (i == 0) {
            applicationController.httpClientBuilder.httpPostAdd (newAccount, "accounts", "create");
        }

        applicationController.httpClientBuilder.httpGet ("accounts", "users", "accountId", "accountRol");
        userManagement.createAccountList(applicationController.httpClientBuilder.getAccounts());

    }

    /**
     * @author Guus Kleinlein
     * Searches the account list for the specific account that was asked to be removed, asks the backend to remove it and updates the model.
     * @param username
     */
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
