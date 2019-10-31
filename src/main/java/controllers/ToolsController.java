package controllers;

import views.ToolsView;

public class ToolsController  {
    private ApplicationController applicationController;
    public ToolsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }
    public void showPopUp() {
        applicationController.loadView(ToolsView.class, applicationController.toolsController);
    }
}
