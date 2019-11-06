package controllers;

public class FilterController {
    private ApplicationController applicationController;


    public FilterController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }


    public void filter(String Filtertype){
        applicationController.httpClientBuilder.httpGet("experimenten", Filtertype);

    }

    public void Search(String searchType, String searchWoord){
        applicationController.httpClientBuilder.httpGet("experimenten", searchType, searchWoord);
    }
}
