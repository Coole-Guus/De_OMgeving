package controllers;

import views.PopUpVoorbeeldView;

public class PopUpVoorbeeldController {
    private ApplicationController applicationController;

    public PopUpVoorbeeldController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void showPopUp() {
        applicationController.loadView(PopUpVoorbeeldView.class, applicationController.popUpVoorbeeldController);
    }


}
