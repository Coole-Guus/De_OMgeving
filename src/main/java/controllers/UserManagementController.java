package controllers;

public class UserManagementController {
    private ApplicationController applicationController;
    public UserManagementController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void createAccountList(){
        applicationController.httpClientBuilder.httpGet ("accounts","users","accountId", "accountRol");
        applicationController.httpClientBuilder.getAccounts ();
    }
}
