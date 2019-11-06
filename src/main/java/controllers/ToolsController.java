package controllers;

import views.UserManagementView;

import views.ToolsView;

public class ToolsController  {
    private ApplicationController applicationController;
    public ToolsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }
    public void showPopUp() {
        applicationController.loadView(ToolsView.class, applicationController.toolsController);
    }

    public void rolCheck() {
        if (applicationController.accountLoginController.getRol ().contains ("Admin"))
            applicationController.loadView (UserManagementView.class, applicationController.mainController);
    }
}
