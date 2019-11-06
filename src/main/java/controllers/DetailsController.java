package controllers;

public class DetailsController {
    private ApplicationController applicationController;

    public DetailsController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void showDetails(String id) {
        System.out.println("load details of " + id);
    }
}
