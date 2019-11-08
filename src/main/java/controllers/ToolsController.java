package controllers;

import views.ToolsView;

public class ToolsController  {
    public ApplicationController applicationController;

    public ToolsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void showPopUp() {
        applicationController.loadView(ToolsView.class, applicationController.toolsController);
    }

    public boolean rolCheck() {
        return applicationController.accountLoginController.getRol ().contains ("Admin");
    }

    public void refreshbutton() {
        applicationController.experimentListController.updateList("");
    }
}
