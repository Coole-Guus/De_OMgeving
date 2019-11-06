package controllers;

import views.UserManagementView;

public class ToolsController  {
    private ApplicationController applicationController;
    public ToolsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void rolCheck() {
        if (applicationController.accountLoginController.getRol ().contains ("Admin"))
            applicationController.loadView (UserManagementView.class, applicationController.mainController);
    }
}
