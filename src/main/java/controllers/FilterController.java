package controllers;

public class FilterController {
    public ApplicationController applicationController;


    public FilterController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }


    public void filter(String filtertype){
        applicationController.httpClientBuilder.httpGet("experimenten", filtertype);
        applicationController.experimentListController.updateList("/" + filtertype);
    }

    public void Search(String searchType, String searchWoord){
        applicationController.httpClientBuilder.httpGet("experimenten", searchType, searchWoord);
        applicationController.experimentListController.updateList("/" + searchType + "/" + "" + searchWoord);
    }
}
